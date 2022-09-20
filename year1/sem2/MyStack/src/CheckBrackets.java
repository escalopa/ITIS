import java.util.Stack;

public class CheckBrackets {

    public static boolean checkCircleBrackets(String str) {

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
            } else if (str.charAt(i) == (')')) {
                count--;
            }
        }
        return count == 0;

    }


    public static boolean bracketsWithStack(String string) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < string.length(); i++) {

            if (!isBracket(string.charAt(i))) continue;

            if (isOpen(string.charAt(i)))
                stack.push(string.charAt(i));

            if (isClosed(string.charAt(i))) {
                if (stack.isEmpty()) return false;

                if (!stack.pop().equals(getOpposite(string.charAt(i))))
                    return false;
            }
        }

        return stack.isEmpty();
    }


    private static boolean isBracket(char charAt) {

        return (charAt == '{' | charAt == '[' | charAt == '(' | charAt == ')' | charAt == ']' | charAt == '}');
    }

    private static boolean isOpen(char charAt) {

        return (charAt == '{' | charAt == '[' | charAt == '(');
    }

    private static boolean isClosed(char charAt) {

        return (charAt == '}' | charAt == ']' | charAt == ')');
    }

    private static char getOpposite(char charAt) {

        if (charAt == '}')
            return '{';

        if (charAt == ']')
            return '[';

        return '(';
    }


}
