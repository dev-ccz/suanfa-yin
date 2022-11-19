package _02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author Zcc
 * created on 22/11/15 21:59
 */
public class SeqListRun {
    public static void main(String[] args) {
        String[] values={"a","b","c","d","e"};
        SeqList<String> seqList = new SeqList<>(values);
        System.out.println(seqList.toString());
        seqList.insert("7");
        System.out.println(seqList.toString());
        seqList.remove("v");
        System.out.println(seqList.toString());

        SeqList<String> seqList1 = new SeqList<>(values);
        seqList1.insert("1");
        System.out.println(seqList1.toString());
        System.out.println(seqList1.isSorted());
        System.out.println("------------迭代器实验------------");
        SeqList<String> seqList2 = new SeqList<>(values);
        Iterator<String> iterator = seqList2.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if("c".equals(next)){
                iterator.remove();
            }

        }
        System.out.println(seqList2);
    }
}
