package view;
import java.util.Scanner;

import biz.AdministratorBiz;
import biz.StudentBiz;

public class LoginUI {
	public static void studentShow() {
		Scanner scanner;
		String studentNo;
		String studentPassword;
		StudentBiz studentBiz;
		System.out.println("������ѧ�ţ�");
		scanner = new Scanner(System.in);
		studentNo = scanner.nextLine();
		System.out.println("���������룺");
		studentPassword = scanner.nextLine();
		
		studentBiz = new StudentBiz();
		studentBiz.login(studentNo,studentPassword);
	}
	public static void administratorShow() {
		Scanner scanner;
		String administratorID;
		String administratorPassword;
		AdministratorBiz administratorBiz;
		System.out.println("�������˺ţ�");
		scanner = new Scanner(System.in);
		administratorID = scanner.nextLine();
		System.out.println("���������룺");
		administratorPassword = scanner.nextLine();
		
		administratorBiz = new AdministratorBiz();
		administratorBiz.login(administratorID,administratorPassword);
	}
}
