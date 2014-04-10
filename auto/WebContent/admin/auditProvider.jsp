<%@ page contentType="text/html; charset=utf-8"%>

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
			<h1>商家审核</h1>
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

				<tr>
					<td><a href="">标致4S店</a></td>
					<td>Bobo</td>
					<td>12345678901</td>
					<td>上海 徐汇区 漕河泾</td>
					<td>2014-02-12<br>13:11
					</td>
					<td class="op">
							<a href="cancel.aspx?orderid=201402121539">修改</a> | 
							<a href="javascript:audit()">通过</a> | 
							<a href="javascript:audit()">不通过</a> | 
							<a href="cancel.aspx?orderid=201402121539">店铺管理</a> 
					</td>
				</tr>
				<tr>
					<td><a href="">标致4S店</a></td>
					<td>Bobo</td>
					<td>12345678901</td>
					<td>上海 徐汇区 漕河泾</td>
					<td>2014-02-12<br>13:11
					</td>
					<td class="op">
							<a href="cancel.aspx?orderid=201402121539">修改</a> | 
							<a href="javascript:audit()">通过</a> | 
							<a href="javascript:audit()">不通过</a> | 
							<a href="cancel.aspx?orderid=201402121539">店铺管理</a> 
					</td>
				</tr>

			</tbody>
		</table>
		<div class="ab-pagenavi" style="padding: 20px;"><a class="numbers first" href="accessories/11-0-1-0-4">上一页</a><a class="numbers" href="accessories/11-0-1-0-1">1</a><a class="numbers" href="accessories/11-0-1-0-2">2</a><a class="numbers" href="accessories/11-0-1-0-3">3</a><a class="numbers" href="accessories/11-0-1-0-4">4</a><span class="numbers current">5</span><a class="numbers" href="accessories/11-0-1-0-6">6</a><a class="numbers last" href="accessories/11-0-1-0-6">下一页</a></div>
	</div>
<script type="text/javascript">
function audit(){
	lunziUtil.confirm("商家信息无误，确认开通?", function() {
        //提交审核
        alert("确认后提交审核");
    });
}
</script>
</body>
</html>
