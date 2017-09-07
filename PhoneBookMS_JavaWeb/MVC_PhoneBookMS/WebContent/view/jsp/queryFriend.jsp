<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title></title>
	<link rel="stylesheet" type="text/css" href="/MVC_PhoneBookMS/view/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="/MVC_PhoneBookMS/view/easyui/themes/icon.css">
	<script type="text/javascript" src="/MVC_PhoneBookMS/view/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="/MVC_PhoneBookMS/view/easyui/jquery.easyui.min.js"></script>
	<script src="/MVC_PhoneBookMS/view/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript" charset="utf-8"></script>
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
		<c:forEach items="${requestScope.friends}" var="friend">
			<tr>
				<td></td>
				<td>${friend.name}</td>
				<td>
					<fmt:formatDate value="${friend.birthday}" pattern="yyyy年MM月dd日"/>
				</td>
				<td>
					<%--
					<c:if test="${friend.sex==1}">
						男
					</c:if>
					<c:if test="${friend.sex!=1}">
						女
					</c:if>--%>
					<c:choose>
						 <c:when test="${friend.sex==1}">
						 	男
						 </c:when>
						 <c:otherwise>
						 	女
						 </c:otherwise>
					</c:choose>
				</td>
				<td>${friend.telephone}</td>
				<td>${friend.qq}</td>
				<td>${friend.qq}</td>
				<td>${friend.address}</td>
			</tr>
		</c:forEach>
			
		<%-- <%
			List<Friend> friends = (List<Friend>)request.getAttribute("friends");
			for(Friend f:friends){
		%>
		<tr>
			<td></td>
			<td><%=f.getName() %></td>
			<td><%=f.getBirthday()==null?"":f.getBirthday() %></td>
			<td><%=f.getSex()==1?"男":"女" %></td>
			<td><%=f.getTelephone() %></td>
			<td><%=f.getQq() %></td>
			<td><%=f.getEmail() %></td>
			<td><%=f.getAddress() %></td>
		</tr>			
		<%		
			}
		%> --%>
		</tbody>
	</table>
		<script type="text/javascript">
		$('#search').bind('click', function() {
			$.messager.alert('sorry', '查询功能暂未开放！');
		});
	</script>
</body>

</html>