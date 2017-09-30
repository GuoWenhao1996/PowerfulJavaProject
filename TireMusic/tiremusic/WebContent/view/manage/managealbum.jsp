<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String basepath = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>专辑管理主界面</title>
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
	select {
		margin-top: 10px;	
	}
	textarea {
		margin-top: 10px;	
	}
</style>
</head>
<body>
	<table id="dg"></table>  
	<div id="win_1">
		<form action="">
			专辑名称：<input type="text" name="albumname"/><br/>
			发行时间：<input type="date" name="releasetime"/><br/>
			专辑介绍：<textarea rows=3 cols=30 name="albumtext"></textarea><br/>
			<a id="btn_1" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加专辑</a>
		</form>
	</div>  
	<div id="win_2">
		<form action="">
			专辑名称：<input type="text" name="albumname"/><br/>
			发行时间：<input type="date" name="releasetime"/><br/>
			专辑介绍：<textarea rows=3 cols=30 name="albumtext"></textarea><br/>
			<a id="btn_1" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">修改专辑</a>
		</form>
	</div>  
	<script type="text/javascript" src="<%=basepath %>/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basepath %>/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basepath %>/easyui/locale/easyui-lang-zh_CN.js"></script> 
	<script type="text/javascript">
	//初始化新窗口
	$('#win_1').window({  
		title:'添加专辑',
	    width:600,    
	    height:400,    
	    modal:true,
	    closed:true
	});
	$('#win_2').window({  
		title:'修改专辑',
	    width:600,    
	    height:400,    
	    modal:true,
	    closed:true
	});
	//加载用户信息
	$('#dg').datagrid({    
	    url:'<%=basepath %>/music/loadAllMusics.do', 
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
				$.messager.alert('警告','服务器发生错误！请稍后重试');    
				$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
				    if (r){    
				        alert('确认删除');    
				    }    
				}); 
			}
		},'-',{
			iconCls: 'icon-edit',
			text:'修改',
			handler: function(){
				$('#win_2').window('open');
			}
		}],
	    columns:[[
	    	{field:'albumid',title:'',width:100,checkbox:true}, 
	        {field:'albumname',title:'专辑名称',width:220,align:'center'},    
	        {field:'releastate',title:'发行时间',width:220,align:'center'},    
	        {field:'albumtext',title:'专辑介绍',width:220,align:'center'},
	        {field:'albumstate',title:'专辑状态',width:220,align:'center'}
	    ]]    
	}); 
	//页面加载后查询流派
	$(function(){
		$.post('<%=basepath %>/school/loadAllSchools.do',function(data){
			for(var i=0;i<data.length;i++){
				$('#searchForm select[name="schoolid"]').append('<option value="'+data[i].schoolid+'">'+data[i].schoolname+'</option>');
			}
		},'json');
	});
	//页面加载完毕后一步查询所有歌手和专辑、
	$(function(){
		$.post('<%=basepath %>/songer/loadAllSongers.do',function(data){
			for(var i=0;i<data.length;i++){
				$('#searchForm select[name="songerid"]').append('<option value="'+data[i].songerid+'">'+data[i].songername+'</option>');
				//二级联动
				$('#searchForm select[name="songerid"]').change(function(){
					var songerid=$(this).val();
					//alert(songerid);
					$.post('<%=basepath %>/album/loadAllAlbumsBySongerid.do',{songerid:songerid},function(data ){
						//先删
						$('#searchForm select[name="albumid"] option:not(:first)').remove();
						for(var j=0;j<data.length;j++){
							$('#searchForm select[name="albumid"]').append('<option value="'+data[j].albumid+'">'+data[j].albumname+'</option>');
						}
					},'json');
				});
			}
		},'json');		
	});
	
	//查询歌曲
	function searchSong(){
		//获取查询参数
		var songname = $('#searchForm input[name="songname"]').val();
		var schoolid = $('#searchForm select[name="schoolid"]').val();
		var songerid = $('#searchForm select[name="songerid"]').val();
		var albumid = $('#searchForm select[name="albumid"]').val();
		//查询
		$('#dg').datagrid('load',{
			songname: songname,
			schoolid: schoolid,
			songerid: songerid,
			albumid: albumid
		});	
	}
	
	</script>
</body>
</html>