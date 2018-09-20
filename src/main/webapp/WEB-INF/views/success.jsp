<%--
  Created by IntelliJ IDEA.
  User: wangxianchao
  Date: 2018/9/20
  Time: 10:15
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
    <title>Title</title>
</head>
<body>

<div>
    <strong> welcome,${sessionScope.user.username}! </strong>
</div>
this is success page!

<a href="${pageContext.request.contextPath}/anotherpage">点我跳到另一个页面</a>

<form action="${pageContext.request.contextPath}/outLogin">
    <table>
        <tr>
            <td><input type="submit" value="退出登录"></td>
        </tr>
    </table>
</form>
</body>
</html>
