/**
 * Created by eabil on 29.04.2017.
 */
function comment(element) {
    var text = $('#textId').val();
    var photoId = element.id;
    $.ajax({
        url: '/comment',
        type: 'GET',
        data: {'photoId' : photoId, 'text' : text},
        success: function (response) {
            $(document).ready(function(){
                document.getElementById('comments').innerHTML = '';
                var i=0;
                var str = '';
                while (i < response.length - 1) {
                    var nickname = response[i];
                    var comment = response[i+1];
                    str = str +  '<div> <p>'+nickname+'</p> <p>'+comment+'</p> </div>';
                    i = i + 2;
                }

                document.getElementById('comments').innerHTML = str;
                document.getElementById('textId').value='';
            });

        }
    });

}