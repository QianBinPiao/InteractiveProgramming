package algorithm;



public class PowFunction {

    public static long power(int base, int exponent) {
        long result = base;

        for (int i = 1; i < exponent; i++) {
            result = result * base;
        }
        return result;
    }

    public static double myPow1(double x, int n) {
        double result;

        if (n > 0) {
            result = x;

            if (x == 1) {
                return 1;
            }

            if (x==-1) {
                if (n % 2 == 0) {
                    return 1;
                } else {
                    return -1;
                }
            }

            for (int i = 1; i < n; i++) {
                result = result * x;
            }
        } else if (n < 0) {

            if (x == 1) {
                return 1;
            }

            if (x==-1) {
                if (n % 2 == 0) {
                    return 1;
                } else {
                    return -1;
                }
            }


            // because when negative number , I need to handle
            // 2147483648 case.
            if ( -(n + 1) >= 20) {
                return 0.0;
            }

            result = 1/x;

            int times = -n;
            for (int i = 1; i <times ; i++) {
                result = result * (1/x);
            }
        } else {
            return 1.0;
        }


        return result;
    }

    public static double binaryPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }

        if (n % 2 ==0) {
            return binaryPow(x * x, n / 2);
        } else {
            return x * binaryPow (x * x, n /2);
        }
    }

    public static double myPow(double x, int n) {
        long m = n;

        if (m > 0) {
            return binaryPow(x, m);
        } else {
            return 1.0/binaryPow(x, -m);
        }

    }

    public static void main(String[] args) {
        System.out.println(Math.pow(2,31));
        System.out.println(Math.pow(2,63));
        System.out.println(Long.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(PowFunction.power(2,31));
        System.out.println(PowFunction.power(2,62)); // because 1 bit for +/-

        System.out.println(PowFunction.myPow(2.0, -2147483648));
        System.out.println(PowFunction.myPow(2.0, -2147483647));
        System.out.println(PowFunction.myPow(2.0, -2));
    }
}
