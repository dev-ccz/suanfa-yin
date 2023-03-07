package _05.BinaryTree;

public class LinkedStack<T> implements Stack<T> {
	private  SinglyList<T> list;
	public LinkedStack() {
		this.list=new SinglyList<T>();//��ʼ������
	}
	
	
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.list.isEmpty();
	}

	@Override
	public void push(T x) {
		// TODO Auto-generated method stub
		this.list.insert(0,x);//ѹջ
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		
		return this.list.get(0);//ȡ��
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		return this.list.remove(0);
	}
	
	public String toString() {
		return this.getClass().getName()+" "+this.list.toString();//����
	}
	
}
