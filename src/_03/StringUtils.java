package _03;

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


}
