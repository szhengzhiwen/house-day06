$(function () {//加载事件
    //显示数据
    $('#dg').datagrid({
        title:"区域信息",
        url:'getDistrictByPage',
        toolbar:"#tb",
        pagination:true,
        pageSize:3,
        pageList:[3,5,7,10],
        columns:[[
            {field:'opt',checkbox:"true",title:'编号',width:100},
            {field:'id',title:'编号',width:100},
            {field:'name',title:'区域名称',width:100}, {
                field: 'dd', title: '操作', width: 100,
                formatter: function (value, row, index) {
                    return "<a href='javascript:delDistrict("+row.id+");'>删除</a>";
                }
            }

        ]]
    });
})
function add() {
    //打开对话框
    $("#AddDialog").dialog("open");
}

//点击取消按钮关闭窗口
function CloseDialog(id) {
    $("#"+id).dialog("close");
}

//点击保存按钮实现添加数据
function SaveDialog() {
    //使用easyui的表单提交插件
    $('#addForm').form('submit', {
        url:"addDistrict",
        success:function(data){//得到的是json字符串
            //将json字符串转化为json对象
            data=$.parseJSON(data);
            //判断返回的数据,执行相应的操作
            if (data.result==1){
                //刷新
                $("#dg").datagrid("reload");
                //关闭窗口
                $("#AddDialog").dialog("close")
            }else{
                $.messager.alert('错误提示','添加失败!','warning');
            }
        }
    });
}
//点击修改按钮弹出对话框
function goupdata() {
    //判断用户是否选中行
    //获取datagrit选中的行
    var SelectRows = $("#dg").datagrid("getSelections");
    if (SelectRows.length==1){
        //获取当前行的编号-->查询当前记录-->还原表单

        //1. 获取当前的编号
        var bh =SelectRows[0].id;
        //2. 发送异步请求获取服务器数据
        $.post("getDistrict",{"id":bh},function (data) {
            //3. 还原加载表单数据
            $("#upForm").form('load',data);
        },"json");
        //获得行对象的数据加载到表单中显示
        //$("#upForm").form('load',{"名称":值,"名称":值});json
        //使用easyui
        /*$("#upForm").form('load',SelectRows[0]);*/

        //打开修改对话框
        $("#upDialog").dialog("open");
    } else{
        //消息提示框
        $.messager.alert("提示信息","你没有选中行或选中多行","warning");
    }
}

/*实现修改区域*/
function updateDistrict() {
    $('#upForm').form('submit', {
        url:"upDistrict",
        success:function(data){//得到的是json字符串
            //将json字符串转化为json对象
            data=$.parseJSON(data);
            //判断返回的数据,执行相应的操作
            if (data.result==1){
                //刷新
                $("#dg").datagrid("reload");
                //关闭窗口
                $("#upDialog").dialog("close")
            }else{
                $.messager.alert('错误提示','修改失败!','error');
            }
        }
    });
}

/*删除区域*/
function delDistrict(id){
    //确认提示框
    $.messager.confirm('删除区域', '真的想删除吗?', function(r){
        if (r){
            //删除
            $.post("delDistrict",{"id":id},function(data){
                if (data.result==1){
                    //刷新
                    $("#dg").datagrid("reload");
                }else{
                    $.messager.alert('错误提示','删除失败!','error');
                }
            },"json");
        }
    });
}

/*批量删除区域*/
function DeleteMoreDistrict() {
    //获取dagagrid选中的行
    var SelectRows = $("#dg").datagrid('getSelections');
    if(SelectRows.length==0) {
        $.messager.alert('提示信息', '你还没有选择删除项', "info");
    }else{
        //确认提示框
        $.messager.confirm('删除区域', '真的想删除吗?', function(r){
            if (r){
                //拼接删除的字符串
                var ids="";
                for (var i = 0; i <SelectRows.length ; i++) {
                    ids = ids + SelectRows[i].id+",";
                }
                ids = ids.substring(0,ids.length-1);//取消最后一个逗号,
                //发送异步请求删除
                $.post("delMoreDistrit",{"ids":ids},function(data){
                    if (data.result>=1){
                        //刷新
                        $("#dg").datagrid("reload");
                    }else{
                        $.messager.alert('错误提示','删除失败!','error');
                    }
                },"json");
            }
        });
    }
}