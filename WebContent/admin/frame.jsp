<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>管理员页面</title>
</head>
<frameset rows="11%,*" framespacing="10">
    <frame src="admin/Top.jsp" noresize="noresize" scrolling="yes"/>
    <frameset cols="15%,*">
        <frame src="admin/Left_nav.jsp" noresize="noresize"/>
        <frame src="admin/admin_user_index.jsp" name="contain"/>
    </frameset>
</frameset>
</html>
