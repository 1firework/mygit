package view;

import java.util.Scanner;

import biz.*;
import dao.*;
import entity.*;
	
public class CourseSelectionUI {
	
	public static void show(Student student) {
		SCBiz scBiz=new SCBiz();
		System.out.println("��ӭ����ѡ��ϵͳ��");
		while(true) {
			Scanner scanner=new Scanner(System.in);
			System.out.println("���������ѡ��1-ѡ�Σ�2-�鿴ѡ����Ϣ��3-��ѡ��0-�˳�");
			int num=scanner.nextInt();
			switch(num) {
			case 1:
				scBiz.choice(student);
				break;
			case 2:
				scBiz.selectionResult(student);
				break;
			case 3:
				scBiz.withdrawal(student);
				break;
			case 0:
				System.exit(0);
			}	
		}
		
	}
}
