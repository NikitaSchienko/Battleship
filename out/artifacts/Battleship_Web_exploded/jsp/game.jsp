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
<%!ShipGeneration shipGeneration = new ShipGeneration(20,10);%>
    <%= getField(shipGeneration) %>
<p />
Ваше имя :
<input type="button" name="action" onclick="actionClick(this)" id="1" value="Кнопка 1"/><br />
<input type="button" name="action" onclick="actionClick(this)" id="2" value="Кнопка 2"/><br />
<span style="font-style:italic; font-size:75%">
                сервлет ответит после потери полем курсора</span>
<p />
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
                if(ships[i][j]==0)
                {
                    table = table + "<td onClick=\"cleanCell(this)\"><input type=\"submit\" name=\"action\" value=\"0\"></td>\n";
                }
                else
                {
                    table = table + "<td onClick=\"cleanCell(this)\"><input type=\"submit\" name=\"action\" value=\"1\"></td>\n";
                }

            }
            table = table + "</tr>\n";
        }
        table = table + "</table>\n";
        return table;
    }
%>