<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일을 올려주세요.</title>
</head>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">
	window.onload= function() {
		$("#image").hide();
	}
	
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e){
				$("#image").attr("src",e.target.result).width(99).height(99);
			}
			reader.readAsDataURL(input.files[0]);
			$("#image").show();
		}
	}
</script>
<body>
<h1>파일을 올려주세요!</h1>
<form action="./insert.do" method="post" enctype="multipart/form-data">
	<input multiple="multiple" type="file" name="file" id="imgInput" onchange="readURL(this)"><br>
	<div style="border: 1px black solid; width: 100px; height: 100px;">
		<img src="#" id="image">
	</div>
	<input type="submit" value="완료">
</form>
</body>
</html>