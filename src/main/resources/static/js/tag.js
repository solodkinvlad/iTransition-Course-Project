function show_add_tag(element) {
    var photoId = element.id;
    $('#' + photoId + 'div-add-tag').css("display" , "inline-block");
    $('#' + photoId + 'div-add-tag').css("position" , "static");
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
                $('#' + photoId + 'div-add-tag').css("position" , "absolute");
                document.getElementById('tagContext' + photoId.toString()).innerHTML = '<p style="display: inline">'+response+'</p>';
                document.getElementById(photoId + 'inputTag').value = '';
            });

        }
    });

}