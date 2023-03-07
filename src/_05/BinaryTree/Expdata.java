package _05.BinaryTree;

public class Expdata {
	int value;//������ֵ
	char oper;//�����
	
	public Expdata(int value,char oper) {
		this.value=value;
		this.oper=oper;//��ʼ��
	}
	public String toString() { //Ҫô�����������
		return this.oper==' '?this.value+"":this.oper+"";
	}
	public boolean equals(Object obj) {
		if(obj==this) {
			return true;
		}
		if(obj instanceof Expdata) {
			Expdata exp=(Expdata )obj;//����ת���������ж��Ƿ����
			return this.value==exp.value && this.oper==exp.oper;
		}
		
		return false;
	}
	
}
