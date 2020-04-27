<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2020/4/21
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主持人管理页面</title>
    <base href="<%=request.getContextPath()+"/"%>">

    <link rel="stylesheet" type="text/css" href="../../../../../Desktop/tingyu/web/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../../../../../Desktop/tingyu/web/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="../../../../../Desktop/tingyu/web/easyui/themes/demo.css">

    <script type="text/javascript" src="../../../../../Desktop/tingyu/web/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="../../../../../Desktop/tingyu/web/easyui/jquery.easyui.min.js"></script>

    <script type="text/javascript" src="../../../../../Desktop/tingyu/web/js/jsonFom.js"></script>

    <script type="text/javascript">

        /*********查询表格所有信息数据*********/
        $(function () {
            $('#dg').datagrid({
                url:'HostController/findMoreHost',
                pagination:true,//定义分页栏的显示
                pageSize:5,//初始化页面尺寸size
                pageList:[5,10,15,20,25],//始化页面尺寸的选择列表
                toolbar: '#toolbar',//引入指定的工具栏
                columns:[[
                    {field:'aa',checkbox:true,width:50,align:'center'},
                    {field:'strong',title:'权重',width:100,align:'center',
                        formatter: function(value,row,index){
                            return  "<input value='"+value+"' style='width: 50px' onblur='updateStrong(this.value,"+row.hid+")'>";
                        }},
                    {field:'hname',title:'姓名',width:100,align:'center'},
                    {field:'hphone',title:'手机号',width:100,align:'center'},
                    {field:'starttime',title:'开通时间',width:100,align:'center',
                        formatter: function(value,row,index){
                             return  value.year+"-"+value.monthValue+"-"+value.dayOfMonth;
                        }},
                    {field:'hpprice',title:'价格',width:100,align:'center',
                        formatter: function(value,row,index){
                            return row.hostPower.hpprice==null?"新人暂无":row.hostPower.hpprice;
                        }},
                    {field:'num',title:'订单量',width:100,align:'center'},
                    {field:'hpdiscount',title:'折扣(折)',width:100,align:'center',
                        formatter: function(value,row,index){
                            return row.hostPower.hpdiscount==null?"新人暂无":row.hostPower.hpdiscount;
                        }},
                    {field:'hpstart',title:'星推荐',width:100,align:'center',
                        formatter: function(value,row,index){
                            return row.hostPower.hpstart==null?"新人暂无":row.hostPower.hpstart;
                        }},
                    {field:'status',title:'账号状态',width:100,align:'center'},
                    ]]});
        })
        
        /**********按条件查询主持人信息****************/
        function hostFindMore() {

            //[A]获得所有的查询的数据
           /* var  val=$("form").serializeArray();

            //手动获得json格式
            var obj ={};
            for(var i =0;i<val.length;i++){
                obj[val[i].name]=val[i].value;
            }*/
             var obj = getGson($("#fm2"));
           
             //[B]发送请求进行条件查询
            $("#dg").datagrid('load',obj);

        }
        
        /***********修改权重的实现***************/
        function  updateStrong(val,hid) {
            //修改权重的参数 -hid   --val

            //对于输入的数据进行校验   数字  数字范围  0-100
             $.post("HostController/updateStrong",{strong:val,hid:hid},function (result) {
                    if(result){
                        $.messager.alert("提示","权限修改成功","info");
                    }
             })

            
        }
       /***********添加主持人消息框操作*********/
       function  newHost() {

           $("#dlg").dialog("open").dialog('setTitle','New Host');;

           $("#fm").form("clear");
       }
       /*********添加主持人具体操作********/
       function  saveHost() {

           //获得所有表单内容
           var  val =$("#fm").serialize();

           $.post("HostController/saveHost",val,function (result) {

                 if(result){
                     //关闭当前的对话框
                     $("#dlg").dialog("close");
                     //重新加载数据网格
                     $("#dg").datagrid("reload");
                 }

           })


       }

        var  s="";
       /***********批量修改权限的操作***************/
       function BPowerUpdate() {
             //【A】获得所有选中行的hpid

               //获得所有选中行的对象  返回的是一个数组
             var   sel= $("#dg").datagrid("getSelections");

             if(sel==null){
                 $.messager.alert("提示","请至少选中一行数据")
             }else if(sel.length==1){

                 console.log(sel);
                 //单个权限的设置

                 $("#power_dlg").dialog("open");

                 $("#power_fm").form("load",sel[0].hostPower);
                 //把hpid赋值给s
                 s=sel[0].hostPower.hpid;

             }else{
                 //通过数据的遍历取出每一个hpid
                 for(var  i  in  sel){
                      if(s!=""){s+=","} ;
                      s+=sel[i].hostPower.hpid;
                  }
                 //【B】使弹框展现
                 $("#power_dlg").dialog("open");

                 $("#power_fm").form("clear");
             }
       }
       /************提交批量修改权限的表单***************/
       function savePower() {

           //获得表单数据
           var  val=$("#power_fm").serialize();

           //发送ajax请求批量修改表单  1,2,3,4,
           $.post("HostPowerController/changeHostPower?hpids="+s,val,function (result) {

                   if(result){
                       //关闭对话框
                       $("#power_dlg").dialog("close");

                       //重新加载数据网格
                       $("#dg").datagrid("reload");
                   }
                   //√把字符串中的hpid清空;
                   s="";
           })




           
       }

       var  statuss="";
       /************批量操作账号状态-弹框展示****************/
        function statusHost() {
           var   sel= $("#dg").datagrid("getSelections");

           if(sel==null){
               $.messager.alert("提示","请至少选中一行数据")
           }else {
               for(var  i  in  sel){
                   if(statuss!=""){statuss+=","} ;
                   statuss+=sel[i].hid;
               }
               //把权限的对话框打开
               $("#status_dlg").dialog("open");
               //清空表单内容
               $("#status_fm").form("clear");
           }

           console.log(statuss);
       }
       /*************批量修改账号状态*********/
       function  savestatus() {

            var  val =$("#status_fm").serialize();

            $.post("HostController/updateStatus?hids="+statuss,val,function (result) {

                if(result){
                    //关闭对话框
                    $("#status_dlg").dialog("close");

                    //加载表格数据
                    $("#dg").datagrid("reload");
                }
                //清空字符串
                statuss="";

            })

       }
       
    </script>

</head>
<body>

<div class="easyui-panel" style="width: 1100px;height: 600px" title="主持人管理" >

         <form id="fm2">
        <%--定义选择下拉框--%>
        <div style="width: 930px; height: 50px;border: 0px solid red;text-align: center;margin-top: 30px">
            <input name="hname" class="easyui-textbox"  style="width:90px" data-options="prompt:'姓名'">
            <select name="status" class="easyui-combobox"  style="width:110px" >
                <option value="">账号状态</option>
                <option value="正常">正常</option>
                <option value="禁用">禁用</option>
            </select>
            <select name="strong" class="easyui-combobox"  style="width:110px" >
                <option value="">权重排序</option>
                <option value="asc">升序</option>
                <option value="desc">降序</option>

            </select>
            <select name="hostPower.hpstart" class="easyui-combobox"  style="width:110px" >
                <option value="">星推荐</option>
                <option value="是">是</option>
                <option value="否">否</option>
            </select>
            <select name="hostPower.hpdiscount" class="easyui-combobox"  style="width:110px;" >
                <option value="">折扣</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>

            </select>
             &nbsp;&nbsp;&nbsp;&nbsp;
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search"  onclick="hostFindMore()">查询</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok"  onclick="destroyUser()">导出</a>
        </div>
    </form>
        <%--定义数据网格--%>
         <div style="margin-left: 60px">
                <table id="dg" style="width: 930px;" title="查询结果"></table>
            </div>
        <%--定义工具栏--%>
        <div id="toolbar">
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add"  onclick="newHost()">添加主持人</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit"  onclick="BPowerUpdate()">权限设置</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove"  onclick="statusHost()">账号权限</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok"  onclick="BPowerUpdate()">批量操作</a>
        </div>

       <%--添加主持人弹框--%>
    <div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
         closed="true" buttons="#dlg-buttons">
        <div class="ftitle">Host Information</div>
        <form id="fm" method="post">
            <div class="fitem" style="margin-top: 20px">
                <input name="hname" data-options="label:'用户名',width:'250px'" class="easyui-textbox" required="true">
            </div>
            <div class="fitem" style="margin-top: 10px">
                <input name="hpwd" data-options="label:'密码',width:'250px'" class="easyui-textbox" required="true">
            </div>
            <div class="fitem" style="margin-top: 10px">
                <input name="hphone" data-options="label:'手机号',width:'250px'" class="easyui-textbox" required="true">
            </div>

        </form>
    </div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveHost()">Save</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
    </div>

    <%--修改权限的弹框--%>
    <div id="power_dlg" class="easyui-dialog" style="width:550px;height:520px;padding:10px 20px"
         closed="true" buttons="#power_dlg-buttons">
        <div class="ftitle"><h3>权限操作</h3></div>
        <div style="margin-left: 40px">
            <form id="power_fm" method="post">
                <div class="fitem" style="margin-top: 20px">

                    星推荐:&nbsp;&nbsp;&nbsp;&nbsp;
                    <input class="easyui-radiobutton" name="hpstart" value="是" label="是">

                    <input class="easyui-radiobutton" name="hpstart" value="否" label="否">
                </div>
                <div class="fitem" style="margin-top: 10px">
                    推荐日期:&nbsp;&nbsp;
                     <input name="hpstartBeigindate" data-options="width:'170px'" class="easyui-textbox">-
                    <input name="hpstartEnddate" data-options="width:'170px'" class="easyui-textbox">
                </div>
                <div class="fitem" style="margin-top: 10px">
                    自填订单:&nbsp;&nbsp;&nbsp;
                    <input class="easyui-radiobutton" name="hpOrderPower" value="1" label="是">

                    <input class="easyui-radiobutton" name="hpOrderPower" value="0" label="否">
                 </div>
                <div class="fitem" style="margin-top: 20px">
                    推荐时间:&nbsp;&nbsp;&nbsp;
                    <input name="hpstartBegintime" data-options="width:'170px'" class="easyui-textbox">-
                    <input name="hpstartEndtime" data-options="width:'170px'" class="easyui-textbox">
                 </div>
                <div class="fitem" style="margin-top: 10px">
                    <input name="hpdiscount" data-options="label:'折&nbsp;&nbsp;&nbsp;&nbsp;扣:',width:'350px'" class="easyui-textbox" >
                </div>
                <div class="fitem" style="margin-top: 10px">
                    折扣日期:&nbsp;&nbsp;&nbsp;
                    <input name="hpDisStarttime" data-options="width:'170px'" class="easyui-textbox">-
                    <input name="hpDisEndtime" data-options="width:'170px'" class="easyui-textbox">
                </div>

                <div class="fitem" style="margin-top: 20px">
                    <input name="hpprice" data-options="label:'价&nbsp;&nbsp;&nbsp;&nbsp;格:',width:'350px'" class="easyui-textbox" >
                </div>
                <div class="fitem" style="margin-top: 10px">
                    <input name="hcosts" data-options="label:'管&nbsp;理&nbsp;费:',width:'350px'" class="easyui-textbox">
                </div>

            </form>
        </div>
    </div>
    <div id="power_dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="savePower()">Save</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
    </div>

    <%--主持人账号权限的设置--%>

    <div id="status_dlg" class="easyui-dialog" style="width:400px;height:200px;padding:10px 20px"
         closed="true" buttons="#status_dlg-buttons">
        <div class="ftitle"><h3>账号权限操作</h3></div>
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


</div>
</body>
</html>
