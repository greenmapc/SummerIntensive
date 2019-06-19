<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>TaxiService. Вход в систему</title>
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
    <h1 class="form-container__h1 flex__element">Вход в систему</h1>

    <form class="form-container__form" action="/login" method="post">
        <h2>Войдите в систему</h2>

        <label for="operator__contact--email">Email</label><br>
        <input class="form-container__form--input flex__element" type="email" name="email" id="operator__contact--email"
               placeholder="Введите email оператора" required><br>

        <label for="operator__contact--password">Пароль</label><br>
        <input class="form-container__form--input flex__element" type="password" id="operator__contact--password"
               name="password"
               placeholder="Введите пароль" required><br>

        <button class="form-container__form--button flex__element" type="submit">Войти</button>
    </form>
</div>
</body>
</html>