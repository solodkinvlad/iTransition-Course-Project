function comment(element) {
    var photoId = element.id;
    $.ajax({
        url: '/comment',
        type: 'GET',
        data: {'photoId': photoId, 'text': document.getElementById(photoId + 'textId').value},
        success: function (response) {
            $(document).ready(function () {
                alert(response);
                var result = '';
                for (var i = 0; i < response.length; i++) {
                    alert(response[i]);
                    var temp = response[i].split(' ');
                    result = result + '<div> <p>' + temp[0] + '</p> <p>' + temp[1] + '</p> </div>';
                }

                document.getElementById(photoId + 'comments').innerHTML = result;
                document.getElementById(photoId + 'textId').value = '';
            });

        }
    });

}