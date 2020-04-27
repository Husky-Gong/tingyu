<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2020/4/27
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理页面</title>
    <base href="<%=request.getContextPath()+"/"%>">

    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyui/themes/demo.css">

    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>

    <script type="text/javascript">

        $(function () {
            $('#dg').datagrid({
                url:'AdminController/findAllAdmin',
                pagination:true,//定义分页栏的显示
                toolbar: '#toolbar',//引入指定的工具栏
                columns:[[
                    {field:'aid',title:'管理员编号',width:150,align:'center'},
                    {field:'aname',title:'管理员名称',width:180,align:'center'},
                    {field:'apwd',title:'管理员密码',width:180,align:'center'},
                    {field:'aphone',title:'管理员电话',width:190,align:'center'}

                ]]});
        })

        /***********添加管理员操作*****************/
        function newAdmin() {

            $("#admin_dlg").dialog("open").dialog("setTitle","Save Admin");

            $("#admin_fm").form("clear");

        }

        /***********提交添加管理员表单信息***********/
        function saveAdmin() {

            var  val=  $("#admin_fm").serialize();

            $.post("AdminController/saveAdmin",val,function (result) {

                if(result){
                    $("#admin_dlg").dialog("close");

                    $("#dg").datagrid("reload");
                }

            })


        }

    </script>
</head>
<body>

<div class="easyui-panel" style="width: 800px;height: 600px" title="管理员管理" >

    <%--定义数据网格--%>
    <div style="margin-left: 30px">
        <table id="dg" style="width: 730px;" title="查询结果"></table>
    </div>

    <%--菜单按钮--%>
    <div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add"  onclick="newAdmin()">新增管理员</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit"  onclick="updateRole()">编辑管理员</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove"  onclick="deleteRole()">删除管理员</a>
    </div>
</div>

<%--添加用户的对话框--%>
<div id="admin_dlg" class="easyui-dialog" style="width:450px;height:400px;padding:10px 20px"
     closed="true" buttons="#admin_dlg-buttons">
    <div class="ftitle"><h3>管理员操作</h3></div>
    <div style="margin-left: 40px">
        <form id="admin_fm" method="post">
            <div class="fitem" style="margin-top: 10px">
                <input name="aname" data-options="label:'用户名称:',width:'300px'" class="easyui-textbox">
            </div>
            <div class="fitem" style="margin-top: 10px">
                <input name="apwd" data-options="label:'用户密码:',width:'300px'" class="easyui-textbox">
            </div>
            <div class="fitem" style="margin-top: 10px">
                <input name="aphone" data-options="label:'用户电话:',width:'300px'" class="easyui-textbox">
            </div>
            <div class="fitem" style="margin-top: 10px">
                <input name="starttime" data-options="label:'入职日期:',width:'300px'" class="easyui-textbox">
            </div>
            <div class="fitem" style="margin-top: 10px">

                用户角色:&nbsp;&nbsp;&nbsp;

                <input class="easyui-combobox" name="roles" style="width:50%"
                       data-options="url:'RoleController/findAllRole',
				                     method:'get',
				                     valueField:'rid',
				                     textField:'rname',
				                     panelHeight:'auto'">
            </div>


        </form>
    </div>
</div>
<div id="admin_dlg-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveAdmin()">Save</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
</div>

</body>
</html>
