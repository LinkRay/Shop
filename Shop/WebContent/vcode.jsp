<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<img alt="验证码" src="${pageContext.request.contextPath}/verificationCode" title="看不清楚，换一张" onclick="changeImag(this)">
</body>
<script type="text/javascript">
function changeImag(obj){
  obj.src="${pageContext.request.contextPath}/verificationCode?i="+Math.random();
 }
</script>

</html>