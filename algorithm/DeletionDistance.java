package algorithm;

public class DeletionDistance {
    public static int deletion_distance(String str1, String str2) {



        int count;

        char[] str1array = str1.toCharArray();
        char[] str2array = str2.toCharArray();
        count = str2array.length + str1array.length;

        for (int i = 0 ; i < str1array.length; i++ ) {
            for (int j = 0; j < str2array.length; j++) {
                if (str2array[j] == str1array[i]) {
                    count = count - 2;
                }
            }
        }

        return count;

    }

    public static void main(String[] args) {
        String a1 = "at";
        String a2 = "cat";
        System.out.println(deletion_distance(a1, a2));
        String b1 = "boat";
        String b2 = "got";
        System.out.println(deletion_distance(b1,b2));
        String c1 = "thought";
        String c2 = "sloughs";
        //System.out.println(deletion_distance(array3));
    }
}
