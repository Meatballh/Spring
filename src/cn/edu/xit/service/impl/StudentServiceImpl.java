package cn.edu.xit.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.xit.dao.IStudentDao;
import cn.edu.xit.dao.impl.StudentDaoImpl;
import cn.edu.xit.entity.Student;
import cn.edu.xit.service.IStudentService;
//@Component
@Service("studentService")
public class StudentServiceImpl implements IStudentService {
	IStudentDao studentDao;
	@Autowired 
	public void setStudentDao(IStudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,
			rollbackFor={SQLException.class,ArithmeticException.class})
	@Override
	public void addStudent(Student student) {
		//if(该学生是否存在)
		//增加其他......
//		studentDao=null;//测试异常通知
//		studentDao.addStudent(student);
		System.out.println("====!进行增加操作!====");
		
	}

	@Override
	public void deleteStudentByNo(int stuNo) {
		System.out.println("...模拟删除...");
		
	}

}
