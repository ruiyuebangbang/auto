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

				<tr>
					<td><a href="">标致4S店</a></td>
					<td>Bobo</td>
					<td>12345678901</td>
					<td>上海 徐汇区 漕河泾</td>
					<td>2014-02-12<br>13:11
					</td>
					<td class="op">
							<a href="cancel.aspx?orderid=201402121539">修改</a> | 
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
							<a href="cancel.aspx?orderid=201402121539">店铺管理</a> 
					</td>
				</tr>

			</tbody>
		</table>
		<div class="ab-pagenavi" style="padding: 20px;"><a class="numbers first" href="accessories/11-0-1-0-4">上一页</a><a class="numbers" href="accessories/11-0-1-0-1">1</a><a class="numbers" href="accessories/11-0-1-0-2">2</a><a class="numbers" href="accessories/11-0-1-0-3">3</a><a class="numbers" href="accessories/11-0-1-0-4">4</a><span class="numbers current">5</span><a class="numbers" href="accessories/11-0-1-0-6">6</a><a class="numbers last" href="accessories/11-0-1-0-6">下一页</a></div>
	</div>
</body>
</html>
