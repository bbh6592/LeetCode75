import java.util.*;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0'); // build multi-digit number
            } else if (ch == '[') {
                countStack.push(k);
                stringStack.push(current);
                current = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                int repeatTimes = countStack.pop();
                StringBuilder prev = stringStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    prev.append(current);
                }
                current = prev;
            } else {
                current.append(ch); // regular character
            }
        }

        return current.toString();
    }
}
