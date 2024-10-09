<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/admin/video/update" method="post" enctype = "multipart/form-data">
		<label for="videoid">Video ID</label><br>
  		<input type="text" id="videoid" name="videoid" value = "${video.videoId }" ><br>
  		<label for="title">Video title</label><br>
  		<input type="text" id="videoname" name="videoname" value = "${video.title}" ><br>
  		<label for="images">Images</label><br>
  		
  		
  		<c:if test="${video.images.substring(0,5) != 'https'}">
			<c:url value = "/image?fname=${video.images }" var="imgUrl" ></c:url>
		</c:if>
			
		<c:if test="${video.images.substring(0,5) == 'https'}">
			<c:url value = "${video.images }" var="imgUrl" ></c:url>
		</c:if>
			
		<img id = "imagess" height="150" width="200" src="${imgUrl}" /><br>
		<input type="file"  onchange="chooseFile(this)" id="images" name="images"><br><br>
  		
  		<label for="lname">Status</label><br>
  		<input type="text" id="status" name="status" value = "${video.active }"><br><br>
  		
  		<select id="mycate" name="mycate" required>
            <c:forEach var="category" items="${listcate}">
                <option value="${category.categoryId}">${category.categoryname}</option>
            </c:forEach>
        </select>
        <br><br>
        
  		<input type="submit" value="Update">
	</form> 
	
	
	<script src="${URL}assets/global/plugins/jquery.min.js" type="text/javascript"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script>
	function chooseFile(fileInput) {
        console.log("File input change detected");
        if (fileInput.files && fileInput.files[0]) {
            var reader = new FileReader();
            reader.onload = function(e) {
                var imgElement = $('#imagess');
                if (imgElement.length > 0) {
                    imgElement.attr('src', e.target.result);
                    console.log("Image updated successfully");
                } else {
                    console.log("Image element not found");
                }
            }
            reader.readAsDataURL(fileInput.files[0]);
        }
    }
	</script>
</body>
</html>