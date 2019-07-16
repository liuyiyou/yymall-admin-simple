var prefix = ctx + "user"

$(document).ready(function () {
    $('body').layout({west__size: 185});
    queryUserList();
});


function queryUserList() {
    var columns = [{
        checkbox: true
    },
        {
            field: 'uid',
            title: '用户ID'
        },
        {
            field: 'account',
            title: '登陆账号'
        },
        {
            field: 'realName',
            title: '真实姓名'
        },
        {
            field: 'gender',
            title: '性别',
            formatter: function (value, row, index) {
                if (value == '0') {
                    return '禁用';
                } else if (value == '1') {
                    return '男';
                } else if (value == '2') {
                    return '女';
                }
            }
        },
        {
            field: '邮箱',
            title: 'email'
        },
        {
            field: 'email',
            title: '邮箱'
        },
        {
            field: 'createTime',
            title: '创建时间'
        },
        {
            field: 'status',
            title: '状态',
            align: 'center',
            formatter: function (value, row, index) {
                if (value == '0') {
                    return '<span class="badge badge-primary">禁用</span>';
                } else if (value == '1') {
                    return '<span class="badge badge-danger">正常</span>';
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
                actions.push('<a class="btn btn-info btn-xs ' + resetPwdFlag + '" href="#" onclick="resetPwd(\'' + row.userId + '\')"><i class="fa fa-key"></i>重置</a>');
                return actions.join('');
            }
        }];
    var url = prefix + '/admin/list';
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

/*用户管理-修改*/
function edit(userId) {
    var url = prefix + '/edit/' + userId;
    layer_showAuto("修改用户", url);
}
