class Solution {
    public String reversePrefix(String word, char ch) {
        int n = word.indexOf(ch);
        String k= word.substring(0, n+1);
        String reversed = new StringBuilder(k).reverse().toString();
        String op = reversed+word.substring(n+1);
        return op;
    }
}