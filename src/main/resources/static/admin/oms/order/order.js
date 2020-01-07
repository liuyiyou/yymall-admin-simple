$(document).ready(function () {
    $('body').layout({west__size: 185});
    queryList();
});


function queryList() {
    var columns = [{
        checkbox: true,

    },
        {
            field: 'orderId',
            title: '订单ID',

        },
        {
            field: 'totalPrice',
            title: '价格',

        },
        {
            field: 'consignee',
            title: '联系人',

        },
        {
            field: 'payTypeName',
            title: '支付类型',

        },
        {
            field: 'prods',
            title: '商品信息',
            align: 'center',
            formatter:function (value,row,index) {
                if(value.length ==1){

                }
            }
        },
        {
            title: '操作',
            align: 'center',
            formatter: function (value, row, index) {
                var actions = [];
                actions.push('<a class="btn btn-success btn-xs ' + editFlag + '" href="#" onclick="edit(\'' + row.orderId + '\')"><i class="fa fa-eye"></i>查看</a> ');
                actions.push('<a class="btn btn-success btn-xs ' + editFlag + '" href="#" onclick="edit(\'' + row.orderId + '\')"><i class="fa fa-edit"></i>编辑</a> ');
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



