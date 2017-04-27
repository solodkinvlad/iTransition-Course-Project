$(document).ready(function () {

    $('.form-photo').submit( function (event) {
        event.preventDefault();
        like_photo($(this).attr('id'));
    })

    function like_photo(form_id) {
        var $form = $(form_id);
        $.ajax({
            url: $form.attr('action'),
            type: 'post',
            data: $form.serialize(),
            contentType: "application/json; charset=utf-8",
            success: function(response) {
                $form.replaceWith(response);
            }
        });
    }

});