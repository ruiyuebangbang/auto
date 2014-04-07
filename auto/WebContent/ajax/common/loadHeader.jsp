<%@ page contentType="text/html; charset=utf-8"%>
<%
String currentModel = "";
if((session.getAttribute("currentModel")) !=null){
	currentModel = (String)session.getAttribute("currentModel");
}
%>
<ul id="navUtility">
	<li class="VehicleInfo"><span><%=currentModel %></span></li>
	<li id="global_choose_vehicle"><a href="javascript:chooseVehicle(refreshPage);"><i class="icon-th-large" style="margin-right:4px;color:#c10208;"></i>更换车型</a></li>
	<li><span class="line">&nbsp;</span></li>
	<li id="lpChatButton2" style="visibility: visible;"><a href="/auto/auth/login.action" id="lpDynamicButtonHref-572" title="">登录</a></li>
	<li><span class="line">&nbsp;</span></li>
	<li><a href="/auto/auth/register.action">注册</a></li>
	<li><span class="line">&nbsp;</span></li>
	<li><a href="/auto/member/member.action">个人中心</a></li>
		
</ul>