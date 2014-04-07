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
	#brandForm ul {
		margin:0 16px;
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
<s:checkboxlist list="vehicleCategories" listKey="code" listValue="cname" value="" name="codes" />
</s:form>
<div style="clear: both;padding-top: 20px;padding-left: 20px;">
<span>选择服务的汽车品牌,车主可以通过这些信息快速找到咱公司；同时，这些信息也会出现在咱公司店铺首页</span>
</div>
<div style="clear:both;width:100%;text-align:center; padding:20px 0;">
<a class="btn btn-large btn-primary" href="#">选好了，提交</a>
</div>
</body>
</html>