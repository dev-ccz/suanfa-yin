package _05.ThreadBinaryTree;

public class ThreadBinaryTree <T>{
       public  ThreadBinaryTreeNode<T> root;//���ڵ�
       public ThreadBinaryTree() {
    	   this.root=null;//����յ�����������
       }
       public  boolean isEmpty() {
    	   return this.root==null;//�ж�Ϊ��
       }
       public ThreadBinaryTree(T[] prelist) { //�������У�������������������
    	   this.root=create(prelist);//����������������
    	   inorderThread(this.root);//����������������
       }
       public int i=0;//���л��ı��
      
       public ThreadBinaryTreeNode<T> create(T[] prelist){
    	   ThreadBinaryTreeNode<T> p=null;//ԭʼ�ڵ�
    	   if(i<prelist.length) {
    		   T elem=prelist[i++];//��ȡԪ��
    		   if(elem!=null) {
    			   p=new ThreadBinaryTreeNode<T>(elem);//����ڵ�
    			   p.left=create(prelist);//�������
    			   p.right=create(prelist);//�����ұ�
    		   }
    	   }
    	   return p;
    	   
       }
       
       
       
       public   ThreadBinaryTreeNode<T>front=null;
       public void inorderThread(ThreadBinaryTreeNode<T> p) {
    	   if(p!=null) {
    		   inorderThread(p.left);
    		   if(p.left==null) {
    			   p.ltag=true;//��ߵ�����
    			   p.left=front;//ǰ�����
    		   }
    		   if(p.right==null) {
    			   p.rtag=true;//�ұ�Ϊ��
    		   }
    		   if(front!=null && front.rtag) {
    			   front.right=p;//�ұ�����
    		   }
    		   front=p;//��һ���ڵ�
    		   inorderThread(p.right);
    	   }
       }
       //  4
       // 2 6
       //13  57
       public ThreadBinaryTreeNode<T> inNext(ThreadBinaryTreeNode<T> p){
    	   if(p.rtag) { //�ұ��б�ǣ�ָ���̽ڵ�
    		   return p.right;
    	   }
    	   p=p.right;//��һ��
    	   while(!p.ltag) {
    		   p=p.left;//ѭ������
    	   }
    	   return p;
       }
       
       public void inorder() { //�������
    	   ThreadBinaryTreeNode<T>p=this.root;
    	   while(p!=null && !p.ltag) {
    		   p=p.left;//ѭ�������
    	   }
    	   while(p!=null) {
    		   System.out.print(p.data.toString()+" ");
    		   p=this.inNext(p);
    	   }
    	   System.out.println();
       }
       //  4
       // 2 6
       //13  57
       public ThreadBinaryTreeNode<T> preNext(ThreadBinaryTreeNode<T> p){
    	   if(!p.ltag) {
    		   return p.left;//p����ڵ㣬p�����Ӻ��
    	   }
    	   while(p.rtag && p.right!=null) {
    		   p=p.right;//����ұ���������
    	   }
    	   return p.right;//�Һ����Ǻ��
       }
       public void preorder() {
    	   //��ʼ��
    	   for(  ThreadBinaryTreeNode<T>p=this.root;p!=null;p=preNext(p)) {
    		   System.out.print(p.data.toString()+" ");
    	   }
    	   System.out.println();
       }
       public ThreadBinaryTreeNode<T> postPrev(ThreadBinaryTreeNode<T> p){
    	   if(!p.rtag) {
    		   return p.right;//p���Һ��ӣ�p�Һ�����ǰ��
    	   }
    	   while(p.ltag && p.left!=null) {
    		   p=p.left;//����ұ���������
    	   }
    	   return p.left;//�Һ����Ǻ��
       }
       public void postorder() {
    	   //��ʼ��
    	   for(  ThreadBinaryTreeNode<T>p=this.root;p!=null;p=postPrev(p)) {
    		   System.out.print(p.data.toString()+" ");
    	   }
    	   System.out.println();
       }
}
