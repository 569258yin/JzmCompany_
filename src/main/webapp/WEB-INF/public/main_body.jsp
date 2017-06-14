<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="../css/wangEditor/css/wangEditor.min.css">
<!--引入jquery和wangEditor.js-->
<!--注意：javascript必须放在body最后，否则可能会出现问题-->
<script type="text/javascript"
	src="../js/lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="../js/wangEditor/wangEditor.min.js"></script>
</head>
<body>
	
	!--用父容器来控制宽度-->
	<div style="width: 75%">

		<div id="div1" style="height: 400px; max-height: 500px;">
			<p>请输入内容...</p>
		</div>
	</div>
	<table>
		<tr>
			<td><button id="btn1">获取内容</button></td>
			<td><button id="btn2">情空内容</button></td>
		</tr>
	</table>


	<!--这里引用jquery和wangEditor.js-->
	<script type="text/javascript">
		var editor = new wangEditor('div1');
		// 上传图片（举例）
	    editor.config.uploadImgUrl = '/file/imgUpload';
	    editor.config.uploadImgFileName = 'imageUploadName'
	    // 配置自定义参数（举例）
	    //editor.config.uploadParams = {
	    //   token: 'abcdefg',
	    //   user: 'wangfupeng1988'
	    //};

	    // 设置 headers（举例）
	    //editor.config.uploadHeaders = {
	    //    'Accept' : 'text/x-json'
	    //};

	    // 隐藏掉插入网络图片功能。该配置，只有在你正确配置了图片上传功能之后才可用。
	    editor.config.hideLinkImg = false;

		
		editor.create();

		$('#btn1').click(function() {
			// 获取编辑器区域完整html代码
			var html = editor.$txt.html();
			
			// 获取编辑器纯文本内容
			//var text = editor.$txt.text();

			// 获取编辑区域的所有图片
			//var imgs = editor.$txt.find('img');

			// 获取格式化后的纯文本
			//var formatText = editor.$txt.formatText();
			//console.log(html);
			$.ajax({
				type:"POST",
				url:"/sendNews",
				data:{text:html},
				dataType:"json",
				cache:false,
				success:function(data){
					alter(data);
				}
			});
		});

		$('#btn2').click(function() {
			// 清空内容。
			// 不能传入空字符串，而必须传入如下参数
			editor.$txt.html('<p><br></p>');
		});
	</script>

</body>
</html>