<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>

<head>

<meta name="description" content="专业汽车保养、维修服务平台">
<meta name="keywords" content="">
<title>养车客商家后台：设置店铺信息</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/scripts/mootools.js"></script>
<style type="text/css">
.changePtohoBox {
	padding: 10px 10px 10px 300px;
	
	clear: both;
}

.changePtohoBoxInner {
	float: left;
	width: 280px;
	margin-left: -280px;
	_margin-left: -140px;
	height: 320px;
	overflow: hidden;
}

.changeImageBox {
	height: 200px;
	width: 260px;
	overflow: hidden;
	position: relative;
	z-index: 3;
	background: #ccc;
}

.controlCursor {
	height: 186px;
	width: 120px;
	overflow: hidden;
	float: left;
	background: url(<%=request.getContextPath()%>/image/changebox.jpg)	no-repeat;
	position: relative;
}

.bigLink {
	height: 20px;
	line-height: 20px;
	margin-top: 10px
}

.bigLink a,.bigLink input {
	display: inline-block;
	height: 20px;
	padding: 0 10px;
	background: #7092da;
	font-size: 14px;
	text-decoration: none !important;
	color: #fff;
	margin-right: 10px;
	cursor: pointer;
	border: 0
}

.controlCursor input {
	border: 0px;
	background: transparent;
}

.controlCursor label,.sbbutton {
	display: inline-block;
	width: 120px;
	height: 33px;
	position: absolute;
	top: 0px;
	cursor: pointer;
}

.controlCursor label input {
	visibility: hidden;
	width: 120px;
	height: 33px;
}

.controlCursor .sbbutton {
	bottom: 0px;
	top: auto;
}

#headlogo {
	filter: Alpha(opacity = 0);
	opacity: 0;
	cursor: pointer;
	font-size: 28px;
	outline: none;
	hide-focus: expression(this.hideFocus = true);
	left: -295px;
	top: 0px;
	position: absolute;
	cursor: pointer;
}

.controlCursor a {
	color: #fff;
	font-size: 14px;
	font-weight: bold;
	display: block;
	height: 32px;
	line-height: 32px;
	text-align: center;
	text-decoration: none;
}

.dragging {
	border: solid 2px red;
}
.ul-80 li {
	float:none;
	padding-left:30px;
}
</style>

</head>

<body class="logged-out ytype" screen_capture_injected="true">
	<div id="user-info">
		<div class="pcontent-title">
			<h1>商家店铺信息设置</h1>
		</div>
		<div class="tab_menu" style="margin:10px 16px;">
			<div style="float: left;margin: 0 20px 0 0;">
				<label for="loaddz">上传店招</label>
			</div>
			<div>
				<div id="provider-dz" style="background-image:url(${pageContext.request.contextPath}/image/b_licence_default.png); width: 230px; height: 123px; overflow: hidden;clear: both;margin: 10px 0; background-color: #f5f5f5;float:left;" class="">
					
				</div>
				<div style="float: left;margin-top: 106px;margin-left: 10px;"><a href=""  class="btn btn-small btn-primary" id="select-0">更换店招</a></div>
			</div>
		</div>
		
			
		<!-- 上传店面环境图片 -->
		<div style="margin:20px;clear:both;">
			<div>
				<label for="loadpic" >上传店铺展示图片</label>
				<!-- span>
					<input type="radio" name="raddioload" value="batch" id="batch" onchange="javascript:changeUpload(this);" checked="true" >
					<label for="batch">批量上传</label>
				</span>
				<span>
					<input type="radio" name="raddioload" value="batch" id="single" onchange="javascript:changeUpload(this);" >
					<label for="single">传统上传</label>
				</span -->
			</div>
			<!-- 批量上传 begin -->
			<div  id="batchdiv"
				style="width: 700px; height: 320px; background-color: #f5f5f5; border: 1px solid rgb(240, 240, 240); padding: 5px; margin-top: 10px; background-position: initial initial; background-repeat: initial initial;">
				<div style="width: 100%; height: 100%;">
					<div style="width: 100%; height: 40px; line-height: 40px;">
				  <s:form id="imageform" action="uploadImage" method="post" enctype="multipart/form-data" >
						<s:file name="logo" id="headlogo" 
								onchange="javascript:alert(1);"/><!-- $('imageform').submit()"/> -->
						</s:form>
						<span style="display: block; height: 40px; width: 80px; background-image: url(<%=request.getContextPath() %>/image/chooseimg.png); background-repeat:no-repeat;position: relative; overflow: hidden; margin-left: 5px; float: left; background-position: 50% 5px; background-repeat: no-repeat no-repeat;">
							<input type="submit" name="logo0" style="position: absolute; font-size: 0; right: 0px; bottom: 5px; outline: none; cursor: pointer; visibility: visible; zoom: 1; opacity: 0; z-index: -1;">
						</span>
						<span style="display: inline-block; margin-left: 20px; ">上传图片大小不得超过2M，格式为（.jpg	| .gif | .png | .jpeg）</span>
					</div>
					<div
						style="width: 700px; height: 280px; clear:both;border: 1px solid rgb(240, 240, 240); background-color: rgb(255, 255, 255); background-position: initial initial; background-repeat: initial initial;">
						<div class="mycur"
							style="width:210px;height:120px; float: left; margin: 5px; background-color: #f5f5f5; overflow: hidden; position: relative; border: 3px solid rgb(254, 254, 254); background-position: initial initial; background-repeat: initial initial;"><img src='<s:property value="provider.IMG1"/>'></div>
						<div class="mycur"
							style="width:210px;height:120px; float: left; margin: 5px; background-color: #f5f5f5; overflow: hidden; position: relative; border: 3px solid rgb(254, 254, 254); background-position: initial initial; background-repeat: initial initial;"><img src='<s:property value="provider.IMG2"/>'></div>
						<div class="mycur"
							style="width:210px;height:120px; float: left; margin: 5px; background-color: #f5f5f5; overflow: hidden; position: relative; border: 3px solid rgb(254, 254, 254); background-position: initial initial; background-repeat: initial initial;"><img src='<s:property value="provider.IMG3"/>'></div>
						<div class="mycur"
							style="width:210px;height:120px; float: left; margin: 5px; background-color: #f5f5f5; overflow: hidden; position: relative; border: 3px solid rgb(254, 254, 254); background-position: initial initial; background-repeat: initial initial;"><img src='<s:property value="provider.IMG4"/>'></div>
						<div class="mycur"
							style="width:210px;height:120px; float: left; margin: 5px; background-color: #f5f5f5; overflow: hidden; position: relative; border: 3px solid rgb(254, 254, 254); background-position: initial initial; background-repeat: initial initial;"><img src='<s:property value="provider.IMG5"/>'></div>
						<div class="mycur"
							style="width:210px;height:120px; float: left; margin: 5px; background-color: #f5f5f5; overflow: hidden; position: relative; border: 3px solid rgb(254, 254, 254); background-position: initial initial; background-repeat: initial initial;"><img src='<s:property value="provider.IMG6"/>'></div>
					</div>

					<input type="hidden" name="tag" value="member"><input
						type="hidden" name="redirecturl"
						value="home/new/album/albumList.xhtml?memberid=43378980">
				</div>
			</div>
			<!-- 批量上传 end -->
			
		</div>
		<!-- 上传店面环境图片 -->
	</div>


<link rel="stylesheet" type="text/css" href="<s:url value='/css/Roar.css' />">
<script type="text/javascript" src="<s:url value='/scripts/Swiff.Uploader.js' />"></script>
<script type="text/javascript" src="<s:url value='/scripts/Roar.js' />"></script>
<script type="text/javascript">
window.addEvent('domready', function() {
	 
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
		path: '<%=request.getContextPath()%>/css/uploader.swf',
		url: '<%=request.getContextPath()%>/ajax/common/uploadDZ.action',
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
 			if (file.response.error) {
				log.alert('上传失败', '上传 <em>' + this.fileList[0].name + '</em> 失败, 请重新上传.');
			} else {
				var url = "<%=request.getContextPath()%>/uploadimage/passport/"+JSON.decode(file.response.text, true).hash; // secure decode
				var img = $('provider-dz');
				img.setStyle('background-image', '<%=request.getContextPath()%>/uploadimage/url');				
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

function changeUpload(obj){
	if(obj.checked && obj.id =="batch"){
		$("singlediv").setStyle('display','none');
		$("batchdiv").setStyle('display','block');		
	}else{
		$("batchdiv").setStyle('display','none');
		$("singlediv").setStyle('display','block');
		
	}
	return true;
	
}
</script>

</body>
</html>
