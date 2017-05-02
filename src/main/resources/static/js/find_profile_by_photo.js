function imgToProfile(element) {
    var photoId = element.id;
    $.ajax({
        url: "/imgToProfile",
        type: "POST",
        data: {'photoId' : photoId},
        success: function (response) {
            window.location.href = '/id' + response;
        }
    });
}
