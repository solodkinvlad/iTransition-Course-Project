$(document).ready(function () {
    $('button#upload-new-photos').click(function (event) {
        event.preventDefault();
        $('#overlay').fadeIn(400,
            function () {
                $('#modal-upload')
                    .css('display', 'block')
                    .animate({opacity: 1, top: '50%'}, 200);
            });
    });
    
    $('button#carousel-show').click(function (event) {
        event.preventDefault();
        $('#overlay').fadeIn(400,
            function () {
                $('#myCarousel')
                    .css('display', 'block')
                    .animate({opacity: 1}, 200);
            });
    })
    
    $('#overlay').click( function(){
        $('#modal-upload')
            .animate({opacity: 0, top: '45%'}, 200,
                function(){ // пoсле aнимaции
                    $(this).css('display', 'none');
                    $('#overlay').fadeOut(400);
                }
            );
        $('#myCarousel')
            .animate({opacity: 0}, 200,
                function(){ // пoсле aнимaции
                    $(this).css('display', 'none');
                    $('#overlay').fadeOut(400);
                }
            );
    });
});
