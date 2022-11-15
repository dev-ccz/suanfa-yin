package _01;

/**
 * @author Zcc
 * created on 22/11/14 20:54
 * 最大公约数
 */
public class Z_05_GCD {


    public static void main(String[] args) {
        System.out.println(gcd01(16, 3));
        System.out.println(gcd02(18, 0));
        System.out.println(gcd03(4, 12, 8, 20));
    }

    /**
     * 欧几里得 辗转相除法
     */
    public static int gcd01(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static int gcd02(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd02(b, a % b);
    }

    /**
     * 求n个数的最大公约数
     */
    public static int gcd03(int... x) {
        if (x.length == 1) {
            return x[0];
        }
        if (x.length == 2) {
            return gcd01(x[0], x[1]);
        }
        int x1 = x[0];
        for (int i = 1; i < x.length; i++) {
            x1 = gcd01(x1, x[i]);
        }
        return x1;
    }
}
