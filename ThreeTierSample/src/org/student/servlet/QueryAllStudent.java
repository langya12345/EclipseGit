package org.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Student;
import org.student.service.IStudentService;
import org.student.service.impl.StudentServiceImpl;



/**
 * Servlet implementation class QueryAllStudent
 */
public class QueryAllStudent extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		IStudentService studentService = new StudentServiceImpl();
		List<Student> students =  studentService.queryAllStudent();
		
		System.out.println(students);
		request.setAttribute("students", students);
		//因为request域中有数据，因此需要通过请求转发的方式跳转（重定向会丢失request域中数据）
		//pageContext<request<session<application 越小性能越优先
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
