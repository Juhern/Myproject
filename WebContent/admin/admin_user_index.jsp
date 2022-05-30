<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@page import="entity.Admin" %>
<%@page import="dao.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css">
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
    <h2>用户账号管理</h2>

    <a href="../admin/admin_user_add.jsp" target="_self">
        <button class="btn btn-primary add">添加用户</button>
    </a>

    <div class="pull-left">
        <table class="table table-hover">
            <thead>
            <tr>
                <td align="center">编号</td>
                <td align="center">帐号</td>
                <td align="center">密码</td>
                <td align="center">类别</td>
                <td align="center">操作</td>
            </tr>

            <%
                java.util.List<Admin> adminList = new java.util.ArrayList<Admin>();
                AdminDao admindao = new AdminDao();
                adminList = admindao.getAllAdmin();
                for (Admin admin : adminList) {
            %>
            <tr>
                <td align="center"><%=admin.getId()%>
                </td>
                <td align="center"><%=admin.getName()%>
                </td>
                <td align="center"><%=admin.getPassword() %>
                </td>
                <td align="center"><%=admin.getStyle() %>
                </td>

                <td align="center">
                    <a href="..//UpdateServlet?id=<%=admin.getId() %>"
                       onclick='return window.confirm("This user will be changed. Are you sure？")'>
                        <button class='btn btn-primary'>修改</button>
                    </a>
                    |<a href="..//DeleteServlet?id=<%=admin.getId() %>"
                        onclick='return window.confirm("This user will be deleted. Are you sure?")'>
                    <button class='btn btn-danger'>删除</button>
                </a>
                </td>
                <%} %>
            </tr>

            </thead>
        </table>
    </div>
</div>
</body>
</html>
