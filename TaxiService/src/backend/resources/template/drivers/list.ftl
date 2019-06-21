<#import "../macros/layout.ftl" as l>
<#import "../macros/navbar.ftl" as n>

<@l.layout "База данных водителей | TaxiService">
    <@n.navbar/>
    <div class="form-container flex__container layout-positioner">
        <h1 class="form-container__h1 flex__element">Список Водителей</h1>
        <#if drivers??>
            <#list drivers as driver>
                <h2>Водитель ${driver.id}</h2>
                <h3>Имя</h3>
                <p>${driver.firstName}</p>
                <h3>Фамилия</h3>
                <p>${driver.lastName}</p>
                <h3>Отчество</h3>
                <p>${driver.patronymic}</p>
                <br>
            </#list>
        <#else>
            <h4>Нет Водителей</h4>
        </#if>
        <form action="/operator/create_driver" method="get">
            <button class="form-container__form--button flex__element" type="submit">Добавить водителя</button>
        </form>
    </div>
</@l.layout>
