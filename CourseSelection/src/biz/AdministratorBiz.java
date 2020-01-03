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
			System.out.println("�û������ڣ�");
			AdministratorUI.administratorShow1();
		}else if(administrator.getAdministratorDepartment().equals(administratorPassword)) {
			System.out.println("��½�ɹ���");
			AdministratorUI.administratorShow2(administrator);
		}else {
			System.out.println("���벻��ȷ��");
			AdministratorUI.administratorShow1();
		}
	}
	public void modifyPassword(Administrator administrator,
			String oldPassword,
			String firstPassword,
			String secondPassword) {
		administratorDao = AdministratorDao.getInstance();
		if(administrator.getStudentGender()==null) {
			System.out.println("���û������ڣ���ע����ڵ�½");
			AdministratorUI.administratorShow1();
		}else if(firstPassword.equals(secondPassword)) {
			administrator.setAdministratorPassword(secondPassword);
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
			AdministratorUI.administratorShow2(administrator);
		}else {
			System.out.println("������������벻һ�£����ٴ����룺");
			ModifyPasswordUI.administratorShow(administrator);
		}
	}
	public void save() {
		administratorDao=AdministratorDao.getInstance();
		administratorDao.update();
	}
	public static void StudentMege() {
		System.out.println("��������Ĳ���:1-����ѧ����Ϣ��2-ɾ��ѧ����Ϣ��3-�޸�ѧ����Ϣ��4-��ѯѧ����Ϣ��0-�˳�");
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
			System.out.println("������Ҫ��ѯ��ѧ��ѧ��");
			String Id = num.nextLine();
			if(studentDao.getEntity(Id)!=null) {
				System.out.println("�д�ѧ������Ϣ");
			}else {
				System.out.println("û�д�ѧ������Ϣ");
			}
		case 5:
			break;
		}
	}
	public static void courseMege() {
		System.out.println("��������Ĳ���:1-���ӿγ���Ϣ��2-ɾ���γ���Ϣ��3-�޸Ŀγ���Ϣ��4-��ѯ�γ���Ϣ��0-�˳�");
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
			System.out.println("������Ҫ��ѯ��ѧ��ѧ��");
			String Id = num.nextLine();
			if(courseDao.getEntity(Id)!=null) {
				System.out.println("�д�ѧ������Ϣ");
			}else {
				System.out.println("û�д�ѧ������Ϣ");
			}
		case 5:
			break;
		}
	}
	public static void scmege() {
		System.out.println("��������Ĳ���:1-����ѡ����Ϣ��2-ɾ��ѡ����Ϣ��3-�޸�ѡ����Ϣ��4-��ѯѡ����Ϣ��0-�˳�");
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
			System.out.println("������Ҫ��ѯ��ѧ��ѧ��");
			String Id = num.nextLine();
			if(scDao.getEntity(Id)!=null) {
				System.out.println("�д�ѧ������Ϣ");
			}else {
				System.out.println("û�д�ѧ������Ϣ");
			}
		case 5:
			break;
		}
	}
	
}
