package algorithm;

import java.util.LinkedList;

public class SortedArrayMedian {
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        LinkedList<Integer> combineList = new LinkedList<>();

        int index1 =0;
        int index2 =0;

        while(index1 < nums1.length && index2 < nums2.length) {

            if ( nums1[index1] < nums2[index2]  ) {
                combineList.add(nums1[index1]);
                index1++;

            }

            else if ( nums2[index2] < nums1[index1]){
                combineList.add(nums2[index2]);
                index2++;

            }

        }

        while (index1 < nums1.length) {
            combineList.add(nums1[index1]);
            index1++;
        }

        while (index2 < nums2.length) {
            combineList.add(nums2[index2]);
            index2++;
        }



        int length = combineList.size();
        if (length % 2 == 0) {
            return (combineList.get(length/2) + combineList.get(length/2 - 1))/2.0;
        } else {
            return combineList.get(length/2);
        }

    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int [] resultArray = new int[nums1.length + nums2.length];

        int index1 =0;
        int index2 =0;
        int indexForResult = 0;

        while(index1 < nums1.length && index2 < nums2.length) {

            if ( nums1[index1] < nums2[index2]  ) {
                resultArray[indexForResult] = nums1[index1];
                index1++;

            }

            else if ( nums2[index2] < nums1[index1]){
                resultArray[indexForResult] =nums2[index2];
                index2++;

            }

            indexForResult++;

        }

        while (index1 < nums1.length) {
            resultArray[indexForResult] = nums1[index1];
            index1++;
            indexForResult++;
        }

        while (index2 < nums2.length) {
            resultArray[indexForResult] = nums2[index2];
            index2++;
            indexForResult++;
        }




        if (resultArray.length % 2 == 0) {
            return (resultArray[resultArray.length /2] + resultArray[resultArray.length /2 - 1])/2.0;
        } else {
            return resultArray[resultArray.length/2];
        }
    }

    public double calculateOddCase(int[] nums1, int[] nums2, int totalSize) {

        int medianNumberIndex = totalSize/2;

        int index1 = 0;
        int index2 = 0;

        int indexResult = 0;

        while (index1 < nums1.length && index2 < nums2.length) {

            if (nums1[index1] <= nums2[index2]) {
                if (indexResult == medianNumberIndex) {
                    return nums1[index1];
                }

                index1++;

            } else {
                if (indexResult == medianNumberIndex) {
                    return nums2[index2];
                }

                index2++;
            }

            indexResult++;


        }

        while( index1 < nums1.length) {


            if (indexResult == medianNumberIndex) {
                return nums1[index1];
            } else {
                index1++;
                indexResult++;
            }


        }

        while(index2 < nums2.length) {



            if (indexResult == medianNumberIndex) {
                return nums2[index2];

            } else {
                index2++;
                indexResult++;
            }


        }

        return 0.0;

    }

    public double calculateEvenCase(int[] nums1, int[] nums2, int totalSize) {

        int firstMedianNumberIndex = (totalSize/2) -1;
        int secondMedianNumberIndex = totalSize/2;
        double firstMedianValue = 0.0;
        int index1 = 0;
        int index2 = 0;

        int indexResult = 0;

        while (index1 < nums1.length && index2 < nums2.length) {

            if (nums1[index1] <= nums2[index2]) {
                if (indexResult == firstMedianNumberIndex) {
                    firstMedianValue = nums1[index1];
                }

                if (indexResult == secondMedianNumberIndex) {
                    return (firstMedianValue + nums1[index1])/2.0;
                }

                index1++;
            } else {
                if (indexResult == firstMedianNumberIndex) {
                    firstMedianValue = nums2[index2];
                }

                if (indexResult == secondMedianNumberIndex) {
                    return (firstMedianValue + nums2[index2])/2.0;
                }

                index2++;
            }
            indexResult++;
        }


        while( index1 < nums1.length) {



            if (indexResult == firstMedianNumberIndex) {
                firstMedianValue  = nums1[index1];
            }

            if (indexResult == secondMedianNumberIndex) {
                return (firstMedianValue + nums1[index1])/2.0;
            }
            index1++;
            indexResult++;

        }

        while(index2 < nums2.length) {



            if (indexResult == firstMedianNumberIndex) {
                firstMedianValue  = nums2[index2];
            }

            if (indexResult == secondMedianNumberIndex) {
                return (firstMedianValue + nums2[index2])/2.0;
            }

            index2++;
            indexResult++;

        }

        return 0.0;

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalSize = nums1.length + nums2.length;

        if (totalSize % 2 == 0) {
            // even case
            return calculateEvenCase(nums1, nums2, totalSize);
        } else {
            //odd case
            return calculateOddCase(nums1, nums2, totalSize);

        }

    }

    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        SortedArrayMedian s = new SortedArrayMedian();
        System.out.println(s.findMedianSortedArrays(nums1, nums2));

        int[] nums3 = {1,2};
        int[] nums4 = {3,4};

        System.out.println(s.findMedianSortedArrays(nums3, nums4));

        int[] nums5 = {};
        int[] nums6 = {2,3};

        System.out.println(s.findMedianSortedArrays(nums5, nums6));

        int[] nums7 = {};
        int[] nums8 = {1};

        System.out.println(s.findMedianSortedArrays(nums7, nums8));

        int[] nums9 = {};
        int[] nums10 = {1,2,3,4,5};

        System.out.println(s.findMedianSortedArrays(nums9, nums10));
    }
}
