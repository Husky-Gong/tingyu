<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2020/4/21
  Time: 14:16
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

    <style type="text/css">

           #tc{
              color: grey;

              text-decoration: none;
           }

           #tc:hover{
              color: #ffffff;
          }

    </style>

    <script type="text/javascript">

           $(function () {

               $('#tt').tree({
                   onClick: function(node){

                       //判断当前点击的菜单是否是一级菜单
                       if(node.url==null||node.url==""){
                            return;
                       }

                      var flag= $("#tab").tabs("exists",node.text);
                      if(flag){
                          //当前选项卡存在
                          $("#tab").tabs("select",node.text);
                      }else{
                          //当前选项卡不存在
                          $('#tab').tabs('add',{
                              title:node.text,
                              content:'<iframe src="'+node.url+'" width="100%" height="100%"></iframe>',
                              closable:true
                          });
                      }



                   }});

           })

    </script>

</head>
<body class="easyui-layout">


    <div data-options="region:'north',split:true" style="height:100px;background-image: url('../../../../../Desktop/tingyu/web/imgs/bg.png')">

         <img src="../../../../../Desktop/tingyu/web/imgs/logo.png" width="240px">

        <span style="color: #f3f3f3;font-size: 30px;font-style: italic;margin-left: 232px;">Ting 域 主 持 人 后 台 管 理 系 统</span>

        <div style="color: grey;float: right;margin-right: 30px;margin-top: 70px">
            您好 ${sessionScope.admin.aname}  |  <a id="tc" href="AdminController/loginOut" >退出</a>
        </div>
    </div>
    <div data-options="region:'south',split:true" style="height:50px;"></div>
    <div data-options="region:'east',title:'备忘录',split:true" style="width:200px;">

        <div style="height: 180px" class="easyui-panel" title="标题一">
            <h4>A、成功很难，失败很简单</h4>
            <h4>B、从哪里跌倒就在哪里趴下</h4>
            <h4>C、每天刷抖音真的很爽</h4>
        </div>

        <div style="height: 180px" class="easyui-panel" title="标题二">
            <h4>A、今日和高总谈分校事宜</h4>
            <h4>B、今日会见张经理</h4>
            <h4>C、今日和开发商谈拆迁事宜</h4>
        </div>
        <div class="easyui-calendar" style="width: 193px;height: 190px"></div>

    </div>
    <div data-options="region:'west',title:'系统菜单',split:true" style="width:200px;">

        <ul id="tt" class="easyui-tree" data-options="url:'MenuController/findMoreMenus'"></ul>

    </div>
    <div data-options="region:'center'" style="background:#eee;">

        <div id="tab" class="easyui-tabs" data-options="fit:true">

        </div>


    </div>

</body>
</html>
