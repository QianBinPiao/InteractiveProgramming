package algorithm;

public class MinimumInteger {

    public String minInteger(String num, int k) {
        char[] resultCharArray = new char[num.length()];
        char minChar = '9';

        int i = 0;
        while (i < k) {

            i++;
        }

        return new String(resultCharArray);
    }

    public static void main(String[] args) {
        MinimumInteger m = new MinimumInteger();


        System.out.println(m.minInteger("4321", 4));

    }
}
