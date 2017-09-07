<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title></title>
	<link rel="stylesheet" type="text/css" href="/MVC_PhoneBookMS/view/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="/MVC_PhoneBookMS/view/easyui/themes/icon.css">
	<script type="text/javascript" src="/MVC_PhoneBookMS/view/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="/MVC_PhoneBookMS/view/easyui/jquery.easyui.min.js"></script>
	<script src="/MVC_PhoneBookMS/view/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript" charset="utf-8"></script>
	<style type="text/css">
		#addFriendFrom {
			padding: 10px 60px;
			font-size: 16px;
		}
		
		#addFriendFrom input {
			margin: 10px 0px;
			font-size: 16px;
		}
		
		#addFriendFrom #save {
			margin-left: 90px;
			margin-right: 10px;
			margin-top: 10px;
		}
		
		#addFriendFrom #clear {
			margin-top: 10px;
		}
	</style>
</head>
<body>
	<form id="addFriendFrom" method="post" action="/MVC_PhoneBookMS/friend?method=addFriend" data-options="novalidate:true">
		<div>
			<label for="name">姓名：</label>
			<input class="easyui-validatebox" type="text" name="name" data-options="required:true" />
		</div>
		<div>
			<label for="birthday">生日：</label>
			<input id="birthday" type= "text" class= "easyui-datebox" name="birthday"/>   
		</div>
		<div>
			<label for="sex">性别：</label>
			<input class="easyui-validatebox" type="radio" name="sex" value="1" checked/>男
			<input class="easyui-validatebox" type="radio" name="sex" value="2"/>女 
		</div>
		<div>
			<label for="telephone">电话：</label>
			<input class="easyui-validatebox" type="text" name="telephone" data-options="required:true,validType:'telephone'" />
		</div>
		<div>
			<label for="qq">ｑｑ：</label>
			<input class="easyui-validatebox" type="text" name="qq" data-options="validType:'qq'" />
		</div>
		<div>
			<label for="email">邮箱：</label>
			<input class="easyui-validatebox" type="text" name="email" data-options="validType:'email'" />
		</div>
		<div>
			<label for="address">地址：</label>
			<input class="easyui-validatebox" type="text" name="address"/>
		</div>
		<a id="save" href="#" class="easyui-linkbutton"	data-options="iconCls:'icon-save'">保存</a>
		<a id="clear" href="" class="easyui-linkbutton" data-options="iconCls:'icon-clear'">清空</a>
	</form>
	<span id="addInfo"></span>
	<script type="text/javascript">
		$.extend($.fn.validatebox.defaults.rules, {
			telephone : {
				validator : function(value, param) {
					var reg = /^[1][3|5|8|7]\d{9}$/;
					return reg.test(value);
				},
				message : '请输入正确的手机号格式！'
			},
			qq : {
				validator : function(value, param) {
					var reg = /^\d{1,15}$/;
					return reg.test(value);
				},
				message : 'qq号只能为数字且不得超过15位！'
			}
		});
		$('#save').bind('click', function() {
			$('#addFriendFrom').submit();
		});
		$('#addFriendFrom').form({
			url : "/MVC_PhoneBookMS/friend?method=addFriend",
			onSubmit : function() {
				$.messager.progress({
					title : '保存',
					msg : '正在保存',
					interval : 50
				}); // 显示进度条
				var isValid = $(this).form('validate');
				if (!isValid) {
					$.messager.progress('close'); // 如果表单是无效的则隐藏进度条
				}
				return isValid; // 返回false终止表单提交
			},
			success : function() {
				setTimeout(function() {
					$.messager.progress('close');
				}, 300);
				/*重置表单*/
				$('#addFriendFrom')[0].reset();
				$.messager.alert('ok', '添加成功！');

			}
		});
	</script>
</body>

</html>