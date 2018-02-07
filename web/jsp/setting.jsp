<%@ page import="panel.ShipGeneration" %><%--
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
    <link href="css/style.css" rel="stylesheet">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="js/javascript.js"></script>
</head>
<body>
<h1>Морской бой</h1>
<%= getField() %>
<form action="setting.jsp" method="GET">
    <div>
        <span>Введите кол-во вражеских кораблей</span>
        <input type="number" max="100" min="0">
        <input type="submit">Создать</input>
    </div>
</form>
</body>
</html>
<%!
    String getField()
    {
        ShipGeneration shipGeneration = new ShipGeneration(20);

        int[][] ships = shipGeneration.getShips();

        String table = "<table>\n";
        for (int i = 0; i < 10; i++)
        {
            table = table + "<tr>\n";
            for (int j = 0; j < 10; j++)
            {
                if(ships[i][j] == 1)
                {
                    table = table + "<td onClick=\"cleanCell(this)\" value=\"1\"><button class=\"button-blue\"> </button></td>\n";
                    System.out.println("Отработал");
                }
                else
                {
                    table = table + "<td onClick=\"cleanCell(this)\" value=\"0\"></td>\n";
                }
            }
            table = table + "</tr>\n";
        }
        table = table + "</table>\n";
        return table;
    }
%>