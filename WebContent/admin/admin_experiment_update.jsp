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
  <h2>子实验修改</h2>
  
  <div class="pull-left">
    
    <form action="ExUpdateServlet" method="post">
    <table class="table table-hover">
    <thead>
        <tr>
            <td>子实验编号:</td>
            <td><input  type="text"  style="width: 40%" name="id" value="${experiment.id}" required/></td>
        </tr>
        
        <tr>
            <td>子实验名称:</td>
            <td><input  type="text"  style="width: 40%" name="name" value="${experiment.name}" required/></td>
        </tr>
        <tr>
            <td>子实验学时:</td>
            <td><input  type="text"  style="width: 40%" name="hour" value="${experiment.hour}"/></td>
        </tr>
        <tr>
            <td>子实验仪器:</td>
            <td><input  type="text"  style="width: 40%" name="device" value="${experiment.device}"/></td>
        </tr>
        <tr>
            <td>子实验规则:</td>
            <td><input  type="text"  style="width: 40%" name="rule" value="${experiment.rule}"/></td>
        </tr>
        <tr>
            <td>子实验目标:</td>
            <td><input  type="text"  style="width: 40%" name="goal" value="${experiment.goal}"/></td>
        </tr>
        <tr>
            <td>子实验注意点:</td>
            <td><input  type="text"  style="width: 40%" name="tips" value="${experiment.tips}"/></td>
        </tr>
        <tr>
            <td>子实验步骤:</td>
            <td><input  type="text"  style="width: 40%" name="step" value="${experiment.step}"/></td>
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