package algorithm;

public class ValidNumber {
    // need draw DFA later.

    final int START = 0;
    final int STARTSIGN = 1;
    final int INTEGER = 2;
    final int DECIMAL = 3;
    final int DECIMAL_START = 4;
    final int EXP = 5;
    final int EXPSIGN = 6;
    final int EXPINT = 7;
    final int ERROR = 8;
    int state;

    public boolean isNumber(String s) {
        s = s.trim();
        state = START;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isError()) {
                return false;
            }
            if (Character.isDigit(c)) onDigit();
            else if (c == '.') onDot();
            else if (c == 'e') onExp();
            else if (c == '+' || c == '-') onSign();
            else return false;
        }
        return isEnd();
    }

    public void onDigit() {
        if (state == START) {
            state = INTEGER;
        } else if (state == EXP) {
            state = EXPINT;
        } else if (state == STARTSIGN) {
            state = INTEGER;
        } else if (state == EXPSIGN) {
            state = EXPINT;
        } else if (state == DECIMAL_START) {
            state = DECIMAL;
        }
    }

    public void onSign() {
        if (state == START) {
            state = STARTSIGN;
        } else if (state == EXP) {
            state = EXPSIGN;
        } else {
            state = ERROR;
        }
    }

    public void onDot() {
        if (state == START) {
            state = DECIMAL_START;
        } else if (state == STARTSIGN) {
            state = DECIMAL_START;
        } else if (state == INTEGER) {
            state = DECIMAL;
        } else {
            state = ERROR;
        }
    }

    public void onExp() {
        if (state == INTEGER) {
            state = EXP;
        } else if (state == DECIMAL) {
            state = EXP;
        } else {
            state = ERROR;
        }
    }

    public boolean isError() {
        return state == ERROR;
    }

    public boolean isEnd() {
        return state == INTEGER || state == DECIMAL || state == EXPINT;
    }

    public boolean isNumberwithHex(String s) {

        String input = s.trim();
        //String input = s;

        char[] inputArray = input.toCharArray();

        for (int i= 0; i < inputArray.length; i++) {
            System.out.println(inputArray[i]);
            System.out.println((int)inputArray[i]);
            if (inputArray[i] < 48) {
                return false;
            } else if (inputArray[i] > 57 && inputArray[i] < 65) {
                // {57 : 9}  { 65 : A}
                return false;
            } else if (inputArray[i] > 69 && inputArray[i] < 97) {
                return false;
            } else if (inputArray[i] > 101) {
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        ValidNumber v = new ValidNumber();
        System.out.println(v.isNumber("48"));
        System.out.println(v.isNumber("-"));
        /*
        System.out.println(v.isNumber("1"));
        System.out.println(v.isNumber("2"));
        System.out.println(v.isNumber("9"));
        System.out.println(v.isNumber("a"));
        System.out.println(v.isNumber("b"));
        System.out.println(v.isNumber("e"));
        System.out.println(v.isNumber("A"));
        System.out.println(v.isNumber("B"));
        System.out.println(v.isNumber("E"));

         */

    }
}
