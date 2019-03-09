$( document ).ready(function() {

    var customerIdList = []

    $(function () {
        $("#search").focus();
        $(document).keypress(function (e) {
            if (e.which === '13') e.preventDefault();
        });
        $("#search").keyup(function (e) {
            var search_text = $("#search").val();
            var token = $("meta[name='_csrf']").attr("content");
            var header = $("meta[name='_csrf_header']").attr("content");
            if (e.which !== '13' && search_text.length >= 3) {
                $.ajax({
                    type: "POST",
                    url: "/searchUser",
                    beforeSend: function(request) {
                        request.setRequestHeader(header, token);
                    },
                    data: {
                        'searchQuery': $("#search").val()
                    },
                    success: searchSuccess,
                    dataType: 'json'
                });
            } else {
                $('#userResult').empty();
            }
        });
    });

    function searchSuccess(data) {
        var listUsers = $('#userResult');
        listUsers.empty();
        data.forEach(function (result) {
            userId = result[0]
            userName = result[1]
            var userHtml = "<li class=\"list-group-item\">" + userName +"</li>";
            $(userHtml).appendTo($(listUsers));
        });
    }
});