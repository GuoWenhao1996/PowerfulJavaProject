<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String basePath=request.getContextPath();
%>      
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>修改密码</title>
		<link rel="icon" href="<%=basePath%>/img/logo.png" type="image/x-icon" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/bootstrap.min.css" />
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
					<form id="form" method="post" style="background-color: #afdfe4; width: 600px; height: 450px; margin: 130px auto 0px; border-radius: 20px;">
						<div class="col-md-6 col-md-offset-3" style="margin-top: 10px; height: 70px">
							<h2 class="text-center">为了您的安全</h2>
							<h3 class="text-center">请修改密码</h3>
							<h4 id="error" class="text-danger text-center">
								${requestScope.updateInfo}
							</h4>
						</div>
						<div class="col-md-6 col-md-offset-3" class="form-group" style="margin-top: 45px; font-size: 16px;">
							<label>原密码：</label>
							<input  onblur="checkPassword()" class="form-control" type="password" name="oldpassword" id="oldpassword" value="" placeholder="初始密码为学号" required autofocus/>
						</div>
						<div class="col-md-6 col-md-offset-3" class="form-group" style="margin-top: 20px; font-size: 16px;">
							<label>新密码：</label>
							<input class="form-control" type="password" name="passwordA" id="passwordA" value="" placeholder="请输入新密码" required/>
						</div>
						<div class="col-md-6 col-md-offset-3" class="form-group" style="margin-top: 20px; font-size: 16px;">
							<label>确认密码：</label>
							<input class="form-control" type="password" name="passwordB" id="passwordB" value="" placeholder="请输入确认密码" required/>
						</div>
						<div class="col-md-6" style="margin-top: 35px; margin-left: 230px; font-size: 16px;">
							<input onclick="updatePassword()" class="btn btn-primary" type="button" value="修改" id="login" name="login" style="margin: 0px 20px;" />
						</div>
					</form>
				</div>
			</div>
		</div>
		<script src="<%=basePath%>/js/jquery-1.11.0.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=basePath%>/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			var flag=false;
			function checkPassword() {
				var oldpassword=$('#oldpassword').val();
				$.post("<%=basePath%>/user/checkPassword.do",{oldpassword:oldpassword},function(data){
					if(data=='true'){
						$('#error').text("　");
						flag=true;
					}else{
						$('#error').text(data);
						flag=false;
					}
				},"text");
			}
			function updatePassword(){
				if(flag){
					var passwordA=$('#passwordA').val();
					var passwordB=$('#passwordB').val();
					if(passwordA==""){
						$('#error').text("新密码不能为空！");
						return;
					}
					if(passwordA.length>20){
						$('#error').text("密码不能超过20位！");
						return;
					}
					if(passwordA!=passwordB){
						$('#error').text("两次密码不相同！");
						return;
					}
					$.post("<%=basePath%>/user/updatepassword.do",{password:passwordA},function(data){
						if(data=='true'){
							location.href="<%=basePath%>/view/login.jsp";	
						}else{
							$('#error').text(data);
						}
					},"text");
				}
			}
		</script>
	</body>
</html>