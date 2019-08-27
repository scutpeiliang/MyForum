<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<HTML>
<HEAD>
    <title>回复列表</title>
    <meta http-equiv="Content-Language" content="zh-cn">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="../../../../static/css/Style1.css"
          rel="stylesheet" type="text/css" />
    <script src="../../../../static/js/jquery-3.2.1.js"></script>
    <script type="text/javascript">
        function deleteOrNot(topicId, id){
            var choice = confirm("确定删除吗?");
            if(choice == true){
                window.location.href = "/admin/deleteOneReply?topicId="+topicId+"&id="+id;
            }
        }
    </script>
</HEAD>
<body>
<br>
<table cellSpacing="1" cellPadding="0" width="100%" align="center"
       bgColor="#f5fafe" border="0">
    <TBODY>
    <tr>
        <td class="ta_01" align="center" bgColor="#afd1f3"><strong>${topicId}号帖子回复详情</strong>
        </TD>
    </tr>
    <tr>
        <td class="ta_01" align="center" bgColor="#f5fafe">
            <table cellspacing="0" cellpadding="1" rules="all"
                   bordercolor="gray" border="1" id="DataGrid1"
                   style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
                <tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
                    <td align="center" width="10%">回复者id</td>
                    <td align="center" width="10%">回复者头像</td>
                    <td align="center" width="10%">回复者</td>
                    <td align="center" width="10%">回复时间</td>
                    <td align="center" width="40%">回复内容</td>
                </tr>
                <c:forEach items="${replyList }" var="reply">
                    <tr onmouseover="this.style.backgroundColor = 'white'"
                        onmouseout="this.style.backgroundColor = '#F5FAFE';">
                        <td style="CURSOR: hand; HEIGHT: 22px" align="center"
                            width="10%">${reply.user.id}</td>
                        <td style="CURSOR: hand; HEIGHT: 22px" align="center"
                            width="10%"><img height="50px" width="50px" src="/userAvatar/${reply.user.avatar}"/></td>
                        <td style="CURSOR: hand; HEIGHT: 22px" align="center"
                            width="10%">${reply.user.username}</td>
                        <td style="CURSOR: hand; HEIGHT: 22px" align="center"
                            width="10%">${reply.localCreateTime}</td>
                        <td style="CURSOR: hand; HEIGHT: 22px" align="center"
                            width="40%">${reply.content}</td>
                        <td align="center" style="HEIGHT: 22px">
                            <button onclick="deleteOrNot(${topicId},${reply.id})" style="color: red;">删除</button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </td>
    </tr>
    </TBODY>
</table>
</form>
<button class="button_ok" type="button" onclick="history.go(-1)">返回</button>
</body>
</HTML>

