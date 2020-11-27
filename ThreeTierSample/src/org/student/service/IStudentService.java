package org.student.service;

import java.util.List;

import org.student.entity.Student;

public interface IStudentService {

	public boolean addStudent(Student student);

	public boolean deleteStudent(int sno);

	public boolean updateStudent(int sno, Student student);

	public Student queryStudentBySno(int sno);

	public List<Student> queryAllStudent();

	// 分页
	// 查询数据总数
	public int getTotalCount();
	// 当前页的对象信息集合 currentPage：当前页（页码） pageSize：页面大小（每页显示的数据量）
	public List<Student> queryStudentByPage(int currentPage, int pageSize);
}
