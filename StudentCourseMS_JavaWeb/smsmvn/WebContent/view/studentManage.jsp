<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String basePath=request.getContextPath();
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/easyui/themes/bootstrap/easyui.css">   
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/easyui/themes/icon.css">
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
	        <label for="name">学生姓名:</label>   
	        <input class="easyui-validatebox" type="text" name="name" data-options="required:true" />
	    </div>
	    <div style="margin-top: 20px">   
	        <label for="zip">身份证号:</label>   
	        <input class="easyui-validatebox" type="text" name="zip" data-options="required:true" />
	    </div>
	    <div style="margin-top: 20px">   
	        <label for="indate">入学日期:</label>   
	        <input class="easyui-validatebox" type="date" name="indate" data-options="required:true" />
	    </div>
	    <div id="DeptDiv" style="margin-top: 20px;">   
	        <label for="dept">所属学院:</label>   
			<select onchange="getProfessByDeptId('1')" id="dept" name="dept" style="width: 170px;height: 20px">   
				<option value='0'>请选择学院</option>
			</select>  
	    </div>
	    <div id="professDiv" style="margin-top: 20px;">   
	        <label for="profess">所学专业:</label>   
			<select id="profess"  name="profess" style="width: 170px;height: 20px">   
				<option value='0'>请选择专业</option>
			</select>  
	    </div>
	    
	    <div style="margin-top: 20px;">   
			<a style="margin-left: 50px;" id="btn" href="javascript:addStudent()" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>
			<a style="margin-left: 50px;" id="btn" href="javascript:closeWin('#addwin')" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>
	    </div>   		
	</div>
	<div id="editwin" style="padding-left:100px;font-size: 16px">
		<div class="state" style="margin-top: 20px">   
	        <label for="state">学生状态:</label>   
 			<input name="sta" class="easyui-switchbutton" data-options="onText:'正常',offText:'已休学',width:100,checked:true">
 			<input name="state" style="display: none;">
	    </div>
		<div style="margin-top: 20px">   
	        <label for="name">学生姓名:</label>   
	        <input type="text" name="sno" style="display: none;"/>
	        <input class="easyui-validatebox" type="text" name="name" data-options="required:true" />
	    </div>
	    <div style="margin-top: 20px">   
	        <label for="zip">身份证号:</label>   
	        <input class="easyui-validatebox" type="text" name="zip" data-options="required:true" />
	    </div>
	    <div style="margin-top: 20px">   
	        <label for="indate">入学日期:</label>   
	        <input class="easyui-validatebox" type="date" name="indate" data-options="required:true" />
	    </div>
	    <div id="DeptDiv" style="margin-top: 20px;">   
	        <label for="dept">所属学院:</label>   
			<select onchange="getProfessByDeptId('2')" id="deptEdit" name="dept" style="width: 170px;height: 20px">   
				<option value='0'>请选择学院</option>
			</select>  
	    </div>
	    <div id="professDiv" style="margin-top: 20px;">   
	        <label for="profess">所学专业:</label>   
			<select id="professEdit"  name="profess" style="width: 170px;height: 20px">   
				<option value='0'>请选择专业</option>
			</select>  
	    </div>
	    <div style="margin-top: 20px;">   
			<a style="margin-left: 50px;" id="btn" href="javascript:editStudent()" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>
			<a style="margin-left: 50px;" id="btn" href="javascript:closeWin('#editwin')" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>
	    </div>   		
	</div>
	<script type="text/javascript" src="<%=basePath%>/easyui/jquery.min.js"></script>   
	<script type="text/javascript" src="<%=basePath%>/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/easyui/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
	<script type="text/javascript">
		//表格
		$('#dg').datagrid({    
		    url:'<%=basePath%>/student/loadStudents.do',
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
					$.post("<%=basePath%>/dept/queryAllDept.do",function(data){
						$('#dept option:not(:first)').remove();
						$('#profess option:not(:first)').remove();
						for (var i = 0; i < data.length; i++) {
							$('#dept').append('<option value="'+data[i].dep_id+'">'+data[i].dep_name+'</option>');
						}					
					},"json");
					$('#addwin').window('open');
				}
			},'-',{
				iconCls: 'icon-my-remove',
				text:'删除',
				handler: function(){
					var rows=$('#dg').datagrid('getSelections');
					var mids=[];
					for (var i = 0; i < rows.length; i++) {
						mids[i]=rows[i].s_no;
					}
					var midStr=mids.join(',');
					if(!midStr){
						$.messager.alert('警告','请选择要删除的学生！');
						return;
					}
					$.messager.confirm('警告','您确认想要删除选中的【'+rows.length+'】个学生吗？删除学生后该学生的状态会变为已休学！',function(r){    
					    if (r){    
							$.post('<%=basePath%>/student/deleteStudent.do',{midStr:midStr},function(data){
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
						$.messager.alert('警告','请选择一个要修改的学生！');
						return;
					}
					
					$('#editwin input[name="state"]').val(rows[0].s_state);
					var staObj = $(".state").find("[switchbuttonName='sta']");
					if(rows[0].s_state==0){
						staObj.switchbutton("uncheck");
					}else{
						staObj.switchbutton("check");  
					}
					
					
					$('#editwin input[name="sno"]').val(rows[0].s_no);
					$('#editwin input[name="name"]').val(rows[0].s_name);
					$('#editwin input[name="zip"]').val(rows[0].s_zip);
					$('#editwin input[name="indate"]').val(getDate(rows[0].s_indate));
					//回填学院
					$.post("<%=basePath%>/dept/queryAllDept.do",function(data){
						$('#deptEdit option:not(:first)').remove();
						$('#professEdit option:not(:first)').remove();
						for (var i = 0; i < data.length; i++) {
							if(data[i].dep_id==rows[0].s_dep_no)
								$('#deptEdit').append('<option selected value="'+data[i].dep_id+'">'+data[i].dep_name+'</option>');
							else
								$('#deptEdit').append('<option value="'+data[i].dep_id+'">'+data[i].dep_name+'</option>');
						}					
					},"json");
					setTimeout(function name() {
						//回填专业
						$.post("<%=basePath%>/profess/queryAllProfessByDeptId.do",{deptId:rows[0].s_dep_no},function(data){
							$('#professEdit option:not(:first)').remove();
							for (var i = 0; i < data.length; i++) {
								if(data[i].pro_id==rows[0].s_pro_id)
									$('#professEdit').append('<option selected value="'+data[i].pro_id+'">'+data[i].pro_name+'</option>');
								else
									$('#professEdit').append('<option value="'+data[i].pro_id+'">'+data[i].pro_name+'</option>');
							}					
						},"json");
						$('#editwin').window('open');
					}, 100);
				}
			}],
		    columns:[[
		        {field:'',title:'',width:100,checkbox:true},    
		        {field:'s_no',title:'学号',width:150,align:'center'},    
		        {field:'s_name',title:'姓名',width:100,align:'center'},    
		        {field:'s_zip',title:'身份证号',width:150,align:'center'}, 
		        {field:'s_indate',title:'入学日期',width:200,align:'center',
		        	formatter: function(value,row,index){
							return getDate(row.s_indate);
					}
		        }, 
		        {field:'dep_name',title:'学院',width:150,align:'center'}, 
		        {field:'pro_name',title:'专业',width:150,align:'center'}, 
		        {field:'s_state',title:'状态',width:100,align:'center',
		        	formatter: function(value,row,index){
						if (row.s_state==0){
							return '已休学';
						} else {
							return '正常';
						}
					}
		        }
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
		//学生状态切换
		$('#editwin input[name="sta"]').switchbutton({
			onChange: function(checked){
				if(!checked){
					$('#editwin input[name="state"]').val(0);
				}else{
					$('#editwin input[name="state"]').val(1);
				}
			}
		});
		//搜索框
		$('#ss').searchbox({ 
			searcher:function(value,name){ 
				$('#dg').datagrid('load',{
					s_no:value
				});
			}, 
			prompt:'请输入学号匹配',
			height:30,
			width:250
		});
		//增加学生的窗口
		$('#addwin').window({
			title:'增加学生',
		    width:600,    
		    height:400,    
		    modal:true,
		    collapsible:false,
		    minimizable:false,
		    maximizable:false,
		    closed:true
		});
		//修改学生的窗口
		$('#editwin').window({
			title:'修改学生信息',
		    width:600,    
		    height:400,    
		    modal:true,
		    collapsible:false,
		    minimizable:false,
		    maximizable:false,
		    closed:true
		});
		//添加学生
		function addStudent() {
			var name=$('#addwin input[name="name"]').val();
			if(name==""){
				$.messager.alert('警告','学生姓名不能为空！');
				return;
			}
			var zip=$('#addwin input[name="zip"]').val();
			if(zip==""){
				$.messager.alert('警告','学生身份证不能为空！');
				return;
			}
			var indate=$('#addwin input[name="indate"]').val();
			if(indate==""){
				$.messager.alert('警告','学生入学日期不能为空！');
				return;
			}
			var deptId=$('#dept').val();
			var professId=$('#profess').val();
			if(deptId=='0'||professId=='0'){
				$.messager.alert('警告','请选择学生所在的学院和专业！');
				return;
			}
			$.post('<%=basePath%>/student/addStudent.do',{name:name,zip:zip,indate:indate,deptId:deptId,professId:professId},function(data){
				if(data=='true'){
					$.messager.alert('恭喜','学生【'+name+'】添加成功！');
					$('#addwin input[name="name"]').val("");
					$('#addwin input[name="zip"]').val("");
					$('#addwin input[name="indate"]').val("");
					$('#dg').datagrid('reload',{});
					$('#addwin').window('close');
				}else{
					$.messager.alert('警告','服务器异常，请稍后再试！');
				}
			},'text');
		}
		//修改学生
		function editStudent() {
			var name=$('#editwin input[name="name"]').val();
			if(name==""){
				$.messager.alert('警告','学生姓名不能为空！');
				return;
			}
			var zip=$('#editwin input[name="zip"]').val();
			if(zip==""){
				$.messager.alert('警告','学生身份证不能为空！');
				return;
			}
			var indate=$('#editwin input[name="indate"]').val();
			if(indate==""){
				$.messager.alert('警告','学生入学日期不能为空！');
				return;
			}
			var deptId=$('#deptEdit').val();
			var professId=$('#professEdit').val();
			if(deptId=='0'||professId=='0'){
				$.messager.alert('警告','请选择学生所在的学院和专业！');
				return;
			}
			var state=$('#editwin input[name="state"]').val();
			var sno=$('#editwin input[name="sno"]').val();
			$.post('<%=basePath%>/student/editStudent.do',{sno:sno,name:name,zip:zip,indate:indate,deptId:deptId,professId:professId,state:state},function(data){
				if(data=='true'){
					$.messager.alert('恭喜','学生【'+name+'】信息修改成功！');
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
		//2位数字
		function parseNum(num) {
			if (num < 10) {
				return "0" + num;
			}
			return num;
		}
		//日期格式
		function getDate(obj) {
			return 1900 + obj.year + "-" + parseNum(obj.month + 1) + "-"
					+ parseNum(obj.date);
		}
		//根据学院加载专业
		function getProfessByDeptId(flag) {
			//增加
			if(flag==1){
				$.post("<%=basePath%>/profess/queryAllProfessByDeptId.do",{deptId:$('#dept').val()},function(data){
					$('#profess option:not(:first)').remove();
					for (var i = 0; i < data.length; i++) {
						$('#profess').append('<option value="'+data[i].pro_id+'">'+data[i].pro_name+'</option>');
					}					
				},"json");
			}
			//修改
			if(flag==2){
				$.post("<%=basePath%>/profess/queryAllProfessByDeptId.do",{deptId:$('#deptEdit').val()},function(data){
					$('#professEdit option:not(:first)').remove();
					for (var i = 0; i < data.length; i++) {
						$('#professEdit').append('<option value="'+data[i].pro_id+'">'+data[i].pro_name+'</option>');
					}					
				},"json");
			}
		}
	</script>
</body>
</html>