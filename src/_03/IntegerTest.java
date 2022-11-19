package _03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Zcc
 * created on 22/11/19 13:06
 */
public class IntegerTest {
    public static void main(String[] args) {
        System.out.println(MyInteger.toString(15,2));
        System.out.println(MyInteger.toString(-15,2));
        System.out.println(Integer.toString(MyInteger.max_value,2));
    }
}
