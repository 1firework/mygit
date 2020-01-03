package view;

import java.util.Scanner;

import biz.AdministratorBiz;
import biz.StudentBiz;
import entity.Administrator;
import entity.Student;

public class ModifyPasswordUI {
	public static void studentShow(Student student) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入旧密码：");
		String oldPassword=scanner.nextLine();
		System.out.println("请输入新密码：");
		String firstPassword1=scanner.nextLine();
		System.out.println("请再次输入新密码：");
		String secondPassword1=scanner.nextLine();
		StudentBiz sb1=new StudentBiz();
		sb1.modifyPassword1(student,
					oldPassword, 
		    		firstPassword1, 
		    		secondPassword1);
	}
	public static void administratorShow(Administrator administrator) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入旧密码：");
		String oldPassword=scanner.nextLine();
		System.out.println("请输入新密码：");
		String firstPassword1=scanner.nextLine();
		System.out.println("请再次输入新密码：");
		String secondPassword1=scanner.nextLine();
		AdministratorBiz sb1=new AdministratorBiz();
		sb1.modifyPassword(administrator,
					oldPassword, 
		    		firstPassword1, 
		    		secondPassword1);
	}
}
