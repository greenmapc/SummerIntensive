<#import "../macros/layout.ftl" as l>
<#import "../macros/navbar.ftl" as n>
<@l.layout "База данных авто | TaxiService" 'style.css'>
    <@n.navbar/>
    <div class="banner">
        <div class="banner_div data__flex layout-positioner">
            <h1 class="banner_h1">База данных автомобилей</h1>
            <img class="banner_img" src="${springMacroRequestContext.contextPath}/img/car.svg" alt="Иконка автомобиля">
        </div>
    </div>
    <div class="layout-positioner">
        <h2>Автомобиль 1</h2>
        <div class="data__flex">
            <h3>Марка/бренд</h3>
            <p>Opel</p>
        </div>
        <div class="data__flex">
            <h3>Модельный ряд</h3>
            <p>Atra</p>
        </div>
        <div class="data__flex">
            <h3>Год выпуска</h3>
            <p>2011</p>
        </div>

        <h2>Автомобиль 2</h2>
        <div class="data__flex">
            <h3>Марка/бренд</h3>
            <p>Lada</p>
        </div>
        <div class="data__flex">
            <h3>Модельный ряд</h3>
            <p>Kalina</p>
        </div>
        <div class="data__flex">
            <h3>Год выпуска</h3>
            <p>2015</p>
        </div>

        <h2>Автомобиль 3</h2>
        <div class="data__flex">
            <h3>Марка/бренд</h3>
            <p>Nissan</p>
        </div>
        <div class="data__flex">
            <h3>Модельный ряд</h3>
            <p>Almera</p>
        </div>
        <div class="data__flex">
            <h3>Год выпуска</h3>
            <p>2005</p>
        </div>
    </div>
</@l.layout>
