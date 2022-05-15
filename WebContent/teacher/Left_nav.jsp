<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
		<style type="text/css">
			ul{
				width: 200px;
				height:400px;
				float: right;
				margin-top: 30px;
				font-family: "微软雅黑";
			}
		</style>
	</head>
	<body>
		<ul class="nav nav-pills nav-stacked">
		    <li style="display: inline-block;background-color:black;font-size: 2em"><a href="teacher_user_index.jsp" target="contain">教师信息</a></li>
			<li style="display: inline-block;background-color:black;font-size: 2em"><a href="teacher_experiment_index.jsp" target="contain">子实验信息</a></li>
			<li style="display: inline-block;background-color:black;font-size: 2em"><a href="teacher_student_index.jsp" target="contain">学生成绩信息</a></li>
			<li style="display: inline-block;background-color:black;font-size: 2em"><a href="../index.jsp" target="_parent">退出系统</a></li>
		</ul>

	</body>
</html>