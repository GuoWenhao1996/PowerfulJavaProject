<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String basePath=request.getContextPath();
%> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>即将返回登录页面</title>
		<link rel="icon" href="<%=basePath%>/img/logo.png" type="image/x-icon" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/bootstrap.min.css" />
	</head>
	<body style="background-color: #7bbfea;">
		<h1 class="text-center text-danger" style="margin-top: 50px">
			您尚未登录或登录认证已过期，请重新登录！<br/>
			<label>5</label>秒后自动跳转至登录页面！<br/>
			<a style="color:#F77A00" href="<%=basePath%>">懒得等了？点此处可直接跳转至登录页面！</a>
		</h1>
	</body>
	<script src="<%=basePath%>/js/jquery-1.11.0.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=basePath%>/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		var time=$('label').html();
		setInterval(function(){
			time--;
			$('label').html(time);
		},1000);
		setTimeout(function(){
			location.href="<%=basePath%>";
		},time*1000);
	</script>
</html>
