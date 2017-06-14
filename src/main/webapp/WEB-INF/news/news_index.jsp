<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="../js/wangEditor/lib/jquery-1.10.2.min.js"></script>
<title>新闻中心</title>
</head>
<body>
	<ul id="list">
	</ul>
<script type="text/javascript">  
     $(function () {  
         $.ajax({  
             url: '/getAllNews',  
             type: 'GET',  
             dataType: 'json',  
             timeout: 1000,  
             cache: false,  
             beforeSend: LoadFunction, //加载执行方法    
             error: erryFunction,  //错误执行方法    
             success: succFunction //成功执行方法    
         })  
         function LoadFunction() {  
             $("#list").html('加载中...');  
         }  
         function erryFunction() {  
             alert("error");  
         }  
         function succFunction(tt) {  
             $("#list").html('');  
  
             //eval将字符串转成对象数组  
             //var json = { "id": "10086", "uname": "zhangsan", "email": "zhangsan@qq.com" };  
             //json = eval(json);  
             //alert("===json:id=" + json.id + ",uname=" + json.uname + ",email=" + json.email);  
  
             var json = eval(tt); //数组         
             $.each(json, function (index, item) {  
                 //循环获取数据    
                 var name = json[index].title;  
                 var id = json[index].id;
                 $("#list").html($("#list").html() + "<br><a href=\"/getNews?id="+id+"\" a>" + name + "</a><br/>");  
             });  
         }  
     });  
    </script>  
</body>
</html>