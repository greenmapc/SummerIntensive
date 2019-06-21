<#import "../macros/layout.ftl" as l>
<#import "../macros/navbar.ftl" as n>
<@l.layout "База данных авто | TaxiService">
    <@n.navbar/>
    <div class="form-container flex__container layout-positioner">
        <h1 class="form-container__h1 flex__element">Список автомобилей</h1>
        <#if autos??>
            <#list autos as auto>
                <h2>Автомобиль 1</h2>
                <h3>Марка/бренд</h3>
                <p>${auto.brand}</p>
                <h3>Модельный ряд</h3>
                <p>${auto.model}</p>
                <h3>Год выпуска</h3>
                <p>${auto.year}</p>
                <br>
            </#list>
        <#else>
            <h4>Нет автомобилей</h4>
        </#if>
        <form action="/operator/create_auto" method="get">
            <button class="form-container__form--button flex__element" type="submit">Добавить авто</button>
        </form>
    </div>
</@l.layout>
