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
			<h1>产品查询</h1>
		</div>
		<div class="pcontent-filter">
			<table>
				<tr>
					<td>产品分类：</td>
					<td>
						<select class="service" id="service_1" name="servie_1" onchange="changeService('');">
							<option value="">全部</option>
							<option value="">保养类服务</option>
							<option value="">轮胎类服务</option>
						</select>
						<select class="service" id="service_2" name="servie_2" onchange="changeService('');">
							<option value="">全部</option>
							<option value="">机油</option>
							<option value="">机油滤芯</option>
							<option value="">汽油滤芯</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>适用车型：</td>
					<td>
						<select class="service" id="service_1" name="servie_1" onchange="changeService('');">
							<option value="">全部</option>
							<option value="" selected="true">宝马（B）</option>
							<option value="">别克（B）</option>
						</select>
						<select class="service" id="service_2" name="servie_2" onchange="changeService('');">
							<option value="">全部</option>
							<option value="" selected="true">宝马X5</option>
							<option value="">宝马X6</option>
							<option value="">宝马740Li</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>产品名称：</td>
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
					<th style="width: 90px">名称</th>
					<th>品牌</th>
					<th>规格</th>
					<th>市场价</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>

				<tr>
					<td>黄壳机油</td>
					<td>黄壳</td>
					<td>SN/CF 10W-40 4L 矿物油</td>
					<td>180元</td>
					<td class="op">
							<a href="productEdit.action">修改</a> | 
							<a href="mappingVehicle.action">车型</a> 
					</td>
				</tr>
				<tr>
					<td>黄壳机油</td>
					<td>黄壳</td>
					<td>SN/CF 10W-40 4L 矿物油</td>
					<td>180元</td>
					<td class="op">
							<a href="productEdit.action">修改</a> | 
							<a href="mappingVehicle.action">车型</a> 
					</td>
				</tr>
				<tr>
					<td>黄壳机油</td>
					<td>黄壳</td>
					<td>SN/CF 10W-40 4L 矿物油</td>
					<td>180元</td>
					<td class="op">
							<a href="productEdit.action">修改</a> | 
							<a href="mappingVehicle.action">车型</a> 
					</td>
				</tr>

			</tbody>
		</table>
		<div class="ab-pagenavi" style="padding: 20px;"><a class="numbers first" href="accessories/11-0-1-0-4">上一页</a><a class="numbers" href="accessories/11-0-1-0-1">1</a><a class="numbers" href="accessories/11-0-1-0-2">2</a><a class="numbers" href="accessories/11-0-1-0-3">3</a><a class="numbers" href="accessories/11-0-1-0-4">4</a><span class="numbers current">5</span><a class="numbers" href="accessories/11-0-1-0-6">6</a><a class="numbers last" href="accessories/11-0-1-0-6">下一页</a></div>
	</div>
</body>
</html>