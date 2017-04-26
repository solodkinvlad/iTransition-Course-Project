function uploadLabel() {
    var photos = document.getElementById("fileUpload").files;
    photos.forEach(function (photo, i, arr) {
        document.getElementById("uploaded").textContent = document.getElementById("uploaded").textContent + photo.name;
    });
}
