<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>

<head>

<meta name="description" content="专业汽车保养、维修服务平台">
<meta name="keywords" content="">
<title>养车客商家后台：互联网养车，开启养车新模式</title>
<link rel="StyleSheet" href="css/main.css" type="text/css">

</head>

<body class="logged-out ytype" screen_capture_injected="true">
	<div class="orderlist">
		<div class="pcontent-title">
			<h1>会员管理</h1>
		</div>
		<div class="pcontent-filter">
			<table>
				<tr>
					<td>关键字：</td>
					<td><input name="name" type="text"
						style="width: 160px; margin-left: 20px;"> <input
						type="submit" class="btn btn-primary btn-small" value=" 查询 "
						style="margin-left: 20px"></td>
				</tr>
			</table>
		</div>
		<s:if test="memberList.size() > 0">
			<div class="content">
				<table class="tblist">
					<tr class="even">
						<th>昵称</th>
						<th>手机号</th>
						<th>Email</th>
						<th>注册时间</th>
						<th>有效</th>
						<th>操作</th>
					</tr>
					<s:iterator value="memberList" status="rows">
						<tr
							class="<s:if test="#rows.odd == true ">odd</s:if><s:else>even</s:else>">
							<td align="left"><s:property value="nickName" /></td>
							<td align="left"><s:property value="mobilePhone" /></td>
							<td align="left"><s:property value="email" /></td>
							<td align="left"></td>
							<td align="left"></td>
							<td><span> <s:url id="deleteURL" action="deleteUser">
										<s:param name="id" value="%{id}"></s:param>
									</s:url> <s:a href="%{deleteURL}">禁用</s:a>
							</span></td>
						</tr>
					</s:iterator>
				</table>
			</div>
			<div class="ab-pagenavi" style="padding: 20px;">
			<a class="numbers first" href="accessories/11-0-1-0-4">上一页</a><a
				class="numbers" href="accessories/11-0-1-0-1">1</a><a
				class="numbers" href="accessories/11-0-1-0-2">2</a><a
				class="numbers" href="accessories/11-0-1-0-3">3</a><a
				class="numbers" href="accessories/11-0-1-0-4">4</a><span
				class="numbers current">5</span><a class="numbers"
				href="accessories/11-0-1-0-6">6</a><a class="numbers last"
				href="accessories/11-0-1-0-6">下一页</a>
		</div>
		</s:if>
		
	</div>
</body>
</html>
