<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String basepath = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>审核管理</title>
<link rel="stylesheet" type="text/css" href="<%=basepath %>/easyui/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basepath %>/easyui/themes/icon.css">
</head>
<body>

	<table id="dg"></table>  
	
	<script type="text/javascript" src="<%=basepath %>/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basepath %>/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basepath %>/easyui/locale/easyui-lang-zh_CN.js"></script> 
	<script type="text/javascript">
	//加载审核表
	$('#dg').datagrid({    
	    url:'<%=basepath %>/auditingmanage/showAllAuditing.do', 
	    rownumbers:true,
	    pagination:true,
	    height:460,
	    toolbar: [{
			iconCls: 'icon-edit',
			text:'通过',
			handler: function(){
				var nodes = $('#dg').datagrid('getChecked');
				var uploadlistid = [];
				for(var i = 0 ; i < nodes.length ; i ++){
					uploadlistid[i] = nodes[i].uploadlistid;
				}
				var uploadlistids = uploadlistid.join(",");
				$.post('<%=basepath %>/auditingmanage/uploadAuditingAC.do',{uploadlistids:uploadlistids},function(data){
					if(data=='true'){
						$.messager.alert('警告','操作成功');
						$('#dg').datagrid('reload');
					}else{
						$.messager.alert('警告','操作失败');  
					}
				},'text');
			}
		},'-',{
			iconCls: 'icon-edit',
			text:'不通过',
			handler: function(){
				var nodes = $('#dg').datagrid('getChecked');
				var uploadlistid = [];
				for(var i = 0 ; i < nodes.length ; i ++){
					uploadlistid[i] = nodes[i].uploadlistid;
				}
				var uploadlistids = uploadlistid.join(",");
				$.post("<%=basepath %>/auditingmanage/uploadAuditingNoAC.do",{uploadlistids:uploadlistids},function(data){
					if(data=='true'){
						$.messager.alert('警告','操作成功'); 
						$('#dg').datagrid('reload');
					}else{
						$.messager.alert('警告','操作失败');  
					}
				},'text');
			}
		}],
	    columns:[[   
	    	{field:'checkbox',title:'',width:100,checkbox:true}, 
	        {field:'uploadlistid',title:'上传编号',width:100,align:'center'},    
	        {field:'songid',title:'歌曲编号',width:100,hidden:true}, 
	        {field:'songname',title:'歌曲名称',width:100,align:'center'},  
	        {field:'uploadid',title:'上传人编号',width:100,align:'center'},  
	        {field:'uploadname',title:'上传人',width:100,align:'center'}, 
	        {field:'state',title:'审核状态',width:100,align:'center'}
	    ]]    
	}); 
		
	</script>
</body>
</html>