<%--
  Created by IntelliJ IDEA.
  User: 吕航
  Date: 2020/6/29
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>出错了</title>
</head>
<body>
    <h3>系统信息页面</h3>
    ${requestScope.exception.message}
</body>
</html>
