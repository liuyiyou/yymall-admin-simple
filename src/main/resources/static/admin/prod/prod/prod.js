var prefix = ctx + "prod/prod"

$(document).ready(function () {
    $('body').layout({west__size: 185});
    queryList();
    queryDeptTreeDaTa();
});


function queryList() {
    var columns = [{
        checkbox: true
    },
        {
            field: 'prodId',
            title: '商品ID'
        },
        {
            field: 'prodName',
            title: '商品名称'
        },
        {
            field: 'brandName',
            title: '品牌'
        },
        {
            field: 'createTime',
            title: '创建时间'
        },
        {
            field: 'lastUpdate',
            title: '修改时间'
        },
        {
            field: 'status',
            title: '状态',
            align: 'center',
            formatter: function (value, row, index) {
                if (value == '0') {
                    return '<span class="badge badge-primary">正常</span>';
                } else if (value == '1') {
                    return '<span class="badge badge-danger">禁用</span>';
                }
            }
        },
        {
            title: '操作',
            align: 'center',
            formatter: function (value, row, index) {
                var actions = [];
                actions.push('<a class="btn btn-success btn-xs ' + editFlag + '" href="#" onclick="edit(\'' + row.userId + '\')"><i class="fa fa-edit"></i>编辑</a> ');
                actions.push('<a class="btn btn-danger btn-xs ' + removeFlag + '" href="#" onclick="remove(\'' + row.userId + '\')"><i class="fa fa-remove"></i>删除</a> ');
                return actions.join('');
            }
        }];
    var url = prefix;
    $.initTableJsonParams(columns, url, queryParams);
}

function queryParams(params) {
    var param =
        {
            pageSize: params.limit,
            pageNum: params.offset / params.limit + 1,
            searchValue: params.search,
            orderByColumn: params.sort,
            isAsc: params.order,
        }
    return param;
}

/*用户管理-删除*/
function remove(userId) {
    $.modalConfirm("确定要删除选中用户吗？", function () {
        _ajax(prefix + "/" + userId, "", "delete");
    })
}

/*用户管理-修改*/
function edit(userId) {
    var url = prefix + '/edit/' + userId;
    layer_showAuto("修改用户", url);
}

/*用户管理-新增*/
function add() {
    var url = prefix + '/add';
    layer_showAuto("新增用户", url);
}

/*用户管理-批量新增*/
function batchAdd() {
    //文件默认上传方法,传ID:uploadfile
    $('#uploadfile').fileinput("upload");
    //同步上传错误处理
    $('#uploadfile').on('filebatchuploaderror', function (event, data, msg) {
        // get message
        $.modalAlert(msg, "error");
        //重置
        $('#uploadfile').fileinput("clear");
        $('#uploadfile').fileinput("reset");
        $('#uploadfile').fileinput('refresh');
        $('#uploadfile').fileinput('enable');
    });
    //同步上传后从后台返回结果
    $('#uploadfile').on('filebatchuploadsuccess', function (event, data, previewId, index) {
        var result = data.response;
        if (result.code == 0) {
            //刷新数据表格
            $('.bootstrap-table').bootstrapTable('refresh');
            var count = result.msg;
            $.modalAlert("成功导入" + count + "条数据", "success");
            $('#uploadfile').fileinput('reset');
            $('#exampleModal').modal('hide');

        } else {
            $.modalAlert(result.msg, "error");
            //重置
            $('#uploadfile').fileinput("clear");
            $('#uploadfile').fileinput("reset");
            $('#uploadfile').fileinput('refresh');
            $('#uploadfile').fileinput('enable');
        }
    });

}

/*用户管理-重置密码*/
function resetPwd(userId) {
    var url = prefix + '/resetPwd/' + userId;
    layer_show("重置密码", url, '800', '300');
}

// 批量删除用户
function batchRemove() {
    var rows = $.getSelections("userId");
    if (rows.length == 0) {
        $.modalMsg("请选择要删除的数据", modal_status.WARNING);
        return;
    }
    $.modalConfirm("确认要删除选中的" + rows.length + "条数据吗?", function () {
        _ajax(prefix + '/batchRemove', {"ids": rows}, "post");
    });
}
