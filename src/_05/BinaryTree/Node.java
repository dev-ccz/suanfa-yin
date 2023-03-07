package _05.BinaryTree;

public class Node<T>                             //���������࣬Tָ������Ԫ������
{
    public T data;                               //�����򣬴洢����Ԫ��
    public Node<T> next;                         //��ַ�����ú�̽��

    public Node(T data, Node<T> next)            //�����㣬dataָ������Ԫ�أ�nextָ����̽��
    {
        this.data = data;                        //T�������ø�ֵ
        this.next = next;                        //Node<T>�������ø�ֵ
    }
    public Node()
    {
        this(null, null);
    }
    public String toString()                     //���ؽ��������������ַ���
    {
        return this.data.toString();
    }
}
