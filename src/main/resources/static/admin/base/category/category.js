var prefix = ctx + "base/admin/category"

window.onload = function () {
    loading();
};

function loading() {
    var columns = [{
        field: 'cataId',
        title: '类目ID',
        align: "center"
    },
        {
            title: '类目名称',
            field: 'cataName',
            align: "center"
        },
        {
            title: '类目类别',
            field: 'cataType',
            align: "center",
            formatter: function (value, row, index) {
                if (value == '1') {
                    return '一级类目';
                } else if (value == '2') {
                    return '二级类目';
                } else {
                    return '三级类目';
                }
            }
        },
        {
            title: '操作',
            align: "center",
            formatter: function (row, index) {
                var actions = [];
                actions.push('<a class="btn btn-success btn-xs ' + editFlag + '" href="#" mce_href="#" onclick="edit(\'' + row.cataId + '\')"><i class="fa fa-edit"></i>编辑</a> ');
                actions.push('<a class="btn btn-info btn-xs ' + addFlag + '" href="#" onclick="add(\'' + row.cataId + '\')"><i class="fa fa-plus"></i>新增</a> ');
                actions.push('<a class="btn btn-danger btn-xs ' + removeFlag + '" href="#" onclick="remove(\'' + row.cataId + '\')"><i class="fa fa-remove"></i>删除</a>');
                return actions.join('');
            }
        }];
    var url = prefix + "/list2";
    $.initTreeTable('cataId', 'cataParentId', columns, url, false);
}

/*菜单管理-新增*/
function add(cataId) {
    var url = prefix + '/add/' + cataId;
    layer_showAuto("新增类目", url);
}

/*菜单管理-修改*/
function edit(cataId) {
    var url = prefix + '/edit/' + cataId;
    layer_showAuto("修改菜单", url);
}

/*菜单管理-删除*/
function remove(cataId) {
    layer.confirm("确定要删除类目吗？", {icon: 3, title: '提示'}, function (index) {
        $.ajax({
            type: 'get',
            url: prefix + "/remove/" + cataId,
            success: function (r) {
                if (r.code == 0) {
                    layer.msg(r.msg, {icon: 1, time: 1000});
                    loading();
                } else {
                    layer.alert(r.msg, {icon: 2, title: "系统提示"});
                }
            }
        });
    });
}
