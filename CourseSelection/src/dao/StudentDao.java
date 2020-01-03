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
	//懒汉式单例模式，得到StudentDao
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
	//把HashMap中存储的学生信息加以处理变为一个字符串，传给putStudentsToFile()，
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
	//将得到的学生信息的字符串以GBK的编译模式写进文件student.txt中
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
	//在HashMap中增加一个学生信息
	public void insert(IEntity entity) {
		Student st = (Student)entity;
		students.put(st.getStudentNo(), st);
	}
	public void add() {
		RegisterUI.show();
	}
	//在HashMap中删除一个学生信息
	public void delete() {
		System.out.println("请输入要删除学生的学号");
		Scanner str=new Scanner(System.in);
		String studentNo=str.nextLine();
		student = (Student)getEntity(studentNo);
		if(student == null) {
			System.out.println("用户不存在！");
		}else {
			students.remove(studentNo);
			System.out.println("删除成功！");
			return;
		}
	}
	//在hashMap中修改一个学生的信息
	public void modifyInformation() {
		System.out.println("请输入要修改的学生的学号");
		Scanner str=new Scanner(System.in);
		String studentNo=str.nextLine();
		student = (Student)getEntity(studentNo);
		if(student==null) {
			System.out.println("用户不存在！");
		}else {
			System.out.println("请输入修改后学生的信息！");
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入学号：");
			String studentNo1=scanner.nextLine();
			student.setStudentNo(studentNo1);
			System.out.println("请输入姓名：");
			String studentName=scanner.nextLine();
			student.setStudentName(studentName);
			System.out.println("请输入性别：");
			String studentGender=scanner.nextLine();
			student.setStudentGender(studentGender);
			System.out.println("请输入年龄：");
			int studentAge=Integer.parseInt(scanner.nextLine());
			student.setStudentAge(studentAge);
			System.out.println("请输入院系：");
			String studentDepartment=scanner.nextLine();
			student.setStudentDepartment(studentDepartment);
			System.out.println("请输入密码：");
			String studentPassword=scanner.nextLine();
			student.setStudentPassword(studentPassword);
			System.out.println("修改成功！");
			return;
		}
	}
	//在HashMap中查找一个学生信息并返回一个对应的学生信息，否则返回NULL
	public IEntity getEntity(String Id) {
		return students.get(Id);
	}
	//在HashMap中返回所有的学生信息
	public HashMap<String, IEntity> getAllEntities(){
		return students;
	}
}
