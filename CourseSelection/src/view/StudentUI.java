package view;

import java.util.Scanner;

import entity.Student;

public class StudentUI {
	public static void studentShow1() {
		System.out.println("1-×¢²á£»2-µÇÂ¼£»0-ÍË³ö");
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
		System.out.println("1-ÐÞ¸ÄÃÜÂë£»2-Ñ¡¿Î£»0-ÍË³ö");
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
