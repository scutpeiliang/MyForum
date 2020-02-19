<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="../../static/css/bootstrap.min.css" rel="stylesheet">
    <script src="../../static/js/jquery-3.2.1.js"></script>
    <script src="../../static/js/bootstrap.min.js"></script>
    <title>${topic.title}</title>
    <script>
        function del(topicId, replyId) {
            var choice = confirm("确定删除回复吗?");
            if(choice == true){
                window.location.href = "/deleteReply?topicId=" + topicId + "&id=" + replyId;
            }
            else{

            }
        }
    </script>
</head>
<body>
    <!-- 引入header文件 -->
    <%@ include file="header.jsp"%>
    <div style="width: 70%;margin:1% 2% 1% 5%;float: left;">
        <div class="panel panel-default" id="main" style="">
            <div class="panel-heading" style="background-color: white">
                <div>
                    <div class="panel-heading" style="background-color: white">
                        <a href="/">返回首页</a>
                    </div>
                    <h3>${topic.title}</h3><br/>
                    <div>
                        <a href="/userInfo?id=${topic.user.id}"><span ><strong>${topic.user.username}</strong></span></a>&nbsp;&nbsp;
                        <small class="text-muted">${topic.localCreateTime}</small>&nbsp;&nbsp;
                        <small class="text-muted">${topic.click}次点击</small>
                    </div>
                </div>

                <div style="float: right;margin-top: -100px" >
                    <img width="50px" height="50px" src="/userAvatar/${topic.user.avatar}" class="img-rounded">
                </div>
            </div>

            <ul class="list-group" style="width: 100%">
                <li class="list-group-item">
                    ${topic.content}
                </li>
            </ul>
        </div>

        <c:if test="${replyList != null}">
            <div class="panel panel-default" id="main" style="">

                <ul class="list-group" style="width: 100%">
                <!-- 遍历评论 -->
                    <c:forEach items="${replyList}" var="reply">
                        <li class="list-group-item">
                            <div style="height: 150px">
                                <div style="float: left;width: 6%;margin-bottom: 5px">
                                    <img width="50px" height="50px" src="/userAvatar/${reply.user.avatar} " class="img-rounded">
                                </div>
                                <div style="width: 89%;float: left">
                                    <a href="/userInfo?id=${reply.user.id}"><strong>${reply.user.username}</strong></a>&nbsp;&nbsp;
                                    <small class="text-muted">${reply.localCreateTime}</small>
                                    <c:if test="${user.id eq reply.user.id}">
                                        <button id="del" onclick="del(${topic.id},${reply.id})"><small style="color: red">删除</small></button>
                                    </c:if>
                                    <br/>
                                    <div>
                                        <p>${reply.content}</p>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>

        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="/topicDetail?id=${topic.id}&page=1" aria-label="Previous">
                        <span aria-hidden="true">首页</span>
                    </a>
                </li>
                <c:forEach items="${page.pages}" var="p">
                    <li><a href="/topicDetail?id=${topic.id}&page=${p}">${p}</a></li>
                </c:forEach>
                <li>
                    <a href="/topicDetail?id=${topic.id}&page=${page.totalPage}" aria-label="Next">
                        <span aria-hidden="true">尾页</span>
                    </a>
                </li>
            </ul>
        </nav>

        <c:if test="${user != null}">
            <div class="panel panel-default" id="main" style="">
                <div class="panel-heading" style="background-color: white">
                    添加一条新回复
                </div>
                <div class="panel-body">
                    <div class="form-group">
                        <form action="/addReply" method="post">
                            <input type="hidden" name="topicId" value="${topic.id}">
                            <input type="hidden" name="userId" value="${user.id}">
                            <textarea class="form-control" rows="3" name="content" required="required"></textarea><br/>
                        <input type="submit" class="btn btn-default btn-sm" value="回复">
                        </form>
                    </div>
                </div>
            </div>
        </c:if>

    </div>
    <!-- 引入侧边栏文件 -->
    <%@ include file="side.jsp"%>

    <!-- 引入footer文件 -->
    <%@ include file="footer.jsp"%>

</body>
</html>