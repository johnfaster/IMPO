<%--
  Created by IntelliJ IDEA.
  User: pxmwcwj
  Date: 2019/5/4
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/rest/receBzUser.do" method="post">
    姓名:<input name="user.username" value="${user.username}" type="text" id="username">
    生日:<input name="user.birthday" value="${user.birthday}" type="text" id="birthday">
    性别:<input name="user.sex" value="${user.sex}" type="text" id="sex">
    地址:<input name="user.address" value="${user.address}" type="text" id="address">
    <input type="submit" value="包装类型提交">
</form>
</body>
</html>
