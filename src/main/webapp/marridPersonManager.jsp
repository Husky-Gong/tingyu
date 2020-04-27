<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2020/4/24
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()+"/"%>">

    <link rel="stylesheet" type="text/css" href="../../../../../Desktop/tingyu/web/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../../../../../Desktop/tingyu/web/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="../../../../../Desktop/tingyu/web/easyui/themes/demo.css">

    <script type="text/javascript" src="../../../../../Desktop/tingyu/web/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="../../../../../Desktop/tingyu/web/easyui/jquery.easyui.min.js"></script>

    <script type="text/javascript" src="../../../../../Desktop/tingyu/web/js/jsonFom.js"></script>

    <script type="text/javascript">

        $(function () {
            $('#dg').datagrid({
                url:'MarridPersonController/findMoreMarridPerson',
                pagination:true,//定义分页栏的显示
                pageSize:5,//初始化页面尺寸size
                pageList:[5,10,15,20,25],//始化页面尺寸的选择列表
                toolbar: '#toolbar',//引入指定的工具栏
                columns:[[
                    {field:'pid',title:'编号',width:100,align:'center'},
                    {field:'pname',title:'新人名称',width:150,align:'center'},
                    {field:'pmail',title:'邮箱',width:100,align:'center'},
                    {field:'pphone',title:'手机号',width:100,align:'center'},
                    {field:'marrydate',title:'结婚时间',width:120,align:'center',
                        formatter: function(value,row,index){
                            return  value.year+"-"+value.monthValue+"-"+value.dayOfMonth;
                        }},
                    {field:'status',title:'状态',width:120,align:'center'}

                    /*{field:'starttime',title:'开通时间',width:100,align:'center',
                        formatter: function(value,row,index){
                            return  value.year+"-"+value.monthValue+"-"+value.dayOfMonth;
                        }},*/
                ]]});
        })

        function marridPersonFindMore() {

            var json = getGson($("#fm2"));

            $("#dg").datagrid("load",json);


        }

    </script>

</head>
<body>

<div class="easyui-panel" style="width: 800px;height: 600px" title="新人管理" >

    <form id="fm2">
        <%--定义选择下拉框--%>
        <div style="width: 750px; height: 50px;border: 0px solid red;text-align: center;margin-top: 30px">
            <input name="pname" class="easyui-textbox"  style="width:160px" data-options="prompt:'新人名称'">

            <input name="pphone" class="easyui-textbox"  style="width:160px" data-options="prompt:'新人手机号'">

            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search"  onclick="marridPersonFindMore()">查询</a>

        </div>
    </form>

    <%--定义数据网格--%>
    <div style="margin-left: 30px">
        <table id="dg" style="width: 730px;" title="查询结果"></table>
    </div>
</div>

</body>
</html>
