<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>欢迎使用网络通讯录</title>
<link rel="stylesheet" type="text/css" href="/PhoneBookMS/css/bootstrap.min.css" />
<link rel="icon" href="/PhoneBookMS/img/icon.png" type="image/x-icon"/>
<script src="/PhoneBookMS/js/jquery-1.11.0.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="/PhoneBookMS/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<script src="/PhoneBookMS/js/jquery.validate.js" type="text/javascript"
	charset="utf-8"></script>
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
				<form id="form" action="/PhoneBookMS/login" method="post"
					style="background-color: #deab8a; width: 600px; height: 400px; margin: 130px auto 0px; border-radius: 20px;">
					<div class="col-md-8 col-md-offset-3" style="margin-top: 10px; height: 70px">
						<h3>欢迎使用网络通讯录系统</h3>
						<h4 class="text-danger" style="margin-left:60px"><%=request.getAttribute("loginInfo") == null ? "" : request.getAttribute("loginInfo").toString()%></h4>
					</div>
					<div class="col-md-6 col-md-offset-3" class="form-group"
						style="margin-top: 15px; font-size: 16px;">
						<label>用户名：</label> <input class="form-control" type="text"
							name="username" id="username" value=""
							placeholder="请输入字母数字或下划线组成的用户名" /> <label class="errLabel"></label>
					</div>
					<div class="col-md-6 col-md-offset-3" class="form-group"
						style="margin-top: 20px; font-size: 16px;">
						<label>密码：</label> <input class="form-control" type="password"
							name="password" id="password" value="" placeholder="请输入密码" /> <label
							class="errLabel"> </label>
					</div>
					<div class="col-md-3 col-md-offset-3" class="form-group"
						style="margin-top: 20px; font-size: 16px;">
						<label>验证码：</label> <input class="form-control" type="text"
							name="yzm" id="yzminput" value="" placeholder="请输入验证码" /> <label
							class="errLabel"> </label>
					</div>
					<div class="col-md-3" style="margin-top: 47px;">
						<canvas id="yzm" width="120" height="35"
							onclick="str_yzm=getYzm()"></canvas>
					</div>
					<div class="col-md-6 col-md-offset-3"
						style="margin-top: 20px; font-size: 16px;">
						<input class="btn btn-primary" type="submit" value="登录"
							id="submit" name="submit" style="margin: 0px 50px;" /> <input
							class="btn btn-info" type="button" value="注册" />
					</div>
				</form>
				<script src="/PhoneBookMS/js/yzm.js" type="text/javascript" charset="utf-8"></script>
				<script src="/PhoneBookMS/js/checkForm.js" type="text/javascript" charset="utf-8"></script>
			</div>
		</div>
	</div>
</body>

</html>