package algorithm;

import java.util.concurrent.TimeUnit;

public class Fibonacci {


    public int fibRecursion(int n) {
        // Exponential

        if (n <= 1) {
            return 1;
        } else {
            return fibRecursion(n-1) + fibRecursion(n-2);
        }

    }


    public int fibDynamicProgramming(int n) {
        int[] fibArray = new int[n + 1];

        fibArray[0] = 1;
        fibArray[1] = 1;

        for (int i =2; i < fibArray.length; i++) {
            fibArray[i] = fibArray[i-1] + fibArray[i-2];
        }


        return fibArray[n];
    }



    public static void main(String[] args) {
        long startTime;
        long endTime;
        long durationInMillis;
        System.out.println(Integer.MAX_VALUE);
        Fibonacci f = new Fibonacci();

        System.out.println(f.fibRecursion(5));
        System.out.println(f.fibDynamicProgramming(5));

        startTime = System.nanoTime();
        System.out.println(f.fibRecursion(30));
        endTime = System.nanoTime();

        System.out.println("time eplapsed :" + (endTime - startTime) );

        startTime = System.nanoTime();
        System.out.println(f.fibDynamicProgramming(30));
        endTime = System.nanoTime();

        System.out.println("time eplapsed :" + (endTime - startTime) );



    }
}
