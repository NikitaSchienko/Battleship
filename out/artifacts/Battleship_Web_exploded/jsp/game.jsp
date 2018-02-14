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
    <script type="text/javascript" src="js/javascript.js"></script>
</head>
<body>
<h1>Морской бой</h1>
<div id="tableContainer"></div>
<input type="button" name="action" onclick="actionClick()" id="1" value="Кнопка 1"/>
<input type="button" name="action" onclick="actionClick()" id="2" value="Кнопка 2"/>
    <input type="submit">
<strong>Ответ сервлета </strong>:
<span id="ajaxUserServletResponse"></span>
</body>
</html>
<%!
    String getField(ShipGeneration shipGeneration)
    {

        int[][] ships = shipGeneration.getShips();

        String table = "<table>\n";
        for (int i = 0; i < 10; i++)
        {
            table = table + "<tr>\n";
            for (int j = 0; j < 10; j++)
            {
                switch (ships[i][j])
                {
                    case 0:
                    {
                        table = table + "<td class=\"td-color-blue\" onClick=\"cleanCell(this)\"></td>\n";
                    }
                    break;
                    case 1:
                    {
                        table = table + "<td class=\"td-color-gray\" onClick=\"cleanCell(this)\"><input type=\"submit\" name=\"action\" value=\"0\"></td>\n";
                    }
                    break;
                    case 2:
                    {
                        table = table + "<td class=\"td-color-red\" onClick=\"cleanCell(this)\"><input type=\"submit\" name=\"action\" value=\"0\"></td>\n";
                    }
                    break;
                }

            }
            table = table + "</tr>\n";
        }
        table = table + "</table>\n";
        return table;
    }
%>