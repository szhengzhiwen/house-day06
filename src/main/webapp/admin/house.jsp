<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/13
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
    <script src="js/jquery-1.8.3.js"></script>
    <!--jquery.easyui.min.js包含了easyUI中的所有插件-->
    <script src="js/jquery.easyui.min.js"></script>
    <script language="JavaScript" src="js/house.js"></script>
</head>
<body>
<table id="dg"></table>

<!--工具栏-->
<div id="tb">
    区域:<select></select>
    街道:<select></select>
    类型:<select></select>
    价格:<input id="sname" type="text" name="name"/>-<input id="sname" type="text" name="name"/>
    <a
            href="javascript:search()" class="easyui-linkbutton"
            iconCls="icon-search" plain="true">搜索</a>
</div>

<!--制作添加区域的对话框-->
<div id="AddDialog" class="easyui-dialog" buttons="#AddDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true"  data-options="modal:true">
    <form action="" id="addForm" name="addForm" method="post">
        区域名称:<input type="text" id="name" name="name"><br/>
    </form>
</div>
<!--对话框的按钮-->
<div id="AddDialogButtons">
    <a href="javascript:SaveDialog()" class="easyui-linkbutton"
       iconCls="icon-ok">保存</a> <a href="javascript:CloseDialog('AddDialog')"
                                   class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>

<!--制作修改区域的对话框-->
<div id="upDialog" class="easyui-dialog" buttons="#upDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true"  data-options="modal:true">
    <form action="" id="upForm" name="addForm" method="post">
        区域名称:<input type="text" id="name2" name="name"><br/>
        <input type="hidden"  id="name2" name="id"><br/>

    </form>
</div>
<!--对话框的按钮-->
<div id="upDialogButtons">
    <a href="javascript:updateDistrict();" class="easyui-linkbutton"
       iconCls="icon-ok">更新</a> <a href="javascript:CloseDialog('upDialog')"
                                   class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>
</body>
</html>
