$( document ).ready(function() {

    var customerIdList = []

    $(function () {
        $("#search").focus();
        $(document).keypress(function (e) {
            if (e.which == '13') e.preventDefault();
        });
        $("#search").keyup(function (e) {
            var search_text = $("#search").val();
            if (e.which != '13' && search_text.length >= 3) {
                $.ajax({
                    type: "POST",
                    url: "/searchPet",
                    data: {
                        'searchQuery': $("#search").val()
                    },
                    success: searchSuccess,
                    dataType: 'json'
                });
            } else {
                $('#customerResult').empty();
            }
        });
    });

    function searchSuccess(data) {
        console.log(data);
        var listCustomers = $('#petResult');
        listCustomers.empty();
        data.forEach(function (pet) {

            var petHtml = "<li class=\"list-group-item\">" +
                pet.name + '-' + pet.petClass + '-'+ pet.kind +
                "<div class=\"pull-right action-buttons\">"+
                "<a href=\"updatePet?id=" + pet.id + "\"><span class=\"glyphicon glyphicon-pencil\"></span></a>\n" +
                "<a href=\"deletePet?id=" + pet.id  +"\" class=\"trash\"><span class=\"glyphicon glyphicon-trash\"></span></a>\n" +
                "</li>" +
                "</div>";
            $(petHtml).appendTo($(listCustomers));
        });
    }
});