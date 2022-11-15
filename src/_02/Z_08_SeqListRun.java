package _02;

/**
 * @author Zcc
 * created on 22/11/15 21:59
 */
public class Z_08_SeqListRun {
    public static void main(String[] args) {
        String[] values={"A","v","x","2","t"};
        Z_03_SeqList<String> seqList = new Z_03_SeqList<>(values);
        System.out.println(seqList.toString());
        seqList.insert("7");
        System.out.println(seqList.toString());
        seqList.remove("v");
        System.out.println(seqList.toString());
    }
}
