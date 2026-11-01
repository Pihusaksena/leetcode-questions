class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder current = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(current);
                current = new StringBuilder();
            }
            else if (ch == ')') {
                current.reverse();
                StringBuilder temp = stack.pop();
                temp.append(current);
                current = temp;
            }
            else {
                current.append(ch);
            }
        }
        return current.toString();
    }
}