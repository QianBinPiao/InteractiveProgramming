package algorithm;

public class PlusOne {

    public int[] plusOne(int[] digits) {

        int i = digits.length - 1;
        int resultOneDigits;
        int override;
        int temp;
        while(true) {

            if (i < 0) {
                int[] newResult = new int[digits.length + 1];
                newResult[0] = 1;
                for (int j = 1; j < newResult.length; j ++ ) {

                    newResult[j] = digits[j-1];
                }

                return newResult;
            }

            temp = digits[i] + 1;


            if (temp > 9) {
                digits[i] = temp % 10;
                i--;
            } else {
                digits[i] = temp;
                break;
            }
        }

        return digits;
    }

    public static void main(String[] args) {

    }
}
