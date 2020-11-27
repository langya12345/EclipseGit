package org.student.dao;

import java.util.List;

import org.student.entity.Student;

public interface IStudentDao {
	
	public boolean isExist(int sno);
	
	public boolean addStudent(Student student);
	
	//����ѧ���޸�ѧ��������sno֪�����޸ĵ��ˣ���������޸ĳ�student
	public boolean updateStudentBySno(int sno,Student student);
	
	//����ѧ����ɾ��
	public boolean deleteStudentBySno(int sno);
	//����ѧ��������
	public Student queryStudentBySno(int sno) ;
	//��ѯ����ѧ��
	public List<Student> queryAllStudent() ;
	
	//��ҳ
	//��ѯ��������
	public int getTotalCount();
	//��ǰҳ�Ķ�����Ϣ����  currentPage����ǰҳ��ҳ�룩   pageSize��ҳ���С��ÿҳ��ʾ����������
	public List<Student> queryStudentByPage(int currentPage,int pageSize);
}
