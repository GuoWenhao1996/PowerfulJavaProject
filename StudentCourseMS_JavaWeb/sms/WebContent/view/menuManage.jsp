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
	<div id="addwin" style="padding-left:100px;font-size: 16px">
		<div style="margin-top: 20px">   
	        <label for="name">菜单名称:</label>   
	        <input class="easyui-validatebox" type="text" name="name" data-options="required:true" />
	    </div>   
	    <div  style="margin-top: 20px">   
	        <label for="url">菜单地址:</label>   
	        <input class="easyui-validatebox" type="text" name="url"/>
	    </div>
	    <div  style="margin-top: 20px">   
	        <label for="grade">菜单级别:</label>   
 			<input name="grade" class="easyui-switchbutton" data-options="onText:'一级菜单',offText:'二级菜单',width:100,checked:true">
	    </div>
	    <div id="parentMenuDiv" style="margin-top: 20px;display: none;">   
	        <label for="parent">父级菜单:</label>   
			<select id="parentMenu"  name="parentMenu" style="width: 170px;height: 20px">   
				<option value='0' style="display: none">请选择</option>
			</select>  
	    </div>
	    <div style="margin-top: 20px;">   
			<a style="margin-left: 50px;" id="btn" href="javascript:addMenu()" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>
			<a style="margin-left: 50px;" id="btn" href="javascript:closeWin('#addwin')" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>
	    </div>   		
	</div>
	<div id="editwin" style="padding-left:100px;font-size: 16px">
		<div style="margin-top: 20px">   
	        <label for="name">菜单名称:</label>   
	        <input class="easyui-validatebox" type="text" name="mid" style="display: none"/>
	        <input class="easyui-validatebox" type="text" name="name" data-options="required:true" />
	    </div>   
	    <div  style="margin-top: 20px">   
	        <label for="url">菜单地址:</label>   
	        <input class="easyui-validatebox" type="text" name="url"/>
	    </div>
	    <div  style="margin-top: 20px">   
	        <label for="grade">菜单级别:</label>   
 			<input name="grade" class="easyui-switchbutton" data-options="onText:'一级菜单',offText:'二级菜单',width:100,checked:true">
	    </div>
	    <div id="parentMenuDivEdit" style="margin-top: 20px;display: none;">   
	        <label for="parent">父级菜单:</label>   
			<select id="parentMenuEdit"  name="parentMenu" style="width: 170px;height: 20px">   
				<option value='0' style="display: none">请选择</option>
			</select>  
	    </div>
	    <div style="margin-top: 20px;">   
			<a style="margin-left: 50px;" id="btn" href="javascript:editMenu()" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>
			<a style="margin-left: 50px;" id="btn" href="javascript:closeWin('#editwin')" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>
	    </div>   		
	</div>
	<script type="text/javascript" src="/sms/easyui/jquery.min.js"></script>   
	<script type="text/javascript" src="/sms/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/sms/easyui/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
	<script type="text/javascript">
		//表格
		$('#dg').datagrid({    
		    url:'/sms/menu/loadMenus.do',
		    pagination:true,
		    rownumbers:true,
		    striped:true,
		    pageSize:10, 
		    pageList:[5,10,20,50],
		    height:450,
		    toolbar: [{
				iconCls: 'icon-my-add',
				text:'增加',
				handler: function(){
					$('#addwin').window('open');
				}
			},'-',{
				iconCls: 'icon-my-remove',
				text:'删除',
				handler: function(){
					var rows=$('#dg').datagrid('getSelections');
					var mids=[];
					for (var i = 0; i < rows.length; i++) {
						mids[i]=rows[i].mid;
					}
					var midStr=mids.join(',');
					if(!midStr){
						$.messager.alert('警告','请选择要删除的菜单！');
						return;
					}
					$.messager.confirm('警告','您确认想要删除选中的【'+rows.length+'】条菜单吗？删除菜单的同时对应的权限也会被删除！',function(r){    
					    if (r){    
							$.post('/sms/menu/deleteMenu.do',{midStr:midStr},function(data){
								if(data=='true'){
									$('#addwin').window('close');
									$('#dg').datagrid('reload',{});
									$.messager.alert('恭喜','删除成功！');
								}else{
									$.messager.alert('警告','服务器异常，请稍后再试！');
								}
							},'text');
					    }    
					});  
				}
			},'-',{
				iconCls: 'icon-my-edit',
				text:'修改',
				handler: function(){
					var rows=$('#dg').datagrid('getSelections');
					if(rows.length!=1){
						$.messager.alert('警告','请选择一条要修改的菜单！');
						return;
					}
					$('#editwin input[name="mid"]').val(rows[0].mid);
					$('#editwin input[name="name"]').val(rows[0].name);
					$('#editwin input[name="url"]').val(rows[0].url);
					$('#editwin').window('open');
				}
			}],
		    columns:[[    
		        {field:'',title:'',width:100,checkbox:true},    
		        {field:'mid',title:'编号',width:100,align:'center'},    
		        {field:'name',title:'菜单名称',width:100,align:'center'},    
		        {field:'url',title:'菜单地址',width:300,align:'left'}, 
		        {field:'parentid',title:'父级菜单',width:100,align:'center'}    
		    ]]    
		});
		// 显示进度条
		$.messager.progress({
			title: '初始化',
			msg: '正在初始化数据',
			interval:100
		});
		//1秒后关闭进度条
		setTimeout(function() {
			$.messager.progress('close');
		}, 1000);
		//增加菜单的一级二级切换
		$('#addwin input[name="grade"]').switchbutton({
			onChange: function(checked){
				if(!checked){
					$.post("/sms/menu/getParentMenu.do",function(data){
						//$('#parentMenu option:not(:first)').remove();
						for (var i = 0; i < data.length; i++) {
							$('#parentMenu').append('<option value="'+data[i].mid+'">'+data[i].name+'</option>');
						}					
						$('#parentMenuDiv').css('display','');
					},"json");
				}else{
					$('#parentMenu option:not(:first)').remove();
					$('#parentMenuDiv').css('display','none');
				}
			}
		});
		//修改菜单的一级二级切换
		$('#editwin input[name="grade"]').switchbutton({
			onChange: function(checked){
				if(!checked){
					$.post("/sms/menu/getParentMenu.do",function(data){
						//$('#parentMenu option:not(:first)').remove();
						for (var i = 0; i < data.length; i++) {
							$('#parentMenuEdit').append('<option value="'+data[i].mid+'">'+data[i].name+'</option>');
						}					
						$('#parentMenuDivEdit').css('display','');
					},"json");
				}else{
					$('#parentMenuEdit option:not(:first)').remove();
					$('#parentMenuDivEdit').css('display','none');
				}
			}
		});
		//搜索框
		$('#ss').searchbox({ 
			searcher:function(value,name){ 
				$('#dg').datagrid('load',{
					name:value
				});
			}, 
			prompt:'请输入菜单名称模糊匹配',
			height:30,
			width:250
		});
		//增加菜单的窗口
		$('#addwin').window({
			title:'增加菜单',
		    width:600,    
		    height:400,    
		    modal:true,
		    collapsible:false,
		    minimizable:false,
		    maximizable:false,
		    closed:true
		});
		//修改菜单的窗口
		$('#editwin').window({
			title:'修改菜单信息',
		    width:600,    
		    height:400,    
		    modal:true,
		    collapsible:false,
		    minimizable:false,
		    maximizable:false,
		    closed:true
		});
		//添加菜单
		function addMenu() {
			var name=$('#addwin input[name="name"]').val();
			if(name==""){
				$.messager.alert('警告','菜单名称不能为空！');
				return;
			}
			var url=$('#addwin input[name="url"]').val();
			var pid=$('#parentMenu').val();
			$.post('/sms/menu/addMenu.do',{name:name,url:url,pid:pid},function(data){
				if(data=='true'){
					$.messager.alert('恭喜','菜单【'+name+'】添加成功！');
					$('#addwin input[name="name"]').val("");
					$('#addwin input[name="url"]').val("");
					//$('input[name="grade"]').css('checked',true);
					$('#dg').datagrid('reload',{});
					$('#addwin').window('close');
					
				}else{
					$.messager.alert('警告','服务器异常，请稍后再试！');
				}
			},'text');
		}
		//修改菜单
		function editMenu() {
			var mid=$('#editwin input[name="mid"]').val();
			var name=$('#editwin input[name="name"]').val();
			if(name==""){
				$.messager.alert('警告','菜单名称不能为空！');
				return;
			}
			var url=$('#editwin input[name="url"]').val();
			var pid=$('#parentMenuEdit').val();
			$.post('/sms/menu/editMenu.do',{mid:mid,name:name,url:url,pid:pid},function(data){
				if(data=='true'){
					$.messager.alert('恭喜','菜单【'+name+'】修改成功！');
					$('#dg').datagrid('reload',{});
					$('#editwin').window('close');
				}else{
					$.messager.alert('警告','服务器异常，请稍后再试！');
				}
			},'text');
		}
		//取消（关闭窗口）
		function closeWin(objID) {
			$(objID).window('close');
		}
	</script>
</body>
</html>