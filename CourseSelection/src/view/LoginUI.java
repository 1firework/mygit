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
		System.out.println("«Î ‰»Î—ß∫≈£∫");
		scanner = new Scanner(System.in);
		studentNo = scanner.nextLine();
		System.out.println("«Î ‰»Î√‹¬Î£∫");
		studentPassword = scanner.nextLine();
		
		studentBiz = new StudentBiz();
		studentBiz.login(studentNo,studentPassword);
	}
	public static void administratorShow() {
		Scanner scanner;
		String administratorID;
		String administratorPassword;
		AdministratorBiz administratorBiz;
		System.out.println("«Î ‰»Î’À∫≈£∫");
		scanner = new Scanner(System.in);
		administratorID = scanner.nextLine();
		System.out.println("«Î ‰»Î√‹¬Î£∫");
		administratorPassword = scanner.nextLine();
		
		administratorBiz = new AdministratorBiz();
		administratorBiz.login(administratorID,administratorPassword);
	}
}
