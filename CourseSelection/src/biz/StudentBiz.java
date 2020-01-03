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
			System.out.println("�û������ڣ�");
		}else if(student.getStudentPasswprd().equals(studentPassword)) {
			System.out.println("��½�ɹ���");
			StudentUI.studentShow2(student);
		}else {
			System.out.println("���벻��ȷ��");
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
				System.out.println("�Ƿ񱣴�ע����Ϣ��������yes��no");
				Scanner ins=new Scanner(System.in);
				String str=ins.nextLine();
				if(str.equals("yes")) {
				   	save(); 
					System.out.println("����ɹ���");
					break;
				}else {
					System.out.println("�������Ϣ��������������");
					continue;
				}
			}
			
			System.out.println("ע��ɹ���");
			StudentUI.studentShow2(student);
		}else {
			System.out.println("ע��ʧ�ܣ�");
			System.out.println("������ע�ᣡ");
			RegisterUI.show();
		}
	}
	public void modifyPassword1(Student student,
			String oldPassword,
			String firstPassword,
			String secondPassword) {
		studentDao = StudentDao.getInstance();
		if(student.getStudentNo()==null) {
			System.out.println("���û������ڣ���ע����ڵ�½");
			StudentUI.studentShow2(student);
		}else if(firstPassword.equals(secondPassword)) {
			student.setStudentPassword(secondPassword);
			while(true) {
				System.out.println("�Ƿ񱣴��޸���Ϣ��������yes��no");
				Scanner ins=new Scanner(System.in);
				String str=ins.nextLine();
				if(str.equals("yes")) {
				   	save(); 
					System.out.println("����ɹ���");
					break;
				}else {
					System.out.println("�������Ϣ��������������");
					continue;
				}
			}
			System.out.println("�޸ĳɹ���");
			StudentUI.studentShow2(student);
		}else {
			System.out.println("������������벻һ�£����ٴ����룺");
			return;
		}
	}
}
