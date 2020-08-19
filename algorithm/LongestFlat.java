package algorithm;

public class LongestFlat {
    public static int longest_flat(int[] array) {
        int temp = array[0];
        int previousCount = 1;
        int currentCount = 1;
        for (int i = 1; i < array.length; i++) {
            if (temp == array[i]) {
                currentCount++;
            } else {
                temp = array[i];
                if (currentCount > previousCount) {
                    previousCount = currentCount;
                    currentCount = 1;
                }
            }
        }

        if (currentCount > previousCount) {
            return currentCount ;
        } else {
            return previousCount;
        }

    }

    public static void main(String[] args) {
        int[] array1 = {1,7,7,3};
        System.out.println(longest_flat(array1));
        int[] array2 = {1,1,1};
        System.out.println(longest_flat(array2));
        int[] array3 = {1,1,2,2,2};
        System.out.println(longest_flat(array3));

    }
}
