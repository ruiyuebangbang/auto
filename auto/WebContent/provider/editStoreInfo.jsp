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
</style>

</head>

<body class="logged-out ytype" screen_capture_injected="true">
	<div id="user-info">
		<div class="pcontent-title">
			<h1>商家店铺信息设置</h1>
		</div>
		<div class="tab_menu" style="margin:10px 16px;">
			<div style="float: left;margin: 0 20px 0 0;">
				<input type="radio" name="loadpic" value="100" id="loaddz" onchange="javascript:changeUpload(this);" 
				<s:if test="isLogo">checked="true"</s:if>
				>
				<label for="loaddz">上传店招</label>
			</div>
			<div>
				<input type="radio" name="loadpic" value="100" id="loadpic" onchange="javascript:changeUpload(this);"
				<s:if test="!isLogo">checked="true"</s:if>
				>
				<label for="loadpic" >上传店铺图片</label>
			</div>
		</div>
		
			
		<!-- 上传店面环境图片 -->
		<div id="injectDom" style="margin:20px;">
			<div
				style="width: 700px; height: 430px; background-color: #f5f5f5; border: 1px solid rgb(240, 240, 240); padding: 5px; margin-top: 10px; background-position: initial initial; background-repeat: initial initial;">
				<div style="width: 100%; height: 100%;">
					<div style="width: 100%; height: 40px; line-height: 40px;">
				  <s:form id="imageform" action="uploadImage" method="post" enctype="multipart/form-data" >
						<s:file name="logo" id="headlogo" 
								onchange="javascript:alert(1);"/><!-- $('imageform').submit()"/> -->
						</s:form>
						<span
							style="display: block; height: 40px; width: 80px; background-image: url(http://img.gewara.cn/css/home/chooseimg.png); position: relative; overflow: hidden; margin-left: 5px; float: left; background-position: 50% 5px; background-repeat: no-repeat no-repeat;"><input
							type="submit" name="logo0"
							style="position: absolute; font-size: 20px; right: 0px; bottom: 5px; outline: none; cursor: pointer; visibility: visible; zoom: 1; opacity: 0; z-index: 0;"></span><span
							style="display: inline-block; margin-left: 20px; ">上传图片总大小不得超过2M，格式为（.jpg
							| .gif | .png | .jpeg）</span>
					</div>
					<div
						style="width: 700px; height: 350px; clear:both;border: 1px solid rgb(240, 240, 240); background-color: rgb(255, 255, 255); background-position: initial initial; background-repeat: initial initial;">
						<div class="mycur"
							style="width:120px;height:120px; float: left; margin: 5px; background-color: #f5f5f5; overflow: hidden; position: relative; border: 3px solid rgb(254, 254, 254); background-position: initial initial; background-repeat: initial initial;"><img src='<s:property value="provider.IMG1"/>'></div>
						<div class="mycur"
							style="width:120px;height:120px; float: left; margin: 5px; background-color: #f5f5f5; overflow: hidden; position: relative; border: 3px solid rgb(254, 254, 254); background-position: initial initial; background-repeat: initial initial;"><img src='<s:property value="provider.IMG2"/>'></div>
						<div class="mycur"
							style="width:120px;height:120px; float: left; margin: 5px; background-color: #f5f5f5; overflow: hidden; position: relative; border: 3px solid rgb(254, 254, 254); background-position: initial initial; background-repeat: initial initial;"><img src='<s:property value="provider.IMG3"/>'></div>
						<div class="mycur"
							style="width:120px;height:120px; float: left; margin: 5px; background-color: #f5f5f5; overflow: hidden; position: relative; border: 3px solid rgb(254, 254, 254); background-position: initial initial; background-repeat: initial initial;"><img src='<s:property value="provider.IMG4"/>'></div>
						<div class="mycur"
							style="width:120px;height:120px; float: left; margin: 5px; background-color: #f5f5f5; overflow: hidden; position: relative; border: 3px solid rgb(254, 254, 254); background-position: initial initial; background-repeat: initial initial;"><img src='<s:property value="provider.IMG5"/>'></div>
						<div class="mycur"
							style="width:120px;height:120px; float: left; margin: 5px; background-color: #f5f5f5; overflow: hidden; position: relative; border: 3px solid rgb(254, 254, 254); background-position: initial initial; background-repeat: initial initial;"><img src='<s:property value="provider.IMG6"/>'></div>
						<div class="mycur"
							style="width:120px;height:120px; float: left; margin: 5px; background-color: #f5f5f5; overflow: hidden; position: relative; border: 3px solid rgb(254, 254, 254); background-position: initial initial; background-repeat: initial initial;"><img src='<s:property value="provider.IMG7"/>'></div>
						<div class="mycur"
							style="width:120px;height:120px; float: left; margin: 5px; background-color: #f5f5f5; overflow: hidden; position: relative; border: 3px solid rgb(254, 254, 254); background-position: initial initial; background-repeat: initial initial;"><img src='<s:property value="provider.IMG8"/>'></div>
						<div class="mycur"
							style="width:120px;height:120px; float: left; margin: 5px; background-color: #f5f5f5; overflow: hidden; position: relative; border: 3px solid rgb(254, 254, 254); background-position: initial initial; background-repeat: initial initial;"><img src='<s:property value="provider.IMG9"/>'></div>
						<div class="mycur"
							style="width:120px;height:120px; float: left; margin: 5px; background-color: #f5f5f5; overflow: hidden; position: relative; border: 3px solid rgb(254, 254, 254); background-position: initial initial; background-repeat: initial initial;"><img src='<s:property value="provider.IMG10"/>'></div>
						
					</div>

					<input type="hidden" name="tag" value="member"><input
						type="hidden" name="redirecturl"
						value="home/new/album/albumList.xhtml?memberid=43378980">
				</div>
			</div>
		</div>
		<!-- 上传店面环境图片 -->
	</div>

<script type="text/javascript">
function changeUpload(obj){
	if(obj.checked && obj.id =="loaddz"){
		$("injectDom").setStyle('display','none');
		$("dzDom").setStyle('display','block');
	}else{
		$("dzDom").setStyle('display','none');
		$("injectDom").setStyle('display','block');
		
	}
	return true;
	
}
</script>

</body>
</html>
