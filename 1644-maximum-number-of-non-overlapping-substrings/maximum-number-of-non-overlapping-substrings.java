import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        List<String> ans = new ArrayList<>();

        // leftmost[i] = leftmost index of ('a' + i)
        int[] leftmost = new int[26];
        Arrays.fill(leftmost, n);

        // rightmost[i] = rightmost index of ('a' + i)
        int[] rightmost = new int[26];
        Arrays.fill(rightmost, -1);

        // Find leftmost and rightmost positions
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            leftmost[index] = Math.min(leftmost[index], i);
            rightmost[index] = i;
        }

        // Equivalent of C++ lambda getNewRight
        java.util.function.IntUnaryOperator getNewRight = (i) -> {
            int right = rightmost[s.charAt(i) - 'a'];

            for (int j = i; j <= right; j++) {
                int index = s.charAt(j) - 'a';

                // If this character appeared before i,
                // this substring is invalid
                if (leftmost[index] < i)
                    return -1;

                // Expand right dynamically
                right = Math.max(right, rightmost[index]);
            }

            return right;
        };

        int right = -1;

        for (int i = 0; i < n; i++) {

            // Current index is the first appearance of this character
            if (i == leftmost[s.charAt(i) - 'a']) {

                int newRight = getNewRight.applyAsInt(i);

                if (newRight == -1)
                    continue;

                String substring = s.substring(i, newRight + 1);

                if (i <= right && !ans.isEmpty()) {
                    ans.set(ans.size() - 1, substring);
                } else {
                    ans.add(substring);
                }

                right = newRight;
            }
        }

        return ans;
    }
}