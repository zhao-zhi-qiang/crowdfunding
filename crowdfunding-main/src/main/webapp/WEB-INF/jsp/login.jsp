<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keys" content="">
    <meta name="author" content="">
    <link rel="stylesheet" href="${APP_PATH}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${APP_PATH}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${APP_PATH}/css/login.css">
    <style>

    </style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <div><a class="navbar-brand" href="index.html" style="font-size:32px;">尚筹网-创意产品众筹平台</a></div>
        </div>
    </div>
</nav>

<div class="container">

    <form action="${APP_PATH}/doLogin.do" method="post" class="form-signin" role="form" id="loginForm">
        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-log-in"></i> 用户登录</h2>
        <div class="form-group has-success has-feedback">
            <input type="text" class="form-control" id="loginacct" name="loginacct" placeholder="请输入登录账号" autofocus>
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <input type="password" class="form-control" id="userpswd"  name="userpswd" placeholder="请输入登录密码" style="margin-top:10px;">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <select class="form-control" name="type" id="type">
                <option value="member">会员</option>
                <option value="user">管理</option>
            </select>
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> 记住我
            </label>
            <br>
            <label>
                忘记密码
            </label>
            <label style="float:right">
                <a href="reg.html">我要注册</a>
            </label>
        </div>
        <a class="btn btn-lg btn-success btn-block" onclick="dologin()" > 登录</a>
    </form>
</div>
<script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
<script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
<%--引入弹窗组件--%>
<script src="${APP_PATH}/jquery/layer/layer.js"></script>
<script>
    function dologin() {

       // $("#loginForm").submit();

        // var type = $(":selected").val();
        // if ( type == "user" ) {
        //     window.location.href = "main.html";..
        // } else {
        //     window.location.href = "index.html";
        // }
        //-----------------------使用异步进行登录---------------
        //获取输入框的值
        var loginacct = $("#loginacct");
        var userpswd = $("#userpswd");
        var type = $("#type");
        console.dir(loginacct);
        // null 是java中对象为空的，在js空的字符串不能使用null判断
        if($.trim(loginacct.val()) === ""){

            //告诉用户用不满不能为空
            layer.msg("用户名不能为空", {time:1000, icon:5, shift:6}, function(){
                loginacct.focus();
                loginacct.val('');
            });
            return false;
        }

        if($.trim(userpswd.val()) === ""){

            layer.msg("密码不能为空", {time:1000, icon:5, shift:6}, function(){
                userpswd.focus();
                userpswd.val('');
            });
            return false;
        }
        var loadingIndex = -1;

        $.ajax({
            url:"${APP_PATH}/doLogin.do",
            type:"POST",
            data:{
                "loginacct":loginacct.val(),
                "userpswd":userpswd.val(),
                "type":type.val()
            },
            beforeSend:function(){
                return true;
            },
            success:function(param){
                loadingIndex = layer.msg('处理中', {icon: 16});
                //json字符串 转换为就送对象
              //console.log(JSON.parse(param));
              var object = JSON.parse(param);

              if(object.success){
                  layer.msg("验证成功！", {time:1000, icon:6, shift:6});
                window.location.href="${APP_PATH}/main.htm";
              }else{
                  layer.close(loadingIndex);
                  layer.msg("用户名或者密码错误", {time:1000, icon:5, shift:6});
              }
            },
            error:function(){

            }
        })
    }
</script>
</body>
</html>
