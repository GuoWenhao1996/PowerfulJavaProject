<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="/sms/easyui/themes/bootstrap/easyui.css">   
	<link rel="stylesheet" type="text/css" href="/sms/easyui/themes/icon.css">
	<style type="text/css">
		.datagrid-btable td{
			height: 35px;
		}
	</style>
</head>
<body>
	<input id="ss"></input> 
	<table id="dg"></table>  
</body>
	<script type="text/javascript" src="/sms/easyui/jquery.min.js"></script>   
	<script type="text/javascript" src="/sms/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/sms/easyui/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
	<script type="text/javascript">
		$('#ss').searchbox({ 
			searcher:function(value,name){ 
				$('#dg').datagrid('load',{
					name:value
				});
			}, 
			prompt:'请菜单名称',
			height:30,
			width:250
		});
		
		$('#dg').datagrid({    
		    url:'/sms/menu/loadMenus.do',
		    pagination:true,
		    rownumbers:true,
		    striped:true,
		    pageSize:10, 
		    pageList:[5,10,20,50],
		    height:450,
		    toolbar: [{
				iconCls: 'icon-add',
				text:'增加',
				handler: function(){alert('增加菜单')}
			},'-',{
				iconCls: 'icon-remove',
				text:'删除',
				handler: function(){alert('删除菜单')}
			},'-',{
				iconCls: 'icon-edit',
				text:'修改',
				handler: function(){alert('修改菜单')}
			}],
		    columns:[[    
		        {field:'',title:'',width:100,checkbox:true},    
		        {field:'mid',title:'编号',width:100,align:'center'},    
		        {field:'name',title:'菜单名称',width:100,align:'center'},    
		        {field:'url',title:'菜单地址',width:300,align:'left'}, 
		        {field:'parentid',title:'父级菜单',width:100,align:'center'}    
		    ]]    
		}); 
	</script>
</html>