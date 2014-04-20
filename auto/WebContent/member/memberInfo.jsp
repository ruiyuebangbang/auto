<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>

<head>

<title></title>

</head>

<body>
	<div class="detail">
		<div class="user_info clearfix">
			<div id="user_avatar">
				<div id="uc-avatar" >
					<img id="img-avatar" src="/auto/image/member/default_m.png" width=120px height=120px/>
					<a href="#" id="select-0" >更换头像</a>
				</div>
			</div>
			
			<table class="mess">
				<tbody>
					<tr>
						<td class="td_l">昵称：</td>
						<td>kevin <a	href="">更改</a></td>
					</tr>
					<tr>
						<td class="td_l">Email：</td>
						<td class="rel_t">qbzhou@hotmail.com <a	href="">更改</a>
							<span class="p_pop"> <span class="doubt"></span> <span
								class="pop"> <span class="lit_tip"></span> <span
									class="td_lht">您可以通过绑定邮箱来找回帐户密码<br>以及可以用来登录养车客。
								</span>
							</span>
						</span>
						</td>
					</tr>
					
					<tr>
						<td class="td_l">手机：</td>
						<td class="rel_t">（未绑定） <a href="http://www.xiaomi.cn">设置</a>
							<span class="p_pop"> <span class="doubt"></span> <span
								class="pop"> <span class="lit_tip"></span> <span
									class="td_lht">您可以通过绑定手机号来找回帐户密码<br>以及可以用来登录养车客。
								</span>
							</span>
						</span>
						</td>
					</tr>
					
					<tr>
						<td class="td_l">区域：</td>
						<td></td>
					</tr>
					<tr>
						<td class="td_l">密码：</td>
						<td><a href="/pass/changePassword?userId=38337095"
							class="mar_no">更改</a> <span class="p_pop"> <span
								class="doubt"></span> <span class="pop"> <span
									class="lit_tip"></span> <span class="td_lht">您可以更改登录密码</span>
							</span>
						</span></td>
					</tr>

				</tbody>
			</table>
		</div>
		
	</div>
	<link rel="stylesheet" type="text/css" href="http://digitarald.de/project/roar/1-0/assets/Roar.css">
	<script type="text/javascript" src="http://digitarald.de/project/fancyupload/3-0/source/Swiff.Uploader.js"></script>
	<script type="text/javascript" src="http://digitarald.de/project/roar/1-0/source/Roar.js"></script>
	<script type="text/javascript">
	window.addEvent('domready', function() {
		 
		// One Roar instance for our notofications, positioned in the top-right corner of our demo.
		var log = new Roar({
			container: $('user_avatar'),
			position: 'topRight',
			duration: 5000
		});
	 
		var link = $('select-0');
		var linkIdle = link.get('html');
	 
		function linkUpdate() {
			if (!swf.uploading) return;
			var size = Swiff.Uploader.formatUnit(swf.size, 'b');
			link.set('html', '<span class="small">' + swf.percentLoaded + '% of ' + size + '</span>');
		}
	 
		// Uploader instance
		var swf = new Swiff.Uploader({
			path: '/auto/css/uploader.swf',
			url: '/auto/ajax/common/upload.action',
			verbose: true,
			queued: false,
			multiple: false,
			target: link,
			instantStart: true,
			typeFilter: {
				'Images (*.jpg, *.jpeg, *.gif, *.png)': '*.jpg; *.jpeg; *.gif; *.png'
			},
			fileSizeMax: 2 * 1024 * 1024,
			onSelectSuccess: function(files) {
				//if (Browser.Platform.linux) window.alert('Warning: Due to a misbehaviour of Adobe Flash Player on Linux,\nthe browser will probably freeze during the upload process.\nSince you are prepared now, the upload will start right away ...');
				//log.alert('Starting Upload', 'Uploading <em>' + files[0].name + '</em> (' + Swiff.Uploader.formatUnit(files[0].size, 'b') + ')');
				this.setEnabled(false);
			},
			onSelectFail: function(files) {
				log.alert('<em>' + files[0].name + '</em> 上传失败!', '请更换小于2M的图片上传.');
			},
			appendCookieData: true,
			onQueue: linkUpdate,
			onFileComplete: function(file) {
	 
				// We *don't* save the uploaded images, we only take the md5 value and create a monsterid ;)
				if (file.response.error) {
					log.alert('上传失败', '上传 <em>' + this.fileList[0].name + '</em> 失败, 请重新上传.');
				} else {
					var md5 = JSON.decode(file.response.text, true).hash; // secure decode
	 
					//log.alert('Successful Upload', 'an MD5 hash was created from <em>' + this.fileList[0].name + '</em>: <code>' + md5 + '</code>.<br />gravatar.com generated a fancy and unique monsterid for it, since we did not save the image.');
	 
					$('img-avatar').set('src', 'http://localhost:8080/auto/image/tmp/test.jpg');
					
					
				}
	 
				file.remove();
				this.setEnabled(true);
			},
			onComplete: function() {
				link.set('html', linkIdle);
			}
		});
	 
		// Button state
		link.addEvents({
			click: function() {
				return false;
			},
			mouseenter: function() {
				this.addClass('hover');
				swf.reposition();
			},
			mouseleave: function() {
				this.removeClass('hover');
				this.blur();
			},
			mousedown: function() {
				this.focus();
			}
		});
	 
	});
	 
	window.addEvent('domready', function() {
		$$(".p_pop").addEvents({
			'mouseenter':function(){
			this.toggleClass('hover');
			},
			'mouseleave':function(){
			this.toggleClass('hover');
			}
		});
	})
</script>
</body>

</html>
