<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String basepath = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en" class="app">
<head>  
  <meta charset="utf-8" />
  <title>Cloud Musik</title>
  <meta name="description" content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav" />
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
  <link rel="stylesheet" href="<%=basepath %>/chahua/js/jPlayer/jplayer.flat.css" type="text/css" />
  <link rel="stylesheet" href="<%=basepath %>/chahua/css/bootstrap.css" type="text/css" />
  <link rel="stylesheet" href="<%=basepath %>/chahua/css/animate.css" type="text/css" />
  <link rel="stylesheet" href="<%=basepath %>/chahua/css/font-awesome.min.css" type="text/css" />
  <link rel="stylesheet" href="<%=basepath %>/chahua/css/simple-line-icons.css" type="text/css" />
  <link rel="stylesheet" href="<%=basepath %>/chahua/css/font.css" type="text/css" />
  <link rel="stylesheet" href="<%=basepath %>/chahua/css/app.css" type="text/css" />  
  <link rel="stylesheet" type="text/css" href="<%=basepath %>/chahua/easyui/themes/bootstrap/easyui.css">   
  <link rel="stylesheet" type="text/css" href="<%=basepath %>/chahua/easyui/themes/icon.css">
    <!--[if lt IE 9]>
    <script src="js/ie/html5shiv.js"></script>
    <script src="js/ie/respond.min.js"></script>
    <script src="js/ie/excanvas.js"></script>
  <![endif]-->
  
  <style type="text/css">
  	html{
  		background-color:#2EA0B6;
  	}
  	#usersex{
  		width:60px;
  		height:20px;
  		line-height:30px;
  		margin-left:50px;
  	}
  	label{
  		position:absolute;
  		
  	}
  	.label1{
  		position:absolute;
  		top:264px;
  	}
  	input{
  		margin-top:30px;
  	}
  </style>
</head>
<body class="bg-info dker" style="overflow-y:scroll;">
  <section id="content" class="m-t-lg wrapper-md animated fadeInDown">
    <div class="container aside-xl">
      <section class="m-b-lg">
        <form id="form" action="<%=basepath %>/userRegister/userRegister.do" method="post" enctype="multipart/form-data" onsubmit="return validation();">
     		 <div class="form-group">
	           <input type="text" id="uname" name="uname"  placeholder="请输入用户名" class="form-control rounded input-lg text-center no-border" onblur="reguname()"><label></label>
	         </div>
	         <div class="form-group">
	            <input type="password" id="upassword" name="upassword" placeholder="请输入密码" class="form-control rounded input-lg text-center no-border" onblur="regupassword()"><label></label>
	         </div>
			 <div class="form-group">
		     	<input type="text" id="realname" name="realname" placeholder="请输入真实姓名" class="form-control rounded input-lg text-center no-border" onblur="regrealname()"><label></label>
		     </div>
	         <div class="form-group">
	            <input type="radio" id="usersex" name="usersex" placeholder="请输入性别" value="0" checked="checked"><label class="label1">男</label>
	            <input type="radio" id="usersex" name="usersex" placeholder="请输入性别" value="1"><label class="label1">女</label>
	         </div>
	         <div class="form-group">
	           <input type="email" id="uemail" name="uemail" placeholder="请输入邮箱" class="form-control rounded input-lg text-center no-border">
	           <input id="reg" type="button" class="btn btn-lg btn-info btn-block btn-rounded" value="向邮箱发送验证码" onclick="sendMail()"/><label id="labelreg2"></label>
	         </div>
	         <div>
	           <input type="text" id="regtext" name="reg" placeholder="请输入邮箱中获得的验证码" class="form-control rounded input-lg text-center no-border" onblur="regreg()"><label id="labelreg"></label>
	         </div>
			 <div class="form-group">
		     	<input type="text" id="uaddress" name="uaddress" placeholder="请输入地址" class="form-control rounded input-lg text-center no-border" onblur="reguaddress()"><label></label>
		     </div>
			 <div class="form-group">
		     	<input type="text" id="utelephone" name="utelephone" placeholder="请输入电话号码" class="form-control rounded input-lg text-center no-border" onblur="regutelephone()"><label></label>
		     </div>
	         <div class="form-group">
	          	<input type="text" id="uidnumber" name="uidnumber" placeholder="请输入身份证号码" class="form-control rounded input-lg text-center no-border" onblur="reguidnumber()"><label></label>
	         </div>
			 <div class="form-group">
		        <input type="date" id="userbirthday" name="userbirthday" placeholder="请输入生日" class="form-control rounded input-lg text-center no-border">
		     </div>
		     <div class="form-group">
		        <input type="file" id="avatar" name="avatar" placeholder="请插入头像" class="form-control rounded input-lg text-center no-border">
		     </div>
		     <button type="submit" class="btn btn-lg btn-warning lt b-white b-2x btn-block btn-rounded"><i class="icon-arrow-right pull-right"></i><span class="m-r-n-lg">注册</span></button>
	         <div class="line line-dashed"></div>
	         <p class="text-muted text-center"><small>已有账号?</small></p>
	         <a href="signin.jsp" class="btn btn-lg btn-info btn-block btn-rounded">登录</a>
        </form>
      </section>
    </div>
  </section>
  <script type="text/javascript">
  function sendMail(){
	  var uemail = document.getElementById("uemail").value;
	  $.post('<%=basepath %>/userRegister/sendMail.do',{uemail:uemail},function(data){
		  if(data=="false"){
			  document.getElementById("labelreg2").innerHTML="邮箱发送失败！";
		  }else{
			  document.getElementById("labelreg2").innerHTML="邮箱发送成功!";
		  }
	  },'JSON');
  }
  var result=false;
  function regreg() {
	  var reg = document.getElementById("regtext").value;
		$.post('<%=basepath %>/userRegister/equalsMail.do',{reg:reg},function(data){
			
		if(data=="true"){
			document.getElementById("labelreg").innerHTML="√";
			result = true;
		}else{
			document.getElementById("labelreg").innerHTML="验证码输入有误！";
			result = false;
		}
		
	},'text');
		return result;
}
  //验证用户名
  function reguname(){
		var uname=document.getElementById("uname").value;
	    $.post('<%=basepath %>/userRegister/reguname.do',{uname:uname},function(data){
	    	if(data=="true"){
	    		document.getElementById("uname").nextElementSibling.innerHTML="用户名已存在";
				return false;
	    	}
	    },'text');
		var reguname=/^[a-zA-Z][a-zA-Z0-9_]{4,15}$/;
		if(reguname.test(uname)){
			document.getElementById("uname").nextElementSibling.innerHTML="√";
			return true;
		}else{
			document.getElementById("uname").nextElementSibling.innerHTML="以字母开头,长度为5-16位";
			return false;
		}
	}
  //验证密码
  function regupassword(){
		var upassword=document.getElementById("upassword").value;
		var regupassword=/^[a-zA-Z]\w{5,17}$/;
		if(regupassword.test(upassword)){
			document.getElementById("upassword").nextElementSibling.innerHTML="√";
			return true;
		}else{
			document.getElementById("upassword").nextElementSibling.innerHTML="以字母开头，长度在6~18之间，只能包含字母、数字和下划线";
			return false;
		}
	}
  function regrealname(){
		var realname=document.getElementById("realname").value;
		var regrealname=/^[\u4e00-\u9fa5]{2,4}$/;
		if(regrealname.test(realname)){
			document.getElementById("realname").nextElementSibling.innerHTML="√";
			return true;
		}else{
			document.getElementById("realname").nextElementSibling.innerHTML="长度为2-4位";
			return false;
		}
	}
  function reguaddress(){
		var uaddress=document.getElementById("uaddress").value;
		var reguaddress=/^[\u4e00-\u9fa5]{0,}$/;
		if(reguaddress.test(uaddress)){
			document.getElementById("uaddress").nextElementSibling.innerHTML="√";
			return true;
		}else{
			document.getElementById("uaddress").nextElementSibling.innerHTML="×";
			return false;
		}
	}
  function regutelephone(){
		var utelephone=document.getElementById("utelephone").value;
		$.post('<%=basepath %>/userRegister/regutelephone.do',{utelephone:utelephone},function(data){
	    	if(data=="true"){
	    		document.getElementById("utelephone").nextElementSibling.innerHTML="电话号码已注册";
				return false;
	    	}
	    },'text');
		var regutelephone=/^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/;
		if(regutelephone.test(utelephone)){
			document.getElementById("utelephone").nextElementSibling.innerHTML="√";
			return true;
		}else{
			document.getElementById("utelephone").nextElementSibling.innerHTML="请输入正确的电话号码";
			return false;
		}
	}
  function reguidnumber(){
		var uidnumber=document.getElementById("uidnumber").value;
		$.post('<%=basepath %>/userRegister/reguidnumber.do',{uidnumber:uidnumber},function(data){
	    	if(data=="true"){
	    		document.getElementById("uidnumber").nextElementSibling.innerHTML="身份证号码已注册";
				return false;
	    	}
	    },'text');
		var reguidnumber=/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
		if(reguidnumber.test(uidnumber)){
			document.getElementById("uidnumber").nextElementSibling.innerHTML="√";
			return true;
		}else{
			document.getElementById("uidnumber").nextElementSibling.innerHTML="请输入15位或者18位的身份证号码";
			return false;
		}
	}
  function validation() {
		if(result&reguname()&regupassword()&regrealname()&reguaddress()&regutelephone()&reguidnumber()){
			return true;
		}else{
			return false;
		}
	}
  </script>
  <!-- footer -->
  <footer id="footer">
    <div class="text-center padder clearfix">
      <p>
        <small>Web app framework base on Bootstrap<br>&copy; 2014</small>
      </p>
    </div>
  </footer>
  <!-- / footer -->
  <script src="<%=basepath %>/chahua/js/jquery.min.js"></script>
  <!-- Bootstrap -->
  <script src="<%=basepath %>/chahua/js/bootstrap.js"></script>
  <!-- App -->
  <script src="<%=basepath %>/chahua/js/app.js"></script>
  <script type="text/javascript" src="<%=basepath %>/chahua/easyui/jquery.min.js"></script>   
  <script type="text/javascript" src="<%=basepath %>/chahua/easyui/jquery.easyui.min.js"></script>
  <script src="<%=basepath %>/chahua/js/slimscroll/jquery.slimscroll.min.js"></script>
  <script src="<%=basepath %>/chahua/js/app.plugin.js"></script>
  <script type="text/javascript" src="<%=basepath %>/chahua/js/jPlayer/jquery.jplayer.min.js"></script>
  <script type="text/javascript" src="<%=basepath %>/chahua/js/jPlayer/add-on/jplayer.playlist.min.js"></script>
  <script type="text/javascript" src="<%=basepath %>/chahua/js/jPlayer/demo.js"></script>
</body>
</html>