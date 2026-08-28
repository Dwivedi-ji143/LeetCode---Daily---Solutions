import java.util.*;

class Solution {
    // Renamed to match the method name called by the LeetCode driver
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] totalCounts = new int[26];
        for (int i = 0; i < n; i++) {
            totalCounts[s.charAt(i) - 'a']++;
        }

        // Count odd frequencies to check if palindrome is valid
        int oddCount = 0;
        int oddCharIdx = -1;
        for (int i = 0; i < 26; i++) {
            if (totalCounts[i] % 2 != 0) {
                oddCount++;
                oddCharIdx = i;
            }
        }
        if (oddCount > 1) return ""; // Invalid palindrome permutation

        // Determine available characters for the left half
        int[] halfCounts = new int[26];
        for (int i = 0; i < 26; i++) {
            halfCounts[i] = totalCounts[i] / 2;
        }

        int half = n / 2;
        char oddChar = oddCharIdx == -1 ? '#' : (char) ('a' + oddCharIdx);

        // --- Step 1: Try to match the target's left half exactly ---
        int[] currentCounts = halfCounts.clone();
        char[] tempLeft = new char[half];
        boolean fullyMatched = true;

        for (int i = 0; i < half; i++) {
            int targetCharIdx = target.charAt(i) - 'a';
            if (currentCounts[targetCharIdx] > 0) {
                tempLeft[i] = target.charAt(i);
                currentCounts[targetCharIdx]--;
            } else {
                fullyMatched = false;
                break;
            }
        }

        if (fullyMatched) {
            String candidate = buildPalindrome(tempLeft, oddChar, n);
            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        // --- Step 2: Backtrack from right to left to find a strict deviation ---
        for (int pos = half - 1; pos >= 0; pos--) {
            currentCounts = halfCounts.clone();
            
            // Reconstruct the matching prefix up to pos - 1
            boolean validPrefix = true;
            for (int i = 0; i < pos; i++) {
                int targetCharIdx = target.charAt(i) - 'a';
                if (currentCounts[targetCharIdx] > 0) {
                    tempLeft[i] = target.charAt(i);
                    currentCounts[targetCharIdx]--;
                } else {
                    validPrefix = false;
                    break;
                }
            }
            if (!validPrefix) continue;

            // At 'pos', find the smallest available character strictly greater than target[pos]
            int targetC = target.charAt(pos) - 'a';
            boolean foundLarger = false;
            for (int c = targetC + 1; c < 26; c++) {
                if (currentCounts[c] > 0) {
                    tempLeft[pos] = (char) ('a' + c);
                    currentCounts[c]--;
                    foundLarger = true;
                    break;
                }
            }
            if (!foundLarger) continue;

            // Fill all positions after 'pos' greedily with the smallest remaining characters
            for (int i = pos + 1; i < half; i++) {
                for (int c = 0; c < 26; c++) {
                    if (currentCounts[c] > 0) {
                        tempLeft[i] = (char) ('a' + c);
                        currentCounts[c]--;
                        break;
                    }
                }
            }

            // Build full palindrome and verify constraint
            String candidate = buildPalindrome(tempLeft, oddChar, n);
            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        return "";
    }

    private String buildPalindrome(char[] leftHalf, char oddChar, int totalLen) {
        char[] fullArr = new char[totalLen];
        int half = leftHalf.length;
        
        // Copy left half
        System.arraycopy(leftHalf, 0, fullArr, 0, half);
        
        // Handle center element if odd
        if (totalLen % 2 != 0) {
            fullArr[half] = oddChar;
        }
        
        // Mirror to the right side
        for (int i = 0; i < half; i++) {
            fullArr[totalLen - 1 - i] = leftHalf[i];
        }
        
        return new String(fullArr);
    }
}
