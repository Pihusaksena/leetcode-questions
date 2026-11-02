class Solution {
    public int myAtoi(String s) {
         if (s == null || s.length() == 0) {
            return 0;
        }
        int index = 0;
        int n = s.length();
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }
        if (index == n) {
            return 0;
        }
        int sign = 1;
        char firstChar = s.charAt(index);
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            sign = -1;
            index++;
        }
        int total = 0;
        while (index < n) {
            char c = s.charAt(index);
            if (c < '0' || c > '9') {
                break;
            }
            int digit = c - '0';
            if (total > Integer.MAX_VALUE / 10 || 
               (total == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = total * 10 + digit;
            index++;
        }
        return total * sign;
    }
}