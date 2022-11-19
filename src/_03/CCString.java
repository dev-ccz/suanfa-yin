package _03;

/**
 * @author Zcc
 * created on 22/11/18 20:07
 */
public interface CCString {
    int length();

    char charAt(int i);

    void setCharAt(int i, char ch);

    CCString subString(int begin, int end);

    CCString concat(CCString string);

    CCString insert(int i, CCString string);

    CCString delete(int begin, int end);

    int indexOf(CCString pattern);

    void removeAll(CCString pattern);

    void replaceAll(CCString pattern, CCString str);

}
