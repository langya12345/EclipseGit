package org.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Page;
import org.student.entity.Student;
import org.student.service.IStudentService;
import org.student.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class QueryStudentByPage
 */
public class QueryStudentByPage extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IStudentService studentService = new StudentServiceImpl();
		Page page = new Page();//将分页所需的字段，组装到page对象中
		
		String cPage = request.getParameter("currentPage");
		
		if(cPage == null)//如果第一次访问
			cPage = "1";
		int currentPage = Integer.parseInt(cPage);//当前页

		String cSize = request.getParameter("pageSize");
		if(cSize == null)
			cSize = "3";
		int pageSize = Integer.parseInt(cSize);//页面大小
		
		int count = studentService.getTotalCount();//数据总数
		
		page.setCurrentPage(currentPage);
		//保证先执行  数据总数 然后再 页面大小  因为有公式计算，必须注意顺序
		page.setTotalCount(count);
		page.setPageSize(pageSize);
		
		System.out.println(count);
		
		List<Student> students = studentService.queryStudentByPage(currentPage, pageSize);//当前页的对象信息集合 
		page.setStudents(students);
		
		
		
		request.setAttribute("page", page);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
