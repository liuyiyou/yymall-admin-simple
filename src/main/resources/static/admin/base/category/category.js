var prefix = ctx + "base/admin/category";

$(function () {
    getCategoryByPid(0, 0);
});
function getCategoryByPid(pid, levelId) {
    $.ajax({
        type: "get",
        url: prefix + "/parent/" + pid,
        dataType: "json",
        success: function (result) {
            var category = result.data;
            $("#treeview-searchable_" + levelId).treeview({
                data: category,
                nodeIcon: 'glyphicon glyphicon-globe',
                emptyIcon: '',
                onNodeSelected: function (event, node) {
                    $("#treeview-searchable_0").treeview("addNode", category);
                    // getCategoryByPid(node.id, node.level);
                }
            });
        },
        error: function () {
            alert("省市区地域信息加载失败！")
        }
    });
}

