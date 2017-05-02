function comment(element) {
    var photoId = element.id;
    $.ajax({
        url: '/comment',
        type: 'GET',
        data: {'photoId': photoId, 'text': document.getElementById(photoId + 'textId').value},
        success: function (response) {
            $(document).ready(function () {
                var result = '';
                for (var i = 0; i < response.length; i++) {
                    var temp = response[i].split('|');
                    result = result + '<div class="div-comment"><p class="comment-nickname">' + temp[0] + '</p><p class="comment-text">' + temp[1] + '</p> </div>';
                }
                document.getElementById(photoId + 'comments').innerHTML = result;
                document.getElementById(photoId + 'textId').value = '';
            });

        }
    });

}