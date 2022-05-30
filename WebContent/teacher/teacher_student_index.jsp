<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="entity.Student"%>
    <%@page import="dao.*" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" >
<title>显示</title>
    <style type="text/css">
           
			form h1 {
				display: inline-block;
				width: 820px;
			}
			.check {
				padding: 30px 30px;
			}
			
			form {
				display: inline;
			}
			
			.contain {
				width: 1298px;
				border-radius: 10px;
				border: 1px #bbb solid;
				background-color: #eee;
				padding-top: 20px;
			}
			
			button {
				margin-left: 10px;
			}
			
			
			.add {
				float: right;
				margin-right: 50px;
			}
			
    </style>
</head>
<body>
<div class="contain pull-left">
    <h2>学生信息</h2>
    
  
    <div class="pull-left">
    <table class="table table-hover">
    <thead>
        <tr>
            <td align="center">姓名</td>
            <td align="center">年龄</td>
            <td align="center">性别</td>
            <td align="center">职位</td>
            <td align="center">班级</td>
            <td align="center">地址</td>
            <td align="center">电话</td>
            <td align="center">查看成绩</td>
        </tr>
        
<% 
    java.util.List<Student> studentList = new java.util.ArrayList<Student>();
    StudentDao studentdao=new StudentDao();
	studentList = studentdao.getallStudents();	
	
	for(Student student : studentList){
%>
    <tr>
    <td align="center"><%=student.getName()%></td>
    <td align="center"><%=student.getAge()%></td>
    <td align="center"><%=student.getSex() %></td>
    <td align="center"><%=student.getPosition() %></td>
    <td align="center"><%=student.getClassname() %></td>
    <td align="center"><%=student.getAddress() %></td>
    <td align="center"><%=student.getPhone() %></td>
    <td align="center">
    
    <a href="teacher_student_score.jsp?name=<%=student.getName()%>"><button class='btn btn-primary'>查看</button></a>
    </td>
    <% }%>
  </tr> 
        
        </thead>
    </table>
    </div>
    </div>
</body>
</html>