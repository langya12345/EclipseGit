<%@page import="org.student.entity.Page"%>
<%@page import="org.student.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("tr:odd").css("background-color", "lightgray");//奇数行加颜色
	})
</script>
</head>
<body>
	<%
		String error = (String) request.getAttribute("error");
		if (error != null) {
			if (error.equals("addsucess"))
				out.println("增加成功");
			else if (error.equals("adderror"))
				out.println("增加失败");
		}
	%>
	<table border="1px">
		<tr>
			<th>学号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>地址</th>
			<th>操作</th>
		</tr>
		<%
			/*
				List<Student> students =  (List<Student>)request.getAttribute("students");
				for(Student student:students)
				{
					*/
			Page p = (Page) request.getAttribute("page");
			for (Student student : p.getStudents()) {
		%>
				<tr>
					<td><a href="QueryStudentBySno?sno=<%=student.getSno()%>"><%=student.getSno()%></a></td>
					<td><%=student.getSname()%></td>
					<td><%=student.getSage()%></td>
					<td><%=student.getSaddress()%></td>
					<td><a href="DeleteStudentServlet?sno=<%=student.getSno()%>">删除</a></td>
				</tr>
		
		<%
			}
		%>
		<tr></tr>

	</table>
	
	<a href="add.jsp">新增</a>
	<br />
		<%
			if(p.getCurrentPage() == 1){
		%>
				<a href="QueryStudentByPage?currentPage=<%=p.getCurrentPage()+1 %>"">下一页</a>
				<a href="QueryStudentByPage?currentPage=<%=p.getTotalPage()%>"">尾页</a>
		<% 
			}
			else if(p.getCurrentPage() == p.getTotalPage()){
		%>	
				<a href="QueryStudentByPage?currentPage=1">首页</a>
				<a href="QueryStudentByPage?currentPage=<%=p.getCurrentPage()-1 %>">上一页</a>
		<%
			}
			else{
		%>
				<a href="QueryStudentByPage?currentPage=1">首页</a>
				<a href="QueryStudentByPage?currentPage=<%=p.getCurrentPage()-1 %>">上一页</a>
				<a href="QueryStudentByPage?currentPage=<%=p.getCurrentPage()+1 %>"">下一页</a>
				<a href="QueryStudentByPage?currentPage=<%=p.getTotalPage()%>"">尾页</a>
		<%
			}
		%>
		<%=p.getCurrentPage() %>/<%=p.getTotalPage() %>
		<br/>
		
		
		<!-- 未完成     -->
		每页显示
		<select name = "pageSzie" >
			<option value="3">3</option>
			<option value="5">5</option>
			<option value="10">10</option>
		</select>
		条

	

</body>
</html>