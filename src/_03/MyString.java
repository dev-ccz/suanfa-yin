package _03;

import java.io.Serializable;
import java.time.temporal.Temporal;

/**
 * @author Zcc
 * created on 22/11/18 20:13
 */
public class MyString implements Comparable<MyString>, Serializable {


    private final char[] value;

    public MyString() {
        this.value = new char[0];
    }

    public MyString(String value) {
        this.value = new char[value.length()];
        for (int i = 0; i < value.length(); i++) {
            this.value[i] = value.charAt(i);
        }
    }

    public MyString(char[] value, int i, int n) {
        if (i >= 0 && n >= 0 && n <= value.length - 1 && i < n) {
            this.value = new char[n - i + 1];
            for (int j = 0; j < this.value.length; j++) {
                this.value[j] = value[i + j];
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public MyString(char[] value) {
        this(value, 0, value.length - 1);
    }

    public MyString(MyString string) {
        this(string.value);
    }

    public int length() {
        return this.value.length;
    }

    public boolean isEmpty() {
        return this.value.length == 0;
    }

    public char charAt(int index) {
        if (index >= 0 && index < this.value.length) {
            return this.value[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public MyString subString(int from, int end) {
        return new MyString(this.value, from, end);
    }

    public MyString subString(int from) {
        return new MyString(this.value, from, this.value.length - 1);
    }

    public MyString contact(MyString string) {
        if (string == null) {
            string = new MyString("null");
        }
        char[] chars = new char[this.value.length + string.length()];
        int i = 0;
        for (; i < this.value.length; i++) {
            chars[i] = this.value[i];
        }
        for (int j = 0; j < string.length(); j++) {
            chars[i + j] = string.value[j];
        }

        return new MyString(chars);
    }

    public MyString trim() {
        char[] chars = new char[this.value.length];
        int index = 0;
        for (int i = 0; i < this.value.length; i++) {
            if (' ' != this.value[i]) {
                chars[index++] = this.value[i];
            }
        }
        if (index == 0) {
            return new MyString("");
        }
        return new MyString(chars, 0, index - 1);
    }

    public static MyString reserve(MyString str) {
        if (str == null || str.length() == 0) {
            return new MyString("");
        }
        char[] value = str.value;
        for (int i = 0, j = value.length - 1; i <= j; i++, j--) {
            char c = value[j];
            value[j] = value[i];
            value[i] = c;
        }
        return new MyString(value);
    }

    //暴力查找
    public int indexOf(MyString pattern, int begin) {
        int n = this.length();
        int m = pattern.length();
        if (begin < 0) {
            begin = 0;
        }

        if (n == 0 || n < m || begin >= n) {
            return -1;
        }
        int i = begin, j = 0;
        while (i < n && j < m) {
            if (this.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
                if (m + i > n) {
                    break;//剩余的字符长度不足m了，不可能存在了 直接返回
                }
            }
        }
        if (j == m) {
            return i - j;
        }
        return -1;
    }

    public MyString replaceFirst(MyString pattern, MyString string) {
        int index = this.indexOf(pattern, 0);
        if (index != -1) {
            char[] chars = new char[this.value.length + string.length()];
            int i = 0;
            int j = 0;
            for (i = 0; i < index; i++) {
                chars[j++] = this.value[i];
            }
            for (int k = 0; k < string.length(); k++) {
                chars[j++] = string.charAt(k);
            }
            for (i = i + pattern.length(); i < this.length(); i++) {
                chars[j++] = this.value[i];
            }
            return new MyString(chars);
        }
        return new MyString(this.value);
    }

    public MyString replaceAll(MyString pattern, MyString string) {
        MyString temp = new MyString(this);
        int i = temp.indexOf(pattern, 0);
        while (i != -1) {
            temp = temp.replaceFirst(pattern, string);
            i = temp.indexOf(pattern, i + string.length());
        }
        return temp;
    }

    @Override
    public String toString() {
        return new String(this.value);
    }


    @Override
    public int compareTo(MyString o) {
        return 0;
    }


}
