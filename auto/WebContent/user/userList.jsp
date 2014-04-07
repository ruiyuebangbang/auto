<%@ page contentType="text/html; charset=utf-8"%>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Registration Page</title>
<s:head />
<style type="text/css">
@import url(style.css);
</style>
</head>
<body>

<div class="pcontent-title">
		<h1>员工账号管理</h1>
	</div>
<div style="margin:20px 30px;">
<s:debug></s:debug>
<s:form action="saveOrUpdateUser">
	<s:push value="user">
		<s:hidden name="id" />
		<s:textfield name="name" label="登录账号" />
		<s:password name="password" label="登录密码" />
		
		<s:submit value="提交"/>
	</s:push>
</s:form>
</div>
<s:if test="userList.size() > 0">
	<div class="content">
	<table class="tblist">
		<tr class="even">
			<th width="30%">账号</th>
			<th width="30%">密码</th>
			<th width="20%">状态</th>
			
			<th width="20%">操作</th>
		</tr>
		<s:iterator value="userList" status="userStatus">
			<tr
				class="<s:if test="#userStatus.odd == true ">odd</s:if><s:else>even</s:else>">
				<td align="left"><s:property value="name" /></td>
				<td align="left">********</td>
				<td align="center"><s:property value="status" /></td>
				
				<td>
					<span>
						<s:url id="editURL" action="editUser">
							<s:param name="id" value="%{id}"></s:param>
						</s:url> <s:a href="%{editURL}">修改</s:a>
					</span>
					<span>
						<s:url id="deleteURL" action="deleteUser">
							<s:param name="id" value="%{id}"></s:param>
						</s:url> <s:a href="%{deleteURL}">删除</s:a>
					</span>
				</td>
			</tr>
		</s:iterator>
	</table>
	</div>
</s:if>
</body>
</html>