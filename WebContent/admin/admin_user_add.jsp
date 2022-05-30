<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" >
   <title>添加</title>
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
  <h2>用户账号添加</h2>
  
  <div class="pull-left">
  
  <form action="../AddServlet" method="post">
    <table class="table table-hover">
    <thead>
        <tr>
            <td>用户id:</td>
            <td><input type="text" style="width: 40%" name="id" required/></td>
        </tr>
        <tr>
            <td>用户帐号:</td>
            <td><input  type="text" style="width: 40%" name="name" required/></td>
        </tr>
        <tr>
            <td>用户密码:</td>
            <td><input  type="password" style="width: 40%" name="password" required/></td>
        </tr>
        <tr>
            <td>用户类别:</td>
            <td>
            <select name="style" style="width: 40%">
            <option>管理员</option>
            <option>学生</option>
            <option>教师</option>
            </select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input  type="submit" class='btn btn-primary' value="提交"/>
                <input  type="reset"  class='btn btn-warning' value="清空"/>
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