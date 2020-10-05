package cn.edu.xit.test;

import org.aspectj.apache.bcel.generic.AllocationInstruction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.factory.CourseFactory;
import cn.edu.xit.entity.Course;
import cn.edu.xit.entity.Student;
import cn.edu.xit.service.IStudentService;
import cn.edu.xt.newinstance.ICourse;

public class Test {
	
	public static void springIoc(){
		
	}
	
	
	
	
	public static void main(String[] args) {
		//Spring 上下文对象
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//执行从springIOC容器中获取一个id为student的对象
		Student student = (Student)applicationContext.getBean("student");
		//System.out.println(student);
		//learnCourse();
		//learnCourseWithFactory();
		
		//learnCourseWithIoc();
		//testDI();
		//testAnnotationAutoWired();
		//testAop();
		testAnnotationAutoWired();
	}
	
	
	
	public static void learnCourse(){
		Student student = new Student();
		student.learnHtml();
		student.learnJava();
	}
	
	public static void learnCourseWithFactory(){
		
		Student student = new Student();
		student.learn("java");	
	}
	
	public static void learnCourseWithIoc(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//从IOC获取学生对象
																		//Student student = (Student)applicationContext.getBean("student") <==>  Student student = new Student();
		Student student = (Student)applicationContext.getBean("student");
//		student.learn("java");
		student.learn("htmlCourse");
	}
	
	public static void testDI(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Course course = (Course)applicationContext.getBean("course");
		System.out.println(course);
	}
	
	public static void testAnnotationAutoWired(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");															//Student student = (Student)applicationContext.getBean("student") <==>  Student student = new Student();
		IStudentService studentService = (IStudentService)applicationContext.getBean("studentService");

		studentService.addStudent(new Student());
	}
	
	public static void testAop(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IStudentService studentService = (IStudentService)applicationContext.getBean("studentService");
		Student student = new Student();
		student.setStuAge(23);
		student.setStuName("ww");
		student.setStuNo(25);
		studentService.addStudent(student);
		
		studentService.deleteStudentByNo(1);
	}
}
