package biz;

import java.util.Scanner;

import dao.AdministratorDao;
import dao.CourseDao;
import dao.SCDao;
import dao.StudentDao;
import entity.Administrator;
import entity.Student;
import view.AdministratorUI;
import view.MainUI;
import view.ModifyPasswordUI;
import view.RegisterUI;
import view.StudentUI;

public class AdministratorBiz {
	AdministratorDao administratorDao;
	private Administrator administrator;
	private static StudentDao studentDao;
	private static CourseDao courseDao;
	private static SCDao scDao;
	
	public void login(String administratorID,String administratorPassword) {
		administratorDao = AdministratorDao.getInstance();
		administrator = (Administrator)administratorDao.getEntity(administratorID);
		if(administrator == null) {
			System.out.println("用户不存在！");
			AdministratorUI.administratorShow1();
		}else if(administrator.getAdministratorDepartment().equals(administratorPassword)) {
			System.out.println("登陆成功！");
			AdministratorUI.administratorShow2(administrator);
		}else {
			System.out.println("密码不正确！");
			AdministratorUI.administratorShow1();
		}
	}
	public void modifyPassword(Administrator administrator,
			String oldPassword,
			String firstPassword,
			String secondPassword) {
		administratorDao = AdministratorDao.getInstance();
		if(administrator.getStudentGender()==null) {
			System.out.println("该用户不存在！请注册后在登陆");
			AdministratorUI.administratorShow1();
		}else if(firstPassword.equals(secondPassword)) {
			administrator.setAdministratorPassword(secondPassword);
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
			AdministratorUI.administratorShow2(administrator);
		}else {
			System.out.println("两次输入的密码不一致，请再次输入：");
			ModifyPasswordUI.administratorShow(administrator);
		}
	}
	public void save() {
		administratorDao=AdministratorDao.getInstance();
		administratorDao.update();
	}
	public static void StudentMege() {
		System.out.println("请输入你的操作:1-增加学生信息；2-删除学生信息；3-修改学生信息；4-查询学生信息；0-退出");
		Scanner num = new Scanner(System.in);
		int numb = num.nextInt();
		switch(numb) {
		case 1:
			studentDao=StudentDao.getInstance();
			studentDao.add();
			break;
		case 2:
			studentDao=StudentDao.getInstance();
			studentDao.delete();
			break;
		case 3:
			studentDao=StudentDao.getInstance();
			studentDao.modifyInformation();
			break;
		case 4:
			studentDao=StudentDao.getInstance();
			System.out.println("请输入要查询的学生学号");
			String Id = num.nextLine();
			if(studentDao.getEntity(Id)!=null) {
				System.out.println("有此学生的信息");
			}else {
				System.out.println("没有此学生的信息");
			}
		case 5:
			break;
		}
	}
	public static void courseMege() {
		System.out.println("请输入你的操作:1-增加课程信息；2-删除课程信息；3-修改课程信息；4-查询课程信息；0-退出");
		Scanner num = new Scanner(System.in);
		int numb = num.nextInt();
		switch(numb) {
		case 1:
			courseDao=CourseDao.getInstance();
			courseDao.add();
			break;
		case 2:
			courseDao=CourseDao.getInstance();
			courseDao.delete();
			break;
		case 3:
			courseDao=CourseDao.getInstance();
			courseDao.modify();
			break;
		case 4:
			courseDao=CourseDao.getInstance();
			System.out.println("请输入要查询的学生学号");
			String Id = num.nextLine();
			if(courseDao.getEntity(Id)!=null) {
				System.out.println("有此学生的信息");
			}else {
				System.out.println("没有此学生的信息");
			}
		case 5:
			break;
		}
	}
	public static void scmege() {
		System.out.println("请输入你的操作:1-增加选课信息；2-删除选课信息；3-修改选课信息；4-查询选课信息；0-退出");
		Scanner num = new Scanner(System.in);
		int numb = num.nextInt();
		switch(numb) {
		case 1:
			scDao=SCDao.getInstance();
			scDao.add();
			break;
		case 2:
			scDao=SCDao.getInstance();
			scDao.delete();
			break;
		case 3:
			scDao=SCDao.getInstance();
			scDao.modify();
			break;
		case 4:
			scDao=SCDao.getInstance();
			System.out.println("请输入要查询的学生学号");
			String Id = num.nextLine();
			if(scDao.getEntity(Id)!=null) {
				System.out.println("有此学生的信息");
			}else {
				System.out.println("没有此学生的信息");
			}
		case 5:
			break;
		}
	}
	
}
