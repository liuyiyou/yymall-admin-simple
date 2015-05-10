$(document).ready(function() {
	$(".js-tab-wrap").fixtop({
		marginTop : 39,
		fixedWidth : 948,
		fixed : function(el) {
			el.css({
				"opacity" : 0.7,
				"background-color" : "#5c5c5c"
			});
		},
		unfixed : function(el) {
			el.css({
				"opacity" : 1,
				"background-color" : "#f5f5f5"
			});
		},
	});

	$(".item-pic-thumb  span").click(function(event) {
		$(this).addClass('active').siblings().removeClass('active');
		console.info($(this).find("img").attr("bsrc"));
		//this的下一级
		$(".item-pic-origin img").attr("src", $(this).find("img").attr("bsrc"));
	});
});
