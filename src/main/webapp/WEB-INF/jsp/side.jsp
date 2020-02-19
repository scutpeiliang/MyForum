<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${user == null}">
    <!-- 未登录 -->
    <div class="panel panel-default" id="sidebar2" style="width: 20%;margin:1% 2% 1% 0%;float: right">
        <ul class="list-group" style="width: 100%">
            <li class="list-group-item">
                <a  href="/signIn" class="btn btn-primary btn-block">登录</a>
                <a  href="/signUp" class="btn btn-default btn-block">注册</a>
            </li>
        </ul>
    </div>
</c:if>

<c:if test="${user != null}">
    <!-- 已登录 -->
    <div class="panel panel-default" id="sidebar2" style="width: 20%;margin:1% 2% 1% 0%;float: right">
        <div class="panel-heading" style="background-color: white;text-align: center">
            <a href="/userInfo?id=${user.id}">${user.username}</a>
        </div>
        <ul class="list-group" style="width: 100%">
            <li class="list-group-item"><a href="/jumpToAddTopic">发帖</a></li>
            <li class="list-group-item"><a href="#">积分:${user.credit}</a></li>
        </ul>
    </div>
</c:if>

<div class="panel panel-default" id="sidebar1" style="width: 20%;margin:1% 2% 1% 0%;float: right">
    <div class="panel-heading" style="background-color: white;text-align: center">
        热议帖子
    </div>
    <ul class="list-group" style="width: 100%">
        <c:forEach items="${hotTopicList}" var="hotTopic">
            <li class="list-group-item"><a href="/topicDetail?id=${hotTopic.id}&page=1">${hotTopic.title}</a></li>
        </c:forEach>
    </ul>
</div>


