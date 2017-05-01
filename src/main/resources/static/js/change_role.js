/**
 * Created by eabil on 29.04.2017.
 */
function changeRole(element) {
    var userId = element.id;
    $.ajax({
        url: '/changeRole',
        type: 'GET',
        data: {'userId': userId},
        success: function (response) {
            $(document).ready(function () {
                $('#' + userId).text(response);
            });

        }
    });

}