$(function () {//加载事件
    //显示数据
    $('#dg').datagrid({
        title: "用户信息",
        url: 'getUsersByPage',
        toolbar: "#tb",
        pagination: true,
        pageSize: 3,
        pageList: [3, 5, 7, 10],
        columns: [[
            {field: 'opt', checkbox: "true", title: '编号', width: 100},
            {field: 'id', title: '编号', width: 100},
            {field: 'name', title: '用户名', width: 100},
            {field: 'telephone', title: '电话', width: 100}, {
                field: 'dd', title: '操作', width: 100,
                formatter: function (value, row, index) {
                    return "<a href='javascript:delType(" + row.id + ");'>删除</a>";
                }
            }

        ]]
    });
});

    function search() {
        var name = $("#sname").val();
        var telephone = $("#stelephone").val()
        $("#dg").datagrid("load", {"name": name, "telephone": telephone})
}