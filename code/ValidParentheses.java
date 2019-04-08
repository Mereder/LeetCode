package code;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        if(len > 0 ) {
            stack.push(s.charAt(0));
            for (int i = 1; i < len; i++) {
                char symbol = s.charAt(i);
                if (!stack.isEmpty() && matching(stack.peek(), symbol)) {
                    stack.pop();
                } else {
                    stack.push(symbol);
                }

            }
        }
        else
            return true;
        if(stack.isEmpty()) return true;
        else return false;
    }

    public boolean matching(char a,char b){
        if (a == '(' && b == ')') return true;
        else if(a == '[' && b == ']') return  true;
        else if(a == '{' && b == '}') return true;
        else return false;
    }

    public ValidParentheses() {
        String str = "()[]{}";
        System.out.println(isValid(str));
    }

    public static void main(String[] args) {
        ValidParentheses test = new ValidParentheses();

    }
}
