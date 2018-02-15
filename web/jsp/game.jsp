<%@ page import="server.ShipGeneration" %><%--
  Created by IntelliJ IDEA.
  User: nish0817
  Date: 06.02.2018
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="../css/style.css" rel="stylesheet">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="../js/javascript.js"></script>
</head>
<body onload="actionClick()">
<h1>Морской бой</h1>
<div id="tableContainer"></div>
<input type="button" name="action" onclick="actionClick()" id="1" value="Сбросить игру"/>
</body>
</html>
