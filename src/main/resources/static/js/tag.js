function show_add_tag(element) {
    var photoId = element.id;
    $('#' + photoId + 'div-add-tag').css("display" , "block");
}

function addTag(element) {
    var photoId = element.id.toString();
    $.ajax({
        url: '/addTag',
        type: 'GET',
        data: {'photoId': photoId, 'text': document.getElementById(photoId + 'inputTag').value},
        success: function (response) {
            $(document).ready(function () {
                $('#' + photoId + 'div-add-tag').css("display" , "none");
                document.getElementById('tagContext' + photoId.toString()).innerHTML = '<p style="display: inline">'+response+'</p>';
                document.getElementById(photoId + 'inputTag').value = '';
            });

        }
    });

}