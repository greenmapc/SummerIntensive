<#import "../macros/layout.ftl" as l>
<#import "../macros/navbar.ftl" as n>


<#assign doc_id = 1>
<@l.layout "Карта авто | TaxiService" "auto_card">
    <@n.navbar/>
    <div class="banner">
        <div class="banner_div data__flex layout-positioner">
            <h1 class="banner_h1">База данных автомобилей</h1>
            <img class="banner_img" src="${springMacroRequestContext.contextPath}/img/car.svg" alt="Иконка автомобиля">
        </div>
    </div>
    <div class="layout-positioner over-bootstrap__form">
        <div class="data__flex">
            <h3>Марка/бренд</h3>
            <p class="data__p p-as-input">${auto.brand}</p>
        </div>
        <div class="data__flex">
            <h3>Модель</h3>
            <p class="data__p p-as-input">${auto.model}</p>
        </div>
        <div class="data__flex">
            <h3>Государственный номер</h3>
            <p class="data__p p-as-input">${auto.gosNumber}</p>
        </div>
        <div class="data__flex">
            <h3>VIN</h3>
            <p class="data__p p-as-input">${auto.vinNumber}</p>
        </div>
        <div class="data__flex">
            <h3>Год выпуска (г.)</h3>
            <p class="data__p p-as-input">${auto.year?c}</p>
        </div>
        <div class="data__flex">
            <h3>Объем двигателя (л.с.)</h3>
            <p class="data__p p-as-input">${auto.volume?c}</p>
        </div>
        <div class="data__flex">
            <h3>Мощность автомобиля (кВт./ч.)</h3>
            <p class="data__p p-as-input">${auto.enginePower?c}</p>
        </div>
        <div class="data__flex">
            <h3>КПП</h3>
            <p class="data__p p-as-input">${auto.transmission}</p>
        </div>
        <div class="data__flex">
            <h3>Привод</h3>
            <p class="data__p p-as-input">${auto.drive}</p>
        </div>
        <div class="data__flex">
            <h3>Тип кузова</h3>
            <p class="data__p p-as-input">${auto.bodyType}</p>
        </div>
        <div class="data__flex">
            <h3>Цвет автомобиля</h3>
            <p class="data__p p-as-input">${auto.color}</p>
        </div>
        <div class="data__flex">
            <h3>Внешний вид (описание)</h3>
            <p class="data__p p-as-input">${auto.description}</p>
        </div>
        <div class="data__flex">
            <h3>Пробег (км.)</h3>
            <p class="data__p p-as-input">${auto.kilometrage?c}</p>
        </div>
        <div class="data__flex">
            <h3>Автомобиль на ходу</h3>
            <p class="data__p p-as-input"><#if auto.state>Да<#else>Нет</#if></p>
        </div>
        <h3>Фотографии</h3>
        <#list auto.documents as doc>
            <a class="data__flex" style="color: lightgreen;" href="/show/doc/${doc.generatedName}.${doc.extension}"> Документ автомобиля ${doc_id} </a>
            <#assign doc_id++>
            <br>
        </#list>
    </div>
</@l.layout>