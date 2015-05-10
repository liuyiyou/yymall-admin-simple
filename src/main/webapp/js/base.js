$(document).ready(function() {
	// 类目滑动
	$(".sec_attr  .list").mouseover(function() {
		$(this).addClass('active').siblings().removeClass('active').end() // 这个需要
		.find('.nav_list').show();
	}).mouseout(function(event) {
		$(this).removeClass('active').find('.nav_list').hide();
	});

	// 导航栏hover。后期改成hover
	$(".dress").mousemove(function(event) {
		$(".header_list").show();
	}).mouseout(function(event) {
		$(".header_list").hide();
	});

	// 导航栏不隐藏
	$("#navbar").fixtop({
		marginTop : 0,
		zIndex : 2000,
		fixed : function(el) {
			el.addClass("staticFix");
		},
		unfixed : function(el) {
			el.removeClass("staticFix");
		},
	});

	// 首页hover
	//
	$('.carousel').carousel();

});