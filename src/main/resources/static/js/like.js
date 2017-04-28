function like(element) {
    var photoId = element.id.toString();
    $.ajax({
        url: "/like",
        type: "GET",
        data: {'photoId' : photoId},
        success: function (response) {
            $("#" + photoId).text(response);
        }
    });
}