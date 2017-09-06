<%@page import="entity.Friend"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title></title>
	<link rel="stylesheet" type="text/css" href="/PhoneBookMS/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="/PhoneBookMS/easyui/themes/icon.css">
	<script type="text/javascript" src="/PhoneBookMS/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="/PhoneBookMS/easyui/jquery.easyui.min.js"></script>
	<script src="/PhoneBookMS/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript" charset="utf-8"></script>
</head>

<body>
	<input class="easyui-textbox" style="width: 200px" prompt="请输入姓名进行模糊查询">
	<a id="search" href="#" class="easyui-linkbutton"
		data-options="iconCls:'icon-search'">查询</a>
	<table class="easyui-datagrid" id="studentTable"
		data-options="rownumbers:true,striped:true">
		<thead>
			<tr>
				<th data-options="field:'',checkbox:true"></th>
				<th data-options="field:'name'">姓名</th>
				<th data-options="field:'age'">生日</th>
				<th data-options="field:'sex'">性别</th>
				<th data-options="field:'telephone'">手机</th>
				<th data-options="field:'qq'">qq</th>
				<th data-options="field:'email'">邮箱</th>
				<th data-options="field:'address'">地址</th>
			</tr>
		</thead>
		<tbody>
		<%
			List<Friend> friends = (List<Friend>)request.getAttribute("friends");
			for(Friend f:friends){
		%>
		<tr>
			<td></td>
			<td><%=f.getName() %></td>
			<td><%=f.getBirthday() %></td>
			<td><%=f.getSex()==1?"男":"女" %></td>
			<td><%=f.getTelephone() %></td>
			<td><%=f.getQq() %></td>
			<td><%=f.getEmail() %></td>
			<td><%=f.getAddress() %></td>
		</tr>			
		<%		
			}
		%>
		</tbody>
	</table>
		<script type="text/javascript">
		$('#search').bind('click', function() {
			$.messager.alert('sorry', '查询功能暂未开放！');
		});
	</script>
</body>

</html>