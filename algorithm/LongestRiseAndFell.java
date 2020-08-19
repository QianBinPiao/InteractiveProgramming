package algorithm;

public class LongestRiseAndFell {
    public static int stock_runs(int[] prices) {
        boolean flag = false;
        if (prices[0] > prices[1]) {
            flag = true;
        } else {
            flag = false;
        }
        int lastValue = prices[1];
        int count = 2;
        for (int i =2 ; i < prices.length; i++) {
            if (flag == true) {
                if (lastValue > prices[i]) {
                    count++;
                } else {
                    flag = false;
                    count = 1;
                }
            } else {
                if (lastValue < prices[i]) {
                    count++;
                } else {
                    flag = true;
                    count = 1;
                }
            }
        }

        return count;

    }

    public static void main(String[] args) {

    }
}
