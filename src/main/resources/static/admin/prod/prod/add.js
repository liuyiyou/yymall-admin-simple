$(document).ready(function () {
    orderAdd.init();
});
var orderAdd = {
    init: function () {
        this.initCategory();
        this.initBrand();
    },
    initCategory: function () {

    },
    initBrand: function () {
        _ajax("/base/admin/brand", '', 'get')
    }
};
