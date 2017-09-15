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
    	<a href="/sms/user/logout.do">退出</a>  
    </div>   
    <div data-options="region:'south'" style="height:75px;"></div>   
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
    	<iframe name="centerFrame" style="width: 100%; height: 100%;border: none">
    	</iframe>
    </div>
</body>
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
</html>