<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="../../../../static/css/Style1.css" type="text/css" rel="stylesheet">
	</HEAD>
	
	<body>
		<form name="Form1" action="/admin/addTab" method="post">
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>添加板块</STRONG>
						</strong>
					</td>
				</tr>

				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						板块名称：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="tabName" class="bg"/>
					</td>
				</tr>

				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						板块英文名：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="tabNameEn" class="bg"/>
					</td>
				</tr>

				<tr>
					<td class="ta_01" style="WIDTH: 100%" align="center"
						bgColor="#f5fafe" colSpan="4">
						<input type="submit" value="确定" class="button_ok"/>
						<button class="button_ok" type="button" onclick="history.go(-1)">返回</button>
					</td>
				</tr>
			</table>
		</form>
	</body>
</HTML>