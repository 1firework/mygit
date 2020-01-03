package biz;

import java.io.InputStream;
import java.util.*;
import dao.*;
import entity.*;

public class SCBiz {
	
	Course course;
	Student student;
	SC sc;
	CourseDao courseDao;
	StudentDao studentDao;
	SCDao scDao;
	CourseBiz courseBiz;
	StudentBiz studentBiz;
	SCBiz scBiz;
	private StringBuffer selectedCourses;
	private HashMap<String,ArrayList> scs;
	private int AllGrade=0,ones=0;
	
	public void choice(Student student) {
		scDao=SCDao.getInstance();
		sc=new SC();
		sc=(SC) scDao.getEntity(student.getStudentNo());
		if(sc==null) {
			courseDao=CourseDao.getInstance();
			selectedCourses=new StringBuffer();
			scs=new HashMap<String,ArrayList>();//先new出来
			Scanner scanner=new Scanner(System.in);
			System.out.println("是否进行选课？1-是，0-退出");
			int num=scanner.nextInt();
			if(num==1) {
				courseBiz=new CourseBiz();
				courseBiz.showAllCourse();
				while(true) {
					System.out.println("请输入你所选择课程号");
					Scanner kechenghao=new Scanner(System.in);
					String courseNo=kechenghao.nextLine();
					course=new Course();
					course = (Course) courseDao.getEntity(courseNo);
					if(course!=null) {
						selectedCourses.append(courseNo+",");
						AllGrade += course.getCourseGrade();
						System.out.println(course.getCouresName()+"选择成功！");
						Scanner a=new Scanner(System.in);
						System.out.println("是否继续进行选课？1-是，0-退出");
						int b=scanner.nextInt();
						if(b!=1) {
							sc=new SC();
							sc.setStudentNo(student.getStudentNo());
							sc.setCourseNo(selectedCourses);
							sc.setGrate(AllGrade);
							scDao.insert(sc);
							break;
						}
					}else {
						System.out.println("输入的课程号错误请重新输入！");
					}
				}
				save();
			}else if(num==0) {
				return;
			}
		}else {
			courseDao=CourseDao.getInstance();
			selectedCourses=new StringBuffer();
			scs=new HashMap<String,ArrayList>();//先new出来
			Scanner scanner=new Scanner(System.in);
			System.out.println("是否进行选课？1-是，0-退出");
			int num=scanner.nextInt();
			if(num==1) {
				courseBiz=new CourseBiz();
				courseBiz.showAllCourse();
				while(true) {
					System.out.println("请输入你所选择课程号");
					Scanner kechenghao=new Scanner(System.in);
					String courseNo=kechenghao.nextLine();
					course = (Course) courseDao.getEntity(courseNo);
					if(course!=null) {
						sc.getCourseNo().append(courseNo+",");
						sc.setGrate(sc.getGrade()+course.getCourseGrade());
						System.out.println(course.getCouresName()+"选择成功！");
						Scanner a=new Scanner(System.in);
						System.out.println("是否继续进行选课？1-是，0-退出");
						int b=scanner.nextInt();
						if(b!=1) {
							scDao.insert(sc);
							break;
						}
					}else {
						System.out.println("输入的课程号错误请重新输入！");
					}
				}
				save();
			}else if(num==0) {
				return;
			}
		}
	}
	public void selectionResult(Student student) {
		scDao=SCDao.getInstance();
		sc=new SC();
		sc=(SC) scDao.getEntity(student.getStudentNo());
		courseBiz = new CourseBiz();
		course = new Course();
		int Grade=0;
		if(sc==null) {
			System.out.println(student.getStudentName()+"同学，你还没有选课！");
		}else if(sc.getCourseNo()==null){
			System.out.println(student.getStudentName()+"同学你的选课信息为空!");
		}else {
			String[] scFields=sc.getCourseNo().toString().split(",");
			System.out.println("你选择的科目分别是：");
			for(int i=0;i<scFields.length;i++) {
				course = courseBiz.lookupCourse(scFields[i]);
				Grade += course.getCourseGrade();
				ones++;
			}
			System.out.println(student.getStudentName()+"同学你好，你选了"+ones+"课。"+"共"+Grade+"学分！");
			Grade=0;
			ones=0;
		}
	}
	public void withdrawal(Student student) {
		scDao=SCDao.getInstance();
		sc=new SC();
		sc=(SC) scDao.getEntity(student.getStudentNo());
		
		if(sc==null) {
			System.out.println(student.getStudentName()+"同学，你还没有进行选课，不能退课。请重新输入你的操作！");
		}else {
			courseDao=CourseDao.getInstance();
			selectedCourses=new StringBuffer();
			scs=new HashMap<String,ArrayList>();//先new出来
			Scanner scanner=new Scanner(System.in);
			System.out.println("是否进行退选？1-是，0-退出");
			int num=scanner.nextInt();
			if(num==1) {
				while(true) {
					System.out.println("请输入你所选择课程号");
					Scanner kechenghao=new Scanner(System.in);
					String courseNo=kechenghao.nextLine();
					course = (Course) courseDao.getEntity(courseNo);
					StringBuffer stringcourse=new StringBuffer();
					if(course!=null) {
						String[] scFields=sc.getCourseNo().toString().split(",");
						for(int i=0;i<scFields.length;i++) {
							if(courseNo.equals(scFields[i])) {
								for(int j=i;j<scFields.length-1;i++) {
									scFields[j]=scFields[j+1];
								}
							}
							stringcourse.append(scFields[i]);
						}
						sc.setCourseNo(selectedCourses);
						sc.setGrate(AllGrade-course.getCourseGrade());
						scDao.insert(sc);
						System.out.println(course.getCouresName()+"退选成功！");
						Scanner a=new Scanner(System.in);
						System.out.println("是否继续进行退选？1-是，0-退出");
						int b=scanner.nextInt();
						if(b!=1) {
							break;
						}
					}else {
						System.out.println("输入的课程号错误请重新输入！");
					}
				}
				save();
			}else if(num==0) {
				return;
			}
		}
	}
	public void save() {
		scDao=SCDao.getInstance();
	    scDao.update();
	}
}
