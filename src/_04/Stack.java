package _04;

/**
 * @author Zcc
 * created on 22/11/26 19:14
 */
public interface Stack<T> {

    boolean isEmpty();

    void push(T t);

    T peek();

    T pop();
}
