var str_yzm;
$(function() {
	str_yzm = getYzm();
});
/*6-20位用户名*/
jQuery.validator.addMethod("userName", function(value, element, params) {
	var reg = /^\w{6,20}$/;
	return this.optional(element) || reg.test(value);
}, "请在messages中重写错误信息");
/*验证码判定*/
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