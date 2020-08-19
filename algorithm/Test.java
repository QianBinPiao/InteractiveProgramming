package algorithm;

import java.util.Arrays;

public class Test {

    public static int compareLogLine(String firstLogLine,String  secondLogLine) {
        if (Character.isDigit(firstLogLine.charAt(0)) && !Character.isDigit(secondLogLine.charAt(0))) {
            return firstLogLine.compareTo(secondLogLine) + 75;
        } else if (!Character.isDigit(firstLogLine.charAt(0)) && Character.isDigit(secondLogLine.charAt(0))) {
            return firstLogLine.compareTo(secondLogLine) - 75;
        } else {
            return  firstLogLine.compareTo(secondLogLine);
        }

    }
    public static void main(String[] args) {

        //System.out.println((int)'-');
        //System.out.println((int)'+');
        //System.out.println((int)'e');
        //System.out.println((int)'.');
        System.out.println((int)'0');
        System.out.println((int)'9');

        System.out.println((int)'A');
        System.out.println((int)'a');
        System.out.println((int)'z');

        System.out.println("0".compareTo("z"));
        System.out.println("z".compareTo("0"));
        System.out.println("a".compareTo("b"));
        System.out.println(Test.compareLogLine("0", "z"));
        System.out.println(Test.compareLogLine("1", "z"));
        System.out.println(Test.compareLogLine("z", "0"));
        System.out.println(Test.compareLogLine("a", "b"));
        int[][] grid = {
                {2,1,1},
                {0,1,1},
                {0,1,1}
        };
        boolean visitedGrid[][] = new boolean[grid.length][grid[0].length];
        System.out.println(Arrays.toString(visitedGrid));
    }
}
