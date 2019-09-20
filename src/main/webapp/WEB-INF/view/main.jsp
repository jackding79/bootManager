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
		<p>欢迎进入主页</p>
		<p>
			<input type="button" value="点击1" id="button1" onclick="fun1()"/>
		</p>
</body>
</html>
<script>
var storage=window.localStorage;

	function fun1(){
		$.ajax({
			header:{
				usertoken:storage.getItem("usertoken")
			},
  			type:"post",
		  url:"<%=request.getContextPath()%>/user/fun1.do",
		  data:{},
		  dataType:"json",
		  success:function(data){
			console.log("点击成功");
		  }
  });	  
	}
</script>