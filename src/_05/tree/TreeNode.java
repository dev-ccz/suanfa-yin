package _05.tree;

public class TreeNode<T> {
	public T data;//����
	public TreeNode<T> parent,child,sibling;//��ĸ�ڵ㣬���ӽڵ㣬�ֵܽڵ㣬��������
	public int level;//�ڵ���
	
	public TreeNode(T data, int level,TreeNode<T> parent,TreeNode<T> child,TreeNode<T> sibling) {
		this.data=data;
		this.level=level;
		this.parent=parent;
		this.child=child;
		this.sibling=sibling;//��ʼ���ɹ�
	}
	public TreeNode(T data,int level) {
		this(data,level,null,null,null);//��ʼ��
	}
	public String toString() {
		return this.data.toString();//�ڵ���Ϣ
	}
	public boolean isLeaf() {
		return this.child==null;
	}
}
