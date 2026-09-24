import java.util.*;

public class removeinvalidparaenthates {

    public static List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();

        int leftToRemove = 0;
        int rightToRemove = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                leftToRemove++;
            } else if (ch == ')') {
                if (leftToRemove > 0) {
                    leftToRemove--;
                } else {
                    rightToRemove++;
                }
            }
        }

        removeParentheses(
                s,
                0,
                leftToRemove,
                rightToRemove,
                result
        );

        return result;
    }

    private static void removeParentheses(
            String s,
            int start,
            int leftToRemove,
            int rightToRemove,
            List<String> result) {

        if (leftToRemove == 0 && rightToRemove == 0) {
            if (isValid(s)) {
                result.add(s);
            }
            return;
        }

        for (int i = start; i < s.length(); i++) {

            // Avoid duplicate results
            if (i > start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }

            char ch = s.charAt(i);

            if (leftToRemove > 0 && ch == '(') {
                String next = s.substring(0, i) + s.substring(i + 1);

                removeParentheses(
                        next,
                        i,
                        leftToRemove - 1,
                        rightToRemove,
                        result
                );
            }

            if (rightToRemove > 0 && ch == ')') {
                String next = s.substring(0, i) + s.substring(i + 1);

                removeParentheses(
                        next,
                        i,
                        leftToRemove,
                        rightToRemove - 1,
                        result
                );
            }
        }
    }

    private static boolean isValid(String s) {
        int balance = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                balance++;
            } else if (ch == ')') {
                balance--;

                if (balance < 0) {
                    return false;
                }
            }
        }

        return balance == 0;
    }

    public static void main(String[] args) {
        String s = "()())()";

        System.out.println(removeInvalidParentheses(s));
    }
}