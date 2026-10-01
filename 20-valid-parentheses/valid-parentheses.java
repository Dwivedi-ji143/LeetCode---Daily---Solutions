class Solution {
    public boolean isValid(String s) {
        Stack<Character> sp = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                sp.push(ch);
            }
            else {
                if (sp.isEmpty()) {
                    return false;
                }

                if (sp.peek() == '(' && ch == ')' ||
                    sp.peek() == '{' && ch == '}' ||
                    sp.peek() == '[' && ch == ']') {
                    sp.pop();
                }
                else {
                    return false;
                }
            }
        }

        return sp.isEmpty();
    }
}