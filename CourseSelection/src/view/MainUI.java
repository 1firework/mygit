package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import entity.Student;

public class MainUI {
	public void show() {
		System.out.println("��ӭʹ�ã�");
		System.out.println("���������ѡ��1-ѧ�����棻2-����Ա���棻0-�˳�");
		Scanner numb = new Scanner(System.in);
		int num = numb.nextInt();
		switch(num) {
		case 1:
			StudentUI.studentShow1();
			break;
		case 2:
			AdministratorUI.administratorShow1();
			break;
		case 0:
			break;
		default :
			System.out.println("���������Ϣ�������������룡");
		}
	}
}
