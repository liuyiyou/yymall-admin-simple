/**
 * 登陆js，
 * 尚未完成的功能有：
 * 1：自定义错误位置和错误样式
 * 2：其他方式登陆
 * 3：验证不通过的时候，可以加多个处理函数吗？
 * 需要完善的功能是：
 * 1：错误的国际化显示
 * 服务端如果出错的话，客户端如何进行显示
 */
$(document).ready(function() {
	$("#loginForm").validate({
		rules: {
			mlsUser: "required",
			password: {
				required: true,
				minlength: 4
			}
		},
		messages: {
			mlsUser: "请输入您的用户名或注册邮箱",
			password: {
				required: "请输入密码",
				minlength: $.validator.format("密码不能小于{0}个字 符")
			}
		},
		submitHandler: function(form) {
			console.info("表单提交");
			//$(form).submit();// 会一直提交
			$(form).ajaxSubmit(); //需要jquery.form.js的支持
			$(":submit").val("登陆中......").attr("disabled","disabled");
		}
	});
});