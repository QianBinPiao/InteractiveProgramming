package algorithm;

public class WaterBottle {
    public int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles;
        int restofBottles = numBottles;

        while(true) {

            result = result + (restofBottles / numExchange);


            restofBottles =  restofBottles / numExchange + restofBottles % numExchange;


            if (restofBottles < numExchange) {
                break;
            }
        }

        return result;

    }

    public static void main(String[] args) {

        WaterBottle w = new WaterBottle();
        System.out.println(w.numWaterBottles(9, 3));

        System.out.println(w.numWaterBottles(15, 4));

    }
}
