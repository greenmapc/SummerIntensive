<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>TaxiService. Вход в базу</title>
    <link href="${springMacroRequestContext.contextPath}/css/app.css" rel="stylesheet">
    <link href="${springMacroRequestContext.contextPath}/css/form-flex.css" rel="stylesheet">
</head>
<body class="site">
<#include "../header/basicHeader.ftl">
<div class="form-container flex__container layout-positioner">
        <h1 class="form-container__h1 flex__element">Вход в базу данных</h1>
        <form class="form-container__form">
            <input class="form-container__form--input flex__element" name="email" type="email" placeholder="Введите email"><br>
            <input class="form-container__form--input flex__element" name="password" type="password" placeholder="Введите пароль"><br>
            <button class="form-container__form--button flex__element" type="button">Войти</button>
        </form>
    </div>
</body>
</html>