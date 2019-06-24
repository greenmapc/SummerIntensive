<#import "../macros/layout.ftl" as l>
<#import "../macros/navbar.ftl" as n>
<@l.layout "Карта авто | TaxiService">
    <@n.navbar/>
    <div class="banner">
        <div class="banner_div data__flex layout-positioner">
            <h1 class="banner_h1">База данных автомобилей</h1>
            <img class="banner_img" src="img/car.svg" alt="Иконка автомобиля">
        </div>
    </div>
    <div class="layout-positioner">
        <h2>Автомобиль 1</h2>

        <div class="data__flex">
            <h3>Марка/бренд</h3>
            <p class="data__p">Opel</p>
        </div>
        <div class="data__flex">
            <h3>Модель</h3>
            <p class="data__p">Astra</p>
        </div>
        <div class="data__flex">
            <h3>Государственный номер</h3>
            <p class="data__p">XXXXXXXXXXXXXXXXX</p>
        </div>
        <div class="data__flex">
            <h3>VIN</h3>
            <p class="data__p">XXXXXXXXXXXXXXXXX</p>
        </div>
        <div class="data__flex">
            <h3>Год выпуска (г.)</h3>
            <p class="data__p">2011</p>
        </div>
        <div class="data__flex">
            <h3>Объем двигателя (л.с.)</h3>
            <p class="data__p">115</p>
        </div>
        <div class="data__flex">
            <h3>Мощность автомобиля (кВт./ч.)</h3>
            <p class="data__p">85</p>
        </div>
        <div class="data__flex">
            <h3>КПП</h3>
            <p class="data__p">Робот</p>
        </div>
        <div class="data__flex">
            <h3>Привод</h3>
            <p class="data__p">Передний</p>
        </div>
        <div class="data__flex">
            <h3>Тип кузова</h3>
            <p class="data__p">Седан</p>
        </div>
        <div class="data__flex">
            <h3>Цвет автомобиля</h3>
            <p class="data__p">Красный</p>
        </div>
        <div class="data__flex">
            <h3>Внешний вид (описание)</h3>
            <p class="data__p">Имеется 2 царапины на левом кузове</p>
        </div>
        <div class="data__flex">
            <h3>Пробег (км.)</h3>
            <p class="data__p">10 000</p>
        </div>
        <div class="data__flex">
            <h3>Автомобиль работает</h3>
            <p class="data__p">Да</p>
        </div>
        <div class="data__flex">
            <h3>Номер ID текущего водителя</h3>
            <p class="data__p">131</p>
        </div>
        <h3>Фотографии</h3>
        <img src="" alt="Фотография автомобиля 1">
        <img src="" alt="Фотография автомобиля 2">
        <img src="" alt="Фотография автомобиля 3">
    </div>
</@l.layout>