class Solution {
    public int reverseDegree(String s) {
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            int reverseValue = 'z' - s.charAt(i) + 1;
            res += reverseValue * (i + 1);
        }

        return res;
    }
}