<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" buffer="0kb"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>系统主页</title>
	<link rel="icon" href="/sms/img/logo.png" type="image/x-icon" />
	<link rel="stylesheet" type="text/css" href="/sms/easyui/themes/bootstrap/easyui.css">   
	<link rel="stylesheet" type="text/css" href="/sms/easyui/themes/icon.css">
	<style type="text/css">
		.panel-body,.accordion-body{
			padding: 0px;
		}
		.panel-header{
			height: 40px;
		}
		.panel-title{
			height:40px;
			line-height:40px;
		}

		#logo{
			margin-top:-20px;
			border: none;
			position: absolute;
			left: 50px;
			width: 98px;
		}
		#logout{
			margin-top:-20px;
			border: none;
			position: absolute;
			right: 5px;
			background: #fff;
		}
		#logout:hover{
			background: #8CC7E5;
		}
		#logout span{
			width: 98px;
			height:98px;
			margin: -48px 0px 0px -2px;
			padding: 0px;
			border: none;
		}
		#menu ul{
			list-style:none;
			padding-left: 0px;
			margin: 0px;
		}
		#menu ul a{
			height:30px;
			line-height: 30px;
			text-align: center;
			font-size: 16px;
			font-family: '楷体';
			text-decoration:none;
			color: #000;
		}
	</style>    
</head>
<body class="easyui-layout">   
    <div data-options="region:'north'" style="height:100px;">
    	<h1 align="center" style="font-size: 30px;color: #0081C2;">
    		<img id="logo" alt="logo" src="/sms/img/main.png">	
    		中 软 国 际<sup>&reg;</sup>学 生 管 理 系 统&trade;<sub><small>书山有路勤为径-学海无涯苦作舟</small></sub>
    		<a id="logout" href="/sms/user/logout.do" class="easyui-linkbutton" data-options="iconCls:'icon-logout',width:98,height:98"></a>
    	</h1> 
    </div>   
    <div data-options="region:'south'" style="height:60px;">
    	<p align="center" style="font-size: 16px;color: #0081C2;">Copyright&copy;2017-2017&nbsp;&nbsp;<a href="http://www.gwhcool.cn:8080" style="font-size: 16px;color: #0081C2;">郭丶丶gwhcool.cn</a>&nbsp;版权所有</p>
    </div>   
    <div data-options="region:'west',title:'导航栏',iconCls:'icon-nav'" style="width:200px;">
		<div id="menu" class="easyui-accordion" data-options="fit:true">   
		    <c:forEach items="${menus}" var="menu">
		    	<div title="${menu.name}" data-options="iconCls:'icon-menu'" style="padding:10px;">   
					<ul>
						<c:forEach items="${menu.children}" var="childMenu">
							<a href="${childMenu.url}" target="centerFrame"><li>${childMenu.name}</li></a>
						</c:forEach>
					</ul>
		    	</div> 
			</c:forEach>    
		</div> 
    </div>   
    <div data-options="region:'center'" style="background:#eee;padding: 0px">
    	<iframe name="centerFrame" style="width: 100%; height: 99%;border: none;">
    	</iframe>
    </div>
	<script type="text/javascript" src="/sms/easyui/jquery.min.js"></script>   
	<script type="text/javascript" src="/sms/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/sms/easyui/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
	<script type="text/javascript">
		$('#menu li').click(function() {
			$('#menu li').css('backgroundColor','#fff');
			$(this).css('backgroundColor','#269AD4');
		});
		$('#menu li').mouseover(function() {
			$(this).css('backgroundColor','#8CC7E5');
			$(this).css('color','#fff');
		});
		$('#menu li').mouseleave(function() {
			$(this).css('backgroundColor','#fff');
			$(this).css('color','#000');
		});
	</script>
</body>
</html>