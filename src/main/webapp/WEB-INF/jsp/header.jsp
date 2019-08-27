<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    $(function () {
        $.ajax({
            url: "/selectAllTabs",
            async:false,
            dataType:"json",
            success:function (data) {
                for(var i = 0; i < data.length; i++){
                    var tab = data[i];
                    $("#tabList").append("<li><a href=" + "/topicsOfTab?id=" + tab.tabId + ">" + tab.tabName + "</a></li>");
                }
            }
        });
    });
</script>
<header>
    <nav class="navbar navbar-default" role="navigation" style="background-color: white">
        <div class="container-fluid" style="margin-left: 10%">
            <div class="navbar-header">
                <a class="navbar-brand" href="/">所有分类</a>
            </div>
            <div>

                <!--向左对齐-->
                <ul class="nav navbar-nav navbar-left" id="tabList">

                </ul>

                <c:if test="${user == null}">
                <!--未登陆-->
                 <ul class="nav navbar-nav navbar-right">
                       <li>
                           <p class="navbar-text"><a href="/signIn">登录</a></p>
                       </li>
                       <li>
                           <p class="navbar-text"><a href="/signUp">注册</a></p>
                       </li>
                 </ul>
                </c:if>

                <c:if test="${user != null}">
                       <!--已登陆-->
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <p class="navbar-text"><a href="/">首页</a></p>
                        </li>
                        <li>
                            <p class="navbar-text"><a href="/userInfo?id=${user.id}">欢迎，${user.username}</a></p>
                        </li>
                        <li>
                            <p class="navbar-text"><a href="/settings?id=${user.id}">设置</a></p>
                        </li>
                        <li>
                            <p class="navbar-text"><a href="javascript:signout_confirm();">注销</a></p>
                        </li>
                    </ul>
                </c:if>
            </div>
        </div>
    </nav>
</header>

<script>
    function signout_confirm()
    {
        var r=confirm("确定退出?")
        if (r==true)
        {
            window.location.href="/user/signOut";
        }
        else
        {

        }
    }
</script>