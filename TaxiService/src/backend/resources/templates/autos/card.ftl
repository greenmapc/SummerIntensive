<#import "../macros/layout.ftl" as l>
<#import "../macros/navbar.ftl" as n>
<@l.layout "Карта авто | TaxiService" 'style.css'>
    <@n.navbar/>
    <div class="banner">
        <div class="banner_div data__flex layout-positioner">
            <h1 class="banner_h1">База данных автомобилей</h1>
            <img class="banner_img" src="${springMacroRequestContext.contextPath}/img/car.svg" alt="Иконка автомобиля">
        </div>
    </div>
    <div class="layout-positioner">
        <form style="margin-top: 10px" class="form-container__form" action="/autos/${auto.id}/update" method="get">
            <button class="form-container__form--button flex__element" type="submit">Изменить данные</button>
        </form>

        <div class="data__flex">
            <h3>Марка/бренд</h3>
            <p class="data__p">${auto.brand}</p>
        </div>
        <div class="data__flex">
            <h3>Модель</h3>
            <p class="data__p">${auto.model}</p>
        </div>
        <div class="data__flex">
            <h3>Государственный номер</h3>
            <p class="data__p">${auto.gosNumber}</p>
        </div>
        <div class="data__flex">
            <h3>VIN</h3>
            <p class="data__p">${auto.vinNumber}</p>
        </div>
        <div class="data__flex">
            <h3>Год выпуска (г.)</h3>
            <p class="data__p">${auto.year}</p>
        </div>
        <div class="data__flex">
            <h3>Объем двигателя (л.с.)</h3>
            <p class="data__p">${auto.volume}</p>
        </div>
        <div class="data__flex">
            <h3>Мощность автомобиля (кВт./ч.)</h3>
            <p class="data__p">${auto.enginePower}</p>
        </div>
        <div class="data__flex">
            <h3>КПП</h3>
            <p class="data__p">${auto.transmission}</p>
        </div>
        <div class="data__flex">
            <h3>Привод</h3>
            <p class="data__p">${auto.drive}</p>
        </div>
        <div class="data__flex">
            <h3>Тип кузова</h3>
            <p class="data__p">${auto.bodyType}</p>
        </div>
        <div class="data__flex">
            <h3>Цвет автомобиля</h3>
            <p class="data__p">${auto.color}</p>
        </div>
        <div class="data__flex">
            <h3>Внешний вид (описание)</h3>
            <p class="data__p">${auto.description}</p>
        </div>
        <div class="data__flex">
            <h3>Пробег (км.)</h3>
            <p class="data__p">${auto.kilometrage}</p>
        </div>
        <div class="data__flex">
            <h3>Автомобиль работает</h3>
            <p class="data__p"><#if auto.state>Да<#else>Нет</#if></p>
        </div>
        <h3>Фотографии</h3>
        <img src="" alt="Фотография автомобиля 1">
        <img src="" alt="Фотография автомобиля 2">
        <img src="" alt="Фотография автомобиля 3">
    </div>
</@l.layout>