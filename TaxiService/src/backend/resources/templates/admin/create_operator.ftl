<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>TaxiService. Создание оператора</title>
    <link href="${springMacroRequestContext.contextPath}/css/app.css" rel="stylesheet">
    <link href="${springMacroRequestContext.contextPath}/css/form-flex.css" rel="stylesheet">
</head>
<body class="site">
<div class="site-header">
    <div class="layout-positioner">
        <img class="site-header__logo" src="${springMacroRequestContext.contextPath}/img/logo.png" alt="Логотип">
    </div>
</div>
<div class="form-container flex__container layout-positioner">
    <h1 class="form-container__h1 flex__element">Создание нового оператора</h1>

    <form class="form-container__form" action="/admin/create_operator" method="post">
        <h2>Оператор</h2>

        <label for="operator__name--last-name">Фамилия оператора*</label><br>
        <input class="form-container__form--input flex__element" type="text" id="operator__name--last-name"
               name="lastName"
               placeholder="Введите фамилию оператора" required><br>

        <label for="operator__name--first-name">Имя оператора*</label><br>
        <input class="form-container__form--input flex__element" type="text" id="operator__name--first-name"
               name="firstName"
               placeholder="Введите имя оператора" required><br>

        <label for="operator__name--patronymic">Отчество оператора*</label><br>
        <input class="form-container__form--input flex__element" type="text" id="operator__name--patronymic"
               name="patronymic"
               placeholder="Введите имя оператора" required><br>

        <label for="operator__contact--email">Email оператора*</label><br>
        <input class="form-container__form--input flex__element" type="email" id="operator__contact--email" name="email"
               placeholder="Введите email оператора" required><br>

        <label for="operator__contact--phone">Телефон оператора*</label><br>
        <input class="form-container__form--input flex__element" type="tel" id="operator__contact--phone"
               name="phoneNumber"
               placeholder="Введите телефон оператора" required><br>

        <button class="form-container__form--button flex__element" type="submit">Создать</button>
    </form>
</div>
<div class="result"><#if success??><h4>${success}</h4></#if></div>
</body>
</html>