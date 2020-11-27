package org.student.service;

import java.util.List;

import org.student.entity.Student;

public interface IStudentService {

	public boolean addStudent(Student student);

	public boolean deleteStudent(int sno);

	public boolean updateStudent(int sno, Student student);

	public Student queryStudentBySno(int sno);

	public List<Student> queryAllStudent();

	// ��ҳ
	// ��ѯ��������
	public int getTotalCount();
	// ��ǰҳ�Ķ�����Ϣ���� currentPage����ǰҳ��ҳ�룩 pageSize��ҳ���С��ÿҳ��ʾ����������
	public List<Student> queryStudentByPage(int currentPage, int pageSize);
}
