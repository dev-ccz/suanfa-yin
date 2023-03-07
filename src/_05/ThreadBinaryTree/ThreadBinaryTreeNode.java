package _05.ThreadBinaryTree;

public class ThreadBinaryTreeNode<T> {
	public T data;    
    public ThreadBinaryTreeNode<T> left, right;//����ָ��
    public boolean ltag, rtag;                 //�����������

    public ThreadBinaryTreeNode(T data,ThreadBinaryTreeNode<T>left, boolean ltag,  ThreadBinaryTreeNode<T> right, boolean rtag) {
    	this.data=data;
    	this.left=left;
    	this.ltag=ltag;
    	this.right=right;
    	this.rtag=rtag;//��ʼ��
    }
    public ThreadBinaryTreeNode(T data)   {
    	this(data,null,false,null,false);//���캯������
    }
    public String toString() {
    	
    	return data.toString();//�ַ���ת��
    }
    public boolean isLeaf() {
    	return !this.ltag &&!this.rtag;//�ж�Ҷ�ӽڵ�
    }


}
