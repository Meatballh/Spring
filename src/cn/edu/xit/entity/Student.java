package cn.edu.xit.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.factory.CourseFactory;
import cn.edu.xt.newinstance.HtmlCourse;
import cn.edu.xt.newinstance.ICourse;
import cn.edu.xt.newinstance.JavaCourse;

public class Student {
	private int stuNo;
	private String stuName;
	private int stuAge;
	public int getStuNo() {
		return stuNo;
	}
	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getStuAge() {
		return stuAge;
	}
	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}
	public Student(int stuNo, String stuName, int stuAge) {
		super();
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.stuAge = stuAge;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [stuNo=" + stuNo + ", stuName=" + stuName + ", stuAge="
				+ stuAge + "]";
	}
	
	
	
	
	//学习任何课程   1.从自己编写的简单工厂中获取 课程
	public void learn(String name){
//		ICourse course = CourseFactory.getCourse(name);
//		course.learn();
		//course就是根据name拿到的相应课程
		
		//直接从ioc容器获取   2.从SpringIOC提供的超级工厂中获取   课程(之前设置过bean)
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		ICourse course = (ICourse)applicationContext.getBean(name);
		course.learn();
	}
	
	//学习Java课程
	public void learnJava(){
		ICourse course = new JavaCourse();
		course.learn();
	}
	
	//学习Html课程
		public void learnHtml(){
			ICourse course = new HtmlCourse();
			course.learn();
		}
	
}
