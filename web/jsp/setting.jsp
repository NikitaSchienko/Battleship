<%--
  Created by IntelliJ IDEA.
  User: nish0817
  Date: 08.02.2018
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/setting" method="GET">
    <div>
        <h1>Параметры игры</h1>
    </div>
    <div>
        <span>Введите размер игравого поля</span>
        <input type="number" max="100" min="0">
        <span>Введите кол-во вражеских кораблей</span>
        <input type="number" max="100" min="0">
        <input type="submit">Создать</input>
    </div>
</form>
</body>
</html>
