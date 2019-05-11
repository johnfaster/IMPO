<%--
  Created by IntelliJ IDEA.
  User: pxmwcwj
  Date: 2019/5/3
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<hr size="12" color="blue"/>
<form action="${pageContext.request.contextPath}/receUser.do" method="post">
    姓名:<input name="username" type="text" id="username">
    生日:<input name="birthday" type="text" id="birthday">
    性别:<input name="sex" type="text" id="sex">
    地址:<input name="address" type="text" id="address">
    <input type="submit" value="提交">
</form>
<form action="${pageContext.request.contextPath}/receBzUser.do" method="post">
    姓名:<input name="user.username" type="text" id="username">
    生日:<input name="user.birthday" type="text" id="birthday">
    性别:<input name="user.sex" type="text" id="sex">
    地址:<input name="user.address" type="text" id="address">
    <input type="submit" value="包装类型提交">
</form>
<form action="${pageContext.request.contextPath}/receList.do" method="post">
    姓名:<input name="list[0].username" type="text" id="username">
    生日:<input name="list[0].birthday" type="text" id="birthday">
    性别:<input name="list[0].sex" type="text" id="sex">
    地址:<input name="list[0].address" type="text" id="address">
    <br/>
    姓名:<input name="list[1].username" type="text" id="username">
    生日:<input name="list[1].birthday" type="text" id="birthday">
    性别:<input name="list[1].sex" type="text" id="sex">
    地址:<input name="list[1].address" type="text" id="address">
    <input type="submit" value="list类型提交">
</form>
<form action="${pageContext.request.contextPath}/receMap.do" method="post">
    姓名:<input name="map['username']" type="text" id="username">
    生日:<input name="map['birthday']" type="text" id="birthday">
    性别:<input name="map['sex']" type="text" id="sex">
    地址:<input name="map['address']" type="text" id="address">
    <input type="submit" value="map类型提交">
</form>
</body>
</html>
