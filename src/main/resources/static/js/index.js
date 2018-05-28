jQuery(function ($) {

    // 轮播
    jQuery(".slide-box").slide({
        mainCell: ".bd ul",
        autoPlay: true,
        interTime: 2000,
        startFun: function (i, c) {
            $("#banner").css("background-color", $(".banner-item").eq(i).attr("data-color"))
        }
    });

    // 搜索框
    $('.search-text').keydown(function () {
        if ($(this).val() != '') {
            $('.hot-search').hide('fast');
        } else {
            $('.hot-search').show('fast');
        }
    })

    // 倒计时
    var djs_interval = setInterval(function () {
        var date = $("#time").val();
        if (date) {
            date = date.replace(/-/g, '/');
            date = new Date(date).getTime();
            var endTime = date;
            var dateNow = new Date().getTime();
            var count = endTime - dateNow;
            if (count <= 1) {
                int = window.clearInterval(djs_interval);
                // alert("倒计时结束");
                return;
            }
            showTime(count);
        }
    }, 27);

    // 倒计时
    function showTime(counttime) {
        counttime1 = parseInt(counttime / 1000);
        var d = Math.floor(counttime1 / (24 * 60 * 60));
        var h = Math.floor((counttime1 - d * 24 * 60 * 60) / 3600);
        var m = Math.floor((counttime1 - h * 3600 - d * 24 * 60 * 60) / 60);
        var s = Math.floor(counttime1 - h * 3600 - d * 24 * 60 * 60 - m * 60);
        if (d == 0) {
            $(".days").hide();
        }
        $(".days").html(d + '天');
        $(".hours").html(formate(h));
        $(".minutes").html(formate(m));
        $(".seconds").html(formate(s));
    }

    function formate(d) {
        return d > 9 ? d : '0' + d;
    }

    jQuery(".hot-content").slide({
        mainCell: ".slide-item ul",
        autoPlay: true,
        interTime: 4000,
        titCell: ".hdbtn ul",
        autoPage: true,
        vis: 4,
        effect: "leftLoop",
        scroll: 4,
        pnLoop: true,
        trigger: "click"
    });


    // 自动楼层
    // var special = $("#drink").offset().top - 48;
    // if ($("#special").html()) {
    //     special = $("#special").offset().top - 48;
    // }
    // var drink = $("#drink").offset().top - 48,
    //     gift = $("#gift").offset().top - 48,
    //     tea = $("#tea").offset().top - 48,
    //     hot = $("#hot").offset().top - 48,
    //     first = $("#first").offset().top - 48;
    // var floorMax = [
    //     {'h': special, 'c': 0},
    //     {'h': drink, 'c': 1},
    //     {'h': gift, 'c': 2},
    //     {'h': tea, 'c': 3},
    //     {'h': hot, 'c': 4},
    //     {'h': first, 'c': 5}
    // ];
    // $(window).scroll(function () {
    //     var floorTop = $(window).scrollTop();
    //     if (floorTop >= floorMax[0].h) {
    //         $('.floor-item').fadeIn();
    //         for (var i = 0; i < floorMax.length; i++) {
    //             if (floorTop >= floorMax[i].h) {
    //                 $('.floor-top').removeClass('on');
    //                 $('.floor-item ul li').eq(floorMax[i].c).addClass('on').siblings().removeClass('on');
    //             }
    //         }
    //     } else {
    //         $('.floor-item').fadeOut();
    //     }
    // })
    // 点击跳转楼层
    $('.floor-item ul li').on('click', function () {
        var index = $(this).index();
        $(this).addClass('on').siblings().removeClass('on');
        $('body,html').animate({scrollTop: floorMax[index].h}, 100);
    })
    // 点击返回顶部
    $('.floor-top').on('click', function () {
        $('body,html').animate({scrollTop: 0}, 100);
    })

    var windowHeight = $(window).height();
    $(window).scroll(function () {
        var windowTop = $(window).scrollTop();
        if (windowTop > windowHeight) {
            $('.suspension-item').fadeIn();
        } else {
            $('.suspension-item').fadeOut();
        }
    })
    if ($(window).scrollTop() > windowHeight) {
        $('.suspension-item').fadeIn();
    }

});


$(function () {

    sessionStorage.backUrl = "https://www.zuipin.cn/?utm_source=zuipin";

    $('login-methods input').blur(function () {
        if (!$(this).val()) {
            $(".tip-red").css('display', 'none');
        }
    });

    $('.login-tab li').on("click", function () {
        var index = $(this).index();
        $(this).addClass('on').siblings().removeClass('on');
        $('.login-methods li').eq(index).addClass('on').siblings().removeClass('on');
        $(".mistake_tips").css('display', 'none');
        if (index == 1) {
            $(".regist-forget-box").css("display", 'none');
        } else {
            $(".regist-forget-box").css("display", 'block');
        }
    });
});

function checkoutaccount(account) {
    var testPhone = /^(1+\d{10})$/;
    var testEmail = /^([a-zA-Z0-9]+[_|_|.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|_|.]?)*[a-zA-Z0-9]+.[a-zA-Z]{2,4}$/;
    if (testPhone.test(account)) {
        return true;
    } else if (testEmail.test(account)) {
        return true;
    }
    return false;
}

//帐号登录验证
function checkOne() {
    var phone = $('#phone').val();
    var pwd = $('#pwd').val();
    var checkPhone = false;
    var checkPwd = false;
    if (!phone) {
        $(".accountTip").css('display', 'none');
        return true;
    }
    if (phone && checkoutaccount(phone)) {
        checkPhone = true;
        $(".accountTip").css('display', 'none');
    } else {
        $(".accountTip").find('span').text('您输入的账号格式有误，请核实后重新输入');
        $(".accountTip").css('display', 'block');
        $(".accountLogin").removeClass("hongse");
        return true;
    }
    if (pwd) {
        if (pwd.length >= 6) {
            checkPwd = true;
        } else {
            $(".accountLogin").removeClass("hongse");
            $(".accountTip").find('span').text('密码长度至少6位')
            $(".accountTip").css('display', 'block');
        }
    }
    if (checkPwd && checkPhone) {
        $(".accountLogin").addClass("hongse");
    }
    return true;
}

$('#phone').blur(function () {
    checkOne();
});

$('#pwd').blur(function () {
    checkOne();
});


$('.accountLogin').click(function () {

    if (!$(this).hasClass('hongse')) {
        return false;
    }

    var token = $('input[name="_token"]').val()
    var phone = $('#phone').val();
    var psw = $('#pwd').val();

    var data = {'phone': phone, '_token': token, 'psd': psw}
    $.post('/accountLogin', data, function (data) {
        var result = data.data;
        if (d == 1) {
            var redirectTo = $('.popup-login').data('redirectTo');
            if (!redirectTo) {
                redirectTo = 'https://www.zuipin.cn/?utm_source=zuipin ';
            }
            location.href = redirectTo;
        } else if (d == '4064') {
            $(".mistake_tips").css('display', 'block');
        } else {
            $(".accountTip").find('span').text('账号或密码错误，请核实后重新输入');
            $(".accountTip").css('display', 'block');
        }
    })
})

//短信登录验证
function checkTwo() {
    var phone = $('#phone2').val();
    var captcha = $('#yzm-input').val();
    var code = $('#code').val();

    var checkPhone = false;
    var checkCaptcha = false;
    var checkCode = false;
    if (phonetest(phone, 'phoneTip')) {
        checkPhone = true;
        $(".phoneTip").css('display', 'none');
    } else {
        $(".message-check").removeClass("hongse");
        $(".phoneLogin").removeClass("hongse");
        return true;
    }

    if (captcha) {
        if (captcha.length == 5 && checkAuthCode(captcha)) {
            checkCaptcha = true;
        } else {
            $(".message-check").removeClass("hongse");
            $(".phoneLogin").removeClass("hongse");
            $(".phoneTip").find('span').text('请输入正确的图片验证码!')
            $(".phoneTip").css('display', 'block');
            return true;
        }
    } else {
        return true;
    }

    if (checkPhone && checkCaptcha && $("#cutNum").val() == 60) {
        $(".message-check").addClass("hongse");
    }

    if (code) {
        if (code.length == 4 && check_code(code, phone)) {
            checkCode = true;
        } else {
            $(".phoneLogin").removeClass("hongse");
            $(".phoneTip").find('span').text('您输入的短信验证码错误，请核对后重新输入')
            $(".phoneTip").css('display', 'block');
            return true;
        }
    } else {
        return true;
    }

    if (checkPhone && checkCaptcha && checkCode) {
        $(".phoneLogin").addClass("hongse");
    }

    return true;
}

$('#phone2').blur(function () {
    checkTwo();
});

$('#yzm-input').blur(function () {
    checkTwo();
});

$('#code').blur(function () {
    checkTwo();
});

$(".message-check").click(function () {
    if ($(this).hasClass('hongse')) {
        send_code();
    }
});

function phoneTip(data) {
    $(".phoneTip").find('span').text(data);
    $(".phoneTip").css('display', 'block');
}

function changeAuthCode() {
    $('#imgs').attr('src', '/captcha?' + Math.random());
    $('#yzm-input').val('');
}

function send_code() {
    var phone = $('#phone2').val()
    var captcha = $('#yzm-input').val();
    var token = $('input[name="_token"]').val()

    if ($('.message-check').hasClass('hongse')) {
        $.post('/s_code/logining', {'phone': phone, '_token': token, 'captcha': captcha}, function (data) {
            if (data == 1) {
                // alert('验证码已发送，请注意查收')
                $(".phoneTip").find('span').text('动态密码己发至您的手机，5分钟内有效，请注意查收');
                $(".phoneTip").css('display', 'block');
                cutdown();
            } else if (data == 4064) {
                $(".mistake_tips").css('display', 'block');
            } else {
                $(".phoneTip").find('span').text('未知错误');
                $(".phoneTip").attr('errorMsg', data);
                $(".phoneTip").css('display', 'block');
            }
        })
    }
}

function cutdown() {
    var cut = $("#cutNum").val();
    if (cut > 0) {
        cut--;
        $("#cutNum").val(cut);
        $('.message-check').removeClass('hongse');
        $(".message-check").text(cut + 'S');
        setTimeout("cutdown()", 1000);
    } else {
        $('.message-check').addClass('hongse');
        $("#cutNum").val('60');
        $(".message-check").text('请重新发送');
        cut = '';
    }
}


function phonetest(phone, tipClass) {
    var myreg = /^(1+\d{10})$/;
    ;
    if (myreg.test(phone)) {
        var token = $('input[name="_token"]').val()
        var da = {'phone': phone, '_token': token}
        var flag = false;
        $.ajaxSetup({async: false});
        $.post('/checkemptyphone', da, function (data) {
            if (data == 1) {
                flag = true;
                $("." + tipClass).css('display', 'none');
            } else {
                $("." + tipClass).find('span').text('您输入的账号不存在，请核对后重新输入')
                $("." + tipClass).css('display', 'block');
                flag = false;
            }
        })
        return flag;
    } else if (phone) {
        $("." + tipClass).find('span').text('您输入的账号格式有误，请核实后重新输入')
        $("." + tipClass).css('display', 'block');
        return false;
    }
}

function check_code(co, phone) {
    if (co && co.length > 3) {
        var token = $('input[name="_token"]').val()
        var captcha = $('#yzm-input').val();
        var flag = false;
        $.ajaxSetup({async: false});
        $.post('/v_code/logining', {
            'num': co,
            '_token': token,
            'phone': phone,
            'captcha': captcha
        }, function (data) {
            if (data == 1) {
                flag = true;
            } else {
                $("." + tipClass).find('span').text('')
                $("." + tipClass).css('display', 'block');
            }
        })
        return flag;
    } else {
        return false;
    }
}

//短信登录
$('.phoneLogin').click(function () {

    if ($(this).hasClass('huise')) {
        return false;
    }
    var token = $('input[name="_token"]').val();
    var num = $('#code').val();
    var phone = $('#phone2').val();
    if (!phone || !num) {
        //phoneTip('手机号或验证码不能为空');
        return false;
    }

    if (!phonetest(phone, 'phoneTip')) {
        phoneTip('您输入的账号格式有误，请核实后重新输入')
        return false;
    }
    if (!check_code(num, phone)) {
        phoneTip('验证码错误，请重新输入')
        return false;
    }
    var info = {'num': num, '_token': token, phone: phone}

    $.post('/phoneLogin', info, function (data) {
        if (data == 1) {
            var redirectTo = $('.popup-login').data('redirectTo');
            if (!redirectTo) {
                redirectTo = 'https://www.zuipin.cn/?utm_source=zuipin ';
            }
            location.href = redirectTo;
        } else if (data == '4064') {
            $(".mistake_tips").css('display', 'block');
        } else {
            phoneTip(data)
        }
    })
})


function checkAuthCode(code) {
    var result = false;
    $.post('/login/checkAuthCode', {'code': code}, function (data) {
        if (data.status == 1) {
            result = true;
        }
    })
    return result;
}

function setCookie(name, value, days) {
    if (days) {
        var date = new Date();
        date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
        var expires = "; expires=" + date.toGMTString();
    } else {
        var expires = "";
    }
    document.cookie = name + "=" + value + expires + "; path=/";
}

// 获取cookie
function getCookie(name) {
    var nameEQ = name + "=";
    var ca = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') c = c.substring(1, c.length);
        if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length, c.length);
    }
    return null;
}

// 删除cookie
function deleteCookie(name) {
    setCookie(name, "", -1);
}

$(".thirdlogin").find("a").click(function () {
    var redirectTo = $('.popup-login').data('redirectTo');
    if (!redirectTo) {
        redirectTo = 'https://www.zuipin.cn/?utm_source=zuipin ';
    }
    setCookie("redirectUrl", redirectTo, 7);
});

jQuery(".special-content").slide({
    titCell: ".hdbtn ul",
    autoPlay: true,
    interTime: 4000,
    mainCell: ".slide-item ul",
    autoPage: true,
    vis: 5,
    effect: "leftLoop",
    scroll: 5,
    pnLoop: true,
    trigger: "click"
});

//  document.onkeydown=keyDownSearch;
function subform() {
    $('#list').submit();
}

$('#sub').click(function () {
    subform();
})

function keyDownSearch(e) {
    // 兼容FF和IE和Opera
    var theEvent = e || window.event;
    var code = theEvent.keyCode || theEvent.which || theEvent.charCode;
    if (code == 13) {
        subform();
    }
    return false;
}



