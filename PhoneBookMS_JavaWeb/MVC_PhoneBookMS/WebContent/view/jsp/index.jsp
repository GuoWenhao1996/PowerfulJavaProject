<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>网络通讯录主页</title>
	<link rel="icon" href="/MVC_PhoneBookMS/view/img/icon.png" type="image/x-icon" />
	<link rel="stylesheet" type="text/css" href="/MVC_PhoneBookMS/view/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="/MVC_PhoneBookMS/view/easyui/themes/icon.css">
	<script type="text/javascript" src="/MVC_PhoneBookMS/view/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="/MVC_PhoneBookMS/view/easyui/jquery.easyui.min.js"></script>
	<script src="/MVC_PhoneBookMS/view/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript" charset="utf-8"></script>
	<link rel="stylesheet" type="text/css" href="/MVC_PhoneBookMS/view/css/index.css" />
	<style type="text/css">
		.logo{
			height: 90px;
			position: absolute;
			margin: 3px 25px;
		}
	</style>
</head>

<body class="easyui-layout">
	<div data-options="region:'north'" style="height: 100px;">
		<%--<img class="logo" src="<%=((User)session.getAttribute("user")).getUrl() %>" alt="头像"/> --%>
		<img class="logo" src="${sessionScope.user.url}" alt="头像"/>
		<h1 align="center" style="font-size: 30px;">
			中 软 国 际<sup>&reg;</sup>网 络 通 讯 录 系 统&trade;
		</h1>
	</div>
	<div data-options="region:'south'" style="height: 60px;">
		<p align="center" style="font-size: 16px;">Copyright&copy;2017-2017&nbsp;&nbsp;郭丶丶gwhcool.cn&nbsp;版权所有</p>
	</div>
	<div data-options="region:'west',title:'导航栏',iconCls:'icon-nav'"
		style="width: 150px;">
		<!--此行以下为导航菜单-->
		<div id="menu" class="easyui-accordion" data-options="fit:true">
			<div title="好友管理" data-options="iconCls:'icon-friend'">
				<ul>
					<li name="/MVC_PhoneBookMS/view/jsp/addFriend.jsp">添加好友</li>
					<li name="/MVC_PhoneBookMS/view/jsp/none.jsp">删除好友</li>
					<li name="/MVC_PhoneBookMS/view/jsp/none.jsp">修改好友</li>
					<li name="/MVC_PhoneBookMS/friend?method=queryAllFriend">查询好友</li>
				</ul>
			</div>
			<div title="个人信息管理" data-options="iconCls:'icon-selfInfo'">
				<ul>
					<li name="/MVC_PhoneBookMS/view/jsp/none.jsp">查看信息</li>
					<li name="/MVC_PhoneBookMS/view/jsp/none.jsp">修改信息</li>
				</ul>
			</div>
			<div title="系统安全" data-options="iconCls:'icon-safe'">
				<ul>
					<li name="/MVC_PhoneBookMS/view/jsp/none.jsp">修改密码</li>
					<a href="/MVC_PhoneBookMS/user?method=logout"><li>退出登录</li></a>
				</ul>
			</div>
		</div>
		<!--此行以上为导航菜单-->
	</div>
	<div data-options="region:'center'"
		style="padding: 5px; background: #eee;">
		<!--此行以下为选项卡-->
		<div id="tab" class="easyui-tabs" data-options="fit:true">
			<div title="日历" style="padding: 0px; display: none;">
				<input class="easyui-datetimebox" name="birthday"
					data-options="required:true,showSeconds:false" value="Today"
					style="width: 150px;">
				<div id="cc" class="easyui-calendar" data-options="fit:true">
				</div>
			</div>
		</div>
		<!--此行以上为选项卡-->
	</div>
	<script type="text/javascript">
		$('#menu li:not(:last)').click(function() {
			var addTitle = $(this).text();
			var exist = $('#tab').tabs('exists', addTitle);
			if (exist) {
				$('#tab').tabs('select', addTitle);
				return;
			}
			$.messager.progress({
				title : '初始化',
				msg : '正在初始化数据',
				interval : 50
			}); // 显示进度条
			var url = $(this).attr('name');
			$('#tab').tabs('add', {
				title : addTitle,
				selected : true,
				closable : true,
				content:'<iframe src="'+url+'" style="width:100%;height:100%;border:0px"></iframe>'
			});
			setTimeout(function() {
				$.messager.progress('close');
			}, 500);
		});
	</script>
</body>

</html>