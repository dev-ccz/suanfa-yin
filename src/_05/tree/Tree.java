package _05.tree;

public class Tree<T> {
	public TreeNode <T>root;
	public Tree() {
		this.root=null;//��ʼ��
	}
	public boolean isEmpty() {
		return this.root==null;
	}
	
	public String toString() {
		return "������ʾ\n"+toString(root,"");
	}
	public String toString(TreeNode<T>  p,String tab) {
		if (p==null) {
			return "";
		}
		return tab+p.data.toString()+"\n"+toString(p.child,tab+"\t")+toString(p.sibling,tab);//�ݹ����
	}
	public  void preorder() {
		
		preorder(this.root);
		System.out.println();
	}
	public  void preorder(TreeNode<T>  p) {
		if(p!=null) {
			System.out.print(p.data+" ");
			preorder(p.child);
			preorder(p.sibling);//ѭ������
		}
	}
	public  void postorder() {
		postorder(this.root);
		System.out.println();
	}
	public  void postorder(TreeNode<T>  p) {
		if(p!=null) {
	
			postorder(p.child);
			System.out.print(p.data+" ");
			postorder(p.sibling);//ѭ������
		}
	}
	//�ݹ���ȡ�ڵ�����
	public int size() {
		return size(this.root);
	}
	public int size(TreeNode<T>  p) {
		if(p==null) {
			return 0;
		}
		return 1+size(p.child)+size(p.sibling);
	}
	
	public Tree(Tree<T> tree) {
		this.root=copy(tree.root,null);//��ʼ��
	}
	
	//���
	public TreeNode<T> copy(TreeNode<T> p,TreeNode<T> parent){
		if (p==null) {
			return null;
		}
		TreeNode<T> q=new TreeNode<T>(p.data,p.level,parent,null,null);
		q.child=copy(p.child,q);
		q.child=copy(p.sibling,q);
		return q;//���ؽڵ�
	}
	public void clear() {
		this.root=null;
	}
	public void setLevel(TreeNode<T> p,int level) {
		if(p!=null) {
			p.level=level;
			setLevel(p.child,level+1);
			setLevel(p.sibling,level);
		}
	}
	public  TreeNode<T> insertRoot(T x){
		this.root=new TreeNode<T>(x,1,null,this.root,null);
		if(this.root.child!=null) {
			this.root.child.parent=this.root;
			setLevel(this.root.child,this.root.level+1);//��ɲ���
		}
		
		
		return this.root;
	}
	//String prelist[]={"�й�","\t����","\t�Ϻ�","\t����","\t\t�Ͼ�","\t\t\t����","\t\t����",
    //"\t\t����","\t\t\t��ɽ","\t�㽭","\t\t����","\t\t����","\t\t����","\t�㶫","\t\t����",
    //"����","\t�׶�","����","�����","����","\t��ʢ��","\tŦԼ��","\t\tŦԼ"};
	public static  Tree<String> create(String[]prelist){
		Tree<String> tree =new Tree<String>();
		if (prelist.length==0) {
			return tree; //���ؿ���
			
		}
		tree.root=new TreeNode<String>(prelist[0],1);//���1��
		TreeNode<String>p=tree.root;//���ݸ��ڵ�
		for(int i=1;i<prelist.length;i++) {
			int n=0;//���ٸ�tab�ַ�
			while(n<prelist[i].length() && prelist[i].charAt(n)=='\t') {
				n++;
			}
			String str=prelist[i].substring(n);//ȥ��\t
			if(n==p.level) {
				p.child=new TreeNode<String>(str,p.level+1,p,null,null);
				p=p.child;//ѭ����һ��
		
			}else {
				while(n<p.level-1) {//����Ѱ��λ��
					p=p.parent;
				}
				p.sibling=new TreeNode<String>(str,p.level,p.parent,null,null);
				p=p.sibling;
				
				
			}
			
			
		}
		
		
		return tree;
	}
	
}
