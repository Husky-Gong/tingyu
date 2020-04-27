<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2020/4/25
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜单管理页面</title>
    <base href="<%=request.getContextPath()+"/"%>">
    <link rel="stylesheet" type="text/css" href="../../../../../Desktop/tingyu/web/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../../../../../Desktop/tingyu/web/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="../../../../../Desktop/tingyu/web/easyui/themes/demo.css">

    <script type="text/javascript" src="../../../../../Desktop/tingyu/web/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="../../../../../Desktop/tingyu/web/easyui/jquery.easyui.min.js"></script>


    <script type="text/javascript">

        $(function () {
            $('#dg').datagrid({
                url:'MenuController/findPageMenus',
                pagination:true,//定义分页栏的显示
                toolbar: '#toolbar',//引入指定的工具栏
                columns:[[
                    {field:'mid',title:'菜单ID',width:150,align:'center'},
                    {field:'mname',title:'菜单名称',width:190,align:'center'},
                    {field:'url',title:'菜单URL',width:190,align:'center'},
                    {field:'mdesc',title:'菜单备注',width:190,align:'center'},

                ]]});
        })

        var  url;
        /**********打开新增菜单对话框***************/
        function newMenu() {
            $("#menu_dlg").dialog("open").dialog("setTitle","New Menu");
            $("#menu_fm").form("clear");

            url="MenuController/saveMenus";
        }

        /***********打开选择树形的对话框*********/
        function selectTree() {
            $("#tree_dlg").dialog("open").dialog("setTitle","Check Tree");
        }
        /*************选择树PID的操作**************/
        $(function () {
                $('#tt').tree({
                    onDblClick: function(node){

                           //关闭当前的对话框
                            $("#tree_dlg").dialog("close");
                           //把选中菜单复制给表单中数据
                           $("#paname").text(node.text);

                           $("#pid").val(node.id);

                    }});
        })

        /*********提交菜单的表单操作****/
        function saveMenu() {

           var val= $("#menu_fm").serialize();

           $.post(url,val,function (result) {
                  if(result){
                      //关闭当前对话框
                       $("#menu_dlg").dialog("close");
                      //重新加载数据网格
                      $("#dg").datagrid("reload");
                  }
           })

        }
        
        /**********修改菜单的实现**************/
        function updateMenu() {
            var  row= $("#dg").datagrid("getSelected");

            if(row){
                //证明已经选中数据
                     console.log(row);
                    //把对话框打开
                    $("#menu_dlg").dialog("open").dialog("setTitle","Update menu");
                    //进行数据回显
                    $("#menu_fm").form("load",row);

                    url="MenuController/changeMenus?mid="+row.mid;

            }else{
                $.messager.alert("提示","请选中一行数据","error");
            }
        }

        /***********删除菜单操作*****************/
        function deleteMenu() {
            var  row= $("#dg").datagrid("getSelected");
            if(row){
                    $.messager.confirm("提示","是否确认删除该数据",function (f) {
                           //判断用户点击的是缺点还是取消
                        if(f){
                            //发送ajax请求进行删除
                            $.post("MenuController/removeMenus",{mid:row.mid},function (result) {
                                   if(result.ErrorMsg){
                                      //证明删除失败
                                       $.messager.alert("提示",result.ErrorMsg,"error");
                                   }else {
                                       //加载表格数据--删除成功
                                       $("#dg").datagrid("reload");
                                   }
                            })
                        }

                    })
            }else{
                $.messager.alert("提示","请选中一条数据进行操作","error");
            }


        }

    </script>
</head>
<body>

<div class="easyui-panel" style="width: 800px;height: 600px" title="菜单管理" >

        <%--定义数据网格--%>
        <div style="margin-left: 30px">
            <table id="dg" style="width: 730px;" title="查询结果"></table>
        </div>

        <%--菜单按钮--%>
        <div id="toolbar">
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add"  onclick="newMenu()">新增菜单</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit"  onclick="updateMenu()">编辑菜单</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove"  onclick="deleteMenu()">删除菜单</a>
        </div>
</div>

<%--添加菜单的对话框--%>
<div id="menu_dlg" class="easyui-dialog" style="width:450px;height:400px;padding:10px 20px"
     closed="true" buttons="#power_dlg-buttons">
    <div class="ftitle"><h3>菜单操作</h3></div>
    <div style="margin-left: 40px">
        <form id="menu_fm" method="post">
            <div class="fitem" style="margin-top: 10px">
                <input name="mname" data-options="label:'菜单名称:',width:'300px'" class="easyui-textbox">
            </div>
            <div class="fitem" style="margin-top: 20px">
                选择PID:&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-reload" onclick="selectTree()">Check Pid</a>
                <span id="paname">默认添加一级菜单</span>
                <input type="text" name="pid" id="pid" value="0"/>
            </div>
            <div class="fitem" style="margin-top: 10px">
                是否open:&nbsp;&nbsp;&nbsp;
                <input class="easyui-radiobutton" name="status" value="1" label="是">
                <input class="easyui-radiobutton" name="status" value="0" label="否">
            </div>
            <div class="fitem" style="margin-top: 20px">
                <input name="url" data-options="label:'菜单URL:',width:'300px'" class="easyui-textbox">
            </div>
            <div class="fitem" style="margin-top: 10px">
                <input name="mdesc" data-options="label:'菜单描述:',width:'300px'" class="easyui-textbox">
            </div>

        </form>
    </div>
</div>
<div id="power_dlg-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveMenu()">Save</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
</div>

<%--展示tree弹框--%>
<div id="tree_dlg" class="easyui-dialog" style="width:350px;height:600px;padding:10px 20px"
     closed="true">
    <%--显示对应的树形菜单--%>
        <ul id="tt" class="easyui-tree" data-options="url:'MenuController/findMoreMenus'"></ul>

</div>

</body>
</html>
