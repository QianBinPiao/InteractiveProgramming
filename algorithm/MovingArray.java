package algorithm;

import java.util.Arrays;

public class MovingArray {




    public int[] shiftAllNumber(int[] inputArray) {
        int[] result = new int[inputArray.length];
        int indexForResult = 0;
        for (int e : inputArray) {
            if (e != 0) {
                result[indexForResult] = e;
                indexForResult++;
            }
        }

        return result;

    }

    public static void main(String[] args) {

        int[] input = {1,0,0,2,5,0};
        int[] resultArray;
        // result [1,2,5, 0 0 0]
        MovingArray m = new MovingArray();
        System.out.println(Arrays.toString(input));
        resultArray = m.shiftAllNumber(input);
        System.out.println(Arrays.toString(resultArray));
        System.out.println(print(1));
        for (int i = 0; i < 10; i=i++){
            i+=1;
            System.out.println("a");
        }
        boolean t = "a" instanceof String;
    }

    static Exception print(int i) {
        return new Exception();
    }

}
