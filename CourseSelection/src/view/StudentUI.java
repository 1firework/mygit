package view;

import java.util.Scanner;

import entity.Student;

public class StudentUI {
	public static void studentShow1() {
		System.out.println("1-ע�᣻2-��¼��0-�˳�");
		Scanner scanner = new Scanner(System.in);
		String option = scanner.nextLine();
		switch(option) {
		case "1":
			RegisterUI.show();
			break;
		case "2":
			LoginUI.studentShow();
			break;
		case "0":
			break;
		}
	}

	public static void studentShow2(Student student) {
		System.out.println("1-�޸����룻2-ѡ�Σ�0-�˳�");
		Scanner scanner = new Scanner(System.in);
		String option = scanner.nextLine();
		switch(option) {
		case "1":
			ModifyPasswordUI.studentShow(student);
			break;
		case "2":
			CourseSelectionUI.show(student);
			break;
		case "0":
			break;
		}
	}
}
