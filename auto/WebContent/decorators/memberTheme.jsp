<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<!--[if lt IE 7 ]> <html xmlns:fb="http://www.facebook.com/2008/fbml" class="ie6 ie ltie9 ltie8 no-js" lang="zh"> <![endif]-->
<!--[if IE 7 ]>    <html xmlns:fb="http://www.facebook.com/2008/fbml" class="ie7 ie ltie9 ltie8 no-js" lang="zh"> <![endif]-->
<!--[if IE 8 ]>    <html xmlns:fb="http://www.facebook.com/2008/fbml" class="ie8 ie ltie9 no-js" lang="zh"> <![endif]-->
<!--[if IE 9 ]>    <html xmlns:fb="http://www.facebook.com/2008/fbml" class="ie9 ie no-js" lang="zh"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html xmlns:fb="http://www.facebook.com/2008/fbml" class="no-js" lang="zh"> <!--<![endif]-->
    <head>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Content-Language" content="CN">
	<link rel="shortcut icon" href="<%=request.getContextPath() %>/favicon.ico" type="image/x-icon">
  	<link rel="StyleSheet" href="<%=request.getContextPath()%>/css/main.css" type="text/css">
  	<link rel="StyleSheet" href="<%=request.getContextPath()%>/css/member.css" type="text/css">
  	<title><decorator:title default="养车客：让车生活更加简单惬意"/></title>
  	<decorator:head></decorator:head>
</head>
<%
String url = request.getRequestURI();
String indexClass = "";
String serviceClass="";
String storeClass="";
String chewenClass="";
if(url.indexOf("store/") > 0) 
	storeClass = "cur";
else if(url.indexOf("service/") > 0)  
	serviceClass = "cur";
else if(url.indexOf("chewen/") > 0)  
	chewenClass = "cur";
else
	indexClass="cur";

%>
<body class="logged-out ytype" screen_capture_injected="true">
<div class="app-header">
		<div id="mastHead" class="header-container clearfix">
			<div class="logo">
				<a href="/">养车客</a>
			</div>

			<div class="hr">
				<div id="nav-shortcut">
					
				</div>
				<div class="guarantee">
					<a href="#" rel="nofollow"
						class="quality"><span>正品保障</span>&nbsp;全场正品，假一罚十</a> <a
						href="#" rel="nofollow"
						class="funds"><span>资金保障</span>&nbsp;养车客维权，先行赔付</a>
				</div>
			</div>
		</div>

	</div>


	<div class="div_nav">
		<div class="nav_content">
			<div class="navLeft">
				<ul>

					<li class="<%=indexClass%>"><a class="currot menua"
						href="<%=request.getContextPath()%>/main.action" ><span>首页</span></a></li>
					<li id="hover" class="autoservice <%=serviceClass%>"><a class="menua"
						href="" >汽车服务<i class="icon-chevron-down"></i></a>
						<div id="maintenance_wrap" style="display: none;">
							<div id="automaintenance" class="automaintenance"></div>
							<div class="maintenancelist">
								<div class="pmain">
									<b class="ptitle" style="float:left;"><i class="icon-hand-right"></i>保养项目查询</b><span style="margin-left:10px;">（我也不知道保养啥项目，查询一下）</span>
									<div class="psearch">
										<dl>
											<dt>
												<span>已行驶：</span>
												<div><input type="text" id="nav_CurMileage" maxlength="7" value=""> </div>
												<span>公里；</span></dt>
											<dd>
												<span>新车购买于：</span>
												<ol>
													<li>
														<div class="newSel">
															<div class="newInput" id="nav-txt-roadyears" name="2009">2009年</div>
															<a class="NewSelBut" href="javascript:;"
																id="nav-arrow-roadyears"></a>
															<div class="clearfix"></div>
															<div style="display: none;" class="newSelLayer"
																id="nav-roadyears">
																<ul>
																	<li><a class="autoitem" href="javascript:;"
																		name="0">年份</a></li>
																	<li><a class="autoitem" href="javascript:;"
																		name="2014">2014年</a></li>
																	<li><a class="autoitem" href="javascript:;"
																		name="2013">2013年</a></li>
																	<li><a class="autoitem" href="javascript:;"
																		name="2012">2012年</a></li>
																	<li><a class="autoitem" href="javascript:;"
																		name="2011">2011年</a></li>
																	<li><a class="autoitem" href="javascript:;"
																		name="2010">2010年</a></li>
																	<li><a class="autoitem" href="javascript:;"
																		name="2009">2009年</a></li>
																</ul>
															</div>
														</div>
													</li>
													<li>
														<div class="newSel">
															<div class="newInput" id="nav-txt-roadmonth" name="8">8月</div>
															<a class="NewSelBut" href="javascript:;"
																id="nav-arrow-roadmonth"></a>
															<div class="clearfix"></div>
															<div style="display: none;" class="newSelLayer"
																id="nav-roadmonth">
																<ul>

																</ul>
															</div>
														</div>
													</li>
													<div class="clearfix"></div>
												</ol>
												<div class="clearfix"></div>
											</dd>
											<div class="psearchBut">
												<form action="/auto/service/proposal.action?act=zn" method="post">
													<button type="submit" class="btn btn-danger">看看需要做哪些保养</button>
												</form>
											</div>
										</dl>
										
										
										<div class="c"></div>
									</div>
									<div class="clearfix"></div>
									<!--psearch-->
									<b class="ptitle" style="float:left;"><i class="icon-hand-right"></i>直接选择保养项目</b><span style="margin-left:10px;">（知道需要什么服务，快速选择）</span>
									<div class="pproject">
										<dl>
											<dt>保养类服务</dt>
											<dd>
												<ol>
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=100101">更换机滤</a></li>                          
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=100102">更换空气滤芯</a></li>                        
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=100103">更换空调滤芯</a></li>                        
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=100104">更换汽油滤芯</a></li>                        
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=100105">更换变速箱油</a></li>                        
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=100106">清洗喷油嘴</a></li>                         
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=100107">更换刹车油</a></li>                         
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=100108">更换防冻液</a></li>                         
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=100109">更换助力油</a></li>                         
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=100110">更换火花塞</a></li>                         
													<!-- li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=100111">更换蓄电池</a></li>                         
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=100112">保养计划</a></li>                          
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=100113">皮带类？？？</a></li -->   
												</ol>
											</dd>
										</dl>

									</div>
									<!--pproject-->
									<div class="c"></div>
									<div class="pproject">
										<dl>
											<dt>轮胎类服务</dt>
											<dd>
												<ol>
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=101101">四轮定位</a></li>                          
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=101102">车轮动平衡</a></li>                         
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=101103">轮胎换位</a></li>                          
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=101104">补胎/轮胎修复</a></li>                       
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=101105">胎压监测</a></li>                          
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=101106">轮毂修复</a></li>   

												</ol>
											</dd>
										</dl>
										<div class="c"></div>
									</div>
									<!--pproject-->
									<div class="c"></div>
									<div class="pproject">
										<dl>
											<dt>检修类服务</dt>
											<dd>
												<ol>
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=102101">刹车类(检测+更换)</a></li>                   
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=102102">转向和悬挂</a></li>                         
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=102103">皮带软管类</a></li>   

												</ol>
											</dd>
										</dl>
										<div class="c"></div>
									</div>
									
									<!--pproject-->
									<div class="c"></div>
									<div class="pproject">
										<dl>
											<dt>美容类服务</dt>
											<dd>
												<ol>
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=103101">车身打蜡</a></li>                          
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=103102">内室清洗</a></li>                          
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=103103">划痕修复</a></li>                          
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=103104">车身封釉</a></li>                          
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=103105">车身镀膜</a></li>                          
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=103106">消毒去味</a></li>                          
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=103107">皮革护理</a></li>    

												</ol>
											</dd>
										</dl>
										<div class="c"></div>
									</div>
									<!--pproject-->
									<div class="c"></div>
									<div class="pproject">
										<dl>
											<dt>特殊类服务</dt>
											<dd>
												<ol>
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=104101">改装音响</a></li>                          
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=104102">改装悬挂</a></li>                          
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=104103">发动机调优</a></li>                         
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=104104">加装倒车雷达</a></li>                        
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=104105">加装倒车影像</a></li>                        
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=104106">换真皮座椅</a></li>                         
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=104107">灯光改装</a></li>                          
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=104108">定制脚垫</a></li>                          
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=104109">定制座椅套</a></li>                         
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=104110">加装导航</a></li>                          
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=104111">加装日行灯</a></li>                         
													<li> <a  class="sitem" href="<%=request.getContextPath() %>/service/proposal.action?act=zx&s=104112">其他</a></li>     

												</ol>
											</dd>
										</dl>
										<div class="c"></div>
									</div>
								</div>

							</div>
							<!--packlist-->



						</div></li>
					<li class="<%=storeClass%>"><a class="menua"
						href="<%=request.getContextPath()%>/store/main.action"
						>周边商家</a></li>
					<li class="<%=chewenClass%>" id="topnav_club"><a class="menua"
						href="<%=request.getContextPath()%>/chewen/chewen.action"
						>车问答</a></li>
					<li class="" id="topnav_club"><a class="menua" href=""
						>车友会</a></li>

					<div class="c"></div>
				</ul>
			</div>
			<div class="navRights"></div>
			<div class="c"></div>


		</div>
	</div>
	<div id="wrap" >
		
		
		<!--  div super-container start -->
		<div id="my-container-wrap">
			<div class="my-navigator">
			    <p>当前位置：</p>
			    <p><a href="/">首页</a></p>
			    <p>&nbsp;&gt; <a href="/my/">用户中心</a></p>
			    <p>&nbsp;&gt; 订单管理</p>
			</div>
			
			<div class="my-container">
				<div class="menu_user">
					<div class="head">
						<div class="avatar"><img src="<%=request.getContextPath()%>/image/member/default_m.png"></div>
						<p class="avatar_tit">IT浪子</p>
					</div>
					
					<div class="menu_item" itemtype="order" lock="">
						<span class="item_icon icon_order"></span><span class="item_name">订单管理</span>
						<span class="item_more item_to_down"></span>
					</div>
					<div class="menu_item_children" itemtype="order">
					    <ul>
					        <li class="menu_item_child selected" id="menu-1-0"><a href="${pageContext.request.contextPath}/orderlist.aspx">全部订单</a></li>
					        <li class="menu_item_child" id="menu-1-6"><a href="orderlist.aspx?state=5">已完成订单</a></li>
					        <li class="menu_item_child" id="menu-1-7"><a href="orderlist.aspx?type=cancel">已取消订单</a></li>
					        <li class="menu_item_child" id="menu-4-3"><a href="votelist.aspx">我的评价</a></li>
					    </ul>
					</div>
					<!--div class="menu_item" itemtype="blance" lock="">
						<span class="item_icon icon_blance"></span><span class="item_name">维权管理</span>
						<span class="item_more item_to_down"></span>
					</div>
					<div class="menu_item_children" itemtype="blance">
					    <ul>
					        <li class="menu_item_child" id="menu-2-6"><a href="share.aspx">发起维权</a></li>
					        <li class="menu_item_child" id="menu-2-5"><a href="mygiftcard.aspx">维权跟踪</a></li>
					    </ul>
					</div-->
					<div class="menu_item" itemtype="blance" lock="">
						<span class="item_icon icon_blance"></span><span class="item_name">财富管理</span>
						<span class="item_more item_to_down"></span>
					</div>
					<div class="menu_item_children" itemtype="blance">
					    <ul>
					        <li class="menu_item_child" id="menu-2-6"><a href="share.aspx">邀请有礼</a></li>
					        <li class="menu_item_child" id="menu-2-5"><a href="mygiftcard.aspx">我的优惠券</a></li>
					        <li class="menu_item_child" id="menu-2-4"><a href="score.aspx">我的积分</a></li>
					    </ul>
					</div>
					<div class="menu_item" itemtype="car"><span class="item_icon icon_car"></span><span class="item_name">爱车信息</span><span class="item_more item_to_down"></span></div>
					<div class="menu_item_children" itemtype="car">
					    <ul>
					        <li class="menu_item_child" id="menu-3-4"><a href="servicerecord.aspx?my_car_id=0">养车Timeline</a></li>
					        <li class="menu_item_child" id="menu-3-3"><a href="storelist.aspx">收藏服务商</a></li>
					        <li class="menu_item_child" id="menu-3-1"><a href="mycar.aspx">我的爱车</a></li>
					    </ul>
					</div>
					<div class="menu_item" itemtype="account"><span class="item_icon icon_account"></span><span class="item_name">个人信息</span><span class="item_more item_to_down"></span></div>
					<div class="menu_item_children" itemtype="account">
					    <ul>
					        <li class="menu_item_child" id="menu-4-1"><a href="myinfo.aspx">个人资料</a></li>
					        <li class="menu_item_child" id="menu-4-2"><a href="password.aspx">修改密码</a></li>
					    </ul>
					</div>
				</div>
				<div class="my-content">
					<decorator:body />
			
				</div>
				<div style="clear:both;"></div>
			</div>
			
			
		</div>
		<!--  div super-container end -->
	<div class="footer">
			<div class="footer-wrap">
				<div class="footer-menu-wrap ">
					<div class="footer-menu first">
						<h3 class="menu-header gy">关于</h3>
						<ul class="menu-list">
							<li><a href="/about">关于四轮子</a></li>
							<li><a href="#">联系我们</a></li>

						</ul>
					</div>

					<div class="footer-menu swhz">
						<h3 class="menu-header">商务合作</h3>
						<ul class="menu-list">
							<li><a href="/faq">招商政策</a></li>
							<li><a href="/advertise">商家入驻流程</a></li>
							<li><a href="/guidelines">广告洽谈</a></li>

						</ul>
					</div>

					<div class="footer-menu bzzx">
						<h3 class="menu-header">帮助中心</h3>
						<ul class="menu-list">
							<li><a href="/careers?country=US">常见问题</a></li>
							<li><a href="/yelpmobile">How it work</a></li>

						</ul>
					</div>

					<div class="follow footer-menu">
						<h3 class="menu-header">关注养车客</h3>
						<img src="<%=request.getContextPath() %>/image/follow_me_weixin.png" width="100px"/>
						
					</div>
				</div>
				
				<p class="copyright lesser-text"><span style="margin-right:20px;">服务热线：400-188-6666（免长话）</span>Copyright © 2014–2018 All Right Reserved yangcheke.com. 沪ICP备08109440</p>
			</div>
		</div>
</div>
  
  
</body>
</html>
