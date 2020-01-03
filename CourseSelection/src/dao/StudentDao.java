package dao;

import java.io.*;
import java.util.*;
import entity.IEntity;
import entity.Student;
import view.RegisterUI;

public class StudentDao implements IDao{
	
	private static StudentDao instance;
	private HashMap<String, IEntity> students;
	private Student student;
	private FileInputStream fs;
    private FileOutputStream fos;
	
	private StudentDao() {
		students = new HashMap<String,IEntity>();
		student = new Student();
		getUsersFormInputStream("students2.txt");   
	}
	
	 public void getUsersFormInputStream(String isName){
    	 try {
			fs=new FileInputStream(isName);
			byte[] content=new byte[1024];
			int i=0;
			int conInteger=0;
			while(true) {
				try {
					conInteger=fs.read();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if(-1==conInteger) {
					break;
				}else if('\r'==(char)conInteger||'\n'==(char)conInteger) {
					try {
						this.processUserString(new String(content,"GBK").trim());
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					i=0;
				}else {
					content[i]=(byte)conInteger;
					i++;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
     }
	public void processUserString(String userString) {
		String[] studentFields=userString.split(",");
   	 	Student st=new Student();
   	 	st.setStudentNo(studentFields[0]);
   	 	st.setStudentName(studentFields[1]);
   	 	st.setStudentAge(Integer.parseInt(studentFields[2]));
   	 	st.setStudentDepartment(studentFields[3]);
   	 	st.setStudentPassword(studentFields[4]);
   	 	st.setStudentGender(studentFields[5]);
   	 	students.put(st.getStudentNo(), st);
	}
	//����ʽ����ģʽ���õ�StudentDao
	public static StudentDao getInstance() {
		if(instance == null) {
			synchronized(StudentDao.class) {
				if(instance == null) {
					instance = new StudentDao();
					return instance;
				}
			}
		}
		return instance;
	}
	//��HashMap�д洢��ѧ����Ϣ���Դ����Ϊһ���ַ���������putStudentsToFile()��
	public void update(){
   	 Set<String> studentSet=students.keySet();
   	 StringBuffer uStringBuffer=new StringBuffer();
   	 for(String studentNo:studentSet) {
   		 Student st=(Student)students.get(studentNo);
			String uString = st.getStudentNo()+","
					+st.getStudentName()+","+
					st.getStudentAge()+","+
					st.getStudentDepartment()+","+
					st.getStudentPasswprd()+","+
					st.getStudentGender()+"\r\n";
			uStringBuffer.append(uString);
   	 }
   	 putStudentsToFile(uStringBuffer.toString(),"students2.txt");
    }
	//���õ���ѧ����Ϣ���ַ�����GBK�ı���ģʽд���ļ�student.txt��
	private void putStudentsToFile(String uString,String osName){
   	 	try {
   	 		fos=new FileOutputStream(osName);
   	 	} catch (FileNotFoundException e) {
   	 		e.printStackTrace();
   	 	}
   	 	try {
   	 		fos.write(uString.getBytes("GBK"));
   	 	} catch (UnsupportedEncodingException e) {
   	 		e.printStackTrace();
   	 	} catch (IOException e) {
   	 		e.printStackTrace();
   	 	}
    }
	//��HashMap������һ��ѧ����Ϣ
	public void insert(IEntity entity) {
		Student st = (Student)entity;
		students.put(st.getStudentNo(), st);
	}
	public void add() {
		RegisterUI.show();
	}
	//��HashMap��ɾ��һ��ѧ����Ϣ
	public void delete() {
		System.out.println("������Ҫɾ��ѧ����ѧ��");
		Scanner str=new Scanner(System.in);
		String studentNo=str.nextLine();
		student = (Student)getEntity(studentNo);
		if(student == null) {
			System.out.println("�û������ڣ�");
		}else {
			students.remove(studentNo);
			System.out.println("ɾ���ɹ���");
			return;
		}
	}
	//��hashMap���޸�һ��ѧ������Ϣ
	public void modifyInformation() {
		System.out.println("������Ҫ�޸ĵ�ѧ����ѧ��");
		Scanner str=new Scanner(System.in);
		String studentNo=str.nextLine();
		student = (Student)getEntity(studentNo);
		if(student==null) {
			System.out.println("�û������ڣ�");
		}else {
			System.out.println("�������޸ĺ�ѧ������Ϣ��");
			Scanner scanner = new Scanner(System.in);
			System.out.println("������ѧ�ţ�");
			String studentNo1=scanner.nextLine();
			student.setStudentNo(studentNo1);
			System.out.println("������������");
			String studentName=scanner.nextLine();
			student.setStudentName(studentName);
			System.out.println("�������Ա�");
			String studentGender=scanner.nextLine();
			student.setStudentGender(studentGender);
			System.out.println("���������䣺");
			int studentAge=Integer.parseInt(scanner.nextLine());
			student.setStudentAge(studentAge);
			System.out.println("������Ժϵ��");
			String studentDepartment=scanner.nextLine();
			student.setStudentDepartment(studentDepartment);
			System.out.println("���������룺");
			String studentPassword=scanner.nextLine();
			student.setStudentPassword(studentPassword);
			System.out.println("�޸ĳɹ���");
			return;
		}
	}
	//��HashMap�в���һ��ѧ����Ϣ������һ����Ӧ��ѧ����Ϣ�����򷵻�NULL
	public IEntity getEntity(String Id) {
		return students.get(Id);
	}
	//��HashMap�з������е�ѧ����Ϣ
	public HashMap<String, IEntity> getAllEntities(){
		return students;
	}
}
