package _05.BinaryTree;

public class BinaryTree<T> {
	public  BinaryTreeNode <T> root;//?????
	public BinaryTree() {
		this.root=null;//?????
	}
	public boolean isEmpty() {
		return this.root==null;//?ж????
	}
	public BinaryTreeNode <T> insert(T x,boolean leftchild){
		//?????????????
		if (leftchild) {
			return this.root=new BinaryTreeNode <T>(x,this.root,null);
		}else {
			return this.root=new BinaryTreeNode <T>(x,null,this.root);
		}
		
	}
	public BinaryTreeNode <T> insert(BinaryTreeNode <T> parent,T x,boolean leftchild){
		if(x==null) {
			return null;
		}
		if(leftchild) { //?ж????????
			return parent.left=new BinaryTreeNode <T>(x,parent.left,null);
	
		}else {
			return parent.right=new BinaryTreeNode <T>(x,null,parent.right);
			
		}
		
		
	}
	public  void  clear() {
		this.root=null;//????????
	}
	public void remove(BinaryTreeNode <T> parent ,boolean leftchild) {
		if (leftchild) {
			parent.left=null;
		}else {
			parent.right=null;
		}
	}
	public void preorder() {
		 preorder(this.root) ;//?????
		 System.out.println();//????
	}
	public void preorder(BinaryTreeNode <T> p) {
		 if(p!=null) {
			 System.out.print(p.data.toString()+" ");
			 preorder(p.left);
			 preorder(p.right);//???????
		 }
	}
	public void inorder() {
		 inorder(this.root) ;//?????
		 System.out.println();//????
	}
	public void inorder(BinaryTreeNode <T> p) {
		 if(p!=null) {
			 inorder(p.left);
			 System.out.print(p.data.toString()+" ");
			 inorder(p.right);//???????
		 }
	}
	public void postorder() {
		 postorder(this.root) ;//?????
		 System.out.println();//????
	}
	public void postorder(BinaryTreeNode <T> p) {
		 if(p!=null) {
			 postorder(p.left);
			
			 postorder(p.right);//???????
			 System.out.print(p.data.toString()+" ");
		 }
	}
	public String  toString() {
		return toString(this.root);//?????????
	}
	public String  toString(BinaryTreeNode <T> p) {
		if(p==null) {
			return "^";
		}else {
			return p.data.toString()+" "+toString(p.left)+ toString(p.right);//???
			
		}
	}
	public  int size() {
		return size(root);//????????????
	}
	public  int size(BinaryTreeNode <T> p) {
		if(p==null) {
			return 0;
		}else {
			return 1+size(p.left)+size(p.right);//?????????????
		}
	}
	public  int height() {
		return size(root);//????????????
	}
	public  int height(BinaryTreeNode <T> p) {
		if(p==null) {
			return 0;
		}else {
			int leftheight=height(p.left);
			int rightheight=height(p.right);//??????
			return rightheight>=leftheight?leftheight+1:rightheight+1;//?????????
			
			
		}
	}
	public  BinaryTree(T[] prelist) {
		this.root=create(prelist) ;//??鹹???????
	}
	public int i=0;//??????к?
	public  BinaryTreeNode <T> create(T[] prelist) {
		 BinaryTreeNode <T> p=null;
		 if(i<prelist.length) {
			 T elem=prelist[i];//???????????????
			 i++;
			 if(elem!=null) {
				 p=new BinaryTreeNode <T> (elem);//???????
				 p.left=create(prelist); //??鹹?????
				 p.right=create(prelist);//??鹹?????
			 }
		 }
		 return p;
	}
	public  BinaryTree(BinaryTree<T> bittree) {
		//????
		this.root=copy(bittree.root);//????
	}
	public   BinaryTreeNode <T> copy(BinaryTreeNode <T> p){
		if (p==null) {
			return null;
		}
		BinaryTreeNode <T> q=new BinaryTreeNode <T> (p.data);//??????
		q.left=copy(p.left);
		q.right=copy(p.right);//???????
		return q;//????????
		
	}
	public  void printGenlist() {
		System.out.print("??????????????");
		printGenlist(this.root);//?????
		System.out.println();
		
	}
	public  void printGenlist(BinaryTreeNode <T> p) {
		if(p==null) {
			System.out.print("^");
		}else {
			System.out.print(p.data.toString());
			if(p.left!=null || p.right!=null) {
				System.out.print("(");
				printGenlist(p.left);//??????
				System.out.print(",");
				printGenlist(p.right);//??????
				System.out.print(")");
			}
		}
		
	}
	//?????????????
	// A      CBA  //ABC
	//B C
	//DEFG    EDBA  // A BDE CFG
	public  void preorderTraverse() {
		if(this.root==null) {
			return ;
		}
		System.out.println("???????????");
		LinkedStack<BinaryTreeNode <T>>stack=new 		LinkedStack<BinaryTreeNode <T>>();
		BinaryTreeNode <T>p=this.root;//????????
		while(p!=null || !stack.isEmpty()) {
			if(p!=null) {
				System.out.println(p.data+" ");
				stack.push(p);//???
				p=p.left;//??????????
			}else {
				System.out.println("^ ");
				p=stack.pop();//????
				p=p.right;//??????????
			}
		}
		System.out.println();
		
		
	}
	public  void inorderTraverse() {
		if(this.root==null) {
			return ;
		}
		System.out.println("???????????");
		LinkedStack<BinaryTreeNode <T>>stack=new 		LinkedStack<BinaryTreeNode <T>>();
		BinaryTreeNode <T>p=this.root;//????????
		while(p!=null || !stack.isEmpty()) {
			if(p!=null) {
				//
				stack.push(p);//???
				p=p.left;//??????????
			}else {
				//System.out.println("^ ");
				p=stack.pop();//????
				System.out.println(p.data+" ");
				p=p.right;//??????????
			}
		}
		System.out.println();
		
	}
	//?????????????
		// A      //BCA
		//B C     //DEB   FGC  A
		//DEFG    //FGCA  //DEB FGC A
	public  void postorderTraverse() {
		if(this.root==null) {
			return ;
		}
		System.out.println("???????????");
		LinkedStack<BinaryTreeNode <T>>stack=new 		LinkedStack<BinaryTreeNode <T>>();
		BinaryTreeNode <T> curnode;//??????
		BinaryTreeNode <T> lastvisitnode;//??ε???
		curnode=this.root;//??????
		lastvisitnode=null;//??η?????
		while(curnode!=null) {
			stack.push(curnode);
			curnode=curnode.left;//??????·?
		}
		while(!stack.isEmpty()) {
			curnode=stack.pop();//??????
			if(curnode.right!=null && curnode.right!= lastvisitnode) {
				stack.push(curnode);//?????
				curnode=curnode.right;//??????
				while(curnode!=null) {
					stack.push(curnode);//?????
					curnode=curnode.left;//??????
				}
				
				
			}else {
				System.out.println(curnode.data+" ");
				lastvisitnode=curnode;//???????????
			}
			
		}
		
		
	}
	//  A
	// BC           _____GH__EF__BC_A___
	//EFGH
	public  void  levelorder() {
		
		System.out.println("??α???????");
		SeqQueue<BinaryTreeNode <T> > sq=new SeqQueue<BinaryTreeNode <T> > ();
		BinaryTreeNode <T> p=this.root;//????????
		while(p!=null) {
			System.out.println(p.data+" ");
			if(p.left!=null) {
				sq.add(p.left); //??????
			}
			if(p.right!=null) {
				sq.add(p.right); //??????
			}
			p=sq.poll();//??????
		}
		System.out.println(" ");
		
		
	}
	public  void  levelorder2() {
		if(this.root==null) {
			return ;
		}
		System.out.println("??α???????");
		SeqQueue<BinaryTreeNode <T> > sq=new SeqQueue<BinaryTreeNode <T> > ();
		sq.add(this.root);
		
		
		while(sq.isEmpty()) {
			BinaryTreeNode <T> p=sq.poll();//??????
			System.out.println(p.data+" ");
			if(p.left!=null) {
				sq.add(p.left); //??????
			}
			if(p.right!=null) {
				sq.add(p.right); //??????
			}
		
		}
		System.out.println(" ");
	}
	//"A(B,C(D(F,G(J,^)),E(H(K,L),I(^,M)))"
	public static int o=0;//??????????????????
	public static BinaryTree<String>createByGenlist(String genlist){
		BinaryTree<String> btree=new BinaryTree<String>();
		o=0;
		if(genlist.length()>0) {
			btree.root=create(genlist);//?ж?
		}
		return btree;
		
	}
	//"A(Baa,C(D(F,G(J,^)),E(H(K,L),I(^,M)))"
	public static BinaryTreeNode <String> create(String genlist){
		BinaryTreeNode <String> p=null;//???
		char ch=genlist.charAt(o);//??????
		if(ch=='^') {
			o++;
			return null;//????????
		}
		int end=o;
		while(end<genlist.length() &&ch!='(' && ch!=')'&& ch!=',')
		{
			end++; //????????????
			ch=genlist.charAt(end);
		}
		String str=genlist.substring(o,end);
		o=end;//????????
		p=new 	BinaryTreeNode <String>(str);//????????
		if(genlist.charAt(o)=='(') {
			o++;
			p.left=create(genlist); //???????
			o++;
			p.right=create(genlist);//???????
			o++;
		}
		
		return p;
	}
	
	
 }
