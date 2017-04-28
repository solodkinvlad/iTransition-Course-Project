$(document).ready(function () {

    $('.form-photo').submit( function (event) {
        event.preventDefault();
        like_photo($(this).attr('id'));
    })

    function like_photo(form_id) {
        var $form = $(form_id);
        $.ajax({
            url: $form.attr('action'),
            type: 'GET',
            data: $form.serialize(),
            dataType: 'json',
            contentType: 'application/json',
            mimeType: 'application/json',
            success: function(response) {
                $form.replaceWith(response);
            }
        });
    }

});