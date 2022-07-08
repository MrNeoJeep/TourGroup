$(function () {
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();

    //2.初始化Button的点击事件
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();
});

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_departments').bootstrapTable({
            url: '/activity/GetHeadAct/'+sessionStorage.getItem('key').toString(),         //请求后台的URL（*）
            // url: '/activity',
            method: 'get',                   //请求方式（*）
            search: 'true',
            toolbar: '#toolbar',                //工具按钮用哪个容器
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber: 1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            paginationPreText: "上一页",
            paginationNextText: "下一页",
            paginationLoop: false,
            showColumns: true,                  //是否显示所有的列
            minimumCountColumns: 2,             //最少允许的列数
            height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            showExport: true,
            exportDataType: "basic",              //basic', 'all', 'selected'.
            columns: [{
                field: 'id',
                title: "id",
                width: 50,
                visible: false
            }, {
                field: 'time',
                title: '时间',
                align: 'center',
            }, {
                field: 'head',
                align: 'center',
                title: '团长'
            }, {
                field: 'content',
                align: 'center',
                title: '内容'
            }, {
                field: 'starting',
                align: 'center',
                title: '起点'
            }, {
                field: 'member',
                align: 'center',
                title: '团员'
            }, {
                field: 'cost',
                align: 'center',
                title: '所需团费'
            }, {
                field: 'costed',
                align: 'center',
                title: '已交团费'
            },{
                field: 'finish',
                align: 'center',
                title: '是否结束'
            },{
                field: 'ending',
                align: 'center',
                title: '结束时间'
            }, {
                field: 'operate',
                title: '操作',
                //width: 120,
                align: 'center',
                valign: 'middle',
                formatter: actionFormatter,
            }
            ]
        });
    };
    return oTableInit;
};

//操作栏的格式化,value代表当前单元格中的值，row代表当前行数据，index表示当前行的下标
function actionFormatter(value, row, index) {
    var id = index;
    var data = JSON.stringify(row);
    var result = "";
    result += "<button class='btn btn-outline-primary btn-sm ch mx-2' type='button' onclick=\"EditViewById('" + row + "','" + id + "')\">编辑</button>";
    result += "<button class='btn btn-outline-danger btn-sm ch' type='button' onclick=\"DeleteByIds('" + id + "','" + row + "')\">删除</button>";
    //{#result += "<a href='javascript:;' class='btn btn-xs blue' onclick=\"EditViewById('" + JSON.stringify(row) + "','" + id + "')\" title='编辑'><span class='glyphicon glyphicon-pencil'></span></a>";#}
    // result += "<a href='javascript:;' class='btn btn-xs blue' onclick=\"EditViewById('" + row + "','" + id + "')\" title='编辑'><span class='glyphicon glyphicon-pencil'></span></a>";
    //{#result += "<a href='javascript:;' class='btn btn-xs blue' onclick=\"edit()\" title='编辑'><span class='glyphicon glyphicon-pencil'></span></a>";#}
    // result += "<a href='javascript:;' class='btn btn-xs red' onclick=\"DeleteByIds('" + id + "','" + row + "')\" title='删除'><span class='glyphicon glyphicon-remove'></span></a>";
    return result;

}

//getData方法获取全部页面数据后，将data转为json对象，使用index当前行号作为下标获取对应数据
function EditViewById(row, index) {
    var data = JSON.stringify($("#tb_departments").bootstrapTable('getData')); //获取全部数据
    var data_json = JSON.parse(data); //data_json和data_json2一样都是json对象
    //var data_json = eval("(" + data+ ")");
    console.log(data_json);
    //由于data2已经是对象了，alert不能显示对象只能显示为[object Object],需要控制台打印
    //{#alert(data_json[0]); #}
    //根据index找到对应行数据，填充数据到修改模态框
    $("#id").val(data_json[index].id);
    $("#id").attr("disabled", "true");		//组件内容禁止修改
    $("#update_name").val(data_json[index].name);
    $("#update_name").removeAttr("disabled", "true");  // 删除禁止修改属性
    $("#update_category").val(data_json[index].category);
    $("#uupdate_category").removeAttr("readonly");
    $("#update_origin").val(data_json[index].origin);
    $("#update_origin").removeAttr("readonly");
    $("#update_price").val(data_json[index].price);
    $("#update_price").removeAttr("readonly");
    $("#update_date").val(data_json[index].date);
    $("#update_date").removeAttr("readonly");
    $("#update_manufacturer").val(data_json[index].manufacturer);
    $("#update_manufacturer").removeAttr("readonly");


    // $("#updateModalLabel").html("修改部门信息");

    // $("#view_close").attr("class", "btn btn-default");
    // $("#view_submit").show();		// 显示提交按钮
    //$("#view_submit").attr("style", "display:block;");

    //弹出修改/查看“部门信息”模态框,对话框中的数据将以Post方式发送。
    $('#updateModal').modal('show');
}

// 删除选中行的数据
function DeleteByIds(index, row) {
    var data = JSON.stringify($("#tb_departments").bootstrapTable('getData')); //获取全部数据
    var data_json = JSON.parse(data); //data_json和data_json2一样都是json对象
    //var data_json = eval("(" + data+ ")");
    console.log(data_json);

    //由于data_json已经是对象了，alert不能显示对象只能显示为[object Object],需要控制台打印
    var str_data_json = JSON.stringify(data_json[index])
    //alert("部门名称: " + data_json[index].Name);
    //alert(str_data_json);	// JSON对象转字符串
    //根据index找到对应行数据，通过ajax方式，发送到服务器。
    axios.delete("/activity/" + data_json[index].id.toString()).then((res) => {
        if (res.data.code == 20021) {
            layer.msg("删除成功！", {time: 1000, icon: 6, shift: 6});
        } else {
            layer.msg("删除失败！", {time: 1000, icon: 5, shift: 6});
        }
    }).finally(() => {
        $("#tb_departments").bootstrapTable('refresh');
    });
}

var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};

    oInit.Init = function () {
        //初始化页面上面的按钮事件
    };
    return oInit;
};
