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
		System.out.println("课程号	课程名	 课程学分");
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
			System.out.println("没有这个课程");
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
