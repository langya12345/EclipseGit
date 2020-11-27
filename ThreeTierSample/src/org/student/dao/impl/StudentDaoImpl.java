package org.student.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.student.dao.IStudentDao;
import org.student.entity.Student;
import org.student.util.DBUtil;


//数据访问层：原子性的增删改查
public class StudentDaoImpl implements IStudentDao{
	
	public boolean isExist(int sno) {//true此人存在 ，false此人不存在
		return queryStudentBySno(sno)==null? false:true;
	}
	
	public boolean addStudent(Student student) {
		
			String sql = "insert into person values(?,?,?,?)";
			Object[] params = {student.getSno(),student.getSname(),student.getSage(),student.getSaddress()};
			return DBUtil.executeUpdate(sql, params);
	}
	
	//根据学号修改学生：根据sno知道待修改的人，把这个人修改成student
	public boolean updateStudentBySno(int sno,Student student)
	{
			String sql = "update person set sname=?,sage=?,saddress=? where sno=?";
			Object[] params = {student.getSname(),student.getSage(),student.getSaddress(),sno};
			return DBUtil.executeUpdate(sql, params);
			
	}
	
	//根据学号来删人
	public boolean deleteStudentBySno(int sno)
	{
			String sql = "delete from person where sno =?";
			Object[] params = {sno};
			return DBUtil.executeUpdate(sql, params);

	}
	//根据学号来查人
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
	//查询所有学生
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

	@Override	//查询数据总数
	public int getTotalCount() {
		
		String sql = "select count(1) from person";//count(1)比count(*)效率高
		return DBUtil.getTotalCount(sql);
	}

	@Override	//当前页的对象信息集合
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
