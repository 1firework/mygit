package biz;
import java.util.Scanner;

import dao.StudentDao;
import entity.Student;
import view.MainUI;
import view.ModifyPasswordUI;
import view.RegisterUI;
import view.StudentUI;

public class StudentBiz {
	StudentDao studentDao;
	private Student student;
	
	public void login(String studentNo,String studentPassword) {
		studentDao = StudentDao.getInstance();
		student = (Student)studentDao.getEntity(studentNo);
		if(student == null) {
			System.out.println("用户不存在！");
		}else if(student.getStudentPasswprd().equals(studentPassword)) {
			System.out.println("登陆成功！");
			StudentUI.studentShow2(student);
		}else {
			System.out.println("密码不正确！");
			StudentUI.studentShow2(student);
		}
	}
	public void save() {
		studentDao=StudentDao.getInstance();
	    studentDao.update();
	}
	public void register(String studentNo,
			String studentName,
			String studentGender,
			int studentAge,
			String studentDepartment,
			String firstPassword,
			String secomdPassword) {
		if(firstPassword.equals(secomdPassword)) {
			student = new Student();
			student.setStudentNo(studentNo);
			student.setStudentName(studentName);
			student.setStudentAge(studentAge);
			student.setStudentDepartment(studentDepartment);
			student.setStudentPassword(firstPassword);
			student.setStudentGender(studentGender);
			
			studentDao = StudentDao.getInstance();
			studentDao.insert(student);
			
			while(true) {
				System.out.println("是否保存注册信息？请输入yes或no");
				Scanner ins=new Scanner(System.in);
				String str=ins.nextLine();
				if(str.equals("yes")) {
				   	save(); 
					System.out.println("保存成功！");
					break;
				}else {
					System.out.println("输入的信息有误！请重新输入");
					continue;
				}
			}
			
			System.out.println("注册成功！");
			StudentUI.studentShow2(student);
		}else {
			System.out.println("注册失败！");
			System.out.println("请重新注册！");
			RegisterUI.show();
		}
	}
	public void modifyPassword1(Student student,
			String oldPassword,
			String firstPassword,
			String secondPassword) {
		studentDao = StudentDao.getInstance();
		if(student.getStudentNo()==null) {
			System.out.println("该用户不存在！请注册后在登陆");
			StudentUI.studentShow2(student);
		}else if(firstPassword.equals(secondPassword)) {
			student.setStudentPassword(secondPassword);
			while(true) {
				System.out.println("是否保存修改信息？请输入yes或no");
				Scanner ins=new Scanner(System.in);
				String str=ins.nextLine();
				if(str.equals("yes")) {
				   	save(); 
					System.out.println("保存成功！");
					break;
				}else {
					System.out.println("输入的信息有误！请重新输入");
					continue;
				}
			}
			System.out.println("修改成功！");
			StudentUI.studentShow2(student);
		}else {
			System.out.println("两次输入的密码不一致，请再次输入：");
			return;
		}
	}
}
