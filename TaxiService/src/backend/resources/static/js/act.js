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
});