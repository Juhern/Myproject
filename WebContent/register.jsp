<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>材料学院管理平台账号注册</title>
    <link rel="stylesheet" href="common/css/style.css">
</head>

<body>

<div class="wrapper">
    <form class="form-signin" action="RegisterServlet" method="post">
        <div class="title">
            <h3 class="form-signin-heading">用户注册</h3>
        </div>
        <div class="main">
            <h6 class="form-register-heading"></h6>
            <input type="text" class="form-inputr" name="useracount"
                   placeholder="用户账号" required autofocus/>
            <input type="password" class="form-inputr" id="pw" name="password" onkeyup="ValidRegister()"
                   placeholder="密码" required/>
            <input type="password" class="form-inputr" id="repw" name="passwordAgain" onkeyup="ValidRegister()"
                   placeholder="确认密码" required/>
            <input type="text" class="form-inputr" name="username"
                   placeholder="姓名" required autofocus/>
            <input type="text" class="form-inputr" name="userage"
                   placeholder="年龄" required autofocus/>
            <input type="text" class="form-inputr" name="usersex"
                   placeholder="性别" required autofocus/>
            <input type="text" class="form-inputr" name="userclass"
                   placeholder="班级" required autofocus/>
            <input type="text" class="form-inputr" name="userposition"
                   placeholder="职位" required autofocus/>
            <input type="text" class="form-inputr" name="useraddress"
                   placeholder="住址" required autofocus/>
            <input type="text" class="form-inputl" id="uesrtel" name="phonenum"
                   placeholder="电话" required autofocus/>
        </div>
        <h6 class="form-signin-headingl">用户类别选择:</h6>
        <div class="gender">
            <input class="radios" type="radio" value="0" name="type" required>
            <label><small>学生</small></label>
            <input class="radios" type="radio" value="1" name="type" required>
            <label><small>教师</small></label>
        </div>

        <div class="btn-wrapper">
            <button class="btn" id="sub" type="submit">注册</button>
            <a class="toRegister" href="index.jsp">返回登录界面</a>
        </div>
    </form>
</div>
</body>


<script type="text/javascript">
    (function () {
        var sub = document.getElementById("sub");
        //初始化移入移出事件
        if (sub.addEventListener) {
            sub.addEventListener("click", test);
        } else if (sub.attachEvent) {
            sub.attachEvent("onClick", test);
        }
    })();

    function test() {
        var password = document.getElementById("pw");
        var passwordConfirm = document.getElementById("repw");
        var tel = document.getElementById("usertel");
        var reg = /^1[3|4|5|6|7|8|9][0-9]{9}$/;
        if (password.value != passwordConfirm.value) {
            alert("对不起，您2次输入的密码不一致");
            event.preventDefault();
        } else {
            document.forms[0].submit;
        }
    }
</script>
</html>
