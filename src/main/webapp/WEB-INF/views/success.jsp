<%--
  Created by IntelliJ IDEA.
  User: wangxianchao
  Date: 2018/9/20
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div>
    <strong> welcome,${sessionScope.user.username}! </strong>
</div>
this is success page!

<a href="/artProject/user/anotherpage">点我跳到另一个页面</a>

<form action="/artProject/user/outLogin">
    <table>
        <tr>
            <td><input type="submit" value="退出登录"></td>
        </tr>
    </table>
</form>
</body>
</html>
