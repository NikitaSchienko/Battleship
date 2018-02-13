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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
</head>
<body>
<form  action="/game" method="GET">
    <div class="container col-6">
        <div class="text-center">
            <h1>Параметры игры</h1>
        </div>
        <div class="form-group">
            <label for="example-number-input" class="col col-form-label">Введите размер игравого поля</label>
            <div class="col">
                <input class="form-control" type="number" value="10" id="example-number-input" max="100" min="0">
            </div>
        </div>
        <div class="form-group">
            <label for="example-number-input" class="col col-form-label" max="100" min="0">Введите кол-во вражеских кораблей</label>
            <div class="col">
                <input class="form-control" type="number" value="15" id="example-number-input">
            </div>
        </div>
        <div class="text-center">
            <button type="submit" class="btn btn-primary col-3">Играть</button>
        </div>
    </div>
</form>
</body>
</html>
