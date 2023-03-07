package _05.BinaryTree;

public class SeqQueue <T> implements Queue<T>{

	private Object elements[];//�洢������
	private int front ,rear;//��ǿ�ͷ���
	
	public SeqQueue(int length) {
		if(length<64) {
			length=64;
		}
		this.elements=new Object[length];
		this.front=this.rear=0;//��ʼ��
	}
	
	public SeqQueue() {
		this(64);//��ʼ��
	}
	
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.front==this.rear;
	}

	@Override
	public boolean add(T x) {
		if (x==null) {
			return false;
		}
		//�������ˣ�����
		if(this.front==(this.rear+1)%this.elements.length) {
			Object[]temp=this.elements;
			this.elements=new Object[temp.length*2];
			int j=0;
			for(int i=this.front;i!=this.rear;i=(i+1)%temp.length) {
				this.elements[j++]=temp[i];//ѭ������
			}
			this.front=0;//��λ
			this.rear=j;
		}
		this.elements[this.rear]=x;
		this.rear=(this.rear+1)%this.elements.length;//ѭ��
		
		return false;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return this.isEmpty()?null:(T)this.elements[this.front];
	}

	@Override
	public T poll() {
		// TODO Auto-generated method stub
		if(this.isEmpty()) {
			return null;
		}
		T temp=(T)this.elements[this.front];//ȡ������
		this.front=(this.front+1)%this.elements.length;//ȡ�����ݣ�
		
		return temp;
	}
	
	public String toString() {
		StringBuffer strbuf=new StringBuffer(this.getClass().getName()+"->");
		for(int i=this.front;i!=this.rear;i=(i+1)%this.elements.length) {
			strbuf.append(this.elements[i].toString()+" ");
		}
				
			
		return new String(strbuf);	
	}

}
