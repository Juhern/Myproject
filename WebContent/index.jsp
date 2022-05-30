<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎来到材料学院管理平台</title>
    <link rel="stylesheet" href="common/css/style.css">
</head>


<body>

<div class="wrapper">
    <form class="form-signin" action="LoginServlet" method="get">
        <div class="title">
            <h2 class="form-signin-heading">用户登录</h2>
        </div>
        <div class="main">
            <input type="text" class="form-input" name="name" placeholder="用户账号" required/>
            <input type="password" class="form-input" name="password" required placeholder="用户密码" />
            <select name="type" class="form-input" style="width: 50%">
            <option>管理员</option>
            <option>学生</option>
            <option>教师</option>
            </select>
        </div>
        <div class="remember-me">
            <input type="checkbox" value="remember-me" id="rememberMe" name="rememberMe">
            <label class="checkbox">记住我</label>
        </div>
        <div class="btn-wrapper">
            <button class="btn" type="submit">登录</button>
            <a class="toRegister" href="register.jsp">注册</a>
        </div>
    </form>
</div>
</body>
</html>
