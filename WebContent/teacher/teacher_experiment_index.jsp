<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="entity.Experiment"%>
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
    <h2>子实验信息</h2>
    
  
    <div class="pull-left">
    <table class="table table-hover">
    <thead>
        <tr>
            <td align="center">编号</td>
            <td align="center">名称</td>
            <td align="center">课时</td>
            <td align="center">仪器</td>
            <td align="center">规则</td>
            <td align="center">目标</td>
            <td align="center">注意点</td>
            <td align="center">步骤</td>
        </tr>
        
<% 
    java.util.List<Experiment> experimentsList = new java.util.ArrayList<Experiment>();
    ExperimentDao experimentDao=new ExperimentDao();
    experimentsList = experimentDao.getAllExperiment();	
	for(Experiment experiment : experimentsList){
%>
    <tr>
    <td align="center"><%=experiment.getId()%></td>
    <td align="center"><%=experiment.getName()%></td>
    <td align="center"><%=experiment.getHour()%></td>
    <td align="center"><%=experiment.getDevice()%></td>
    <td align="center"><%=experiment.getRule()%></td>
    <td align="center"><%=experiment.getGoal()%></td>
    <td align="center"><%=experiment.getTips()%></td>
    <td align="center"><%=experiment.getStep()%></td>
    
    <td align="center" >
    </td>
    <%} %>
  </tr> 
        
        </thead>
    </table>
    </div>
    </div>
</body>
</html>