<%@page pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
    <head>
        <base href="<%=basePath%>">
        <meta charset="UTF-8">
        <title>artProject</title>
    </head>
<body>
<form action="${pageContext.request.contextPath}/checkLogin" method="post">
    <p>
        <label>username:<input name="username"></label>
    </p>
    <p>
        <label>password:<input name="password"></label>
    </p>
    <p>
        <button type="submit">Login</button>
    </p>
</body>
</html>
