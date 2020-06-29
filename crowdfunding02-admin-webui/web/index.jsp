<%--
  Created by IntelliJ IDEA.
  User: 吕航
  Date: 2020/6/29
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <%-- http://localhost:8080/crowdfunding/test/ssm.html --%>
    <base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
    <script src="jquery/jquery-3.3.1.min.js"></script>
    <script>
        $(function () {
            $("#btnOne").click(function () {
                $.ajax({
                    type: "post",
                    url: "send/array.html",
                    data: {
                        "array": [3, 5, 8]
                    },
                    dataType: "text",
                    success: function (result) {
                        alert(result);
                    },
                    error: function (result) {
                        alert(result);
                    }
                });
            });
        });
    </script>
</head>
<body>
    <a href="test/ssm.html">测试SSM整合环境</a>
    <br>
    <button id="btnOne">Send Array One</button>
</body>
</html>
