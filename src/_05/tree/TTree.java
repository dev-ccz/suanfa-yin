package _05.tree;

public interface TTree<T> {
	boolean isEmpty();//�ж��Ƿ�Ϊ��
	int level(T key);//�жϲ��
	int size();//�ڵ�����
	int height();//���ĸ߶�
	
	void preorder();//�ȸ�����
	void postorder();//�������
	void levelorder();//��α���
	
	TreeNode<T> insertRoot(T x);//�����ڵ����
	TreeNode<T> insertChild(TreeNode<T> p,T x,int i);//����x����p�ڵ��i������
	void remove(TreeNode<T> p,int i);//ɾ����i������
	void clear();//���
	
	TreeNode<T> search(T x);//����
	T remove(T x);//ɾ��
	boolean contains(T key);//�ж��Ƿ����
	
	
	
	
}
