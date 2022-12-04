package _03;

import java.util.Objects;

/**
 * @author Zcc
 * created on 22/11/19 0:12
 */
public class StringUtils {

    public static int indexOf(String string, String substring) {
        int length = string.length();
        int subLength = substring.length();
        if (subLength == 0 || subLength > length) {
            return -1;
        }
        int i = 0, j = 0;
        while (i < length && j < subLength) {
            if (string.charAt(i) == substring.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
                if (i + subLength > length) {
                    break;
                }
            }
        }
        if (j == subLength) {
            return i - j;
        }
        return -1;
    }

    public static int[] next(String pattern) {
        char[] chars = pattern.toCharArray();
        int[] next = new int[chars.length];
        int k = -1, j = 0;
        next[0] = -1;
        while (j < chars.length - 1) {
            if (k == -1 || chars[j] == chars[k]) {
                chars[++j] = chars[++k];
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static int index(String str, String pattern) {
        if (Objects.isNull(str) || Objects.isNull(pattern) || pattern.length() > str.length()) {
            return -1;
        }
        int i = 0, j = 0;
        int[] next = next(pattern);
        int count=0;
        while (i < str.length() && j < pattern.length()) {
            ++count;
            if (j == -1 || str.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        System.out.println("str.length:"+str.length()+",pattern.length:"+pattern.length()+",search.times:"+count);
        if (j >= pattern.length()) return i - j;
        return -1;
    }
}
