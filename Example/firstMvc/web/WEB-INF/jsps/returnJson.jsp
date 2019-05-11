<%--
  Created by IntelliJ IDEA.
  User: pxmwcwj
  Date: 2019/5/5
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
</head>
<body>
<script>
    //requestJson();
    returnPo();
    function requestJson() {
        var json = JSON.stringify({"username":"梅超风","sex":"男","address":"中关村"});
      $.ajax({
          type:'POST',
          url:"${pageContext.request.contextPath}/requestJson.do",
          contentType:'application/json;charset=utf-8',
          data:json,
          success:function (text) {
              alert(text.username);
          }
      })
    }
    function returnPo() {
        $.ajax({
            type:'post',
            url:'${pageContext.request.contextPath}/returnPo.do',
            data:'username=张三丰&address=武当山',
            success:function (data) {
                alert(data.username)
            }
        })
    }
</script>
</body>
</html>
