package cn.edu.xit.entity;

public class Course {
	private String courseName;
	private int courseHour;
	private Teacher teacher;//依赖于Teacher
	
	
	public Course() {
	}
	
	public Course(String courseName, int courseHour, Teacher teacher) {
		this.courseName = courseName;
		this.courseHour = courseHour;
		this.teacher = teacher;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCourseHour() {
		return courseHour;
	}
	public void setCourseHour(int courseHour) {
		this.courseHour = courseHour;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", courseHour="
				+ courseHour + ", teacher=" + teacher.getName() + "]";
	}
	
}
