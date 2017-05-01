$(document).ready(function () {
    $('button#upload-new-avatar').click(function (event) {
        event.preventDefault();
        $('#overlay').fadeIn(400,
            function () {
                $('#modal-avatar-upload')
                    .css('display', 'block')
                    .animate({opacity: 1, top: '50%'}, 200);
            });
    });
    $('#overlay').click( function(){
        $('#modal-avatar-upload')
            .animate({opacity: 0, top: '45%'}, 200,
                function(){ // пoсле aнимaции
                    $(this).css('display', 'none');
                    $('#overlay').fadeOut(400);
                }
            );
    });
});
