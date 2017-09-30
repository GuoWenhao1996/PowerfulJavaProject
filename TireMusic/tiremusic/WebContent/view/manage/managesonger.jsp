<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String basepath = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>歌手管理主界面</title>
<link rel="stylesheet" type="text/css" href="<%=basepath %>/easyui/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basepath %>/easyui/themes/icon.css">
<style type="text/css">
	input {
		margin-top: 15px;	
	}
	#btn_1{
		margin:10px 0px 0px 100px; 
	}
	#btn_2{
		margin:10px 0px 0px 100px; 
	}
	textarea {
		margin-top: 10px;	
	}
</style>
</head>
<body>
	<table id="dg"></table>  
	<div id="win_1">
		<form action="" id="">
			歌手名称：<input type="text" name="songername"/><br/>
			歌手介绍：<textarea rows=3 cols=30 name="songertext"></textarea><br/>
			<a id="btn_1" href="javascript:addSonger()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加歌手</a>
		</form>
		</form>
	</div>  
	<div id="win_2">
		<form action="">
			歌手名称：<input type="text" name="songername"/><br/>
			歌手介绍：<textarea rows=3 cols=30 name="songertext"></textarea><br/>
			<a id="btn_2" href="javascript:editSonger()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">修改歌手</a>
		</form>
	</div>  
	<script type="text/javascript" src="<%=basepath %>/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basepath %>/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basepath %>/easyui/locale/easyui-lang-zh_CN.js"></script> 
	<script type="text/javascript">
	//初始化新窗口
	$('#win_1').window({  
		title:'添加歌手',
	    width:600,    
	    height:400,    
	    modal:true,
	    closed:true
	});
	$('#win_2').window({  
		title:'修改歌手',
	    width:600,    
	    height:400,    
	    modal:true,
	    closed:true
	});
	//加载用户信息
	$('#dg').datagrid({    
	    url:'<%=basepath %>/songer/loadAllSongersPage.do', 
	    rownumbers:true,
	    singleSelect:true,
	    pagination:true,
	    height:460,
	    singleSelect:true,
	    toolbar: [{
			iconCls: 'icon-add',
			text:'增加',
			handler: function(){
				$('#win_1').window('open');
			}
		},'-',{
			iconCls: 'icon-remove',
			text:'删除',
			handler: function(){
	var temp = $('#dg').datagrid('getSelected');
				if(temp==null){
					$.messager.alert('警告','至少选择一条信息'); 
				}else{
					var songerid = temp.songerid;
					$.post('<%=basepath %>/songer/deleteSonger.do',{songerid:songerid},function(data){
						if(data=="1"){
							$.messager.alert('成功！','移除歌手成功！');  
							
						}else{
							$.messager.alert('失败！','服务器错误，移除歌手失败！');  
						}
					},'json');
				
				}
			}
		},'-',{
			iconCls: 'icon-edit',
			text:'修改',
			handler: function(){
				var temp = $('#dg').datagrid('getSelected');

				if(temp==null){
					$.messager.alert('警告','至少选择一条信息'); 
				}else{
					var songername=temp.songername;
					var songertext=temp.songertext;
					$('#win_2').window('open');
					$('#win_2 input[name="songername"]').val(songername);
					$('#win_2 textarea[name="songertext"]').val(songertext);
				}
			}
		}],
	    columns:[[
	    	{field:'songerid',title:'',width:100,checkbox:true},  
	        {field:'songername',title:'歌手名称',width:200,align:'center'},    
	        {field:'songertext',title:'歌手简介',width:200,align:'center'},
	        {field:'songerstate',title:'歌手状态',width:200,align:'center'}
	    ]]    
	}); 
	
	//添加歌手
	function addSonger(){
		var songername = $('#win_1 input[name="songername"]').val();
		var songertext = $('#win_1 textarea[name="songertext"]').val();
		if(songername==''||songertext==''){
			$.messager.alert('失败！','所有信息必须填写完整！');
		}else{
			$.post("<%=basepath %>/songer/addNewSonger.do",{'songername':songername,'songertext':songertext},function(data){
				if(data="1"){
					$.messager.alert('添加成功！','添加歌手成功！');
					$('#win_1').window('close');
				}else{
					$.messager.alert('添加失败！','服务器错误，请稍后重试！');
				}
				
			},'json');
		}
	}
	//修改歌手
	function editSonger(){
		var temp = $('#dg').datagrid('getSelected');
		var songerid = temp.songerid;
		var songername = $('#win_2 input[name="songername"]').val();
		var songertext = $('#win_2 textarea[name="songertext"]').val();
		if(songername==''||songertext==''){
			$.messager.alert('失败！','所有信息必须填写完整！');
		}else{
			$.post('<%=basepath %>/songer/changeSonger.do',{"songerid":songerid,"songername":songername,"songertext":songertext},function(data){
				if(data="1"){
					$.messager.alert('修改成功！','');
					$('#win_2').window('close');
				}else{
					$.messager.alert('修改失败！','服务器错误，请稍后重试！');
				}
				
			},'json');
		}
	}
	</script>
</body>
</html>