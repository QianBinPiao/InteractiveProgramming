package algorithm;

import java.util.ArrayList;
import java.util.List;

public class PopularFeature {

    public ArrayList<String> popularNFeatures(int numFeatures,
                                              int topFeatures,
                                              List<String> possibleFeatures,
                                              int numFeatureRequests,
                                              List<String> featureRequests)
    {
        ArrayList<String> popularFeatures = new ArrayList<>();
        int[] wordCount = new int[numFeatures];

        for(String eachFeature : featureRequests) {
            String afterLowerCase  = eachFeature.toLowerCase();
            for (int i = 0; i < numFeatures; i++) {
                if (afterLowerCase.contains(possibleFeatures.get(i))) {
                    wordCount[i]++;
                }
            }

        }



        for (int j = 0; j < topFeatures; j++) {
            int index = getIndexOfLargest(wordCount);
            popularFeatures.add(possibleFeatures.get(index));
            wordCount[index] = 0;
        }

        return popularFeatures;

    }



    public int getIndexOfLargest( int[] array )
    {
        if ( array == null || array.length == 0 ) return -1; // null or empty

        int largest = 0;
        for ( int i = 1; i < array.length; i++ )
        {
            if ( array[i] > array[largest] ) largest = i;
        }
        return largest; // position of the first largest found
    }



    public static void main(String[] args) {
        PopularFeature p = new PopularFeature();
        ArrayList<String> possibleFeatures = new ArrayList<>();
        possibleFeatures.add("storage");
        possibleFeatures.add("battery");
        possibleFeatures.add("hover");
        possibleFeatures.add("alexa");
        possibleFeatures.add("waterproof");
        possibleFeatures.add("solar");
        ArrayList<String> featureRequests = new ArrayList<>();
        featureRequests.add("I wish my Kindle had even more starge!");
        featureRequests.add("I wish the battery life on my Kindle lasted 2 years");
        featureRequests.add("I read in the bath and would enjoy a waterproof Kindle");
        featureRequests.add("Waterproof and increased battery are my top two requests");
        featureRequests.add("I want to take my Kindle into the shower. Waterproof plea Waterproof");
        featureRequests.add("It would be neat if my Kindle would hover on my ");
        featureRequests.add("in the sun via solar power");
        ArrayList<String> popularFeatures = p.popularNFeatures(
                6,
                2,
                possibleFeatures,
                7,
                featureRequests
        );

        for(String top : popularFeatures) {
            System.out.println(top);
        }

    }
}
