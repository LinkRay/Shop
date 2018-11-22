<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head></head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员注册</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<!-- 引入表单校验的插件 -->
<script src="js/jquery.validate.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css" />

<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}

font {
	color: #3164af;
	font-size: 18px;
	font-weight: normal;
	padding: 0 10px;
}

.error {
	color: red;
}
</style>

<script type="text/javascript">
	// 自定义校验规则
	$.validator.addMethod(
		//规则的名称
		"checkUsername",
		//校验的函数
		function(value, element,params){
			// 定义一个标志
			var flag = false;
			//value:输入的内容
			//element:被校验的元素对象
			//params:规则对应的参数值
			//对输入的username进行ajax校验
			$.ajax({
				//异步true,同步false
				"async":false,
				"url":"${pageContext.request.contextPath}/checkUsername",
				"data":{"username":value},
				"type":"POST",
				"dataType": "json",
				"success": function(data) {
					flag=data.isExist;
				}
			});
			//返回false 代表该校验器不通过, true则通过
			//alter(flag);
			return !flag;
		}
	);
	$.validator.addMethod(
		"isOK",
		function(value, element,params){
			var flag = false;
			$.ajax({
				//异步true,同步false
				"async":false,
				"url":"${pageContext.request.contextPath}/checkCode",
				"data":{"checkCode":value},
				"type":"POST",
				"dataType": "json",
				"success": function(data) {
					flag=data.isMatch;
				}
			});
			return flag;
		}
	);
	$(function() {
		$("#myform").validate({
			/* errorElement :'span',
			  errorClass :'help-block', */
			rules:{
				"username":{
					"required": true,
					"checkUsername": true
				},
				"password":{
					"required": true,
					"rangelength":[6,12]
				},
				"repassword": {
					"required": true,
					"rangelength":[6,12],
					"equalTo": "#password"
				},
				"email": {
					"required": true,
					"email": true
				},
				"sex": {
					"required": true
				},
				"checkCode": {
					"isOK": true
				}
				
			},
			messages:{
				"username":{
					"required":"用户名不能为空",
					"checkUsername":"用户名已存在"
				},
				"password": {
					"required": "密码不能为空",
					"rangelength" : "密码长度6-12位"
				},
				"repassword": {
					"required": "密码不能为空",
					"rangelength" : "密码长度6-12位",
					"equalTo":"两次密码不一致"
				},
				"email": {
					"required": "邮箱不能为空",
					"email": "邮箱格式不正确"
				},
				"checkCode": {
					"isOK":"验证码输入错误"
				}
				
			},
		/* 	 success: function(e) {//关键方法，该方法会在validate完成该输入框的判断以后进行一次调用并且会取消默认的显示错误的方法（大概会吧）
				    //如果进行调试，会方法输入框的class属性会在根据是否合法改变其样式为  "error"和"valid"中的一种，通过判断这个进行判断
	         if(e.prev().hasClass("valid")){   //此处e相当于错误信息这个html标签本身，然后找e的前一个标签是否有"valid"类样式，有则说明当前输入框验证正确
	            e.removeClass("glyphicon-remove");//boostrap的样式，查手册，bootstrap3的全局样式里的表单里有样式说明，添加了对应样式span标签会变为图形。
					//比如在引入bootstrap.css的情况下<span class="glyphicon glyphicon-ok form-control-feedback"></span>就是一个打钩的图案
	            e.addClass("glyphicon-ok");
	         }
	         if(e.prev().hasClass("error")){  //判断输入框里有样式"error"则把打叉换成打钩
	            e.removeClass("glyphicon-ok");
	            e.addClass("glyphicon-remove");
	         }

	      },
	      errorPlacement:function(error,element){  //决定错误信息要放在哪里的方法，error是label对象，element是当前验证的输入框对象
	         error.addClass('glyphicon glyphicon-remove form-control-feedback');
	         error.appendTo(element.parent());

	      }
 */
			
		/* 	 errorPlacement :function(error, element){
				 element.next().remove();//删除显示图标
				 element.after('<span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>');
				 element.closest('.form-group').append(error);//显示错误消息提示
			 }，
			 highlight :function(element){
				 $(element).closest('.form-group').addClass('has-error has-feedback');
			 }，
			 success :function(label){
				 var el=label.closest('.form-group').find("input");
				 el.next().remove();//与errorPlacement相似
				 el.after('<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>');
				 label.closest('.form-group').removeClass('has-error').addClass("has-feedback has-success");
				 label.remove();
			 } */
		});
	});
</script>
</head>
<body>

	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>

	<div class="container"
		style="width: 100%; background: url('image/regist_bg.jpg');">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8"
				style="background: #fff; padding: 40px 80px; margin: 30px; border: 7px solid #ccc;">
				<font>会员注册</font>USER REGISTER
				<form id = myform class="form-horizontal" action="${pageContext.request.contextPath }/register" style="margin-top: 5px;">
					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="username" name="username"
								placeholder="请输入用户名">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="password" name="password"
								placeholder="请输入密码">
						</div>
					</div>
					<div class="form-group">
						<label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="confirmpwd" name="repassword"
								placeholder="请输入确认密码">
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-6">
							<input type="email" class="form-control" id="inputEmail3" name="email"
								placeholder="Email">
						</div>
					</div>
					<div class="form-group">
						<label for="usercaption" class="col-sm-2 control-label">姓名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="usercaption" name="name"
								placeholder="请输入姓名">
						</div>
					</div>
					<div class="form-group opt">
						<label for="inlineRadio1" class="col-sm-2 control-label">性别</label>
						<div class="col-sm-6">
							<label class="radio-inline"> <input type="radio"
								name="sex" id="sex1" value="male">
								男
							</label> <label class="radio-inline"> <input type="radio"
								name="sex" id="sex2" value="female">
								女
							</label>
							<lable class="error" for="sex" style="display: none">您没有第三种选择</lable>
						</div>
					</div>
					<div class="form-group">
						<label for="date" class="col-sm-2 control-label">出生日期</label>
						<div class="col-sm-6">
							<input type="date" class="form-control" name="birthday">
						</div>
					</div>

					<div class="form-group">
						<label for="date" class="col-sm-2 control-label">验证码</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" name="checkCode">

						</div>
						<script type="text/javascript">
								function changeImag(obj){
								  obj.src="${pageContext.request.contextPath}/verificationCode?i="+Math.random();
								 }
								</script>
						<div class="col-sm-2">
							<img alt="验证码" src="${pageContext.request.contextPath}/verificationCode" title="看不清楚，换一张" onclick="changeImag(this)">
						</div>
		
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" width="100" value="注册" name="submit"
								style="background: url('./images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
						</div>
					</div>
				</form>
			</div>

			<div class="col-md-2"></div>

		</div>
	</div>

	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>




