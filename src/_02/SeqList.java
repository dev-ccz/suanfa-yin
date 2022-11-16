package _02;

import java.util.Iterator;

/**
 * @author Zcc
 * created on 22/11/15 21:01
 */
public class SeqList<T> implements Iterable<T> {

    protected Object[] elements;
    protected int n;

    public SeqList(int length) {
        this.n = 0;
        this.elements = new Object[length];
    }

    public SeqList() {
        this(512);
    }

    public SeqList(T[] values) {
        this(values.length);
        for (int i = 0; i < values.length; i++) {
            this.elements[i] = values[i];
        }
        this.n = this.elements.length;
    }

    public SeqList(T[] values, int n) {
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
            if (this.elements[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    public T remove(T x) {
        return this.remove(this.search(x));
    }

    public boolean contains(T x) {
        return this.search(x) != -1;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SeqList<?>) {
            SeqList<T> tempList = (SeqList<T>) obj;
            if (this.n == tempList.n) {
                for (int i = 0; i < n; i++) {
                    if (!this.get(i).equals(tempList.get(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }


    public int insertDifferent(int i, T x) {
        return this.search(x) == -1 ? this.insert(i, x) : -1;

    }

    public int insertDifferent(T x) {
        return this.search(x) == -1 ? this.insert(x) : -1;
    }


    public boolean isDifferent() {
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < i; j++) {
                if (this.elements[i].equals(this.elements[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public void removeAll(T x) {
        int i = 0;
        while (i < this.n) {
            if (this.elements[i].equals(x)) {
                this.remove(i);
            } else {
                i++;
            }
        }
    }

    public void replaceFirst(T key, T x) {
        if (key != null && x != null) {
            int search = this.search(key);
            if (search != -1) {
                this.set(x, search);
            }
        }

    }

    public void replaceAll(T key, T x) {
        if (key != null && x != null) {
            for (int i = 0; i < this.n; i++) {
                if (key.equals(this.elements[i])) {
                    this.set(x, i);
                }
            }
        }
    }

    public int searchLast(T x) {
        for (int i = this.n - 1; i > -1; i--) {
            if (this.elements[i].equals(x)) {
                return i;
            }
        }
        return -1;
    }

    public SeqList(SeqList<? extends T> seqList, int type) {
        if (type == 1) {//浅拷贝
            this.n = seqList.n;
            this.elements = seqList.elements;
        } else {
            this.n = seqList.n;
            this.elements = new Object[seqList.elements.length];
            for (int i = 0; i < seqList.n; i++) {
                this.elements[i] = seqList.elements[i];
            }
        }
    }

    public <t extends Comparable<t>> boolean isSorted() {
        for (int i = 0; i < this.n - 1; i++) {
            if (((t) this.elements[i]).compareTo((t) this.elements[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public void addAll(SeqList<T> seqList) {

    }

    public void insertAll(int i, SeqList<T> seqList) {

    }

    public void unionAll(SeqList<T> seqList) {

    }

    public void retainAll(SeqList<T> seqList) {

    }

    public void containsAll(SeqList<T> seqList) {

    }

    public void removeAll(SeqList<T> seqList) {

    }



    public SeqList<T> sublist(int begin, int end) {
        return null;
    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
