$(document).ready(function() {
    $(".dtc_select").change(function () {
        var value = $(this).val();
        $.ajax({
            url: '/autos/getRentedAuto',
            type: 'GET',
            data: {id : value},
            dataType: 'json',
            success: function (json) {
                optionText = json.brand + ", " + json.model + ", " + json.year + ", " + json.gosNumber;
                var htmlOption = new Option(optionText, json.id);
                $('.dtc_auto_select').find('option').remove();
                $('.dtc_auto_select').append(htmlOption);
            }
        })
    });
});