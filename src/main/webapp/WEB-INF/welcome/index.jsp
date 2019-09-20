<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>

<title>百度一下</title>
</head>
<body>
	<div class="login_kuang" id="login_kuang" align="center" >
        <h3>登录<span class="login_close" id="login_close"><i class="iconfont"><span style="color: rgb(57, 51, 255); font-family: Monaco; font-size: 11px;"></span></i></span></h3>
        <div class="loginContent">
            
                <p id="info_error"></p>
                <input type="text" placeholder="用户名" id="login_user" name="login_user" class="login_user">
                <p id="user_error"></p>
                <input type="password" placeholder="密码" id="login_pass" name="login_pass" class="login_pass">
                <p id="pass_error"></p>
                <label for="rementPass"><input type="checkbox" checked id="rementPass" class="rementPass"> 记住密码</label>
            <input type="button" value="登录" class="login_btn" id="login_submit2">
        </div>
        <p class="login_botP">还没有账号？<a href="page/register.html" id="hurreyUpRge" class="hurreyUpRge">立即注册！</a></p>
    </div>
</body>



<script type="text/javascript">
var storage=window.localStorage;

//	$(function(){ 
//		$.ajax({
//			headers:{
//	  			"user-token":storage["usertoken"]
//	  		},
//	  		type:"post",
//			  url:"<%=request.getContextPath()%>/user/inint",
//			  data:{},
//			  dataType:"json",
//			  success:function(data){
//				  console.log(data);
//			  }
//		});
//	});
	

$("#login_submit2").click(function(){
	var username=$("#login_user").val();
	var pwd=$("#login_pass").val();
	var checked=$("#rementPass").is(':checked');
	
	  $.ajax({
	  			type:"post",
			  url:"<%=request.getContextPath()%>/user/login.do",
			  data:{"username":username,"pwd":pwd,"checked":checked},
			  dataType:"json",
			  success:function(data){
				 if(data.retcode=='00'){
					 if(checked='true'){
						 storage.setItem("usertoken",data.token);
					 }
					 window.location.href("main.jsp?token="+storage.getKey("usertoken"));
				 }else{
					 alert(data.retmessage);
				 }
				  console.log(data);
			  }
	  });	  
			  
	  	 
	});
</script>

</html>
