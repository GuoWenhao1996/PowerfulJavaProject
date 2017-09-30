<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String basepath = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>云音乐管理员界面</title>
<link rel="stylesheet" type="text/css" href="<%=basepath %>/easyui/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basepath %>/easyui/themes/icon.css">
	<style type="text/css">
		ul{
			list-style: none;
			padding-left: 0px;
		}
		li{
			height:30px;	
			margin-top: 10px;
			text-align: center;
			margin-bottom: 10px;
		}
		li a{
		width:80px;
		height:20px;
		margin-top: 5px;
		text-decoration: none;
		}
		.accordion .accordion-body{
		border-width: 0px 0px 0px 0px;
		}
		#p1{
			margin-left:600px;
			font-family:"微软雅黑";
		}
		h1{
			margin-top:20px;
			margin-left:40px;
			margin-bottom:-20px;
			font-size:50px;
			font-family:"微软雅黑";
			color:#76A2ED;
			float:left;
			position:absolute;
			left:20px;
		}
		#p2{
			float:left;
			margin-top:50px;
			margin-left:250px;
			margin-bottom:-20px;
			font-size:20px;
			color:#CCE969;
		}
		#img1{
			margin-left:700px;
			margin-top:40px;
			margin-bottom:-20px;
			float:left;
		}
		#p3{
			float:left;
			margin-top:50px;
			font-size:15px;
		}
		
		#a1{
			float:left;
		}
		#aa ul{
		list-style:none;
		padding-left:0px;
		}
		#aa ul li{
			height:30px;
			line-height:30px;
			margin-bottom:20px;
			text-align:center;
		}
		#aa ul li:hover{
			background-color: #D8D9D3;
		}
		#aa ul li a{
			text-decoration: none;
			text-align:center;
			color:#000;
		}
		.panel-titel{
			height:30px;
			line-height:10px;
		}
		#img2{
			float:left;
			margin-left:10px;
			margin-right:-23px;
			margin-top:0px;
		}
	</style>
</head>
<body class="easyui-layout">   
    <div data-options="region:'north'" style="height:90px;">
    	<img id="img2" alt="图标" src="<%=basepath %>/assets/img/timg.jpg"/>
    	<h1>TireMusic</h1>	
    	<p id="p2">用八轮车的眼光听音乐</p>
    	<a id="a1" href="<%=basepath %>/view/manage/managelogin.jsp"><img id="img1"  alt="退出图片" src="<%=basepath %>/assets/img/exit.png"><p id="p3">退出</p></a>
    </div>   
    <div data-options="region:'south'" style="height:50px;">
    	<p id="p1"><b><i>Copyright © 2017  八轮车开发小组</i> </b></p>
    </div>   
    <div data-options="region:'west',title:'导航'" style="width:150px;">
    	<div id="aa" class="easyui-accordion">   
		    <div title="用户管理" style="height:100px;">   
		       <ul>
		       	<li id="um">
		       		<a href="<%=basepath %>/view/manage/manageusermain.jsp" target="centerIframe">用户信息</a>
		       	</li>	
		       </ul>
		    </div>   
		    <div title="歌曲管理" >   
	     	  <ul>
		       	<li id="sm">
		       		<a href="<%=basepath %>/view/manage/managesongmain.jsp" target="centerIframe">歌曲信息</a>
		       	</li>
		       	<li id="sl">
					<a href="<%=basepath %>/view/manage/managesonglisten.jsp" target="centerIframe">歌曲试听</a>
				</li>
		       	<li id="sd">
		       		<a href="<%=basepath %>/view/manage/managesongdownload.jsp" target="centerIframe">歌曲下载</a>
		       	</li>
		       	<li id="se">
		       		<a href="<%=basepath %>/view/manage/managesonger.jsp" target="centerIframe">歌手管理</a>
		       	</li>
		       	<li id="al">
		       		<a href="<%=basepath %>/view/manage/managealbum.jsp" target="centerIframe">专辑管理</a>
		       	</li>
		       	<li id="sd">
		       		<a href="<%=basepath %>/view/manage/manageschool.jsp" target="centerIframe">流派管理</a>
		       	</li>
		       </ul> 
		    </div>   
		    <div title="MV管理">   
	          <ul>
		       	<li id="mm">
		       		<a href="<%=basepath %>/view/manage/manageMVmain.jsp" target="centerIframe">MV信息</a>
		       	</li>
		       	
		       </ul>   
		    </div> 
		    <div title="审核管理">   
	          <ul data-options="fit:true">
		       	<li id="ml">
		       		<a href="<%=basepath %>/view/manage/managelook.jsp" target="centerIframe">审核上传</a>
		       	</li>
		       	<li id="mc">
		       		<a href="<%=basepath %>/view/manage/managecomment.jsp" target="centerIframe">评论</a>
		       	</li>
		       	<li id="msw">
		       		<a href="<%=basepath %>/view/manage/managecommentsensitiveword.jsp" target="centerIframe">敏感词</a>
		       	</li>
		       </ul>   
		    </div>   
		</div>
    </div>   
    <div data-options="region:'center'" style="padding:5px;background:#eee;">
    	<iframe name="centerIframe" style="width: 100%;height: 100%;border: none">
		
		</iframe>
    </div>  
    <script type="text/javascript" src="<%=basepath %>/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basepath %>/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basepath %>/easyui/locale/easyui-lang-zh_CN.js"></script> 
	<script type="text/javascript">
	//点击li标签改变标签颜色
		$('li').click(function () {
			$('li').css('backgroundColor','#fff');
			$(this).css('backgroundColor','#A3C3F6');
		});
	
	</script>
</body>

</html>