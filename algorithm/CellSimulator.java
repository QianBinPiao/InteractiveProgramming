package algorithm;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CellSimulator {

    public List<Integer> cellCompete(int[] states, int days) {
        int dayIndex = 0;
       // List<Integer> newStates = new ArrayList<>(8);
        int[] currentStates = Arrays.copyOf(states,states.length);
        int[] newStates = new int[8];
        while (dayIndex < days) {
            Arrays.fill(newStates, 0);
            for (int i = 0; i < currentStates.length; i++) {
                if (i == 0) { // left case is 0
                    if (currentStates[i + 1] == 0) {
                        //states[i] = 0;
                        newStates[i] = 0;
                    } else if (currentStates[i + 1] == 1) {
                        //states[i] = 1;
                        newStates[i] = 1;
                    }

                    continue;
                }

                if (i == currentStates.length - 1) { // right case is 0
                    if (currentStates[i - 1] == 0) {
                        newStates[i] = 0;
                    } else if (currentStates[i - 1] == 1) {
                        newStates[i] = 1;
                    }

                    continue;
                }

                if (
                        (currentStates[i - 1] == 1 && currentStates[i + 1] == 0)
                                || (currentStates[i - 1] == 0 && currentStates[i + 1] == 1)
                ) {
                    newStates[i] = 1;
                } else {
                    newStates[i] = 0;
                }

            }
            dayIndex++;
            currentStates = Arrays.copyOf(newStates, newStates.length);
        }


        return Arrays.stream(newStates).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        CellSimulator solution = new CellSimulator();
        int[] initialStates = {1,0,0,0,0,0,0,1};
        System.out.println(Arrays.toString(initialStates));


        System.out.println(solution.cellCompete(  initialStates,1));
        System.out.println(solution.cellCompete(  initialStates,2));
        System.out.println(solution.cellCompete(  initialStates,3));

    }
}
