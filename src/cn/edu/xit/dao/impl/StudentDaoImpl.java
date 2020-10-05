package cn.edu.xit.dao.impl;

import org.springframework.stereotype.Repository;

import cn.edu.xit.dao.IStudentDao;
import cn.edu.xit.entity.Student;

/*
 *@Component("studentDao") <==>  <bean id="studentDao" class="cn.edu.xit.dao.StudentDaoImpl">
 * 
 * 
*/
@Repository
public class StudentDaoImpl implements IStudentDao {
	public void addStudent(Student student){
		System.out.println("增加学生....");
	}
}
