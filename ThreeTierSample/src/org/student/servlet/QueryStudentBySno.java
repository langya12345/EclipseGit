package org.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Student;
import org.student.service.IStudentService;
import org.student.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class QueryStudentBySno
 */
public class QueryStudentBySno extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt(request.getParameter("sno"));
		IStudentService studentService = new StudentServiceImpl();
		Student result = studentService.queryStudentBySno(no);
		System.out.println(result);
		
		System.out.println("��ѯ�ɹ�");
		request.setAttribute("student", result);
		//��Ϊrequest���������ݣ������Ҫͨ������ת���ķ�ʽ��ת���ض���ᶪʧrequest�������ݣ�
		//pageContext<request<session<application ԽС����Խ����
		request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
