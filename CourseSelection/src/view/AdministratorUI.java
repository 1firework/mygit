package view;

import java.util.Scanner;

import biz.AdministratorBiz;
import entity.Administrator;

public class AdministratorUI {
	public static void administratorShow1() {
		System.out.println("1-��¼��0-�˳�");
		Scanner scanner = new Scanner(System.in);
		String option = scanner.nextLine();
		switch(option) {
		case "1":
			LoginUI.administratorShow();
			break;
		case "0":
			break;
		}
	}
	public static void administratorShow2(Administrator administrator) {
		System.out.println("1-�޸����룻2-�޸�ѧ����Ϣ��3-�޸Ŀγ���Ϣ��4-�޸�ѡ����Ϣ��0-�˳�");
		Scanner scanner = new Scanner(System.in);
		String option = scanner.nextLine();
		switch(option) {
		case "1":
			ModifyPasswordUI.administratorShow(administrator);
			break;
		case "2":
			AdministratorBiz.StudentMege();
			break;
		case "3":
			AdministratorBiz.courseMege();
			break;
		case "4":
			AdministratorBiz.scmege();
			break;
		case "0":
			break;
		}
	}
}
