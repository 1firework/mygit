package ����ѧ������ϵͳ;

public class Student {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println("1~���ѧ����Ϣ----------------------");
       add();
       System.out.println("2~ɾ��ѧ����Ϣ----------------------");
       remove();
       System.out.println("3~�޸�ѧ����Ϣ----------------------");
       alter();
	}
	public static void add() {
		StringBuffer sb=new StringBuffer();
		StringBuffer bt=new StringBuffer();
		sb.append("���ĺ� ");
		bt.append("184805031");
		System.out.println("append��ӽ����"+sb+bt);
	}
	public static void remove() {
		StringBuffer sb=new StringBuffer("xuwenhao1");
		sb.deleteCharAt(8);
		System.out.println("ɾ��ָ��λ�ý����"+sb);
		sb.delete(0,sb.length());
		System.out.println("��������������"+sb);
	}
	public static void alter() {
		StringBuffer sb=new StringBuffer("���ĺ�");
		sb.replace(0,1,"��" );
		System.out.println("�޸�ָ��λ�ý����"+sb);
	}

}
