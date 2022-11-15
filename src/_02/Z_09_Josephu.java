package _02;

import java.util.Arrays;

/**
 * @author Zcc
 * created on 22/11/15 20:21
 * 约瑟夫环问题
 */
public class Z_09_Josephu {

    public static void main(String[] args) {
        josephus(7, 0, 4);
    }

    public static void josephus(int size, int from, int length) {
        Z_03_SeqList<String> list = new Z_03_SeqList<>(size);
        for (int i = 0; i < size; i++) {
            list.insert(i, (char) ('a' + i) + "");
        }
        System.out.println(list);
        int i = from;
        while (list.size() > 1) {
            i = (i + length - 1) % list.size();
            System.out.println("删除了" + list.remove(i));
            System.out.println(list);
        }
        System.out.println(list.get(0));
    }


}
