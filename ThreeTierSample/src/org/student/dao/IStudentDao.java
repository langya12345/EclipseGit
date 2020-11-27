package org.student.dao;

import java.util.List;

import org.student.entity.Student;

public interface IStudentDao {
	
	public boolean isExist(int sno);
	
	public boolean addStudent(Student student);
	
	//根据学号修改学生：根据sno知道待修改的人，把这个人修改成student
	public boolean updateStudentBySno(int sno,Student student);
	
	//根据学号来删人
	public boolean deleteStudentBySno(int sno);
	//根据学号来查人
	public Student queryStudentBySno(int sno) ;
	//查询所有学生
	public List<Student> queryAllStudent() ;
	
	//分页
	//查询数据总数
	public int getTotalCount();
	//当前页的对象信息集合  currentPage：当前页（页码）   pageSize：页面大小（每页显示的数据量）
	public List<Student> queryStudentByPage(int currentPage,int pageSize);
}
