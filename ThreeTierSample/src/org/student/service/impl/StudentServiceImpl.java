package org.student.service.impl;

import java.util.List;

import org.student.dao.IStudentDao;
import org.student.dao.impl.StudentDaoImpl;
import org.student.entity.Student;
import org.student.service.IStudentService;
import org.student.util.DBUtil;

//ҵ���߼��㣺�߼��Ե���ɾ�Ĳ飨������+��������Dao����е���װ
public class StudentServiceImpl implements IStudentService{
	IStudentDao studentDao = new StudentDaoImpl();
	
	public boolean addStudent(Student student) 
	{
		if(!studentDao.isExist(student.getSno())) {//������
			return studentDao.addStudent(student);
		}
		else
		{
			System.out.println("�����Ѵ���");
			return false;
		}
		
	}
	
	public boolean deleteStudent(int sno) 
	{
		if(studentDao.isExist(sno))//����
		{
			return studentDao.deleteStudentBySno(sno);
		}
		else
		{
			System.out.println("���˲�����");
			return false;
		}
	}
	
	public boolean updateStudent(int sno,Student student) 
	{
		if(studentDao.isExist(sno))//����
		{
			return studentDao.updateStudentBySno(sno, student);
		}
		else
		{
			System.out.println("���˲�����");
			return false;
		}
	}
	public Student queryStudentBySno(int sno) 
	{
		return studentDao.queryStudentBySno(sno);
	}
	
	public List<Student> queryAllStudent() 
	{
		return studentDao.queryAllStudent();
	}

	@Override
	public int getTotalCount() {
		return studentDao.getTotalCount();
	}

	@Override
	public List<Student> queryStudentByPage(int currentPage, int pageSize) {
		return studentDao.queryStudentByPage(currentPage, pageSize);
	}
}
