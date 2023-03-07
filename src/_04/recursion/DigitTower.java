package _04.recursion;

/**
 * @author zcc
 * 数组塔
 */
public class DigitTower {
    /**
     * 打印每一行
     *
     * @param i 最小值
     * @param n 最大值
     */
    public static void line(int i, int n) {
        System.out.printf("%d", i);
        if (i < n) {
            line(i + 1, n);
            System.out.printf("%d", i);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        for (int i = 1; i <= n; i++) {
            int em = (n - i);
            if (em != 0) {
                System.out.printf("%" + em + "c", ' ');
            }
            line(1, i);
            System.out.println();
        }
    }
}
