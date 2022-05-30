<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" >
    <title>修改</title>
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
  <h2>教师信息修改</h2>
  
  <div class="pull-left">
    
    <form action="TeachUpdateServlet" method="post">
    <table class="table table-hover">
    <thead>
        <tr>
            <td>教师姓名:</td>
            <td><input  type="text"  style="width: 40%" name="name" value="${teacher.name}" readonly=”true”/></td>
        </tr>
        <tr>
            <td>教师年龄:</td>
            <td><input  type="text"  style="width: 40%" name="age" value="${teacher.age}" required/></td>
        </tr>
        <tr>
            <td>教师性别:</td>
            <td><input  type="text"  style="width: 40%" name="sex" value="${teacher.sex}" required/></td>
        </tr>
        <tr>
            <td>教师职位:</td>
            <td><input  type="text"  style="width: 40%" name="position" value="${teacher.position}"/></td>
        </tr>
        <tr>
            <td>教师地址:</td>
            <td><input  type="text"  style="width: 40%" name="address" value="${teacher.address}"/></td>
        </tr>
        <tr>
            <td>教师电话:</td>
            <td><input  type="text"  style="width: 40%" name="phone" value="${teacher.phone}"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input  type="submit"  class='btn btn-primary'  value="提交"/>
                <input  type="button"  class='btn btn-success'  value="返回" onclick="history.go(-1)"/>
            </td>
        </tr>
    </thead>
    </table>
   </form>
   </div>
   </div>
  </body>
</html>