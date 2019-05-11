<%--
  Created by IntelliJ IDEA.
  User: pxmwcwj
  Date: 2019/5/4
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Title</title>
<link rel="stylesheet" href="../bootstrap-3.3.7-dist/css/bootstrap.min.css">
</head>
<body>
<table class="table" border="1" style="color:blue;position: absolute;top: 45%;right: 45%;line-height: 30px;background-color: antiquewhite" cellpadding="0" cellspacing="0">
    <tr>
        <td>姓名</td>
        <td>生日</td>
        <td>性别</td>
        <td>地址</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${userList }" var="user">
        <tr>
            <td>${user.username}</td>
            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${user.birthday}"/></td>
            <td>${user.sex}</td>
            <td>${user.address}</td>
            <td><a href="${pageContext.request.contextPath}/rest/updateById.do?id=${user.id}">修改</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
