package org.student.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.student.dao.IStudentDao;
import org.student.entity.Student;
import org.student.util.DBUtil;


//���ݷ��ʲ㣺ԭ���Ե���ɾ�Ĳ�
public class StudentDaoImpl implements IStudentDao{
	
	public boolean isExist(int sno) {//true���˴��� ��false���˲�����
		return queryStudentBySno(sno)==null? false:true;
	}
	
	public boolean addStudent(Student student) {
		
			String sql = "insert into person values(?,?,?,?)";
			Object[] params = {student.getSno(),student.getSname(),student.getSage(),student.getSaddress()};
			return DBUtil.executeUpdate(sql, params);
	}
	
	//����ѧ���޸�ѧ��������sno֪�����޸ĵ��ˣ���������޸ĳ�student
	public boolean updateStudentBySno(int sno,Student student)
	{
			String sql = "update person set sname=?,sage=?,saddress=? where sno=?";
			Object[] params = {student.getSname(),student.getSage(),student.getSaddress(),sno};
			return DBUtil.executeUpdate(sql, params);
			
	}
	
	//����ѧ����ɾ��
	public boolean deleteStudentBySno(int sno)
	{
			String sql = "delete from person where sno =?";
			Object[] params = {sno};
			return DBUtil.executeUpdate(sql, params);

	}
	//����ѧ��������
	public Student queryStudentBySno(int sno) {
		ResultSet rs = null;
		Student student = null;
		try {
			String sql = "select * from person where sno=?";
			Object[] params = {sno};
			rs = DBUtil.executeQuery(sql, params);
			
			while(rs.next())
			{
				int no = rs.getInt("sno");
				String name =rs.getString("sname");
				int age = rs.getInt("sage");
				String address = rs.getString("saddress");
				student = new Student(no, name, age,address);
			}
			return student;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				if(DBUtil.pstmt != null) DBUtil.pstmt.close();
				if(DBUtil.conn != null) DBUtil.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	//��ѯ����ѧ��
	public List<Student> queryAllStudent() {
		
		ResultSet rs = null;
		Student student = null;
		List<Student> students = new ArrayList<>();
		try {
			String sql = "select * from person";
			rs = DBUtil.executeQuery(sql, null);
			
			while(rs.next())
			{
				int no = rs.getInt("sno");
				String name =rs.getString("sname");
				int age = rs.getInt("sage");
				String address = rs.getString("saddress");
				student = new Student(no, name, age,address);
				students.add(student);
			}
			return students;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.closeAll(rs, DBUtil.pstmt, DBUtil.conn);
		}
		
	}

	@Override	//��ѯ��������
	public int getTotalCount() {
		
		String sql = "select count(1) from person";//count(1)��count(*)Ч�ʸ�
		return DBUtil.getTotalCount(sql);
	}

	@Override	//��ǰҳ�Ķ�����Ϣ����
	public List<Student> queryStudentByPage(int currentPage, int pageSize) {
		
		String sql = "select * from person order by sno offset ? rows fetch next ? rows only";
		Object[] params = {(currentPage-1)*pageSize,pageSize};
		
		List<Student> students = new ArrayList<>();
		Student student = null;
		ResultSet rs = DBUtil.executeQuery(sql, params);
		try {
			while(rs.next())
			{
				int no = rs.getInt("sno");
				String name =rs.getString("sname");
				int age = rs.getInt("sage");
				String address = rs.getString("saddress");
				student = new Student(no, name, age,address);
				students.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}
}
