<%@ page contentType="text/html; charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>

<head>

<meta name="description" content="专业汽车保养、维修服务平台">
<meta name="keywords" content="">
<title>养车客商家后台：互联网养车，开启养车新模式</title>
<link rel="StyleSheet" href="css/main.css" type="text/css">
<script src="../scripts/jquery-1.11.0.js"></script>
<script language="javascript">
function f_gotoPage(sel){
    //alert(sel);
    $('#queryProvider_pager_pageCurr').val(sel);

    document.forms[0].submit();
}
</script>
</head>

<body class="logged-out ytype" screen_capture_injected="true">
<s:form  method="post">
			<s:hidden  name="pager.pageTotal"/>
			<s:hidden  name="pager.pageSize"/>
			<s:hidden  name="pager.pageCurr"/>
</s:form>
	<div class="orderlist">
		<div class="pcontent-title">
			<h1>查询商家</h1>
		</div>
		<div class="pcontent-filter">
			<table>
				<tr>
					<td>区域：</td>
					<td>
						<select class="service" id="service_1" name="servie_1" onchange="changeService('');">
							<option value="">全部</option>
							<option value="">上海市</option>
							<option value="">杭州市</option>
						</select>
						<select class="service" id="service_2" name="servie_2" onchange="changeService('');">
							<option value="">全部</option>
							<option value="">徐汇区</option>
							<option value="">长宁区</option>
							<option value="">闵行区</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>店铺名称：</td>
					<td>
						<input name="name" type="text" style="width:160px;margin-left:20px;"> 
						<input type="submit" class="btn btn-primary btn-small" value=" 查询 " style="margin-left:20px">
					</td>
				</tr>
			</table>
		</div>
		<table class="tblist">
			<thead>
				<tr>
					<th style="width: 90px">店铺名称</th>
					<th>联系人</th>
					<th>手机号</th>
					<th>所在区域</th>
					<th>申请时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="providerList" status="rowstat">
				<tr>
					<td><a href=""><s:property value="SHORT_NAME"/></a></td>
					<td><s:property value="AGENT"/></td>
					<td><s:property value="TELEPHONE"/></td>
					<td><s:property value="regionName"/></td>
					<td><s:property value="apply_date"/></td>
					<td class="op">
							<a href="cancel.aspx?orderid=201402121539">修改</a> | 
							<a href="cancel.aspx?orderid=201402121539">店铺管理</a> 
					</td>
				</tr>
				</s:iterator>

			</tbody>
		</table>
		<div class="ab-pagenavi" style="padding: 20px;">
	        <a class="numbers first" href="javascript:f_gotoPage(<s:property value="pager.pagePre"/>);">上一页</a>
	        <s:iterator value="pager.pageList" id="page">
	        <s:if test="#page = 3">
	            <a class="numbers" href="javascript:f_gotoPage(<s:property/>);"><s:property/></a>
	        </s:if>
	        <s:else>
	            <a class="numbers" href="javascript:f_gotoPage(<s:property/>);"><s:property/></a>
	        </s:else>
	        </s:iterator>
	        <a class="numbers last" href="javascript:f_gotoPage( <s:property value="pager.pageNext"/>);">下一页</a>
	    </div>
 </div>
</body>
</html>
