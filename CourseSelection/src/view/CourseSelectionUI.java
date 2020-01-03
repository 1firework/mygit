package view;

import java.util.Scanner;

import biz.*;
import dao.*;
import entity.*;
	
public class CourseSelectionUI {
	
	public static void show(Student student) {
		SCBiz scBiz=new SCBiz();
		System.out.println("欢迎来到选课系统！");
		while(true) {
			Scanner scanner=new Scanner(System.in);
			System.out.println("请输入你的选择：1-选课，2-查看选课信息，3-退选，0-退出");
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
