package algorithm;

import java.util.Stack;

public class ValidParenthesesCount {
    public static int bracket_match(String bracket_string) {
        char[] charArray = bracket_string.toCharArray();

        int count = 0;
        for(int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(') {
                count++;
            } else if (charArray[i] == ')'){
                count--;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String a1 = "()(";
        System.out.println(bracket_match(a1));
        String a2= "()";
        System.out.println(bracket_match(a2));
    }
}
