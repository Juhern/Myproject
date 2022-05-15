<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="entity.Admin"%>
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
    <h2 align="center">您获得了<span>${n*10}</span>分！</h2>
    
    <div class="pull-left">
    <table class="table table-hover">
    <thead>
    <tr>
    <%
    Object num=request.getAttribute("n");
    int number= Integer.parseInt(num.toString());
    if(number<6)
    {
    	out.println("您的成绩不及格，请继续努力！");
    }
    else if(number>=9)
    {
    	out.println("做的很棒，您已经达到优秀水平！");
    }
    else
    {
    	out.println("成绩理想，您还可以做的更棒！");
    }
    %>
     <td colspan="2">         
     <input  type="button"  class='btn btn-success'  value="返回" onclick="history.go(-2)"/>
     </td>
    </tr>  
    </thead>
    </table>
    </div>
    </div>
</body>
</html>