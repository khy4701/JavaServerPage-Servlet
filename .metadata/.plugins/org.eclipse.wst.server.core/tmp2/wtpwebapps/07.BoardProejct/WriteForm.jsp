<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 인코딩을 시키지 않는 방법 :  enctype="multipart/form-data"  -->
<!-- 인코딩을 시키지 않는 이유 : 파일을 업로드 할 경우에는 인코딩을 해서는 안된다. -->
<!-- 인코딩을 시키지 않으면 request.getParameter()를 사용할 수 없다.  -->


<form action = "write.kitri" method="post" enctype="multipart/form-data">

<fieldset>
	<legend>게시판 글쓰기</legend>
	<ul>
		<li> 아이디: ${ sessionScope.id } <input type="hidden" name="id" value = "${ sessionScope.id }"></li>
		<li> 제목 : <input type="text" name="title"></li>
		<li> 내용  <br> <textarea rows="10" cols="30" name="content"></textarea></li>
		<li> 파일 첨부: <input type="file" name="fileName"></li>
	</ul>	
	<input type ="submit" value="작성하기">
</fieldset>
</form>
</body>
</html>