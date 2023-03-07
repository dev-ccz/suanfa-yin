package _05.HuffmanTree;

public class TriElement {
	int data;//����
	int parent,left,right;//���׽ڵ㣬���ӣ��Һ����±�
	public TriElement (int data,int parent,int left, int right) {
		this.data=data;
		this.parent=parent;
		this.left=left;
		this.right=right;//ѭ���ڵ�Ԫ�س�ʼ��
	}
	public TriElement(int data){
		this(data,-1,-1,-1);
	}
	public String toString() {
		return "<"+this.data+","+this.parent+","+this.left+","+this.right+">";
	}
	public boolean isLeaf() {
		return this.left==-1 &&this.right==-1;//�ж�Ҷ�ӽڵ�
	}
	
	
	
}
