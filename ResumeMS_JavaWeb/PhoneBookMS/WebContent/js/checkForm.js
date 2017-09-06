var str_yzm;
$(function() {
	str_yzm = getYzm();
});
/* 6-20位用户名 */
jQuery.validator.addMethod("userName", function(value, element, params) {
	var reg = /^\w{6,20}$/;
	return this.optional(element) || reg.test(value);
}, "请在messages中重写错误信息");
/* 重复密码判断 */
jQuery.validator.addMethod("equalPassword", function(value, element, params) {
	return this.optional(element) || $('#password').val()==value;
}, "请在messages中重写错误信息");
/*11位手机号*/
jQuery.validator.addMethod("telephone", function(value, element, params) {
	var reg = /^[1][3|5|7|8]\d{9}$/;
	return this.optional(element) || reg.test(value);
}, "请在messages中重写错误信息");
/* 验证码判定 */
jQuery.validator.addMethod("yzm", function(value, element, params) {
	return this.optional(element) || str_yzm == value.toUpperCase();
}, "请在messages中重写错误信息");
$('#form').validate({
	rules: {
		username: {
			required: true,
			userName: true
		},
		password: {
			required: true,
			userName: true
		},
		password2: {
			required: true,
			equalPassword: true
		},
		nickname: {
			required: true
		},
		telephone: {
			required: true,
			telephone: true
		},
		email: {
			email: true
		},
		yzm: {
			required: true,
			yzm: true
		}
	},
	messages: {

		username: {
			required: "× 用户名不能为空！",
			userName: "× 用户名长度为6-20位的字母数字或下划线！"
		},
		password: {
			required: "× 密码不能为空！",
			userName: "× 密码长度为6-20位的字母数字或下划线！"
		},
		password2: {
			required: "× 确认密码不能为空！",
			equalPassword: "× 两次密码不相同！"
		},
		nickname: {
			required: "× 昵称不能为空！"
		},
		telephone: {
			required: "× 手机号码不能为空！",
			telephone: "× 手机号码格式有误！"
		},
		email: {
			email: "× 电子邮箱格式有误！"
		},
		yzm: {
			required: "× 验证码不能为空！",
			yzm: "× 验证码输入有误！"
		}
	},
	success: function(label) {
		label.addClass("valid").text("√");
	},
	errorPlacement: function(error, element) {
		error.appendTo(element.next('label'));
	}
});