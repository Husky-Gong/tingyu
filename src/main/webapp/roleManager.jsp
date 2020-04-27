<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2020/4/25
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>角色管理页面</title>
    <base href="<%=request.getContextPath()+"/"%>">

    <link rel="stylesheet" type="text/css" href="../../../../../Desktop/tingyu/web/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../../../../../Desktop/tingyu/web/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="../../../../../Desktop/tingyu/web/easyui/themes/demo.css">

    <script type="text/javascript" src="../../../../../Desktop/tingyu/web/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="../../../../../Desktop/tingyu/web/easyui/jquery.easyui.min.js"></script>

    <script type="text/javascript">

        $(function () {
            $('#dg').datagrid({
                url:'RoleController/findPageRole',
                pagination:true,//定义分页栏的显示
                toolbar: '#toolbar',//引入指定的工具栏
                columns:[[
                    {field:'rid',title:'角色编号',width:150,align:'center'},
                    {field:'rname',title:'角色名称',width:190,align:'center'},
                    {field:'rdesc',title:'角色描述',width:190,align:'center'},

                ]]});
        })

        var  url="";
        
        /******打开添加对话框*******/
        function newRole() {

               $("#role_dlg").dialog("open").dialog("setTitle","New Role");

               $("#role_fm").form("clear");

               //清空树形勾选
               uncheck();

               url="RoleController/roleSave?"

        }

        /*********提交表单的实现********************/
        function saveRole() {

            //获得所有选中框的ID
            var nodes = $('#tt').tree('getChecked');
            var s = '';
            for(var i=0; i<nodes.length; i++){
                if (s != '') s += ',';
                s += nodes[i].id;
            }

            //获取未全部选中子节点的父节点
            var pnodes = $('#tt').tree('getChecked', ['indeterminate']);
            var ps = '';
            if(pnodes!=""){
                for(var i=0; i<pnodes.length; i++){
                    if (ps != '') ps += ',';
                    ps += pnodes[i].id;
                }
                s+=","+ps;
            }
            //发送ajax请求进行表单的提交
          var val=  $("#role_fm").serialize();

            $.post(url+"mmids="+s,val,function (result) {

                   if(result){

                       $("#role_dlg").dialog("close");

                       $("#dg").datagrid("reload");
                   }


            })

            
        }
        
        /********打开修改的对话框***************/
        function updateRole() {

            var  row= $("#dg").datagrid("getSelected");

            console.log(row);
            if(row){
                //[A]把对话框打开
                $("#role_dlg").dialog("open");

                //[B]进行数据的回显
                  $("#role_fm").form("load",row);
                //进行菜单的回显
                    //发送ajax请求通过rid 查询指定的mid
                    // result--->就是所有的mid 的集合

                    $.post("RoleMenuController/findMoreMids",{rid:row.rid},function (result) {
                       for (var i  in   result){
                            var node = $('#tt').tree('find', result[i]);
                            $('#tt').tree('check', node.target);
                        }
                    })

                url="RoleController/roleUpdate?rid="+row.rid+"&"
            }else {
                $.messager.alert("提示","请选中一条数据进行操作","error");
            }
        }

        /***********清空所有的tree的勾选框***************/
        function  uncheck() {

            //方式一：
            $.post("MenuController/findPid",function (result) {

               /*for (var  i  in   result){
                   var node = $('#tt').tree('find', result[i].mid);
                   $('#tt').tree('uncheck', node.target);
               }*/
            })


            //方式二：
            var nodes = $('#tt').tree('getChecked');
            for(var i  in  nodes){
                $('#tt').tree('uncheck', nodes[i].target);
            }


        }

        /**********删除角色的操作**********************/
        function deleteRole() {

            var  row= $("#dg").datagrid("getSelected");

            if(row){

                //进行判断删除

                $.messager.confirm("提示","是否确认删除该数据",function (f) {
                       if(f){
                           //发送ajax请求进行数据删除
                           $.post("RoleController/roleRemove",{rid:row.rid},function (result) {

                               if(result){
                                   //重新加载数据网格
                                   $("#dg").datagrid("reload");
                               }

                           })

                       }

                })

            }else{

                $.messager.alert("提示","请选中一行数据","error");

            }

            
        }
         
    </script>
</head>
<body>

<div class="easyui-panel" style="width: 800px;height: 600px" title="角色管理" >

    <%--定义数据网格--%>
    <div style="margin-left: 30px">
        <table id="dg" style="width: 630px;" title="查询结果"></table>
    </div>

    <%--菜单按钮--%>
    <div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add"  onclick="newRole()">新增角色</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit"  onclick="updateRole()">编辑角色</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove"  onclick="deleteRole()">删除角色</a>
    </div>
</div>

<%--添加角色的对话框--%>

<div id="role_dlg" class="easyui-dialog" style="width:450px;height:700px;padding:10px 20px"
     closed="true" buttons="#role_dlg-buttons">
    <div class="ftitle"><h3>角色操作</h3></div>
    <div style="margin-left: 40px">
        <form id="role_fm" method="post">
            <div class="fitem" style="margin-top: 10px">
                <input name="rname" data-options="label:'角色名称:',width:'300px'" class="easyui-textbox">
            </div>
            <div class="fitem" style="margin-top: 10px">
                <input name="rdesc" data-options="label:'角色描述:',width:'300px'" class="easyui-textbox">
            </div>
            <div class="fitem" style="margin-top: 10px">
                角色菜单选择：
                <ul id="tt" class="easyui-tree" data-options="url:'MenuController/findAllMenus',method:'get',animate:true,checkbox:true"></ul>
            </div>

        </form>
    </div>
</div>
<div id="role_dlg-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveRole()">Save</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
</div>

</body>
</html>
