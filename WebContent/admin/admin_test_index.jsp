<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="entity.Test"%>
    <%@page import="dao.*" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" >
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
    <h2>题库题目管理</h2>
    
    <a href="../admin/admin_test_add.jsp" target="_self"><button class="btn btn-primary add">添加题目</button></a>
  
    <div class="pull-left">
    <table class="table table-hover">
    <thead>
        <tr>
            <td align="center">编号</td>
            <td align="center">题目详情</td>
            <td align="center">A选项</td>
            <td align="center">B选项</td>
            <td align="center">C选项</td>
            <td align="center">答案</td>
            <td align="center">操作</td>
        </tr>
        
<% 
    java.util.List<Test> testList = new java.util.ArrayList<Test>();
    TestDao testDao=new TestDao();
	testList = testDao.getallTests();	
	for(Test test : testList){
%>
    <tr>
    <td align="center"><%=test.getId()%></td>
    <td align="center"><%=test.getName()%></td>
    <td align="center"><%=test.getAcho() %></td>
    <td align="center"><%=test.getBcho() %></td>
    <td align="center"><%=test.getCcho() %></td>
    <td align="center"><%=test.getAnswer() %></td>
    
    <td align="center">
    <a href="..//TeUpdateServlet?id=<%=test.getId() %>"
    onclick='return window.confirm("This test will be changed. Are you sure？")'><button class='btn btn-primary'>修改</button></a>
    |<a href="..//TeDeleteServlet?id=<%=test.getId() %>"
    onclick='return window.confirm("This test will be deleted. Are you sure?")'><button class='btn btn-danger'>删除</button></a>
    </td>
    <%} %>
  </tr> 
        
        </thead>
    </table>
    </div>
    </div>
</body>
</html>