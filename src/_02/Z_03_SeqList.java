package _02;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author Zcc
 * created on 22/11/15 21:01
 */
public class Z_03_SeqList<T> implements Iterable<T> {

    protected Object[] elements;
    protected int n;

    public Z_03_SeqList(int length) {
        this.n = 0;
        this.elements = new Object[length];
    }

    public Z_03_SeqList() {
        this(512);
    }

    public Z_03_SeqList(T[] values) {
        this(values.length);
        for (int i = 0; i < values.length; i++) {
            this.elements[i] = values[i];
        }
        this.n = this.elements.length;
    }

    public Z_03_SeqList(T[] values, int n) {
        this(values.length * n);
        for (T value : values) {
            if (value != null) {
                this.elements[n++] = value;
            }
        }
    }

    public int insert(T x) {
        return this.insert(this.n, x);
    }

    public boolean isEmpty() {
        return this.n == 0;
    }

    public int size() {
        return this.n;
    }

    public T get(int i) {
        if (i >= 0 && i < this.n) {
            return (T) this.elements[i];
        }
        return null;
    }

    public void set(T x, int i) {
        if (i >= 0 && i < this.n) {
            this.elements[i] = x;
        }
    }

    @Override
    public String toString() {
        String str = "(";
        if (this.n > 0) {
            str += this.elements[0].toString();
        }
        for (int i = 1; i < this.n; i++) {
            str += "," + this.elements[i].toString();
        }
        return str + ")";
    }

    public int insert(int i, T x) {
        if (x != null) {
            i = Math.max(0, i);
            Object[] source = this.elements;
            if (this.n == this.elements.length) {
                this.elements = new Object[source.length * 2];
                for (int j = 0; j < i; j++) {
                    this.elements[j] = source[j];
                }
            }
            for (int j = this.n - 1; j >= i; j--) {
                this.elements[j + 1] = source[j];
            }
            this.elements[i] = x;
            this.n++;
            return i;
        }
        return -1;
    }

    public T remove(int i) {
        if (this.n > 0 && i >= 0 && i < this.n) {
            T old = (T) this.elements[i];
            for (int j = i; j < this.n - 1; j++) {
                this.elements[j] = this.elements[j + 1];
            }
            this.elements[n - 1] = null;
            n--;
            return old;
        }
        return null;
    }

    public void clear() {
        this.n = 0;
    }

    public int search(T t) {
        for (int i = 0; i < this.n; i++) {
            if (t.equals(this.elements[i])) {
                return i;
            }
        }
        return -1;
    }

    public T remove(T x) {
        return this.remove(this.search(x));
    }



    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
