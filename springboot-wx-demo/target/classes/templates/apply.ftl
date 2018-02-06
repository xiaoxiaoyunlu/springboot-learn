<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
<title>第一届乡村大赛报名</title>
<!-- 引入资源 -->
<#include "common.ftl">
<style type="text/css">
td {
	padding-bottom: 2px;
}

</style>
</style>
<script type="text/javascript">
	var loginForm, inPhone, inAddress, inCheckCode;
	var test = {
		node : null,
		count : 60,
		start : function() {
			if (this.count > 0) {
				this.node.innerHTML = this.count-- + "秒(s)";
				var _this = this;
				setTimeout(function() {
					_this.start();
				}, 1000);
			} else {
				
				this.node.innerHTML = "重新获取";
				this.node.setAttribute("onclick", "getMessage()");
				//60秒读完，变回开始背景颜色，在这里添加。
				this.count = 60;
			}
		},
		//初始化
		init : function(node) {
			this.node = node;
			
			this.node.removeAttribute("onclick");
			this.start();
		}
	};
	$(function() {
		loginForm = $("#loginForm");
		inPhone = $("input[name=phone]");
		inAddress = $("input[name=address]");
		inCheckCode = $("input[name=randomCode]");

		// 参数验证
		inPhone.textbox({
			validType : 'phone',
			iconCls : 'icon-man',
			iconAlign : 'right',
			required : true

		});

		inAddress.textbox({
			validType : 'length[4,20]',
			iconCls : 'icon-lock',
			iconAlign : 'right',
			required : true
		});

		inCheckCode.textbox({
			validType : 'length[6,6]',
			iconCls : 'icon-man',
			iconAlign : 'right'

		});

		// 点击回车键登录
		$(document.documentElement).bind("keydown", function(event) {
			if (event.keyCode == 13) {
				$("#submitForm").click();
			}
		});

		// 登录
		$("#submitForm").bind("click", function() {
			var check = $("#randomCode").val();
			if (check) {
				loginForm.form("submit", {
					url : "/save",
					success : function(data) {
						// 将json字符串解析为json对象
						data = $.parseJSON(data);
						// 成功
						if (data.success) {
							location.href = "/index";
						}
						// 失败
						else {
							var errorCode = data.code;
							var message = data.message;
							$.messager.alert('警告', message, 'warning');
						}
					}
				});
			} else {
				$.messager.alert('警告', '请检查，确认验证码是否填写');
			}

		});

		// 重置
		$("#resetForm").bind("click", function() {
			loginForm.form("clear");
			inPhone.next('span').find('input').focus();
		});

		inPhone.next('span').find('input').focus();
	});

	function getMessage() {
		$.get("/getMessage")
		var btn = document.getElementById("msg");
		test.init(btn);
	}
</script>
</head>
<body style="background-color:#836FFF;">
	<div align="center" style="margin-top: 40px">
			<img width="180" height="70" src="/static/image/logo.png"
				style="padding-top: 10px">
			<p style="padding-left: 18px; color: #FFFFFF; font-size: 17px">比赛信息登记</p>
			<form id="loginForm" method="post">
				<input name="open_id" value="${user.open_id}" type="hidden" />
				<input name="count" value="${user.count}" type="hidden" />
				<input name="type" value="${user.type}" type="hidden" />
				<input name="user_name" value="${user.user_name}" type="hidden" />
				<table align="center" style="margin-top: 5px">
					<tr>
						<td style="color: #FFFFFF; font-size: 15px" height="5px">手机号码</td>
					</tr>
					<tr height="10">
						<td><input name="phone" value="${user.phone}"
							style="width: 200px; height: 28px"><a id="msg"
							href="javascript:void(0);" onclick="getMessage()"
							class="easyui-linkbutton" style="width: 80px; height: 28px">获取验证码</a></input></td>
					</tr>
					<tr>
						<td style="color: #FFFFFF; font-size: 15px">所在社区</td>
					</tr>
					<tr height="10">
						<td><input name="address" style="width: 280px; height: 28px" /></td>
					</tr>
					<tr>
						<td style="color: #FFFFFF; font-size: 15px">验证码</td>
					</tr>
					<tr height="10">
						<td><input name="randomCode"
							style="width: 280px; height: 28px" id="randomCode" /></td>
					</tr>
					<tr height="60">
						<td align="center"><a href="javascript:;"
							class="easyui-linkbutton" id="submitForm"
							style="width: 105px; height: 28px"><span
								style="font-size: 15px">立即报名</span></a> &emsp; <a
							href="javascript:;" class="easyui-linkbutton" id="resetForm"
							style="width: 105px; height: 28px"><span
								style="font-size: 15px">重置</span></a></td>
					</tr>
					<tr>
						<td align="center">
							<p style="color: #AE00AE; font-size: 13px">版权解释归上海厚矣科技有限公司</p>
						</td>
					</tr>
				</table>
			</form>
		</div>
</body>
</html>