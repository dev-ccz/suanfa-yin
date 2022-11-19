package _03;

/**
 * @author Zcc
 * created on 22/11/18 20:34
 */
public class MyStringTest {
    public static void main(String[] args) {
        MyString myString = new MyString("12332");
        MyString myString1 = new MyString("1234567890".toCharArray(), 3, 9);
        MyString myString2 = new MyString("1234567890".toCharArray());
        MyString myString3 = new MyString(myString2);
        System.out.println(myString3.subString(7));
        System.out.println(myString3.subString(2,7));
        System.out.println(myString3.contact(new MyString("zhangchangchun")));
        System.out.println(myString3.charAt(7));
        System.out.println(myString3.contact(null));
        System.out.println(myString3);
        System.out.println(new MyString(" 12 ").trim());
        System.out.println(new MyString(" 123 333 dx").trim());
        System.out.println(new MyString("      ").trim());
        System.out.println(MyString.reserve(new MyString("1234")));
        System.out.println(MyString.reserve(new MyString("")));

        MyString myString4 = new MyString("aa");
        MyString replaceFirst = myString4.replaceFirst(new MyString("a"), new MyString("xxxxx"));
        MyString all = myString4.replaceAll(new MyString("a"), new MyString("xxxxx"));
        System.out.println(replaceFirst);
        System.out.println(all);
        System.out.println(StringUtils.indexOf("aaaaxxx","ax"));
        String a= """
                aaaaxxx
                """;
        System.out.println(a);
        System.out.println(a.indexOf("ax"));

        String s = Integer.toString(10, 2);
        System.out.println(s);
        System.out.println(Integer.toBinaryString(10));

    }
}
