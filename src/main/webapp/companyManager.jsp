<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2020/4/24
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>婚庆公司管理</title>
    <base href="<%=request.getContextPath()+"/"%>">
    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyui/themes/demo.css">

    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>

    <script type="text/javascript" src="js/jsonFom.js"></script>

    <script type="text/javascript">
       /**********加载数据网格查询所有实现***************/
        $(function () {
            $('#dg').datagrid({
                url:'CompanyController/findMoreCompany',
                pagination:true,//定义分页栏的显示
                pageSize:5,//初始化页面尺寸size
                pageList:[5,10,15,20,25],//始化页面尺寸的选择列表
                toolbar: '#toolbar',//引入指定的工具栏
                columns:[[
                    {field:'aa',checkbox:true,width:50,align:'center'},
                    {field:'cid',title:'编号',width:50,align:'center'},
                    {field:'cname',title:'公司名称',width:150,align:'center'},
                    {field:'ceo',title:'公司法人',width:90,align:'center'},
                    {field:'cphone',title:'手机号',width:100,align:'center'},
                    {field:'starttime',title:'开通时间',width:100,align:'center',
                        formatter: function(value,row,index){
                            return  value.year+"-"+value.monthValue+"-"+value.dayOfMonth;
                        }},
                    {field:'cnum',title:'订单量',width:100,align:'center'},
                    {field:'status',title:'账号状态',width:100,align:'center'}

                    /*{field:'starttime',title:'开通时间',width:100,align:'center',
                        formatter: function(value,row,index){
                            return  value.year+"-"+value.monthValue+"-"+value.dayOfMonth;
                        }},*/
                ]]});
        })
        
        /***********按照条件查询指定数据*******************/
        function companyFindMore() {
            //手动调用获得json数据格式
            var json = getGson($("#fm2"));

            $("#dg").datagrid("load",json);
        }

        var  url="";

        /***********添加公司信息*************/
        function  newCompany() {

            //打开对话框
             $("#dlg").dialog("open").dialog("setTitle","New Company");
            //清空提交表单
            $("#fm").form("clear");

            url="CompanyController/saveCompany";
        }

        /***********提交表单（公司信息）*************/
        function  saveCompany() {

              //获得所有表单项
           var  val= $("#fm").serialize();

           $.post(url,val,function (result) {
                  if(result){
                      //关闭对话框
                      $("#dlg").dialog("close");

                      //重新加载表格数据
                      $("#dg").datagrid("reload");

                  }
           })
        }
        
        /***********修改公司信息************/
        function  updateCompany() {

            var  row=$("#dg").datagrid("getSelections");

            if(row==null){
                $.messager.alert("提示","请选中一条数据进行操作","info");
            }else if(row.length==1){

                //打开对话框
                $("#dlg").dialog("open");
                //进行数据的回显
                $("#fm").form("load",row[0]);

                url="CompanyController/changeCompany?cid="+row[0].cid;
            }else {
                $.messager.alert("提示","最多选中一条进行操作","info");
            }

        }
        
        /***********重新公司对应的策划师列表*******************/
        function  findCompanyPlanner() {
            var  row=$("#dg").datagrid("getSelections");

            if(row.length==0){
                $.messager.alert("提示","请选中一条数据进行操作","ERROR");
            }else if(row.length==1){

                //打开对话框
               $("#planner_dlg").dialog("open").dialog("setTitle","策划师列表查询");

                $("#planner_dg").datagrid({
                    url:'PlannerController/findMorePlanner',
                    queryParams:{cid:row[0].cid},
                    columns:[[
                        {field:'nid',title:'编号',width:50,align:'center'},
                        {field:'nname',title:'策划师姓名',width:150,align:'center'},
                        {field:'nphone',title:'策划师电话',width:120,align:'center'},
                        {field:'status',title:'账号状态',width:120,align:'center'},
                        {field:'pnum',title:'订单量',width:120,align:'center'}
                    ]]});
            }else {
                $.messager.alert("提示","最多选中一条进行操作","ERROR");
            }
        }

        var  url2="";
        /**********公司状态对话框*************/
        function CompanyStatusUpdate() {

            var  row=$("#dg").datagrid("getSelections");

            if(row.length==0){
                $.messager.alert("提示","请选中一条数据进行操作","ERROR");
            }else if(row.length==1){
                $("#status_dlg").dialog('open').dialog("setTitle","Update Status");

                $("#status_fm").form("clear");

                url2="CompanyController/statusCompanyUpdate?cid="+row[0].cid;
            }else {
                $.messager.alert("提示","最多选中一条进行操作","ERROR");
            }
        }

        /***********提交公司状态修改信息**************/
        function savestatus() {

           var  val= $("#status_fm").serialize();

           $.post(url2,val,function (result) {

               if(result){
                   $("#status_dlg").dialog("close");

                   $("#dg").datagrid("reload");
               }

           })
        }

    </script>

</head>
<body>

    <%--提交查询--%>
   <div class="easyui-panel" style="width: 800px;height: 600px" title="婚庆管理" >

    <form id="fm2">
        <%--定义选择下拉框--%>
        <div style="width: 750px; height: 50px;border: 0px solid red;text-align: center;margin-top: 30px">
            <input name="cname" class="easyui-textbox"  style="width:160px" data-options="prompt:'公司名称'">
            <select name="status" class="easyui-combobox"  style="width:160px" >
                <option value="">账号状态</option>
                <option value="正常">正常</option>
                <option value="禁用">禁用</option>
            </select>
            <select name="cpwd" class="easyui-combobox"  style="width:160px" >
                <option value="">订单量排序</option>
                <option value="asc">升序</option>
                <option value="desc">降序</option>

            </select>&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search"  onclick="companyFindMore()">查询</a>

          </div>
    </form>

    <%--定义数据网格--%>
    <div style="margin-left: 30px">
        <table id="dg" style="width: 730px;" title="查询结果"></table>
    </div>
</div>
    <%--定义工具栏--%>
    <div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add"  onclick="newCompany()">添加公司</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit"  onclick="updateCompany()">编辑公司</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove"  onclick="findCompanyPlanner()">策划师类表</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok"  onclick="CompanyStatusUpdate()">账号状态</a>
    </div>

    <%--添加公司的对话框--%>

    <div id="dlg" class="easyui-dialog" style="width:400px;height:350px;padding:10px 20px"
         closed="true" buttons="#dlg-buttons">
        <div class="ftitle">Company Information</div>
        <form id="fm" method="post" style="margin-left: 50px">
            <div class="fitem" style="margin-top: 20px">
                <input name="cname" data-options="label:'公司名称',width:'250px'" class="easyui-textbox" required="true">
            </div>
            <div class="fitem" style="margin-top: 10px">
                <input name="cpwd" data-options="label:'账号密码',width:'250px'" class="easyui-textbox" required="true">
            </div>
            <div class="fitem" style="margin-top: 10px">
                <input name="ceo" data-options="label:'公司法人',width:'250px'" class="easyui-textbox" required="true">
            </div>
            <div class="fitem" style="margin-top: 10px">
                <input name="cphone" data-options="label:'公司座机',width:'250px'" class="easyui-textbox" required="true">
            </div>
            <div class="fitem" style="margin-top: 10px">
                <input name="cmail" data-options="label:'公司邮箱',width:'250px'" class="easyui-textbox" required="true">
            </div>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveCompany()">Save</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
    </div>

    <%--策划师列表的查询框--%>
    <div id="planner_dlg" class="easyui-dialog" style="width:600px;height:350px;padding:10px 20px"
         closed="true">

        <table id="planner_dg" style="width: 560px;" title="查询结果"></table>

    </div>

     <%--账号状态操作--%>
    <div id="status_dlg" class="easyui-dialog" style="width:400px;height:200px;padding:10px 20px"
         closed="true" buttons="#status_dlg-buttons">
        <div class="ftitle"><h3>公司权限操作</h3></div>
        <div style="margin-left: 40px">
            <form id="status_fm" method="post">
                <div class="fitem" style="margin-top: 20px">

                    账号状态:&nbsp;&nbsp;&nbsp;&nbsp;
                    <input class="easyui-radiobutton" name="status" value="禁用" label="禁用">

                    <input class="easyui-radiobutton" name="status" value="正常" label="正常">
                </div>

            </form>
        </div>
    </div>
    <div id="status_dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="savestatus()">Save</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
    </div>

</body>
</html>
