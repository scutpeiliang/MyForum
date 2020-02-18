<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="Content-Type"  content="text/html;charset=utf-8">
    <title>言所欲言</title>
    <link href="../../static/css/bootstrap.min.css" rel="stylesheet">
    <script src="../../static/js/jquery-3.2.1.js"></script>
    <script src="../../static/js/bootstrap.min.js"></script>
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
        function deleteTopic(topicId) {
            var choice = confirm("确认删除帖子吗？");
            if(choice == true){
                window.location.href = "/deleteTopic?id=" + topicId;
            }
            else{

            }
        }
    </script>
</head>

<body>
<!-- 引入header文件 -->
<%@ include file="header.jsp"%>

<%--有主题展示--%>
<c:if test="${topicList != null}">
    <div class="panel panel-default" id="main" style="width: 70%;margin:1% 2% 5% 5%;float: left;">

        <ul class="list-group" style="width: 100%">
            <c:forEach items="${topicList}" var="topic">
                <li class="list-group-item">
                    <div style="height: 50px">
                        <div style="float: left;width: 6%;margin-bottom: 5px">
                            <img width="50px" height="50px" src="/userAvatar/${topic.user.avatar}" class="img-rounded">
                        </div>
                        <div style="width: 89%;float: left">
                            <a href="/topicDetail?id=${topic.id}&page=1">${topic.title}</a><br/>
                            <div>
                                <a><span class="label label-default" >${topic.tab.tabName}</span></a>&nbsp;&nbsp;&nbsp;
                                <a href="/userInfo?id=${topic.user.id}"><span ><strong>${topic.user.username}</strong></span></a>&nbsp;&nbsp;&nbsp;
                                <small class="text-muted">${topic.localCreateTime}</small>
                                <c:if test="${user.id eq topic.user.id}">
                                    <button onclick="deleteTopic(${topic.id})" id="delTopic" style="color: red">删除</button>
                                </c:if>
                            </div>
                        </div>
                        <div style="width: 5%;float: right;text-align: center">
                            <span class="badge">${topic.countReplies}</span>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>

        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="/topicsOfTab?id=${page.id}&page=1" aria-label="Previous">
                        <span aria-hidden="true">首页</span>
                    </a>
                </li>
                <c:forEach items="${page.pages}" var="p">
                    <li><a href="/topicsOfTab?id=${page.id}&page=${p}">${p}</a></li>
                </c:forEach>
                <li>
                    <a href="/topicsOfTab?id=${page.id}&page=${page.totalPage}" aria-label="Next">
                        <span aria-hidden="true">尾页</span>
                    </a>
                </li>
            </ul>
        </nav>

    </div>
</c:if>

<%--没有主题可展示--%>
<c:if test="${topicList == null}">
    <div class="panel panel-default" id="main" style="width: 70%;margin:1% 2% 5% 5%;float: left;">
        <img src="../../static/img/cartoon/nothing.jpg" alt="img" height="400px" width="1000px">
        <div>
            <span style="color: black;size: A4">没有找到你要的，欢迎发帖!</span>
        </div>
    </div>
</c:if>

<!-- 引入侧边栏文件 -->
<%@ include file="side.jsp"%>

<!-- 引入footer文件 -->
<%@ include file="footer.jsp"%>
</body>
</html>
