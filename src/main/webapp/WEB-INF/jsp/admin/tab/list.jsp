<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<HTML>
<HEAD>
	<title>板块列表</title>
	<meta http-equiv="Content-Language" content="zh-cn">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="../../../../static/css/Style1.css"
		rel="stylesheet" type="text/css" />
	<script src="../../../../static/js/jquery-3.2.1.js"></script>
	<script type="text/javascript">
			function addTab(){
				window.location.href = "/jumpToAddTab";
			}

			function deleteOrNot(tabName){
				var choice = confirm("确定删除吗?");
				if(choice == true){
					window.location.href = "/admin/check/deleteOneTab?tabName="+tabName;
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
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>板块列表</strong>
					</TD>
				</tr>
				<tr>
					<td class="ta_01" align="right">
						<button type="button" id="add" name="add" value="添加" class="button_add" onclick="addTab()">添加</button>
					</td>
				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
								<td align="center" width="25%">板块id</td>
								<td align="center" width="30%">板块中文名</td>
								<td align="center" width="30%">板块英文名</td>
							</tr>
							<c:forEach items="${tabList }" var="tab">
								<tr onmouseover="this.style.backgroundColor = 'white'"
								onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="25%">${tab.id }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="30%"><a href="/admin/check/listTopicsOfTab?tabName=${tab.tabName}">${tab.tabName}</a></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="30%">${tab.tabNameEn}</td>
									<td align="center" style="HEIGHT: 22px">
										<button onclick="deleteOrNot('${tab.tabName}')" style="color: red;">删除</button>
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

