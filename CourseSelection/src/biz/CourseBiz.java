package biz;

import java.util.HashMap;
import java.util.Set;

import dao.*;
import entity.*;

public class CourseBiz {
	CourseDao courseDao;
	private Course course;
	
	public void showAllCourse() {
		courseDao = (CourseDao)CourseDao.getInstance();
		HashMap<String, IEntity> courses=courseDao.getAllEntities();
		Set<String> courseSet=courses.keySet();
		System.out.println("�γ̺�	�γ���	 �γ�ѧ��");
	   	 for(String courseNo:courseSet) {
	   		course=(Course)courses.get(courseNo);
			System.out.println(course.getCourseNo()+":   "+
								course.getCouresName()+":   "+
								course.getCourseGrade());
	   	 }
	}
	public Course lookupCourse(String courseNo) {
		courseDao = (CourseDao)CourseDao.getInstance();
		HashMap<String, IEntity> courses = new HashMap<String, IEntity>();
		courses=courseDao.getAllEntities();
		course=(Course)courses.get(courseNo);
		if(course==null) {
			System.out.println("û������γ�");
		}else {
			System.out.println(course.getCourseNo()+course.getCouresName()+course.getCourseGrade());
		}
		return course;
	}
	public void save() {
		courseDao=CourseDao.getInstance();
	    courseDao.update();
	}
}
