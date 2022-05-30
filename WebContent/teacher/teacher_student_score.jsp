<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@page import="entity.Score" %>
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
    <h2>学生成绩信息</h2>


    <div class="pull-left">
        <table class="table table-hover">
            <thead>
            <tr>
                <td align="center">学生姓名</td>
                <td align="center">实验名称</td>
                <td align="center">成绩</td>
            </tr>

            <%
                java.util.List<Score> scoresList = new java.util.ArrayList<Score>();
                ScoreDao scoreDao = new ScoreDao();
                scoresList = scoreDao.getallScores();
                String studentname = request.getParameter("name");

                for (Score score : scoresList) {
                    if (score.getName().equals(studentname)) {
            %>
            <tr>
                <td align="center"><%=score.getName()%>
                </td>
                <td align="center"><%=score.getExperiment()%>
                </td>
                <td align="center"><%=score.getResult()%>
                </td>

                <% }
                } %>
            </tr>
            <tr>
                <td>
                    <input type="button" class='btn btn-success' value="返回" onclick="history.go(-1)"/>
                </td>
            </tr>

            </thead>
        </table>
    </div>
</div>
</body>
</html>
