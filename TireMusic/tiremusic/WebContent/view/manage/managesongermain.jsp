<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String basepath = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>歌曲试听</title>
<link rel="stylesheet" type="text/css" href="<%=basepath %>/easyui/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basepath %>/easyui/themes/icon.css">
</head>
<body>

	<table id="dg"></table>  
	
	<script type="text/javascript" src="<%=basepath %>/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basepath %>/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basepath %>/easyui/locale/easyui-lang-zh_CN.js"></script> 
	<script type="text/javascript">
	//加载歌曲试听列表
	$('#dg').datagrid({    
	    url:'', 
	    rownumbers:true,
	    singleSelect:true,
	    pagination:true,
	    height:460,
	    singleSelect:true,
	    columns:[[  
	    	{field:'checkbox',title:'',width:100,checkbox:true},
	        {field:'songerid',title:'歌手编号',width:100,align:'center'},    
	        {field:'songername',title:'歌手名称',width:100,align:'center'},    
	        {field:'songertext',title:'歌手描述',width:100,align:'center'},    
	        {field:'songerstate',title:'歌手状态',width:100,align:'center'} 
	    ]] ,
		toolbar: [{
			text:'增加',
			iconCls: 'icon-add',
			handler: function(){alert('增加按钮')}
		},'-',{
			text:'删除',
			iconCls: 'icon-remove',
			handler: function(){alert('删除按钮')}
		},'-',{
			text:'修改',
			iconCls: 'icon-edit',
			handler: function(){alert('修改按钮')}
		}]
	}); 
		
	</script>
</body>
</html>