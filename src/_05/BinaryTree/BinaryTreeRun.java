package _05.BinaryTree;

public class BinaryTreeRun {

	public static void main1(String[] args) {
		// TODO Auto-generated method stub
		String[]prelist= {"A","B","D",null,"G",null,null,null,"C","E",null,null,"F","H"};
		BinaryTree<String>btree=new BinaryTree<String>(prelist);
		System.out.println(btree.toString());
		btree.inorder();
		btree.preorder();
		btree.postorder();
		btree.levelorder();
		btree.insert(btree.root.left,"X",true);
		btree.inorderTraverse();
		btree.preorderTraverse();
		btree.postorderTraverse();
		btree.levelorder2();
	}
	public static void main(String[] args) {
		String data="A(B,C(D(F,G(J,^)),E(H(K,L),I(^,M))))";
		BinaryTree<String>btree =BinaryTree.createByGenlist(data);
		btree.printGenlist();
	}
}
