package _05.tree;

public class TreeRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String prelist[]={"�й�","\t����","\t�Ϻ�","\t����","\t\t�Ͼ�","\t\t\t����","\t\t����",
                "\t\t����","\t\t\t��ɽ","\t�㽭","\t\t����","\t\t����","\t\t����","\t�㶫","\t\t����",
                "����","\t�׶�","����","�����","����","\t��ʢ��","\tŦԼ��","\t\tŦԼ"};
		
		Tree<String>mytree=Tree.create(prelist);
		mytree.preorder();
		mytree.postorder();
		System.out.println(mytree.toString());
	}

}
