<%--
  Created by IntelliJ IDEA.
  User: wangxianchao
  Date: 2018/7/12
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>loginPage</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/checkLogin" method="get">
    <p>
        <label>username:<input name="username"></label>
    </p>

    <p>
        <label>password:<input name="password"></label>
    </p>
    <p>
        <button type="submit">Login</button>
    </p>
</form>

</body>
</html>
