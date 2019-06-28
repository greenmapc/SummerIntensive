<#import "../macros/layout.ftl" as l>
<#import "../macros/navbar.ftl" as n>

<@l.layout "База данных авто | TaxiService" "auto_list">
    <@n.navbar/>
    <div class="banner over-bootstrap__site-content">
        <div class="banner__div data__flex layout-positioner">
            <h1 class="banner__h1">База данных автомобилей</h1>
            <img class="banner__img" src="${springMacroRequestContext.contextPath}/img/car.svg" alt="Иконка автомобиля">
        </div>
    </div>
    <div class="form-container layout-positioner over-bootstrap__form">
        <div class="autos">
            <#list autos as auto>
                <div class="autos__bar">
                    <h2 class="autos__bar--title">Автомобиль ${auto_index + 1}</h2>

                    <h3 class="autos__bar--brand">Марка/бренд</h3>
                    <p>${auto.brand}</p>

                    <h3 class="autos__bar--model-row">Модельный ряд</h3>
                    <p>${auto.model}</p>

                    <h3 class="autos__bar--release-year">Год выпуска</h3>
                    <p>${auto.year?c}</p>

                    <div class="details__container">
                        <form action="/autos/${auto.id}" method="get">
                            <button class="autos__bar--details" type="submit">Подробнее</button>
                        </form>
                    </div>
                </div>
            </#list>
        </div>
    </div>
</@l.layout>
