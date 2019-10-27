<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
    <script src="js/jquery-1.8.3.js"></script>
    <!--jquery.easyui.min.js包含了easyUI中的所有插件-->
    <script src="js/jquery.easyui.min.js"></script>

    <script language="JavaScript" src="js/district.js"></script>
</head>
<body>
<table id="dg"></table>

<!--工具栏-->
<div id="tb">
    <a href="javascript:add()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
    <a href="javascript:goupdata()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
    <a href="javascript:DeleteMoreDistrict()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">批量删除</a>
</div>

<%--制作添加对话框--%>
<div id="AddDialog" class="easyui-dialog" title="区域添加" buttons="#AddDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form action="" name="addForm" id="addForm" method="post">
        区域名称:<input type="text" id="name" name="name"><br/>

    </form>
</div>

<%--对话框按钮--%>
<div id="AddDialogButtons">
    <a href="javascript:SaveDialog()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:CloseDialog('AddDialog')" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>

<%--制作修改对话框--%>
<div id="upDialog" class="easyui-dialog" title="区域修改" buttons="#upDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form action="" name="upForm" id="upForm" method="post">
        区域名称:<input type="text" id="name2" name="name"><br/>
      <%-- <input type="hidden" name="id" id="id">--%>

       编号: <input type="text" readonly name="id" id="id">
    </form>
</div>
<%--对话框按钮--%>
<div id="upDialogButtons">
    <a href="javascript:updateDistrict()" class="easyui-linkbutton" iconCls="icon-ok">更新</a>
    <a href="javascript:CloseDialog('upDialog')" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>
</body>
</html>
