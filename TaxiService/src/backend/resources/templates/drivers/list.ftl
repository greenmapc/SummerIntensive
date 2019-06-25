<#import "../macros/layout.ftl" as l>
<#import "../macros/navbar.ftl" as n>

<@l.layout "База данных водителей | TaxiService" "style.css">
    <@n.navbar/>
    <div class="banner">
        <div class="banner_div data__flex layout-positioner">
            <h1 class="banner_h1">База данных водителей</h1>
            <img class="banner_img" src="${springMacroRequestContext.contextPath}/img/driver.svg" alt="Иконка водителя">
        </div>
    </div>
    <div class="layout-positioner">
        <#if drivers??>
            <#list drivers as driver>
                <h2>Водитель 1</h2>
                <div class="data__flex">
                    <h3>ФИО</h3>
                    <p>Иванов Иван Иванович</p>
                </div>
                <div class="data__flex">
                    <h3>Рейтинг из 5 баллов</h3>
                    <p>4,7</p>
                </div>
            </#list>
        <#else >
            <h3>Нет Водителей</h3>
        </#if>
    </div>
    <form action="/user/create_driver" method="get">
        <button class="form-container__form--button flex__element" type="submit">Добавить водителя</button>
    </form>
</@l.layout>
