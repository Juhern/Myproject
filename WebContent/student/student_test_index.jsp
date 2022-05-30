<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@page import="entity.Test" %>
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
    <h2>测试界面</h2>
    <h3>单选题(共10题，合计100分)</h3>
    <div class="pull-left">
        <form action="../AdjustServlet" method="post">
            <table class="table table-hover">
                <thead>
                <tr>
                    <td align="center">编号</td>
                    <td align="center">题目详情</td>
                    <td align="center">A选项</td>
                    <td align="center">B选项</td>
                    <td align="center">C选项</td>
                    <td align="center">选择</td>
                </tr>

                <%
                    java.util.List<Test> testList = new java.util.ArrayList<Test>();
                    TestDao testDao = new TestDao();
                    int i = 0;
                    testList = testDao.getallTests();
                    HttpSession session2 = request.getSession();
                    String namestring = (String) session2.getAttribute("user");
                    String experimentname = request.getParameter("experimentname");

                    for (i = 0; i < 10; i++) {
                %>
                <tr>
                    <td align="center"><%=testList.get(i).getId()%>
                    </td>
                    <td align="center"><%=testList.get(i).getName()%>
                    </td>
                    <td align="center"><%=testList.get(i).getAcho() %>
                    </td>
                    <td align="center"><%=testList.get(i).getBcho() %>
                    </td>
                    <td align="center"><%=testList.get(i).getCcho() %>
                    </td>
                    <td>
                        <select name="<%=i%>">
                            <option value="A">A</option>
                            <option value="B">B</option>
                            <option value="C">C</option>
                        </select>
                    </td>
                    <input type="hidden" name="<%=i+15%>" value="<%=testList.get(i).getAnswer() %>"/>
                    <input type="hidden" name="str" value="<%=namestring%>"/>
                    <input type="hidden" name="experimentname" value="<%=experimentname %>"/>

                    <%} %>
                </tr>
                <td colspan="2">
                    <input type="submit" class='btn btn-primary' value="提交"/>
                    <input type="button" class='btn btn-success' value="返回" onclick="history.go(-1)"/>
                </td>
                </thead>
            </table>
        </form>
    </div>
</div>
</body>

</html>
