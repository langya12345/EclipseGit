package org.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.service.IStudentService;
import org.student.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class DeleteStudentServlet
 */
public class DeleteStudentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt(request.getParameter("sno"));
		IStudentService studentService = new StudentServiceImpl();
		boolean result = studentService.deleteStudent(no);
		//设置响应编码,解决乱码
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		if(result)
		{
			//out.println("删除成功");
			System.out.println("删除成功");
			response.sendRedirect("QueryStudentByPage");//重新查询所有学生
		}
		else
			out.println("删除失败");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
