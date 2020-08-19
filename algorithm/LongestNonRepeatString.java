package algorithm;

public class LongestNonRepeatString {

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int[] remember = new int[length];
        int count = 0;
        for (int i = 0; i < length; i++) {

            for (int j = 0; j < remember.length; j++) {
                if (remember[j] == 0) {
                    remember[j] = s.charAt(i);

                    break;
                }

                if (remember[j] == s.charAt(i)) {

                    break;
                } else {


                }


            }



        }

        return count;

    }

    public static void main(String[] args) {


        LongestNonRepeatString l = new LongestNonRepeatString();

        //System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(l.lengthOfLongestSubstring("abcabefgh"));
    }
}
