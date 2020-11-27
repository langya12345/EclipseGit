package org.student.service.impl;

import java.util.List;

import org.student.dao.IStudentDao;
import org.student.dao.impl.StudentDaoImpl;
import org.student.entity.Student;
import org.student.service.IStudentService;
import org.student.util.DBUtil;

//业务逻辑层：逻辑性的增删改查（增：查+增），对Dao层进行的组装
public class StudentServiceImpl implements IStudentService{
	IStudentDao studentDao = new StudentDaoImpl();
	
	public boolean addStudent(Student student) 
	{
		if(!studentDao.isExist(student.getSno())) {//不存在
			return studentDao.addStudent(student);
		}
		else
		{
			System.out.println("此人已存在");
			return false;
		}
		
	}
	
	public boolean deleteStudent(int sno) 
	{
		if(studentDao.isExist(sno))//存在
		{
			return studentDao.deleteStudentBySno(sno);
		}
		else
		{
			System.out.println("此人不存在");
			return false;
		}
	}
	
	public boolean updateStudent(int sno,Student student) 
	{
		if(studentDao.isExist(sno))//存在
		{
			return studentDao.updateStudentBySno(sno, student);
		}
		else
		{
			System.out.println("此人不存在");
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
