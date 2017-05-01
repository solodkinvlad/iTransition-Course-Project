function comment(element) {
    var photoId = element.id;
    $.ajax({
        url: '/comment',
        type: 'GET',
        data: {'photoId': photoId, 'text': document.getElementById(photoId + 'textId').value},
        success: function (response) {
             $(document).ready(function () {
             document.getElementById(photoId + 'comments').innerHTML = '';
             var i = 0;
             var str = '';
             while (i < response.length - 1) {
             var nickname = response[i];
             var comment = response[i + 1];
             str = str + '<div> <p>' + nickname + '</p> <p>' + comment + '</p> </div>';
             i = i + 2;
             }

             document.getElementById(photoId + 'comments').innerHTML = str;
             document.getElementById(photoId + 'textId').value = '';
             });

        }
    });

}