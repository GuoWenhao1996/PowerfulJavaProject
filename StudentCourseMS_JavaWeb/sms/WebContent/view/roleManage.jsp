<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="/sms/easyui/themes/bootstrap/easyui.css">   
	<link rel="stylesheet" type="text/css" href="/sms/easyui/themes/icon.css">
</head>
<body>
	<table id="dg"></table>
	<div id="win">
		<ul id="tt"></ul>
		<a id="btn" href="javascript:updatePower()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">提交修改</a>
	</div>
	<script type="text/javascript" src="/sms/easyui/jquery.min.js"></script>   
	<script type="text/javascript" src="/sms/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/sms/easyui/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
	<script type="text/javascript">
		function updatePower() {
			var row=$('#dg').datagrid('getSelected');
			var rid=row.rid;
			var nodes=$('#tt').tree('getChecked');
			var mids=[];
			for (var i = 0; i < nodes.length; i++) {
				mids[i]=nodes[i].id;
			}
			var midStr=mids.join(',');
			$.post('/sms/power/updatePower.do',{rid:rid,midStr:midStr},function(data){
				if(data=='true'){
					$('#win').window('close');
					$.messager.alert('恭喜','权限修改成功！');
				}else{
					$.messager.alert('警告','服务器异常，请稍后再试！');
				}
			},'text');
		}
	
		$('#win').window({
			title:'权限修改-打勾代表拥有此权限',
		    width:600,    
		    height:400,    
		    modal:true,
		    collapsible:false,
		    minimizable:false,
		    maximizable:false,
		    closed:true
		});
		
		$('#dg').datagrid({    
		    url:'/sms/role/queryAllRoles.do',
		    rownumbers:true,
		    singleSelect:true,
		    toolbar: [{
				iconCls: 'icon-my-edit',
				text:'修改权限',
				handler: function(){
					var row=$('#dg').datagrid('getSelected');
					if(!row){
						$.messager.alert('警告','请选择要修改的角色！');
						return;
					}
					var rid=row.rid;
					$('#win').window('open');
					$('#tt').tree({    
					    url:'/sms/power/loadPowers.do?rid='+rid,
					    checkbox:true,
					    cascadeCheck:false
					});  
				}
			}],
		    columns:[[    
		        {field:'',title:'',width:100,checkbox:true},    
		        {field:'rid',title:'编号',width:100,align:'center'},    
		        {field:'name',title:'名称',width:100,align:'center'}    
		    ]]    
		});
	</script>
</body>
</html>