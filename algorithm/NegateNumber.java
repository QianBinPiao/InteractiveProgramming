package algorithm;

public class NegateNumber {
    public static void main(String[] args) {
        for (short i = 0; i < Short.MAX_VALUE; i++ ) {
            System.out.print(i);
            System.out.print(":");
            System.out.print(-i);
            System.out.println(~i);
        }
    }
}
