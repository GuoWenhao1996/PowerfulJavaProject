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
	<div id="win_1">
		<form action="" id="">
			敏感词：<input type="text" name="swtext"style="margin: 50px 0px 0px 0px;"/><br/>
			<a id="btn_1" href="javascript:addSW()" style="margin: 50px 0px 0px 100px;"class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>
		</form>
	</div>
	<div id="win_2">
		<form action="" id="">
			敏感词：<input type="text" name="swtext"style="margin: 50px 0px 0px 0px;"/><br/>
			<a id="btn_2" href="javascript:editSW()"style="margin: 30px 0px 0px 100px;" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a>
		</form>
	</div>
	<script type="text/javascript" src="<%=basepath %>/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basepath %>/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basepath %>/easyui/locale/easyui-lang-zh_CN.js"></script> 
	<script type="text/javascript">
	//加载敏感词听列表
	$('#dg').datagrid({    
	    url:'<%=basepath %>/sw/loadAllSensitiveword.do', 
	    rownumbers:true,
	    singleSelect:true,
	    pagination:true,
	    height:460,
	    singleSelect:true,
	    columns:[[  
	    	{field:'checkbox',title:'',width:100,checkbox:true},
	        {field:'swid',title:'敏感词编号',width:100,align:'center'},       
	        {field:'swtext',title:'敏感词',width:100,align:'center'}
	    ]] ,
		toolbar: [{
			text:'增加',
			iconCls: 'icon-add',
			handler: function(){
				$('#win_1').window('open');
			}
		},'-',{
			text:'删除',
			iconCls: 'icon-remove',
			handler: function(){
			  var temp = $('#dg').datagrid('getSelected');
				 if(temp==''){
					 $.messager.alert('警告！','请选择一条信息！');
				 }else{
					 var swid= temp.swid;
					 $.post('<%=basepath %>/sw/deleteSensitivewordBySwid.do',{swid:temp.swid},function(data){
						 if(data=="1"){
							 $.messager.alert('删除成功！','');
						 }else{
							 $.messager.alert('警告！','服务器错误，请稍后重试！');
						 }
					 },'json');
				 } 
			}
		},'-',{
			text:'修改',
			iconCls: 'icon-edit',
			handler: function(){
			 var temp = $('#dg').datagrid('getSelected');
				//  alert(temp.songid);
				 if(temp==''){
					 $.messager.alert('警告！','请选择一条信息！');
				 }else{
				$('#win_2').window('open');
				//加载修改的敏感词信息
				 $('#win_2 input[name="swtext"]').val(temp.swtext);
				 }
			}
		}]
	}); 
	//初始化新窗口
	$('#win_1').window({  
		title:'添加歌曲',
	    width:600,    
	    height:400,    
	    modal:true,
	    closed:true
	});
	$('#win_2').window({  
		title:'修改歌曲',
	    width:600,    
	    height:400,    
	    modal:true,
	    closed:true
	});
	//添加敏感词
	function addSW(){
		var swtext=$('#win_1 input[name="swtext"]').val();
		if(swtext==''){
			 $.messager.alert('警告！','必须填写信息！');
		}else{
			$.post('<%=basepath %>/sw/addSW.do',{"swtext":swtext},function(data){
				if(data="1"){
					$.messager.alert('添加成功！','');
					$('#win_1').window('close');
				}else{
					$.messager.alert('添加失败！','服务器错误，请稍后重试！');
				}
				
			},'json');
		}
	}
	//修改敏感词
	function editSW(){
		var temp = $('#dg').datagrid('getSelected');
		
		if(swtext==''){
			 $.messager.alert('警告！','必须填写信息！');
		}else{
			var swid=temp.swid;
			var swtext=$('#win_2 input[name="swtext"]').val();
			$.post('<%=basepath %>/sw/editSW.do',{"swtext":swtext},function(data){
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