<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<head>
<title>养车客：互联网养车新模式，养车也可以如此轻松惬意！</title>
<meta name="description" content="专业汽车保养、维修服务平台">
<meta name="keywords" content="">
<link rel="StyleSheet" href="<%=request.getContextPath()%>/css/main.css" type="text/css">
<link rel="StyleSheet" href="<%=request.getContextPath()%>/css/login.css" type="text/css">
<style>
.simple-header {
	width: 990px;
	margin: 10px auto;
	
}
.simple-header .reg-logo {
	background: url(../image/yck_logo.gif) no-repeat;
	width: 340px;
	float: left;
	height: 70px;
}

.simple-header h1 {
	padding-top: 30px;
	float: left;
	font: 24px/24px "微软雅黑", "宋体";
	color: #333;
}
.container {
	clear: both;
	width: 990px;
	margin: 0 auto 30px;
	padding:60px 0 80px;
	background-color: #fff;
	border: 1px solid #ccccc8;
}
.field-error {
	color: rgb(221, 75, 57); margin: -20px 0px 8px; font-size: 13px; line-height: 22px;
}
</style>

</head>

<body class="login" screen_capture_injected="true"  text="">
<div class="G_nologin_main clear">
		<div class="scroll_img">
			<img src="<%=request.getContextPath()%>/image/loginbanner.png" alt="" width="560" height="330">
		</div>
		<div class="loginbox">
			<div class="W_login_form">
				<s:form action="login.action" method="post" id="loginForm">
					<s:hidden name="returnURL"/>
					<input type="hidden" name="TARGETURL" value="">
					<div class="info_list">
						<label class="username">
							<input class="G_input" type="text" name="userName" id="userName" alt="输入登录邮箱或手机号码" value="" autocomplete="off">
							
						</label>
					</div>
					<s:property value="errors['member.username'][0]" escape="false"/>
					<div class="info_list">
						<label class="password">
							<input class="G_input" type="password" name="password" id="password" alt="输入登录密码">
						</label>
					</div>
					<s:property value="errors['member.password'][0]" escape="false"/>
					<!-- 
					<div class="info_list clear">
						<input type="hidden" name="captchaId" id="myLoginCaptcha" value="rMLf77NMNKnGhATy21bf20ef">
						<label class="verify">
							<input type="text" class="G_input captcha" id="myLoginCaptchaInput" name="captcha" alt="输入验证码">
						</label>
						<img id="myLoginCaptchaImg" width="80" height="30" src="" onclick="" style="cursor: pointer; margin: 3px 0px 0px 30px; background-image: url(images/loading2.gif); background-position: 50% 50%; background-repeat: no-repeat no-repeat;" title="看不清楚，请点击换一张图片">
					</div>
					 -->
					<div class="info_list no_reg clear">
						<span class="no_reg_tip"><a href="/forgetPassword.xhtml" title="忘记密码" class="mr5">忘记密码？</a>|<a href="<%=request.getContextPath()%>/auth/register.action" title="免费注册" class="ml10">免费注册</a></span>
						<a href="javascript:void(0)"  class="tostep2 on" style="width:160px;float:left;" id="sbmit">登录</a>
					</div>
					<div class="info_list cooperation clear" style="margin-bottom:10px;">
						<dl>
							<dt><span class="left">其它账号登录</span></dt>
							<dd class="mt10">
							
								<a href="" class="login_btn_qq">QQ账号登录</a>
								<a href="" class="login_btn_weib">微博账号登录</a>
							
							</dd>
						</dl>
					</div>
					
				</s:form>
				
			</div>		
		</div>
	</div>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/scripts/mootools.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/scripts/silunzi.js?n=silunzi-util&v=2014022209"></script>
<script type="text/javascript">
window.addEvent('domready',function(){
	lunziUtil.textOver('.G_input');
	silunziUtil.refreshCaptcha('myLoginCaptcha');
	$$(".info_list").getElements("input[type='text'],input[type='password']").each(function(items,i){
		items.addEvents({
			'focus':function(){
				this.getParent('label').addClass('focus_username');
			},
			'blur':function(){
				var el = this.getParent('label').removeClass('focus_username');
			}
		});
	});
		$('sbmit').addEvent('click',function(e){
		e.preventDefault();
		vForm = $("loginForm");
		var isValid = validateForm(vForm);
		if(isValid) $("loginForm").submit();
		return false;
	})
	autoNotice();
});
function focusError(that,text){
	that = that.getParent();
	var el = that.getParent();
	if(!that.retrieve('error')){
		that.addClass('focus_error');
		var s = el.getStyle('margin-bottom').toInt(),error = new Element('div',{'html':text,styles:{'color':'#dd4b39','margin':'-'+s+'px 0 8px 0','font-size':'13px','line-height':'22px'}}).inject(el,'after');
		that.store('error',error);
	}else{
		that.addClass('focus_error');
		that.retrieve('error').show().innerHTML = text;
	}
}

function remmoveError(el){
	el = $(el).getParent();
	if(!el.retrieve('error'))return;
	el.retrieve('error').hide();
	el.removeClass('focus_error');
}

function validateForm(form) {
	var nval = $('userName').value;
	var mycaptcha = $('myLoginCaptchaInput').value;
	if(nval ==''){
		$("userName").focus();
		//focusError($('userName'),'登录邮箱或手机号码不能为空！');
		return false;
	}else remmoveError("password");
	if($("password").value==''){
		$("password").focus();
		//focusError($('password'),'登录密码不能为空！');
		return false;
	}else remmoveError('password');
	if(mycaptcha == ''){
		$('myLoginCaptchaInput').focus();
		//focusError($('myLoginCaptchaInput'),'验证码不能为空！');
		return false;
	}else remmoveError('myLoginCaptchaInput');
	return true;
}
function autoNotice(){
	var tokens = ['@qq.com','@163.com','@126.com','@sina.com','@gmail.com','@hotmail.com','@tencent.com','@alipay.com','@sohu.com','@139.com','@msn.com','@live.cn','@kaixin.com','@taobao.com','@miao.com','@yeah.net','@vip.qq.com'];
	completer = new Autocompleter.Local($("j_username"), tokens, {
		'delay': 100,
		'maxChoices': 8,
		'minLength':1,
		'autoPos':false,
		'filter': function() {
			this.choices.setStyles({'width':this.element.getSize().x,'border-color':'#ff9a66'})
			this.choices.toPos(this.element,'bottomLeft',Browser.ie?(-55):(-54),8);
			var values = this.element.value.trim().split(/ +/);
			if(/^\d+$/.test(values[0]))return false;
			return this.tokens.filter(function(token){
				var result = values.every(function(v){
					if(v.split('@').length > 1 && v.split('@')[1] != ''){
						var reg = new RegExp(v.split('@')[1].escapeRegExp(),'i');
						return reg.test(token);
					}else return true; 
				});
				return result;
			});
		},
		'injectChoice': function(choice){
			var el = new Element('li');
			if(this.element.value.trim().split('@').length > 1){
				el.innerHTML = this.element.value.trim().split('@')[0] + choice;
				this.addChoiceEvents(el).injectInside(this.choices);
			}else{el.innerHTML = this.element.value.trim() + choice;this.addChoiceEvents(el).injectInside(this.choices);}
		}
	});
}

</script>
	
	</body>
	</html>