package _05.BinaryTree;

public interface Stack<T> {
    public abstract boolean isEmpty();           //�ж�ջ�Ƿ��
    public abstract void push(T x);              //Ԫ��x��ջ
    public abstract T peek();                    //����ջ��Ԫ�أ�δ��ջ
    public abstract T pop();                     //��ջ������ջ��Ԫ��
}
