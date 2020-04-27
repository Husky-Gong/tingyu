
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User login</title>
    <base href="<%=request.getContextPath()+"/"%>">

    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyui/themes/demo.css">

    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    
    <script type="text/javascript">

        /************管理员登录操作**********/
        function adminLogin() {

            //获得所有表单内容
            var val =$("form").serialize();

            //发送ajax请求
            $.post("AdminController/adminLogin",val,function (result) {

                  if(result){
                      window.location.href="main.jsp"
                  }else{
                      $.messager.alert("提示","登录失败","error");
                  }
            })
        }
          
        
        
    </script>
    

</head>
<body>

 <div style="margin-top: 206px;margin-left: 565px">
     <div id="p" class="easyui-panel" title="登录"
          style="width:400px;height:300px;padding:10px;background:#fafafa;"
          data-options="iconCls:'icon-save',collapsible:true">

         <div style="margin-left: 57px;margin-top: 60px">

             <form>
                 <div style="margin-bottom:25px">
                     <input name="aname" class="easyui-textbox" required="true" label="用户名:" style="width:75%">
                 </div>
                 <div style="margin-bottom:35px">
                     <input name="apwd" class="easyui-passwordbox" required="true" label="密&nbsp;&nbsp;&nbsp;码:" style="width:75%">
                 </div>

                 <div style="text-align: center">
                     <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="adminLogin()" style="width:90px;margin-right: 50px">Login</a>
                     <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"  style="width:90px">Cancel</a>
                 </div>
             </form>


         </div>
         
     </div>
 </div>





</body>
</html>
