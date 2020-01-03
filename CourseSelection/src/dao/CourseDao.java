package dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import biz.CourseBiz;
import entity.Course;
import entity.IEntity;
import entity.Student;

public class CourseDao implements IDao{
	
	private static CourseDao instance;
	private HashMap<String,IEntity> courses;
	private Course course;
	private FileInputStream fs;
    private FileOutputStream fos;
    
    private CourseDao() {
    	courses = new HashMap<String,IEntity>();
		course = new Course();
    	getCoursesFormInputStream("course2.txt");
    }
    public void getCoursesFormInputStream(String isName){
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
						this.processCourseString(new String(content,"GBK").trim());
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
    private void processCourseString(String courseString) {
		String[] courseFields=courseString.split(",");
   	 	Course course = new Course();
   	 	course.setCourseNo(courseFields[0]);
   	 	course.setCourseName(courseFields[1]);
   	 	course.setCourseGrade(Integer.parseInt(courseFields[2]));
   	 	courses.put(course.getCourseNo(), course);
	}
   	public static CourseDao getInstance() {
   		if(instance == null) {
   			synchronized(CourseDao.class) {
   				if(instance == null) {
   					instance = new CourseDao();
   					return instance;
   				}
   			}
   		}
   		return instance;
   	}
	public void update() {
		Set<String> courseSet=courses.keySet();
	   	 StringBuffer courseStringBuffer=new StringBuffer();
	   	 for(String courseNo:courseSet) {
	   		 Course course=(Course)courses.get(courseNo);
				String uString = course.getCourseNo()+","
						+course.getCouresName()+","+
						course.getCourseGrade()+"\r\n";
				courseStringBuffer.append(uString);
	   	 }
	   	 putCoursesToFile(courseStringBuffer.toString(),"course2.txt");
	}
    private void putCoursesToFile(String uString,String osName){
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

   	public void insert(IEntity entity) {
   		Course course= (Course)entity;
   		courses.put(course.getCourseNo(), course);
   	}
    public void add() {
    	Course course1 = new Course();
    	System.out.println("请输入要增加的课程信息!");
    	Scanner scanner = new Scanner(System.in);
		System.out.println("请输入课程号：");
		String courseNo=scanner.nextLine();
		course1.setCourseNo(courseNo);
		System.out.println("请输入课程名：");
		String courseName=scanner.nextLine();
		course1.setCourseName(courseName);
		System.out.println("请输入学分：");
		String courseGrade=scanner.nextLine();
		course1.setCourseGrade(Integer.parseInt(courseGrade));
   		courses.put(course.getCourseNo(), course1);
   		CourseBiz courseBiz=new CourseBiz();
   		courseBiz.save();
   		return;
    }
	public void delete() {
		System.out.println("请输入要删除课程号");
		Scanner str=new Scanner(System.in);
		String studentNo=str.nextLine();
		course = (Course)getEntity(studentNo);
		if(course == null) {
			System.out.println("用户不存在！");
		}else {
			courses.remove(studentNo);
			System.out.println("删除成功！");
			CourseBiz courseBiz=new CourseBiz();
			courseBiz.save();
			return;
		}
	}
	public void modify() {
		System.out.println("请输入要修改的课程的号");
		Scanner str=new Scanner(System.in);
		String courseNo=str.nextLine();
		course = (Course)getEntity(courseNo);
		if(courseNo==null) {
			System.out.println("用户不存在！");
		}else {
			System.out.println("请输入要修改后的课程信息!");
	    	Scanner scanner = new Scanner(System.in);
			System.out.println("请输入课程号：");
			String courseNo1=scanner.nextLine();
			course.setCourseNo(courseNo1);
			System.out.println("请输入课程名：");
			String courseName=scanner.nextLine();
			course.setCourseName(courseName);
			System.out.println("请输入学分：");
			String courseGrade=scanner.nextLine();
			course.setCourseGrade(Integer.parseInt(courseGrade));
	   		courses.put(course.getCourseNo(), course);
			System.out.println("修改成功！");
			CourseBiz courseBiz=new CourseBiz();
			courseBiz.save();
			return;
		}
	}
	public HashMap<String, IEntity> getAllEntities() {
		return courses;
	}

	public IEntity getEntity(String Id) {
		return courses.get(Id);
	}

}
