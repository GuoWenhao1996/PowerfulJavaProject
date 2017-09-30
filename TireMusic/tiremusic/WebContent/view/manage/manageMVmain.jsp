<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String basepath = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>MV主界面</title>
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
</style>
</head>
<body>
	 	<form action=""id ="searchform">
			<table>
				<tr>
					<td>MV编号:</td><td><input type="text" name="mvid"></td>
					<td>MV名称:</td><td><input type="text" name="mvname"></td>
					<td>MV介绍:</td><td><input type="text" name="mvtext"></td>
					<td>歌曲id:</td><td><select name="songid"><option value="">--请选择歌曲id--</option></select></td>
				</tr>
				<tr><td>MV状态</td><td><select name="mvstate">
											<option value="">--请选择MV状态--</option>
											<option value="0">--已下架--</option>
											<option value="1">--上架中--</option>
										</select></td>
					<td>MV审核状态</td><td><select name="mvpustate">
											<option value="">--请选择MV审核状态--</option>
											<option value="1">--已通过审核--</option>
											<option value="0">--未通过审核--</option>
										</select></td></td>
					<td>发行时间</td><td><input  id="begin"  type= "text" class= "easyui-datebox" > </input></td>
					<td>到</td><td><input  id="end"  type= "text" class= "easyui-datebox" > </input></td>
					<td><a id="btn" href="javascript:searchMV()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>  </td>
				</tr>	
			</table>
		</form>
	<table id="dg">	</table>  
	<div id="win_1">
		<form action="">
				<input name="mvid" type="text" style="display:none"/>
			MV名称：<input  name="mvname"  type= "text"  style="width: 150px"/></br>
			歌曲编号:<select name="songid">
					</select>
			歌曲名称：<input  name="songname"  type= "text"  style="width: 150px" value=" " readonly="true" />
					</br>
			MV介绍：<input  name="mvtext"  type= "text"  style="width: 150px"/></br>
			发行时间:<input class="easyui-datetimebox" id="dd" name="releasetime" style="width:150px"></br> 
			<a id="btn_1" href="javascript:updateMvInfo()" class="easyui-linkbutton" data-options="iconCls:'icon-cut'">修改MV</a>
		</form>
	</div>  
	<div id="win_2">
		<form action="/tiremusic/addMV" method="post" enctype="multipart/form-data" id="addMv">
			MV名称：<input type="text" name="mvname"></td></br>
			歌曲id:<select name="songid"><option value="">--请选择歌曲id--</option></select></br>
			MV介绍:<input type="text" name="mvtext"></br>
			发行时间:<input  name="releasetime"  type= "text" class= "easyui-datebox" style="width:150px" required ="required"/></br>
			要上传的MV:<input type="file" name="location"/><br/>
			<input type="submit" value="上传"/>
		<!--  	<a id="btn" href="javascript:addMV()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">上传MV</a>
		--></form>
	</div>  
	<div id="win_3"></div> 
	<script type="text/javascript" src="<%=basepath %>/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basepath %>/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basepath %>/easyui/locale/easyui-lang-zh_CN.js"></script> 
	<script type="text/javascript">
	
	//初始化新窗口
	$('#win_1').window({  
		title:'修改MV信息',
	    width:600,    
	    height:400,    
	    modal:true,
	    closed:true,
	});
	$('#win_2').window({  
		title:'修改MV',
	    width:600,    
	    height:400,    
	    modal:true,
	    closed:true
	});
	
	//加载MV信息
	$('#dg').datagrid({    
	    url:'/tiremusic/MV/loadAllMv.do', 
	    rownumbers:true,
	    singleSelect:true,
	    pagination:true,
	    height:460,
	    toolbar: [{
			iconCls: 'icon-add',
			text:'上架MV',
			handler: function(){
				//获取选择的行
				var row = $('#dg').datagrid('getSelected');
				if(!row){
					$.messager.alert('警告','请选择一首要上架的mv'); 
				}else{
					$.messager.confirm('确认','您确认想要上架该MV吗？',function(da){    
						if(da){
						if(row.mvstate==1){
							$.messager.alert('提示','同一首MV不能多次上架');
						}else{
							//修改数据库中状态
							$.post("/tiremusic/MV/putMv.do",{mvid:row.mvid},function(data){
								if(data){
									$.messager.alert('提示','上架成功');
								}else{
									$.messager.alert('提示','上架失败服务器繁忙请稍后再试');
								}
							},'json');
							//重修加载表单
							$('#dg').datagrid('load',{
							});
							
						}
						}
					}); 
				}
			}
		},'-',{
			iconCls: 'icon-remove',
			text:'下架MV',
			handler: function(){
				//获取选择的行
				var row = $('#dg').datagrid('getSelected');
				if(!row){
					$.messager.alert('警告','请选择一首要下架的mv'); 
				}else{
					$.messager.confirm('确认','您确认想要下架该MV吗？',function(da){    
						if(da){
						if(row.mvstate==0){
							$.messager.alert('提示','同一首MV不能多次下架');
						}else{
							//修改数据库中状态
							$.post("/tiremusic/MV/downMv.do",{mvid:row.mvid},function(data){
								if(data){
									$.messager.alert('提示','下架成功');
								}else{
									$.messager.alert('提示','下架失败服务器繁忙请稍后再试');
								}
							},'json');
							//重新加载表单
							$('#dg').datagrid('load',{
							});
							
						}}
					}); 
				}
			}
		},'-',{
			iconCls: 'icon-edit',
			text:'修改',
			handler: function(){
				//获取选择的行
				var row = $('#dg').datagrid('getSelected');
				if(!row){
					$.messager.alert('警告','请选择一首要修改的mv'); 
				}
				else{
					$('#win_1').window('open');
					var mvname=$('#win_1 input[name="mvid"]').val(row.mvid);
					var mvname=$('#win_1 input[name="mvname"]').val(row.mvname);
					var mvtext=$('#win_1 input[name="mvtext"]').val(row.mvtext);
					var releasetime=$('#dd').datebox('setValue',parseJSONDate(row.releasetime)).val();
					$('#win_1 select[name="songid"]').append('<option value="'+row.songid+'">'+row.songid+'</option>');
					$.post('/tiremusic/MV/serachSongnameBysongid.do',{songid:row.songid},function(data){
						$('#win_1 input[name="songname"]').val(data);
					},'text')
					$.post('/tiremusic/MV/searchAllSongid.do',function(data){
						for(var i=0;i<data.length;i++){
							$('#win_1 select[name="songid"]').append('<option value="'+data[i].songid+'">'+data[i].songid+'</option>');
						}
					},'json')
					$('#win_1 select[name="songid"]').change(function(){
						$.post('/tiremusic/MV/serachSongnameBysongid.do',{songid:$(this).val()},function(data){
							$('#win_1 input[name="songname"]').val(data);
						},'text')
					});
					var songid=$('#win_1 select[name="songid"]').val();
				}
				}
		},'-',{
			iconCls: 'icon-add',
			text:'增加MV',
			handler: function(){
					$('#win_2').window('open');
				}
		},'-',{
			iconCls: 'icon-remove',
			text:'通过审核',
			handler: function(){
				//获取选择的行
				var row = $('#dg').datagrid('getSelected');
				if(!row){
					$.messager.alert('警告','请选择一首未通过审核的mv'); 
				}else{
					$.messager.confirm('确认','您确认想要通过该MV的审核吗？',function(da){    
						if(da){
						if(row.mvpustate==1){
							$.messager.alert('提示','该MV已通过审核');
						}else{
							//修改数据库中状态
							$.post("/tiremusic/MV/auditingMv.do",{mvid:row.mvid},function(data){
								if(data){
									$.messager.alert('提示','审核通过');
								}else{
									$.messager.alert('提示','上传失败服务器繁忙请稍后再试');
								}
							},'json');
							//重新加载表单
							$('#dg').datagrid('load',{
							});
							
						}}
					}); 
				}
			}
		}],

	    columns:[[ 
	    	{field:'checkbox',title:'',width:100,checkbox:true,align:'center'}, 
	        {field:'mvname',title:'MV名称',width:100,align:'center'},
	        {field:'location',title:'MV地址',width:100,align:'center'},
	        {field:'mvid',title:'MV编号',width:100,align:'center'},    
	        {field:'songid',title:'歌曲id',width:100,align:'center'},    
	        {field:'releasetime',title:'发行时间',width:100,align:'center',
	        	formatter: function(value,row,index){
	        		return parseJSONDate(value);
	        }
	        },
	        {field:'downloadtimes',title:'下载次数',width:100,align:'center'},
	        {field:'mvpustate',title:'MV审核状态',width:100,align:'center',
	        	formatter: function(value,row,index){
					if (value==1){
						return '已通过审核';
					} else {
						return '未通过审核';
					}
				}	
	        },{field:'mvstate',title:'MV状态',width:100,align:'center',
	        	formatter: function(value,row,index){
					if (value==1){
						return '上架中';
					} else {
						return '已下架';
					}
				}	
	        },
	        
	        {field:'frontimg',title:'MV封面',width:100,align:'center'},
	        {field:'mvtext',title:'MV介绍',width:100,align:'center'},
	    ]]    
	    
	}); 
	//修改MV
	function updateMvInfo(){
		var mvname=$('#win_1 input[name="mvname"]').val();
		var mvtext=$('#win_1 input[name="mvtext"]').val();
		var releasetime=$('#win_1 input[name="releasetime"]').val();
		var songid=$('#win_1 select[name="songid"]').val();
		var mvid=$('#win_1 input[name="mvid"]').val();
		$.post("/tiremusic/MV/updateMvInfo.do",{mvname:mvname,songid:songid,releasetime:releasetime,mvtext:mvtext,mvid:mvid},function(data){
			if(data!=null){
				$.messager.alert('提示','修改成功'); 
			}else{
				$.messager.alert('提示','修改失败服务器繁忙请稍后再试'); 
			}
		},'text');
		$('#win_1').window('close');
		//重修加载表单
		$('#dg').datagrid('load',{
		});
	}
	//修改时间
	function parseJSONDate(json){
		var year = json.year+1900;
		var month = json.month+1;
		var date =json.date;
		return year+"-"+(month>10?month:("0"+month))+"-"+(date>10?date:("0"+date));
	}
	//页面加载是初始化歌曲id选择框信息
	$(function(){
		$.post('/tiremusic/MV/searchAllSongid.do',function(data){
			for(var i=0;i<data.length;i++){
				$('#searchform select[name="songid"]').append('<option value="'+data[i].songid+'">'+data[i].songid+'</option>');
				$('#addMv select[name="songid"]').append('<option value="'+data[i].songid+'">'+data[i].songid+'</option>');
			}
		},'json');
		
	})
	//组合查询
	function searchMV(){
		//获取查询数据
		var mvid =$('#searchform input[name="mvid"]').val();
		var mvname=$('#searchform input[name="mvname"]').val();
		var mvtext=$('#searchform input[name="mvtext"]').val();
		var songid=$('#searchform select[name="songid"]').val();
		var mvstate=$('#searchform select[name="mvstate"]').val();
		var mvpustate=$('#searchform select[name="mvpustate"]').val();
		var beginDate=$('#begin').combo('getValue');
		var endDate=$('#end').combo('getValue');
		$('#dg').datagrid('load',{
			mvid:mvid,
			mvname:mvname,
			mvtext:mvtext,
			songid:songid,
			mvstate:mvstate,
			beginDate:beginDate,
			endDate:endDate,
			mvpustate:mvpustate
		});
	}
	</script>
</body>
</html>