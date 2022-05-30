<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>学生页面</title>
</head>
<frameset rows="10%,*" framespacing="10">
    <frame src="student/Top.jsp" noresize="noresize" scrolling="yes"/>
    <frameset cols="15%,*">
        <frame src="student/Left_nav.jsp" noresize="noresize"/>
        <frame src="student/student_user_index.jsp" name="contain"/>
    </frameset>
</frameset>
</html>
