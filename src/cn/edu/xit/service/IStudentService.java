package cn.edu.xit.service;

import cn.edu.xit.entity.Student;

public interface IStudentService {
	void addStudent(Student student);
	void deleteStudentByNo(int stuNo);
}
