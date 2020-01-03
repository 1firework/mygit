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
		System.out.println("欢迎使用！");
		System.out.println("请输入你的选择！1-学生界面；2-管理员界面；0-退出");
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
			System.out.println("你输入的信息有误！请重新输入！");
		}
	}
}
