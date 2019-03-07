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
                    url: "/searchCustomer",
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
        var listCustomers = $('#customerResult');
        listCustomers.empty();
        data.forEach(function (customer) {

            var customerHtml = "<li class=\"list-group-item\">" +
                customer.firstName + ' ' + customer.lastName +
                "<div class=\"pull-right action-buttons\">"+
                "<a href=\"updateCustomer?id=" + customer.id + "\"><span class=\"glyphicon glyphicon-pencil\"></span></a>\n" +
                "<a href=\"deleteCustomer?id=" + customer.id  +"\" class=\"trash\"><span class=\"glyphicon glyphicon-trash\"></span></a>\n" +
                "<a href=\"createPet?id=" + customer.id + "\" class=\"plus\"><span class=\"glyphicon glyphicon-plus\"></span></a>\n" +
                "<a href=\"pet?customerId=" + customer.id + "\" class=\"plus\"><span class=\"glyphicon glyphicon-new-window\n\"></span></a>\n" +
                "</li>" +
                "</div>";
            $(customerHtml).appendTo($(listCustomers));

        });


    }
});