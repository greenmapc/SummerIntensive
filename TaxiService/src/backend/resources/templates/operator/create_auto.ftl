<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>TaxiService. Добавление машины</title>
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
    <h1 class="form-container__h1 flex__element">Создание нового автомобиля</h1>

    <form class="form-container__form" action="/operator/create_auto" method="post">
        <h2>Добавление автомобиля</h2>

        <label for="auto__brand">Марка автомобиля</label><br>
        <input class="form-container__form--input flex__element" type="text" id="auto__brand"
               name="brand"
               placeholder="Введите марку автомобиля" required><br>

        <label for="auto__model">Модель автомобиля</label><br>
        <input class="form-container__form--input flex__element" type="text" id="auto__model"
               name="model"
               placeholder="Введите модель автомобиля" required><br>

        <label for="auto__gos_number">Государственный номер</label><br>
        <input class="form-container__form--input flex__element" type="text" id="auto__gos_number"
               name="gosNumber"
               placeholder="Введите Гос.номер ТС" required><br>

        <label for="auto__vin_number">VIN номер</label><br>
        <input class="form-container__form--input flex__element" type="text" id="auto__vin_number"
               name="vinNumber"
               placeholder="Введите VIN-номер" required><br>

        <label for="auto__year">Год выпуска ТС</label><br>
        <input class="form-container__form--input flex__element" type="number" id="auto__year"
               name="year"
               placeholder="Введите год выпуска автомобиля" required><br>

        <label for="auto__volume">Объём двигателя автомобиля</label><br>
        <input class="form-container__form--input flex__element" type="number" id="auto__volume"
               name="volume"
               placeholder="Введите объём двигателя" required><br>

        <label for="auto__engine_power">Мощность двигателя</label><br>
        <input class="form-container__form--input flex__element" type="number" id="auto__engine_power"
               name="enginePower"
               placeholder="Введите мощность двигателя(в л.с.)" required><br>

        <label for="auto__transmission_type">КПП</label><br>
        <input class="form-container__form--input flex__element" type="text" id="auto__transmission_type"
               name="transmissionType"
               placeholder="Введите тип КПП" required><br>

        <label for="auto__drive">Привод автомобиля</label><br>
        <input class="form-container__form--input flex__element" type="text" id="auto__drive"
               name="drive"
               placeholder="Введите привод автомобиля" required><br>

        <label for="auto__body_type">Тип кузова</label><br>
        <input class="form-container__form--input flex__element" type="text" id="auto__body_type"
               name="bodyType"
               placeholder="Введите тип кузова" required><br>

        <label for="auto__color">Цвет машины</label><br>
        <input class="form-container__form--input flex__element" type="text" id="auto__color"
               name="color"
               placeholder="Введите цвет машины" required><br>

        <label for="auto__kilometrage">Пробег</label><br>
        <input class="form-container__form--input flex__element" type="text" id="auto__kilometrage"
               name="kilometrage"
               placeholder="Введите пробег автомобиля" required><br>

        <label for="auto__description">Описание</label><br>
        <textarea class="form-container__form--input flex__element" id="auto__description" name="description"
                  placeholder="Введите описание автомобиля"></textarea><br>

        <button class="form-container__form--button flex__element" type="submit">Добавить автомобиль</button>
    </form>
</div>
</body>
</html>