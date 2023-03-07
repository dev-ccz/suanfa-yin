package _05.HuffmanTree;
//   4
// 2   6
//1 3 5 7
//1
//  2
//    3
//     4
//       5
//         6
//           7
public class HuffmanTree {
	public  String charset;//�ַ����
	public TriElement[] huftree;//��̬��������ڵ�����
	public  HuffmanTree (int[]weights) {
		this.charset="";
		for(int i=0;i<weights.length;i++) {
			this.charset+=(char)('A'+i);//���
		}
		int n=weights.length;//���ȣ�
		this.huftree=new  TriElement[2*n-1];
		for(int i=0;i<n;i++) {
			this.huftree[i]=new TriElement(weights[i]);//����Ҷ�ӽڵ�
		}
		for(int i=n;i<2*n-1;i++) { //������n-1�����Ƚڵ�
			int min1=Integer.MAX_VALUE;
			int min2=Integer.MAX_VALUE;//����������С��
			int x1=-1;
			int x2=-2;//��С�������ڵ��±�
			for(int j=0;j<i;j++) {
				if (this.huftree[j].parent==-1) { //j���ڵ�û�и��׽ڵ�
					if(this.huftree[j].data<min1) {
						min2=min1;
						x2=x1;//�����С
						min1=this.huftree[j].data;//������С
						x1=j;
						
						
					}else {
						if(this.huftree[j].data<min2) {
							min2=this.huftree[j].data;//�����С
							x2=j;
						}
					}
				}
			}
			this.huftree[x1].parent=i;
			this.huftree[x2].parent=i;
			this.huftree[i]=new TriElement(min1+min2,-1,x1,x2);//����ڵ�
			
		}
		
		
	}
	public  String getcode(int i) { //��i���ַ��ı���
		int n=8;//1���ֽ�8λ
		char hufcode[]=new char[n];//����һ���ַ�����
		int child=i;//������
		int parent=this.huftree[child].parent;//���׽ڵ�
		for(i=n-1;parent!=-1;i--) {
			hufcode[i]=(huftree[parent].left==child)?'0':'1';//���ұ߽ڵ����0��1
			child=parent;
			parent=huftree[child].parent;//���׽ڵ㣬������
		}
		return new String(hufcode,i+1,n-1-i);
		
		
	}
	public  String toString() { //��i���ַ��ı���
		String str="�ڵ�����";
		for(int i=0;i<this.huftree.length;i++) {
			str+=this.huftree[i].toString()+",";//�ַ��ڵ�����
		}
		str+="\n ����";
		for(int i=0;i<this.charset.length();i++) {
			str+=this.charset.charAt(i)+":"+getcode(i)+",";
			
		}
		return str;
	}
	public  String decode(String compressed) { //��i���ַ��ı���
		String text="";
		int node=this.huftree.length-1;//����Ҷ�ӵľ���
		for(int i=0;i<compressed.length();i++) {
			if (compressed.charAt(i)=='0') {
				node=huftree[node].left;
			}else {
				node=huftree[node].right;
			}
			if(huftree[node].isLeaf()) {
				text+=this.charset.charAt(node);//��ȡ�ַ�
				node=this.huftree.length-1;//�л����ڵ����
			}
		}
		
		return text;
		
	}
	public  String encode(String text) { //��i���ַ��ı���
		String compressed="";
		for(int i=0;i<text.length();i++) {
			compressed+=getcode(text.charAt(i)-'A');
		}
		return compressed;
	}
}
