<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>登录选课系统</title>
		<link rel="icon" href="/sms/img/logo.png" type="image/x-icon" />
		<link rel="stylesheet" type="text/css" href="/sms/css/bootstrap.min.css" />
		<style type="text/css">
			.errLabel {
				font-size: 10px;
				color: red;
				position: absolute;
			}
		</style>
	</head>

	<body style="background-color: #7bbfea;">
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2">
					<form action="/sms/user/login.do" id="form" method="post" style="background-color: #afdfe4; width: 600px; height: 450px; margin: 130px auto 0px; border-radius: 20px;">
						<div class="col-md-6 col-md-offset-3" style="margin-top: 10px; height: 70px">
							<h2 class="text-center">欢迎使用选课系统</h2>
							<h3 class="text-center">请登录</h3>
							<h4 id="error" class="text-danger text-center">
								${requestScope.loginInfo}
							</h4>
						</div>
						<div class="col-md-6 col-md-offset-3" class="form-group" style="margin-top: 45px; font-size: 16px;">
							<label>账号：</label>
							<input class="form-control" type="text" name="username" id="username" value="" placeholder="请输入字母数字或下划线组成的用户名" required autofocus/>
							<label class="errLabel"> </label>
						</div>
						<div class="col-md-6 col-md-offset-3" class="form-group" style="margin-top: 20px; font-size: 16px;">
							<label>密码：</label>
							<input class="form-control" type="password" name="password" id="password" value="" placeholder="请输入密码" required/>
							<label class="errLabel"> </label>
						</div>
						<div class="col-md-3 col-md-offset-3" class="form-group" style="margin-top: 20px; font-size: 16px;">
							<label>验证码：</label>
							<input class="form-control" type="text" name="yzm" id="yzminput" value="" placeholder="请输入验证码" required/>
							<label class="errLabel"> </label>
						</div>
							<div class="col-md-3" style="margin-top: 47px;">
							<canvas id="yzm" width="120" height="35" onclick="str_yzm=getYzm()"></canvas>
						</div>
						<div class="col-md-6" style="margin-top: 35px; margin-left: 230px; font-size: 16px;">
							<input class="btn btn-primary" type="submit" value="登录" id="login" name="login" style="margin: 0px 20px;" />
						</div>
					</form>
				</div>
			</div>
		</div>
	</body>
	<script src="/sms/js/jquery-1.11.0.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="/sms/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="/sms/js/jquery.validate.js" type="text/javascript" charset="utf-8"></script>
	<script src="/sms/js/yzm.js" type="text/javascript" charset="utf-8"></script>
	<script src="/sms/js/checkForm.js" type="text/javascript" charset="utf-8"></script>
</html>