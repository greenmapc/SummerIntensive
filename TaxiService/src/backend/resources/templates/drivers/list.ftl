<<<<<<< HEAD
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>TaxiService. Список водителей</title>
    <link href="${springMacroRequestContext.contextPath}/css/app.css" rel="stylesheet">
    <link href="${springMacroRequestContext.contextPath}/css/form-flex.css" rel="stylesheet">
</head>
<body class="site">
<#include "../header/basicHeader.ftl">
<div class="form-container flex__container layout-positioner">
    <h1 class="form-container__h1 flex__element">Список водителей</h1>
    <#list drivers as driver>
        <h3>ФИО</h3>
        <p>${driver.lastName} ${driver.firstName} ${driver.patronymic}</p>
        <h3>Рейтинг из 5 баллов</h3>
        <p>${driver.raiting!5}</p>
    </#list>
</div>
</body>
</html>
=======
<#import "../macros/layout.ftl" as l>
<#import "../macros/navbar.ftl" as n>
<@l.layout "TaxiService">
    <@n.navbar/>
    <div class="form-container flex__container layout-positioner">
        <h1 class="form-container__h1 flex__element">Список водителей</h1>

        <h2>Водитель 1</h2>
        <h3>ФИО</h3>
        <p>Иванов Иван Иванович</p>
        <h3>Рейтинг из 5 баллов</h3>
        <p>4,7</p>


    </div>
</@l.layout>
>>>>>>> 374aae2ec7a0113f47fcb59857a96bf025da26d6
