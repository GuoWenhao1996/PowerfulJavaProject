<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String basepath = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>歌曲下载</title>
<link rel="stylesheet" type="text/css" href="<%=basepath %>/easyui/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basepath %>/easyui/themes/icon.css">
</head>
<body>

	<table id="dg"></table>  
	
	<script type="text/javascript" src="<%=basepath %>/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basepath %>/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basepath %>/easyui/locale/easyui-lang-zh_CN.js"></script> 
	<script type="text/javascript">
	//加载歌曲下载列表
	$('#dg').datagrid({    
	    url:'<%=basepath %>/Statistics/showDownNumber.do', 
	    rownumbers:true,
	    singleSelect:true,
	    pagination:true,
	    height:460,
	    singleSelect:true,
	    columns:[[       
	        {field:'songid',title:'歌曲编号',width:100},
	        {field:'songname',title:'歌曲名称',width:100},
	        {field:'downnum',title:'下载次数',width:100}    
	    ]]    
	}); 
		
	</script>
</body>
</html>