package _05.ThreadBinaryTree;

public class ThreadBinaryTreeRun {
	public static void main(String args[]) {
		String[] prelist= {"A","B","D",null,null,"E","G",null,null,null,"C","F",null,"H",null,null,"K"};
		ThreadBinaryTree <String> tbtree=new ThreadBinaryTree <String>(prelist);
		tbtree.preorder();
		tbtree.inorder();
		
		tbtree.postorder();
	
	}
}
