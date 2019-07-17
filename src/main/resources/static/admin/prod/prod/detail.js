var form = layui.form;
$(document).ready(function () {
    orderAdd.init();
});
var orderAdd = {
    init: function () {
        this.initData();
        this.initEvent();
    },
    initData: function () {
        this.initCategory();
        this.initBrand();
    },
    initEvent: function () {
        this.submitProd();
    },
    initCategory: function () {
        //得到一级类目
        get("/base/admin/category/parent/0", '', 'get', function (result) {
            if (result.success) {
                var option = '';
                result.data.forEach(function (item) {
                    option += '<option value="' + item.cataId + '">' + item.cataName + '</option>';
                });
                $("select[name='categoryLevel1']").append(option);
                form.render('select');
            }
        });

        form.on('select(categoryLevel1)', function (data) {
            console.log(data.value); //得到被选中的值
            get("/base/admin/category/parent/" + data.value, '', 'get', function (result) {
                if (result.success) {
                    var option = '';
                    result.data.forEach(function (item) {
                        option += '<option value="' + item.cataId + '">' + item.cataName + '</option>';
                    });
                    $("select[name='categoryLevel2']").html(option);
                    form.render('select');
                }
            });
        });

        form.on('select(categoryLevel2)', function (data) {
            console.log(data.value); //得到被选中的值
            get("/base/admin/category/parent/" + data.value, '', 'get', function (result) {
                if (result.success) {
                    var option = '';
                    result.data.forEach(function (item) {
                        option += '<option value="' + item.cataId + '">' + item.cataName + '</option>';
                    });
                    $("select[name='categoryLevel3']").html(option);
                    form.render('select');
                }
            });
        });

    },
    initBrand: function () {
        get("/base/admin/brand/all", '', 'get', function (result) {
            console.info(result)
        })
    },
    submitProd: function () {
        form.on('submit(formDemo)', function (data) {
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    }
};
