$(document).ready(function () {
    $('body').layout({west__size: 185});
    queryList();
});


function queryList() {
    var columns = [{
        checkbox: true
    },
        {
            field: 'orderId',
            title: '订单ID'
        },
        {
            field: 'totalPrice',
            title: '价格'
        },
        {
            field: 'consignee',
            title: '联系人'
        },
        {
            field: 'payTypeName',
            title: '支付类型'
        },
        {
            field: 'statusName',
            title: '订单状态'
        },
        {
            field: 'createTime',
            title: '创建时间'
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
    var url = "/admin/order/list";
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


/*查看-SKU*/
function add() {
    var url = prefix + '/add';
    layer_showAuto("新增用户", url);
}


/*用户管理-新增*/
function add() {
    var url = prefix + '/add';
    layer_showAuto("新增用户", url);
}

