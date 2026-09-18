import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        List<String> ans = new ArrayList<>();

        int[] leftmost = new int[26];
        Arrays.fill(leftmost, n);

        int[] rightmost = new int[26];
        Arrays.fill(rightmost, -1);

        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            leftmost[index] = Math.min(leftmost[index], i);
            rightmost[index] = i;
        }
        java.util.function.IntUnaryOperator getNewRight = (i) -> {
            int right = rightmost[s.charAt(i) - 'a'];

            for (int j = i; j <= right; j++) {
                int index = s.charAt(j) - 'a';

                if (leftmost[index] < i)
                    return -1;

                right = Math.max(right, rightmost[index]);
            }

            return right;
        };

        int right = -1;

        for (int i = 0; i < n; i++) {

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