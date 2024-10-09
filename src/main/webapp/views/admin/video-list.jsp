<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<style>
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
  background-color: #04AA6D;
  color: white;
}
</style>
</head>
<body>

<h2>Video List</h2>

<a href = "${pageContext.request.contextPath }/admin/video/add">Add</a>
<table border="1" width = "100%">
  <tr>
    <th>STT</th>
    <th>Images</th>
    <th>ID</th>
    <th>Video Title</th>
    <th>Category</th>
    <th>Status</th>
    <th>Action</th>
  </tr>
  
  <c:forEach items="${listvideo}" var="video" varStatus="STT" >
	<tr class="odd gradeX">
		<td>${STT.index+1 }</td>
		
		
		
		<td>
			<c:if test="${video.images.substring(0,5) != 'https'}">
				<c:url value = "/image?fname=${video.images }" var="imgUrl" ></c:url>
			</c:if>
			
			<c:if test="${video.images.substring(0,5) == 'https'}">
				<c:url value = "${video.images }" var="imgUrl" ></c:url>
			</c:if>
			
			<img height="150" width="200" src="${imgUrl}" />
		</td>
		
		<td>${video.videoId }</td>
		<td>${video.title }</td>
		<td>${video.category.categoryname }</td>
		<td>
			<c:if test= "${video.active == 1 }">
				<span>Active</span>
			</c:if>
			<c:if test= "${video.active != 1 }">
				<span>Inactive</span>
			</c:if>
		</td>
		<td><a 
			href="<c:url value='/admin/video/edit?id=${video.videoId }'/>"
			>Sửa</a>
 			<a 
 			href="<c:url value='/admin/video/delete?id=${video.videoId }'/>"
			>Xóa</a></td>
	</tr>
  </c:forEach>
  

</table>

</body>
</html>
    