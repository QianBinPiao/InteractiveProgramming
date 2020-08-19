package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {



    private void swap(int[] v, int i, int j) {

        int t = v[i];

        v[i] = v[j];

        v[j] = t;

    }



    public void permute(int[] v, int n) {

        if (n == 1) {

            System.out.println(Arrays.toString(v));

        } else {

            for (int i = 0; i < n; i++) {

                permute(v, n - 1);

                if (n % 2 == 1) {

                    swap(v, 0, n - 1);

                }
                else {

                    swap(v, i, n - 1);

                }

            }

        }

    }

    public static void main(String[] args) {
        int[] array = {1,2,3};
        //List<Integer> list= Arrays.asList(1,2,3);
        /*
        List<Integer> list = Arrays.stream(array)		// IntStream
                .boxed()  		// Stream<Integer>
                .collect(Collectors.toList());
                */

        Permutations p = new Permutations();
        p.permute(array, 3);




        //java.util.Collections.swap(list, 0, 1);

        //System.out.println(Arrays.toString(list.toArray()));
        //java.util.Collections.swap(list, 1, 0);
        //System.out.println(Arrays.toString(list.toArray()));
    }
}
