<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>菜单</title>
    <link href="../../../static/css/left.css" rel="stylesheet" type="text/css"/>
    <link rel="StyleSheet" href="../../../static/css/dtree.css" type="text/css" />
</head>

<body>
    <table width="100" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td height="12"></td>
        </tr>
    </table>
    <table width="100%" border="0">
        <tr>
            <td>
                <div class="dtree">
                    <a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a>
                    <script type="text/javascript" src="../../../static/js/dtree.js"></script>
                    <script type="text/javascript">
                        d = new dTree('d');
                        d.add('0',-1,'后台管理系统');
                        d.add('01',0,'管理选项');
                        d.add('011','01','板块与帖子管理','/admin/listAllTabs');
                        d.add('012','01','用户管理','/admin/listAllUsers');
                        d.add('013','01','登录日志','/admin/listLog');
                        document.write(d);
                    </script>
                </div>
            </td>
        </tr>
    </table>
</body>
</html>
