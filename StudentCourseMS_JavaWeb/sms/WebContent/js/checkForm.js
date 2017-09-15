var str_yzm;
$(function() {
	str_yzm = getYzm();
});
/* 账号 */
jQuery.validator.addMethod("userName", function(value, element, params) {
	var reg = /^\w{0,10}$/;
	return this.optional(element) || reg.test(value);
}, "请在messages中重写错误信息");
/* 密码 */
jQuery.validator.addMethod("password", function(value, element, params) {
	var reg = /^\w{0,20}$/;
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
			password: true
		},
		yzm: {
			required: true,
			yzm: true
		}
	},
	messages: {
		username: {
			required: "× 账号不能为空！",
			userName: "× 账号长度不超过10位！"
		},
		password: {
			required: "× 密码不能为空！",
			password: "× 密码长度不超过20位！"
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