<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>注册到网络通讯录</title>
<link rel="stylesheet" type="text/css" href="/MVC_PhoneBookMS/view/css/bootstrap.min.css" />
<link rel="icon" href="/MVC_PhoneBookMS/view/img/icon.png" type="image/x-icon"/>
<script src="/MVC_PhoneBookMS/view/js/jquery-1.11.0.min.js" type="text/javascript" charset="utf-8"></script>
<script src="/MVC_PhoneBookMS/view/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<script src="/MVC_PhoneBookMS/view/js/jquery.validate.js" type="text/javascript" charset="utf-8"></script>
<style type="text/css">
.errLabel {
	font-size: 10px;
	color: red;
	position: absolute;
}
</style>
</head>

<body style="background-color: #fedcbd;">
	<div class="container">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<form id="form" action="/MVC_PhoneBookMS/view/reg" method="post"
					style="background-color: #deab8a; width: 600px; height: 780px; margin: 130px auto 0px; border-radius: 20px;">
					<div class="col-md-8 col-md-offset-3" style="margin-top: 10px; height: 70px">
						<h3>拥有一个属于自己的账号</h3>
						<h4 class="text-danger" style="margin-left:60px">
							<%=request.getAttribute("loginInfo") == null ? "" : request.getAttribute("loginInfo").toString()%>
						</h4>
					</div>
					<div class="col-md-6 col-md-offset-3" class="form-group" style="margin-top: 15px; font-size: 16px;">
						<label>登录名：</label>
						<input class="form-control" type="text" name="username" id="username" value="" placeholder="请输入字母数字或下划线组成的用户名" /> 
						<label class="errLabel"></label>
					</div>
					<div class="col-md-6 col-md-offset-3" class="form-group" style="margin-top: 20px; font-size: 16px;">
						<label>密码：</label> 
						<input class="form-control" type="password" name="password" id="password" value="" placeholder="请输入密码" />
						<label class="errLabel"> 
						</label>
					</div>
					<div class="col-md-6 col-md-offset-3" class="form-group" style="margin-top: 20px; font-size: 16px;">
						<label>确认密码：</label> 
						<input class="form-control" type="password" name="password2" id="password2" value="" placeholder="请输入确认密码" />
						<label class="errLabel"> 
						</label>
					</div>
					<div class="col-md-6 col-md-offset-3" class="form-group" style="margin-top: 15px; font-size: 16px;">
						<label>昵称：</label>
						<input class="form-control" type="text" name="nickname" id="nickname" value="" placeholder="请输入昵称" /> 
						<label class="errLabel"></label>
					</div>
					<div class="col-md-6 col-md-offset-3" class="form-group" style="margin-top: 15px; font-size: 16px;">
						<label>电话：</label>
						<input class="form-control" type="text" name="telephone" id="telephone" value="" placeholder="请输入电话号码" /> 
						<label class="errLabel"></label>
					</div>
					<div class="col-md-6 col-md-offset-3" class="form-group" style="margin-top: 15px; font-size: 16px;">
						<label>邮箱：</label>
						<input class="form-control" type="text" name="email" id="email" value="" placeholder="请输入邮箱账号" /> 
						<label class="errLabel"></label>
					</div>
					<div class="col-md-6 col-md-offset-3" class="form-group" style="margin-top: 15px; font-size: 16px;">
						<label>地址：</label>
						<input class="form-control" type="text" name="address" id="address" value="" placeholder="请输入联系地址" /> 
						<label class="errLabel"></label>
					</div>
					<div class="col-md-6 col-md-offset-3" class="form-group" style="margin-top: 15px; font-size: 16px;">
						<label>头像：</label>
						<input class="form-control" type="file" name="url" id=""url"" value="" placeholder="请上传头像" /> 
						<label class="errLabel"></label>
					</div>
					
					<div class="col-md-6 col-md-offset-3" style="margin-top: 20px; font-size: 16px;">
						<input class="btn btn-primary" type="submit" value="注册" id="submit" name="submit" style="margin: 0px 20px;" />
						<a href="/MVC_PhoneBookMS/view/login.jsp">已有账号？点我登录！</a>
					</div>
				</form>
				<script src="/MVC_PhoneBookMS/view/js/yzm.js" type="text/javascript" charset="utf-8"></script>
				<script src="/MVC_PhoneBookMS/view/js/checkForm.js" type="text/javascript" charset="utf-8"></script>
			</div>
		</div>
	</div>
</body>

</html>