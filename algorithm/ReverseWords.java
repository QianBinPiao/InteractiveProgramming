package algorithm;

import java.util.Stack;

public class ReverseWords {
    /*
    Runtime: 13 ms
    Memory Usage: 40.5 MB
     */
    public String reverseWords1(String s) {
        int length = s.length();

        Stack<Character> stack = new Stack<>();
        char[] reverseCharArray = new char[length];
        int reverseIndex = 0;

        for (int i = 0; i <= length; i ++) {

            if (i == length) {
                while (!stack.isEmpty()) {
                    reverseCharArray[reverseIndex] = stack.pop();
                    reverseIndex++;
                }

                break;
            }


            if (s.charAt(i) == 32 ) { //blank
                while (!stack.isEmpty()) {
                    reverseCharArray[reverseIndex] = stack.pop();
                    reverseIndex++;
                }



                reverseCharArray[reverseIndex] = (char)32;
                reverseIndex++;
            } else {
                stack.add(s.charAt(i));
            }
            //reverseCharArray[length - i - 1] = s.charAt(i);
        }
        //reverseCharArray[reverseIndex - 1] = 0x255;


        return String.valueOf(reverseCharArray);
    }

    /*
    Runtime: 4 ms
    Memory Usage: 40 MB
     */
    public String reverseWords(String s) {
        int length = s.length();


        char[] reverseCharArray = new char[length];
        int reverseIndex;
        int previousStart = -1;
        int j = 0;
        for (int i = 0; i <= length; i ++) {

            if (i == length) {
                reverseIndex = i - 1;
                while (reverseIndex > previousStart) {
                    reverseCharArray[previousStart + 1 + j] = s.charAt(reverseIndex);
                    reverseIndex--;
                    j++;
                }

                break;
            }


            if (s.charAt(i) == 32 ) { //blank
                reverseIndex = i - 1;
                while (reverseIndex > previousStart) {
                    reverseCharArray[previousStart + 1 + j] = s.charAt(reverseIndex);
                    reverseIndex--;
                    j++;
                }
                j = 0;
                previousStart = i;


                reverseCharArray[i] = (char)32;

            }
            //reverseCharArray[length - i - 1] = s.charAt(i);
        }
        //reverseCharArray[reverseIndex - 1] = 0x255;


        return String.valueOf(reverseCharArray);
    }


    public static void main(String[] args) {
        ReverseWords r = new ReverseWords();
        System.out.println("Let's take LeetCode contest");
        System.out.println(r. reverseWords("Let's take LeetCode contest"));
    }
}
