package cn.edu.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.xit.entity.Student;
import cn.edu.xt.newinstance.HtmlCourse;
import cn.edu.xt.newinstance.ICourse;
import cn.edu.xt.newinstance.JavaCourse;
//课程工厂
public class CourseFactory {
	
//	public static ICourse getCourse(String name){
//		//获取IOC容器
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//		
//		if(name.equals("java")){
//			return (ICourse) applicationContext.getBean("javaCourse");//new->从ioc获取
//		}else {
//			return (ICourse) applicationContext.getBean("htmlCourse");
//		}
//	}
}
