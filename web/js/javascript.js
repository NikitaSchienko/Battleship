// вызов функции по завершению загрузки страницы
function actionClick()
{
        $.ajax({
            url : 'game',     // URL - сервлет
            type : 'get',
            success : function(response)
            {
                // обработка ответа от сервера
                $('#tableContainer').html(response);
            }
        });
}

function actionClick1(td)
{
    $.ajax({
        url : 'game',     // URL - сервлет
        type : 'post',
        data :
            {                 // передаваемые сервлету данные
                idCell : td.id
            },
        success : function(response)
        {
            // обработка ответа от сервера
            $('#tableContainer').html(response);
        }
    });
}

$(function() {
    if(document.getElementById("fixed")!=null)
    {
        $('#myModal').on('shown.bs.modal', function () {
            $('#myInput').focus()
        })
    }
});


