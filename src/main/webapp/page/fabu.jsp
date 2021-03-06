﻿<%@ page pageEncoding="utf-8" language="java" contentType="text/html;utf-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0044)http://localhost:8080/HouseRent/page/add.jsp -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 -发布房屋信息</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="../css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
<script language="JavaScript" src="../scripts/jquery-1.8.3.js"></script>
<script language="JavaScript">
  $(function () { //jQuery加载事件
      //1.发送异步请求加载类型数据
      $.post("getAllType",null,function (data) {
          //循环一次一行就对应一个选项
          for (var i = 0; i <data.length ; i++) {
              //创建dom节点
              var option = $("<option value="+data[i].id+">"+data[i].name+"</option>");
              //添加节点
              $("#type_id").append(option);
          }
      },"json")
      //2.异步加载所有区域
      $.post("getAllDistrict",null,function (data) {
          //循环一次一行就对应一个选项
          for (var i = 0; i <data.length ; i++) {
              //创建dom节点
              var option = $("<option value="+data[i].id+">"+data[i].name+"</option>")
              //添加节点
              $("#district_id").append(option);
          }
      },"json");
      //3.加载街道
      $("#district_id").change(function(){  //触发区域的改变事件
          var did=$(this).val();
          //发送异步请求获取街道
          //清空选项
          $("#street_id>option:gt(0)").remove();
          //加载数据
          $.post("getStreetByDid",{"did":did},function(data){
              //循环一次一行对就一个选项
              for (var i=0;i<data.length;i++){
                  //创建dom节点
                  var option=$("<option value="+data[i].id+">"+data[i].name+"</option>");
                  //添加节点
                  $("#street_id").append(option);
              }
          },"json");
      });

  })
</script>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV>
  <a href="getUserHouse">我的出租房</a>
</DIV>
<DIV id=regLogin class=wrap>
<DIV class=dialog>
<DL class=clearfix>
  <DT>新房屋信息发布</DT>
  <DD class=past>填写房屋信息</DD></DL>
<DIV class=box>
<FORM id=add_action method=post name=add.action 
action="addHouse" enctype="multipart/form-data">
<DIV class=infos>
<TABLE class=field>
  <TBODY>
  <TR>
    <TD class=field>标　　题：</TD>
    <TD><INPUT id=add_action_title class=text type=text name=title> </TD></TR>
  <TR>
    <TD class=field>户　　型：</TD>
    <TD><SELECT class=text name=type_id id="type_id"><OPTION selected
    >--选择类型--</OPTION></SELECT></TD></TR>
  <TR>
    <TD class=field>面　　积：</TD>
    <TD><INPUT id=add_action_floorage class=text type=text 
name=floorage></TD></TR>
  <TR>
    <TD class=field>价　　格：</TD>
    <TD><INPUT id=add_action_price class=text type=text name=price> </TD></TR>
  <TR>
    <TD class=field>房产证日期：</TD>
    <TD><INPUT class=text type=date name=pubdate></TD></TR>
  <TR>
    <TD class=field>位　　置：</TD>
    <TD>区：<SELECT class=text name=district_id id="district_id"><OPTION selected>--选择区域--</OPTION></SELECT>
        街：<SELECT class=text name=street_id id="street_id"><OPTION selected >--请选择街道--</OPTION></SELECT> </TD></TR><!--
						<tr>
							<td class="field">坐  标：</td>
							<td><input type="text" class="text" name="point" />
							</td>
						</tr>
						--><!--  <tr>
							<td class="field">Y 坐  标：</td>
							<td><input type="text" class="text" name="point.y" /></td>
						</tr>-->
  <TR>
    <TD class=field>联系方式：</TD>
    <TD><INPUT id=add_action_contact class=text type=text name=contact> </TD></TR>
  <TR>
    <TD class=field>详细信息：</TD>
    <TD><TEXTAREA name=description></TEXTAREA></TD></TR>
  </TEXTAREA>
  <TR>
    <TD class=field></TD>
    <TD><input type="file" value="请选择图片" name="pfile"></TD></TR>
  </TBODY></TABLE>
<DIV class=buttons><INPUT  value=立即发布 type=submit>
</DIV></DIV></FORM></DIV></DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
