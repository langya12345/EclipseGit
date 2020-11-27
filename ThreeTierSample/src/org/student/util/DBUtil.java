package org.student.util;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.student.entity.Student;

import com.sun.org.apache.regexp.internal.recompile;

public class DBUtil {
	private static final String url = "jdbc:sqlserver://localhost:1433;DatabaseName=test";
	private static final String user = "sa";
	private static final String pwd = "123456";

	public static Connection conn = null;
	public static PreparedStatement pstmt = null;
	public static ResultSet rs = null;

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url, user, pwd);
		/*
		 * conn= DriverManager.getConnection(url,user,pwd);//�������� return conn
		 */
	}

	public static PreparedStatement createPreParedStatement(String sql, Object[] params)
			throws ClassNotFoundException, SQLException {
		pstmt = getConnection().prepareStatement(sql);
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}

		}
		return pstmt;
	}

	// ��ɾ��
	// ����ѧ����ɾ��
	public static boolean executeUpdate(String sql, Object[] params) {

		try {
			pstmt = createPreParedStatement(sql, params);
			int count = pstmt.executeUpdate();
			if (count > 0)
				return true;
			else
				return false;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			/*
			 * try { if(pstmt != null) pstmt.close(); if(conn !=null) conn.close(); } catch
			 * (SQLException e) { e.printStackTrace(); }
			 */
			closeAll(null, pstmt, conn);

		}
	}

	// ��
	// ��ѯ����ѧ��
	public static ResultSet executeQuery(String sql, Object[] params) {

		
		try {
			pstmt = createPreParedStatement(sql, params);
			rs = pstmt.executeQuery();

			return rs;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//��ҳ����
	//��ѯ��������
 	public static int getTotalCount(String sql) {
 		int count = -1;//Ϊʲô��-1����Ϊrs.next()û������ʱ������Ϊ-1
 		try {
			pstmt = createPreParedStatement(sql, null);
			rs = pstmt.executeQuery();//��Ҫ�����������������Ե��е���
			if(rs.next())
			{
				count = rs.getInt(1);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, conn);
		}
 		return count;
 	}
}
