package _02;

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
    }
}
