package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        try {
            int length = s.length();
            for (int i = 0; i < length; i++) {

                if (s.charAt(i) == '(') {
                    stack.add(s.charAt(i));
                } else if (s.charAt(i) == ')') {
                    if (stack.pop() != '(')
                        return false;
                } else if (s.charAt(i) == '[') {
                    stack.add(s.charAt(i));
                } else if (s.charAt(i) == ']') {
                    if (stack.pop() != '[')
                        return false;
                } else if (s.charAt(i) == '{') {
                    stack.add(s.charAt(i));
                } else if (s.charAt(i) == '}') {
                    if (stack.pop() != '{')
                        return false;
                }
            }
        } catch (Exception e) {
            return false;

        }
        //s.charAt();

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses v = new ValidParentheses();
        //System.out.println(v.isValid("{}"));
        //System.out.println(v.isValid("()"));
        //System.out.println(v.isValid("[]"));
        //System.out.println(v.isValid("{[("));
        //System.out.println(v.isValid("{a}(b)"));
        System.out.println(v.isValid("{[]}"));
        System.out.println(v.isValid("]"));
        System.out.println(v.isValid("{(})"));

    }
}
