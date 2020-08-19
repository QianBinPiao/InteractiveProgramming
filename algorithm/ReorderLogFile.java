package algorithm;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReorderLogFile {

    public List<String> reorderLines(int logFileSize, List<String> logLines) {
        List<String> result = new ArrayList<>();
        int[] ranks = new int[logFileSize];
        for(int i = 0; i < logFileSize; i++) {
            String[] inputs = logLines.get(i).split("\\s+");
            //ranks[i] = calculateMeasureValue(Arrays.copyOfRange(inputs, 1, inputs.length));
            ranks[i] = calculateMeasureValue(inputs[1]);

        }

        for (int i =0 ; i < logFileSize; i++) {
            int index = getIndexOfSmallest(ranks);
            result.add(logLines.get(index));
            ranks[index] = 9999999;
        }

        return result;

    }

    public int calculateMeasureValue(String[] inputs) {
        int count = 0;
        for(String eachInput : inputs) {
            for (int i =0 ;i < eachInput.length(); i ++) {
                if (Character.isDigit(eachInput.charAt(i))) {
                    return (int)eachInput.charAt(i) + 122;
                } else {
                    return (int)eachInput.charAt(i);
                }
            }
        }

        return count;

    }

    public int calculateMeasureValue(String inputs) {

                if (Character.isDigit(inputs.charAt(0))) {
                    return (int)inputs.charAt(0) + 122;
                } else {
                    return (int)inputs.charAt(0);
                }

    }

    public int getIndexOfSmallest( int[] array )
    {
        if ( array == null || array.length == 0 ) return -1; // null or empty

        int largest = 0;
        for ( int i = 1; i < array.length; i++ )
        {
            if ( array[i] < array[largest] ) largest = i;
        }
        return largest; // position of the first largest found
    }
    /*
    public int compareLogLine(String[] firstLogLine,String[]  secondLogLine) {
        if (Character.isDigit(firstLogLine[1].charAt(0)) && !Character.isDigit(secondLogLine[1].charAt(0))) {
            return firstLogLine[1].compareTo(secondLogLine[1]) + 75;
        } else if (!Character.isDigit(firstLogLine[1].charAt(0)) && Character.isDigit(secondLogLine[1].charAt(0))) {
            return firstLogLine[1].compareTo(secondLogLine[1]) - 75;
        } else {
            return  firstLogLine[1].compareTo(secondLogLine[1]);
        }

    }

    public boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }
    */


    public static void main(String[] args) {
        ReorderLogFile r = new ReorderLogFile();
        List<String> logLines = new ArrayList<>();
        logLines.add("mi2 jog mid pet");
        logLines.add("wz3 34 54 398");
        logLines.add("a1 alps cow bar");
        logLines.add("x4 45 21 7");
        List<String> result = r.reorderLines(
                4,
                logLines
        );

        for(String input : result) {
            System.out.println(input);
        }




    }
}
