<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>TaxiService. Список авто</title>
    <link href="${springMacroRequestContext.contextPath}/css/app.css" rel="stylesheet">
    <link href="${springMacroRequestContext.contextPath}/css/form-flex.css" rel="stylesheet">
</head>
<body class="site">
<#include "../header/basicHeader.ftl">
<div class="form-container flex__container layout-positioner">
    <h1 class="form-container__h1 flex__element">Список автомобилей</h1>
    <#list autos as auto>
        <h3>Марка/бренд</h3>
        <p>${auto.brand}</p>
        <h3>Модельный ряд</h3>
        <p>${auto.model}</p>
        <h3>Год выпуска</h3>
        <p>${auto.year}</p>
        <br>
    </#list>
</div>
</body>
</html>