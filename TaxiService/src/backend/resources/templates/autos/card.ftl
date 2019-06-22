<#import "../macros/layout.ftl" as l>
<#import "../macros/navbar.ftl" as n>
<@l.layout "Карта авто | TaxiService">
    <@n.navbar/>
    <div class="layout-positioner">
        <h1>База данных автомобилей > Автомобиль ${auto.id}</h1>

        <h3>Марка/бренд</h3>
        <p>${auto.model} / ${auto.brand}</p>

        <h3>Внешний вид</h3>
        <p>${auto.description}</p>

        <h3>Фотографии</h3>
        <img src="" alt="Фото автомобиля в текущем состоянии 1">
        <img src="" alt="Фото автомобиля в текущем состоянии 2">
        <img src="" alt="Фото автомобиля в текущем состоянии 3">
        <img src="" alt="Фото автомобиля в текущем состоянии 4">

        <h3>VIN</h3>
        <p>${auto.vinNumber}</p>

        <h3>Гос. номер</h3>
        <p>${auto.gosNumber}</p>

        <h3>Цвет </h3>
        <p>${auto.color} </p>

        <h3>Привод</h3>
        <p>${auto.drive}</p>

        <h3>Киллометраж</h3>
        <p>${auto.kilometrage}</p>
    </div>
</@l.layout>