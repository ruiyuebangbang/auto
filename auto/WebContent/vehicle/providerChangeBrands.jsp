<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="description" content="专业汽车保养、维修服务平台">
<meta name="keywords" content="">
<meta http-equiv="imagetoolbar" content="no">
<title>养车客商家后台：维修品牌设置</title>
<style>
	.b-shortcut span {
		display:block;
	}
	#brandForm ul {
		width: 700px;
		float: left;
		
	}
	#brandForm ul li {
		width: 130px;
		float: left;
		margin: 2px 0 2px 10px;
	}
</style>
</head>
<body>
<div class="pcontent-title"><h1>维修品牌设置</h1></div>
<s:form id="brandForm" method="post" action="edit" theme="simple">
<div class="b-shortcut" style="width: 20px; float: left; margin-left: 20px;">
<span style="margin-top:2px;">A</span>
<span style="margin-top:4px;">B</span>
<span style="margin-top:56px;">C</span>
<span style="margin-top:4px;">D</span>
<span style="margin-top:30px;">F</span>
<span style="margin-top:6px;">G</span>
<span style="margin-top:4px;">H</span>
<span style="margin-top:54px;">J</span>
<span style="margin-top:32px;">K</span>
<span style="margin-top:30px;">L</span>
<span style="margin-top:54px;">M</span>
<span style="margin-top:6px;">O</span>
<span style="margin-top:4px;">Q</span>
<span style="margin-top:6px;">R</span>
<span style="margin-top:4px;">S</span>
<span style="margin-top:30px;">W</span>
<span style="margin-top:30px;">X</span>
<span style="margin-top:4px;">Y</span>
<span style="margin-top:4px;">Z</span>
</div>
<s:checkboxlist list="vehicleCategories" listKey="code" listValue="cname" value="" name="codes" />
<div style="clear:both;"></div>
</s:form>
<div style="clear: both;padding-top: 20px;padding-left: 20px;">
<span>选择服务的汽车品牌,车主可以通过这些信息快速找到咱公司；同时，这些信息也会出现在咱公司店铺首页</span>
</div>
<div style="clear:both;width:100%;text-align:center; padding:20px 0;">
<a class="btn btn-small btn-primary" href="#">选好了，提交</a>
</div>
</body>
</html>