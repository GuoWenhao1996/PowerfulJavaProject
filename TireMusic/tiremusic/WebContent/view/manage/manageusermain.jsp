<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String basepath = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户管理主界面</title>
<link rel="stylesheet" type="text/css" href="<%=basepath %>/easyui/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basepath %>/easyui/themes/icon.css">
<style type="text/css">
	input {
		margin-top: 10px;	
	}
	#btn_1{
		margin:10px 0px 0px 100px; 
	}
	#btn_2{
		margin:10px 0px 0px 100px; 
	}
</style>
</head>
<body>
	<table id="dg"></table>  
	<script type="text/javascript" src="<%=basepath %>/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basepath %>/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basepath %>/easyui/locale/easyui-lang-zh_CN.js"></script> 
	<script type="text/javascript">
	//加载用户信息
	$('#dg').datagrid({    
	    url:'<%=basepath %>/usermanage/showUser.do', 
	    rownumbers:true,
	    pagination:true,
	    height:460,
	    toolbar: [{
			iconCls: 'icon-edit',
			text:'禁用',
			handler: function(){
				var nodes = $('#dg').datagrid('getChecked');
				var uid = [];
				for(var i = 0 ; i < nodes.length ; i ++){
					uid[i] = nodes[i].uid;
				}
				var uids = uid.join(",");
				$.post("<%=basepath %>/usermanage/updateUserState.do",{uids:uids},function(data){
					if(data=='true'){
						$.messager.alert('警告','禁用成功');  
						$('#dg').datagrid('reload');
					}else{
						$.messager.alert('警告','禁用失败');  
					}
				},'text');
			}
		}],
	    columns:[[  
	    	{field:'checkbox',title:'',width:100,checkbox:true},
	        {field:'uid',title:'用户编号',width:100,align:'center'},    
	        {field:'uname',title:'用户名称',width:100,align:'center'},    
	        {field:'realname',title:'用户真实姓名',width:100,align:'center'},
	        {field:'upassword',title:'用户密码',width:100,align:'center'},
	        {field:'uaddress',title:'用户地址',width:100,align:'center'},
	        {field:'uemail',title:'用户邮箱',width:100,align:'center'},
	        {field:'utelephone',title:'用户电话',width:100,align:'center'},
	        {field:'uidnumber',title:'身份证号码',width:100,align:'center'},
	        {field:'ustate',title:'用户状态',width:100,align:'center'}

	    ]]    
	}); 
		
	</script>
</body>
</html>