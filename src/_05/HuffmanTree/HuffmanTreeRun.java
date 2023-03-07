package _05.HuffmanTree;

public class HuffmanTreeRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text="AAAABBBCDDBBAAA";
		int []weights= {7,5,1,2};//���ֵ�Ƶ��
		HuffmanTree hf=new HuffmanTree(weights);
		System.out.println(hf.toString());
		String c=hf.encode(text);
		System.out.println(c);
		String t=hf.decode(c);
		System.out.println(t);
		
	}

}
