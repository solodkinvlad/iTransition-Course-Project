$(document).ready(function() {
    $('#dropContainer').ondragover = $('#dropContainer').ondragenter = function (evt) {
        evt.preventDefault();
    };

    $('#dropContainer').ondrop = function (evt) {
        evt.preventDefault();
        $('#fileUpload').files.add(evt.dataTransfer.files);
    };
});