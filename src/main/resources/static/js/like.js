function like(element) {
    var photoId = element.id.toString();
    var likeName = photoId + "like";
    $.ajax({
        url: "/like",
        type: "GET",
        data: {'photoId' : photoId},
        success: function (response) {
            $('[name = '+likeName+']').text(response);
        }
    });
}