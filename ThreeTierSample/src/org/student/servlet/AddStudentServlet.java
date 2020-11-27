package org.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Student;
import org.student.service.IStudentService;
import org.student.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class AddStudentServlet
 */
public class AddStudentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt(request.getParameter("sno"));
		String name = request.getParameter("sname");
		int age = Integer.parseInt(request.getParameter("sage"));
		String address = request.getParameter("saddress");
		Student student = new Student(no, name, age, address);
		
		IStudentService studentService = new StudentServiceImpl();
		boolean result = studentService.addStudent(student);
		
		/*
		 * out request response session application
		 * out:PrintWriter out = response.getWriter();
		 * session:request.getSession()
		 * application:request.getServletContext()
		 */
		//������Ӧ����,�������
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		if(result)
		{
			//out.println("���ӳɹ�");
			System.out.println("���ӳɹ�");
			request.setAttribute("error", "addsucess");
		}
		else
		{
			//out.println("����ʧ��");
			System.out.println("����ʧ��");
			request.setAttribute("error", "adderror");
		}
		//response.sendRedirect("QueryAllStudent");//���²�ѯ����ѧ��
		request.getRequestDispatcher("QueryStudentByPage").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
