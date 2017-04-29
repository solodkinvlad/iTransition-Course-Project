/**
 * Created by eabil on 29.04.2017.
 */
function comment(element) {
    var text = $('#textId').val();
    var photoId = element.id;
    $.ajax({
        dataType: 'json',
        url: '/comment',
        type: 'GET',
        data: {'photoId' : photoId, 'text' : text},
        success: function (response) {
            $('#comments').innerHTML = "";
            for (var i in response) {
                var nickname = response[i].get("nickname");
                var comment = response[i].get("comment");
                $('#comments').append('<div align="center"> <p align="center" text="nickname"></p> <p align="center" text="comment"></p> </div>');
            }
        }
    });

}