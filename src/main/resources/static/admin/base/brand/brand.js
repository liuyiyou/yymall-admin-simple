$(document).ready(function () {
    $('body').layout({west__size: 185});
    queryList();
});

function queryList() {
    var columns = [{
        checkbox: true
    },
        {
            field: 'brandId',
            title: '品牌ID'
        },
        {
            field: 'brandNameCn',
            title: '品牌名称'
        },
        {
            field: 'brandIcon',
            title: '品牌图标',
            formatter: function (value, row, index) {
                return '<img style="width:50px;height:50px;"  src="https://oss.liuyiyou.cn/' + value + '">';
            }
        },
        {
            field: 'createDate',
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
    var url = "/base/admin/brand/list";
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
