package 简易学生管理系统;

public class Student {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println("1~添加学生信息----------------------");
       add();
       System.out.println("2~删除学生信息----------------------");
       remove();
       System.out.println("3~修改学生信息----------------------");
       alter();
	}
	public static void add() {
		StringBuffer sb=new StringBuffer();
		StringBuffer bt=new StringBuffer();
		sb.append("徐文豪 ");
		bt.append("184805031");
		System.out.println("append添加结果："+sb+bt);
	}
	public static void remove() {
		StringBuffer sb=new StringBuffer("xuwenhao1");
		sb.deleteCharAt(8);
		System.out.println("删除指定位置结果："+sb);
		sb.delete(0,sb.length());
		System.out.println("清除缓冲区结果："+sb);
	}
	public static void alter() {
		StringBuffer sb=new StringBuffer("刘文豪");
		sb.replace(0,1,"徐" );
		System.out.println("修改指定位置结果："+sb);
	}

}
