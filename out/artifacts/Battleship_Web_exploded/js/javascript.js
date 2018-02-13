// вызов функции по завершению загрузки страницы
function actionClick(component)
{
        $.ajax({
            url : 'game',     // URL - сервлет
            data :
                {                 // передаваемые сервлету данные
                    userName : component.id
                },
            success : function(response)
            {
                // обработка ответа от сервера
                $('#ajaxUserServletResponse').text(response);
            }
        });
}