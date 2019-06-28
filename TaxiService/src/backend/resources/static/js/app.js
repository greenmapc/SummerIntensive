$(document).ready(function() {

    $(".driver_select").change(function () {
        var value = $(this).val();
        $.ajax({
            url: '/autos/getRentedAuto',
            type: 'GET',
            data: {id : value},
            dataType: 'json',
            success: function (json) {
                optionText = json.brand + ", " + json.model + ", " + json.year + ", " + json.gosNumber;
                var htmlOption = new Option(optionText, json.id);
                var selectClassName = '.auto_select';
                $(selectClassName).find('option').remove();
                $(selectClassName).append(htmlOption);
            }
        })
    });

    $("#auto-brand").change(function () {
        location.href = "/autos?filter=brand_" + $(this).val();
    });

    $("#driver-rating").change(function () {
        location.href = "/drivers/?filter=rating_" + $(this).val();
    });

    $(".checkbox-banned").change(function () {
        if($(this).is(':checked')) {
            location.href = "/drivers/?filter=banned";
        } else {
            location.href = "/drivers";
        }
    });

    $(".checkbox-state").change(function () {
        if($(this).is(':checked')) {
            location.href = "/autos/?filter=state"
        } else {
            location.href = "/autos";
        }
    });

});