package _03;

/**
 * @author Zcc
 * created on 22/11/19 12:57
 */
public class MyInteger implements Comparable<MyInteger> {


    public static final int min_value = 0x80000000;
    public static final int max_value = 0x7fffffff;
    private final int value;

    public MyInteger(int value) {
        this.value = value;
    }

    public int initValue() {
        return this.value;
    }

    public String toString() {
        return this.value + "";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MyInteger) {
            MyInteger objTemp = (MyInteger) obj;
            return this.value == objTemp.value;

        }
        if (obj instanceof Integer) {
            Integer objTemp = (Integer) obj;
            return objTemp == this.value;
        }

        return false;
    }

    //进制转换 支持 2-16
    public static int parseInt(String s, int radix) {
        if (s == null) {
            throw new NumberFormatException("null");
        }
        if (radix < 2 || radix > 16) {
            throw new NumberFormatException("仅支持2-16进制");
        }
        int value = 0;
        int index = 0;
        int sign = s.charAt(0) == '-' ? -1 : +1;
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            if (s.length() == 1) {
                throw new NumberFormatException("空字符串");
            } else {
                index++;
            }
        }
        while (index < s.length()) {
            char c = s.charAt(index++);
            if (radix <= 10) { //2-10进制
                if (c > '0' && c - '0' < radix) {
                    value = value * radix + c - '0';
                } else {
                    throw new NumberFormatException("进制错误");
                }
            } else {
                //11-16进制
                if (c > '0' && c - '0' < radix) {
                    value = value * radix + c - '0';
                } else if (c >= 'A' && c - 'A' < radix - 10) {
                    value = value * radix + c - 'A' + 10;
                } else if (c >= 'a' && c - 'a' < radix - 10) {
                    value = value * radix + c - 'a' + 10;
                } else {
                    throw new NumberFormatException("进制错误");
                }
            }
        }
        return sign * value;
    }

    //转16进制字符串
    public static String toHexString(int value) {
        char[] buffer = new char[8];
        for (int i = buffer.length - 1; i >= 0; i--) {
            int bit = value & 15;
            buffer[i] = (char) (bit <= 9 ? bit + '0' : bit - 10 + 'a');
            value >>>= 4;
        }
        return new String(buffer);
    }

    public static String toOtcString(int value) {
        char[] buffer = new char[32 / 3 + 1];
        for (int i = buffer.length - 1; i >= 0; i--) {
            int bit = value & 7;
            buffer[i] = (char) (bit + '0');
            value >>>= 3;
        }
        return new String(buffer);
    }


    public static String toBinaryString(int value) {
        char[] buffer = new char[32];
        for (int i = buffer.length - 1; i >= 0; i--) {
            int bit = value & 1;
//            if (bit == 0) break;
            buffer[i] = (char) (bit + '0');
            value >>>= 1;
        }
        return new String(buffer);
    }

    //支持2，4，8，10，16进制
    public static String toString(int value, int radix) {
        if (radix == 10) return value + "";

        if (radix == 2 || radix == 4 || radix == 8 || radix == 16) {
            int max, bitLen = 0;
            for (int i = radix - 1; i > 0; i >>>= 1) {
                bitLen++;
            }
            max = radix - 1;
            char[] buffer = new char[(int) (32.0 / bitLen + 0.5)];
            for (int i = buffer.length - 1; i >= 0; i--) {
                int bit = value & max;
                buffer[i] = (char) (bit <= 9 ? bit + '0' : bit - 10 + 'a');
                value >>>= bitLen;
            }
            return new String(buffer);
        } else {
            throw new NumberFormatException("进制错误,支持2，4，8，10，16进制");
        }
    }


    @Override
    public int compareTo(MyInteger o) {
        return this.value - o.value;
    }
}
