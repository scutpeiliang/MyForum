<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>管理员登录</title>
    <link href="../../../static/css/bootstrap.min.css" rel="stylesheet">
    <script src="../../../static/js/jquery-3.2.1.js"></script>
    <script src="../../../static/js/bootstrap.min.js"></script>

    <style>
        li {list-style-type:none;}
        html, body {
            height: 100%;
            font-size: 14px;
            color: #525252;
            font-family: NotoSansHans-Regular,AvenirNext-Regular,arial,Hiragino Sans GB,"Microsoft Yahei","Hiragino Sans GB","WenQuanYi Micro Hei",sans-serif;
            background: #f0f2f5;
        }
        .footer {
            background-color: #fff;
            margin-top: 22px;
            margin-bottom: 22px;
            width: 100%;
            padding-top: 22px;
            color: #8A8A8A;
            display: block;
            height: 200px;
            border: 1px ;
            clear:both
        }

        .container {
            margin-right: 5%;
            margin-left: 5%;
            padding-left: 15px;
            padding-right: 15px;
            width: 40%;
            float: left;
        }
        .info {
            margin-right: 5%;
            width: 10%;
            float: left;
        }
        a{
            color: #8A8A8A;
            cursor: pointer;
        }
    </style>
    <script>
        $(function () {
            $("#submit").click(function () {
                var username = $("#username").val();
                var password = $("#password").val();
                if(username == ''){
                    alert("请输入管理员名！");
                }
                else if(password == ''){
                    alert("请输入密码！")
                }
                else{
                    $("#signInForm").submit();
                }
            });
        });
    </script>
</head>
<body>

<div class="panel panel-default" id="login" style="width: 20%;margin-left: 40%;margin-top: 5%;margin-bottom: 5%">
    <div class="panel-heading" style="background-color: #fff">
        <h3 class="panel-title">登录进入后台管理</h3>
    </div>
    <div class="panel-body">
        <form method="post" action="/admin/signIn" id="signInForm">
        <div class="form-group">
            <label for="name">管理员名</label>
            <span style="color: red">${message}</span>
            <input type="text" class="form-control" id="name" name="name" placeholder="请输入管理员名" required="required">
        </div>
        <div class="form-group">
            <%--@declare id="password"--%><label for="password">密码</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码" required="required">
        </div>
        <p style="text-align: right;color: red;position: absolute" id="info"></p><br/>
            <button class="btn btn-success btn-block" id="submit">登录</button>
        </form>
    </div>
</div>

</body>
</html>