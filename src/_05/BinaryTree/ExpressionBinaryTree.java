package _05.BinaryTree;

//���ʽ�������࣬�̳ж�����
public class ExpressionBinaryTree extends BinaryTree<Expdata> {
	
	public int i=0;//���ظ���
	public ExpressionBinaryTree () {
		super();//�����ʼ��
	}
	public ExpressionBinaryTree (String prefix) {
		this.root=createPrefix(prefix);//�������
	}
	
	public BinaryTreeNode <Expdata> createPrefix (String prefix) {
		BinaryTreeNode <Expdata> p=null;//����ڵ�
		if(i<prefix.length()) {
			char ch=prefix.charAt(i);//ȡ���ַ�
			if(ch>='0' && ch<='9') {
				int value=0;//����ת��
				while(i<prefix.length()&& ch!=' ') {
					//123
					//0*10+1  1*10+2 12*10+3
					value=value*10+ch-'0';
					i++;
					if (i<prefix.length()) {
						ch=prefix.charAt(i);//ȡ���ַ�
					}
				}
				//������ֵ�ڵ�
				p=new BinaryTreeNode <Expdata>(new Expdata(value,' '));
				i++;//ѭ����һ��
				
			}else {
				p=new BinaryTreeNode <Expdata>(new Expdata(0,prefix.charAt(i)));
				i++;//ѭ����һ��
				p.left=createPrefix(prefix);
				p.right=createPrefix(prefix);//������������������
			}
		}
		return p;
	}
	public int toValue() {
		return this.toValue(this.root);//��������
	}
	public int toValue(BinaryTreeNode <Expdata> p) {
		if(p==null) {
			return 0;
		}
		if(!p.isLeaf()) {
			switch(p.data.oper) {
			case'+':
				p.data.value=toValue(p.left)+toValue(p.right);
				break;
			case'-':
				p.data.value=toValue(p.left)-toValue(p.right);
				break;
			case'*':
				p.data.value=toValue(p.left)*toValue(p.right);
				break;
			case'/':
				p.data.value=toValue(p.left)/toValue(p.right);
				break;
			case'%':
				p.data.value=toValue(p.left)%toValue(p.right);
				break;
			}
		}
		return p.data.value;//���ؼ���
	}
	
	public static void main(String[] args) {
		//"45+(10-15)*((25+35)/(60-40))-11"
		//45+ -5*(3)-11=19
		//-+45*-10 15 / + 25 35 -60 40 11 //ջ�ݹ�ת��
		String prefix="-+45 *-10 15 /+25 35 -60 40 11";  
		ExpressionBinaryTree etree=new ExpressionBinaryTree(prefix);
		etree.preorder();
		etree.inorder();
		etree.postorder();
		
		System.out.println(etree.toValue());
		
		
		
	}
}
