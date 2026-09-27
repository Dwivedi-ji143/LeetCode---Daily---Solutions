class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> sp = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) != ')') {
                sp.push(s.charAt(i));
            }
            else {
                String temp = "";
                while (sp.peek() != '(') {
                    temp += sp.pop();
                }
                sp.pop();
                for (int j = 0; j < temp.length(); j++) {
                    sp.push(temp.charAt(j));
                }
            }
            i++;
        }
        String op = "";
        while (!sp.isEmpty()) {
            op += sp.pop();
        }
        String ans = "";
        for (int j = op.length() - 1; j >= 0; j--) {
            ans += op.charAt(j);
        }
        return ans;
    }
}