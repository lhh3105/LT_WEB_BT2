<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/admin/video/insert" method="post" enctype = "multipart/form-data">
		<label for="fname">Video ID</label><br>
  		<input type="text" id="videoid" name="videoid" ><br>
  		<label for="fname">Video name</label><br>
  		<input type="text" id="videoname" name="videoname" ><br>
  		<label for="lname">Images</label><br>
  		<img height = "150" width="200" src="" id = "imagess" />
  		<input type="file" onchange="chooseFile(this)" id="images" name="images"><br><br>
  		<label for="lname">Status</label><br>
  		<input type="text" id="status" name="status"><br><br>
  		
  		<label for="categories">Category: </label>
        <select id="mycate" name="mycate" required>
            <c:forEach var="category" items="${listcate}">
                <option value="${category.categoryId}">${category.categoryname}</option>
            </c:forEach>
        </select>
		<br><br>
  		
  		<input type="submit" value="Submit">
	</form> 
</body>
</html>