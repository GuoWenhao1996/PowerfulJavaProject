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
	<div>
		<table style="text-align: right;">
			<tr>
				<td>学号：</td>
				<td>
					<input type="text" name="sno">
				</td>
				<td>　　姓名：</td>
				<td>
					<input type="text" name="name">
				</td>
				<td>身份证号：</td>
				<td>
					<input type="text" name="zip">
				</td>
			</tr>
			<tr>
				<td>学院：</td>
				<td>
					<select onchange="getProfessByDeptId()" id="dept" name="dept" style="width: 173px;height: 21px;">   
						<option value='0'>请选择学院</option>
					</select>
				</td>
				<td>专业：</td>
				<td>
					<select id="profess"  name="profess" style="width: 173px;height: 21px;">   
						<option value='0'>请选择专业</option>
					</select>  
				</td>
			</tr>
			<tr>
				<td>入学时间：</td>
				<td>
					<input id="begin" type= "text" class= "easyui-datebox">   
				</td>
				<td>到：</td>
				<td>
					<input id="end" type= "text" class= "easyui-datebox">
				</td>
				<td>
					<a id="btn" href="javascript:queryStudent()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
				</td>
			</tr>			
		</table>
	</div>
	<table id="dg"></table>
	<script type="text/javascript" src="/sms/easyui/jquery.min.js"></script>   
	<script type="text/javascript" src="/sms/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/sms/easyui/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
	<script type="text/javascript">
		//表格
		$('#dg').datagrid({    
		    url:'/sms/student/zuheLoadStudents.do',
		    pagination:true,
		    rownumbers:true,
		    striped:true,
		    pageSize:9, 
		    pageList:[5,9,10,20],
		    height:380,
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
		        {field:'pro_name',title:'专业',width:150,align:'center'}
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
		$.post("/sms/dept/queryAllDept.do",function(data){
			$('#dept option:not(:first)').remove();
			for (var i = 0; i < data.length; i++) {
				$('#dept').append('<option value="'+data[i].dep_id+'">'+data[i].dep_name+'</option>');
			}					
		},"json");
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
		function getProfessByDeptId() {
			$.post("/sms/profess/queryAllProfessByDeptId.do",{deptId:$('#dept').val()},function(data){
				$('#profess option:not(:first)').remove();
				for (var i = 0; i < data.length; i++) {
					$('#profess').append('<option value="'+data[i].pro_id+'">'+data[i].pro_name+'</option>');
				}					
			},"json");
		}
		
		function queryStudent() {
			var sno=$('table input[name="sno"]').val();
			var name=$('table input[name="name"]').val();
			var zip=$('table input[name="zip"]').val();
			var dept=$('#dept').val();
			var profess=$('#profess').val();
			var begin=$('#begin').val();
			var end=$('#end').val();
			$('#dg').datagrid('load',{
				sno:sno,
				name:name,
				zip:zip,
				dept:dept,
				profess:profess,
				begin:begin,
				end:end
			});
		}
	</script>
</body>
</html>