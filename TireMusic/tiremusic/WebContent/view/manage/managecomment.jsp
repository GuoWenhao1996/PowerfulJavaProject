<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String basepath = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>评论</title>
<link rel="stylesheet" type="text/css" href="<%=basepath %>/easyui/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basepath %>/easyui/themes/icon.css">
</head>
<body>

	<table id="dg"></table>  
	
	<script type="text/javascript" src="<%=basepath %>/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basepath %>/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basepath %>/easyui/locale/easyui-lang-zh_CN.js"></script> 
	<script type="text/javascript">
	//加载评论列表
	$('#dg').datagrid({    
	    url:'', 
	    rownumbers:true,
	    singleSelect:true,
	    pagination:true,
	    height:460,
	    columns:[[  
	    	{field:'checkbox',title:'',width:100,checkbox:true}, 
	        {field:'commentid',title:'评论编号',width:100,align:'center'},    
	        {field:'uid',title:'用户id',width:100,hidden:true},  
	        {field:'uname',title:'评论人',width:100,align:'center'},   
	        {field:'commentcontent',title:'评论内容',width:100,align:'center'},
	        {field:'commenttime',title:'评论时间',width:100,align:'center'}
	    ]]    
	}); 	
	</script>
</body>
</html>