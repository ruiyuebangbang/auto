<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>

<head>

<meta name="description" content="专业汽车保养、维修服务平台">
<meta name="keywords" content="">
<title>养车客商家后台：互联网养车，开启养车新模式</title>
<link rel="StyleSheet" href="css/main.css" type="text/css">
<script src="../scripts/jquery-1.11.0.js"></script>
</head>

<body class="logged-out" screen_capture_injected="true">
	<div class="">
		<div class="pcontent-title">
			<h1>设置产品适用车型</h1>
		</div>
		<div class="pcontent-filter">
			<ul>
				<s:checkboxlist list="brands" listKey="code" listValue="cname" name="selbrands"/>		
			</ul>
			<div class="filter-btn"><input type="button" class="btn btn-primary btn-small" value=" 查询 "></div>
		</div>
		<div class="pcontent">
			<s:iterator value="brands" var="bd">
			<dl>
				<dt><s:property value="cname"/> <input type="radio" name="" value="">全选<input type="radio" checked="checked" value="" >取消</dt>
				<dd>
					<ul>
						 
							<s:checkboxlist list="%{series}" listKey="code" listValue="cname" name="#selseries"/>	
		         
		         	
					</ul>
				</dd>
			</dl>
		</s:iterator>
			<div class="pcontent-btn"><input type="button" class="btn btn-primary btn-small" value=" 确定 "></div>
		</div>
		
	</div>
</body>
</html>
