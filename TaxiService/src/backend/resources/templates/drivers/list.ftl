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