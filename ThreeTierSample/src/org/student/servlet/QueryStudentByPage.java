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
		Page page = new Page();//����ҳ������ֶΣ���װ��page������
		
		String cPage = request.getParameter("currentPage");
		
		if(cPage == null)//�����һ�η���
			cPage = "1";
		int currentPage = Integer.parseInt(cPage);//��ǰҳ

		String cSize = request.getParameter("pageSize");
		if(cSize == null)
			cSize = "3";
		int pageSize = Integer.parseInt(cSize);//ҳ���С
		
		int count = studentService.getTotalCount();//��������
		
		page.setCurrentPage(currentPage);
		//��֤��ִ��  �������� Ȼ���� ҳ���С  ��Ϊ�й�ʽ���㣬����ע��˳��
		page.setTotalCount(count);
		page.setPageSize(pageSize);
		
		System.out.println(count);
		
		List<Student> students = studentService.queryStudentByPage(currentPage, pageSize);//��ǰҳ�Ķ�����Ϣ���� 
		page.setStudents(students);
		
		
		
		request.setAttribute("page", page);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
