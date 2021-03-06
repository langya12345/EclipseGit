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
 * Servlet implementation class UpdateStudentServlet
 */
public class UpdateStudentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt(request.getParameter("sno"));
		String name = request.getParameter("sname");
		int age = Integer.parseInt(request.getParameter("sage"));
		String address = request.getParameter("saddress");
		Student student = new Student(name, age, address);
		
		IStudentService studentService = new StudentServiceImpl();
		boolean result = studentService.updateStudent(no, student);
		
		//设置响应编码,解决乱码
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		if(result)
		{
			//out.println("修改成功");
			System.out.println("修改成功");
			response.sendRedirect("QueryStudentByPage");//重新查询所有学生
		}
		else
			out.println("修改失败");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
