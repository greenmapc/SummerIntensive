<#import "../macros/layout.ftl" as l>
<#import "../macros/navbarWithSearch.ftl" as n>

<@l.layout "База данных водителей | TaxiService" "driver_list">
    <@n.navbar "/drivers/search"/>
    <div class="banner">
        <div class="banner__div data__flex layout-positioner">
            <h1 class="banner__h1">База данных водителей</h1>
            <img class="banner__img" src="${springMacroRequestContext.contextPath}/img/driver.svg" alt="Иконка водителя">
        </div>
    </div>
    <div class="form-container layout-positioner over-bootstrap__form">
        <div class="drivers">
            <#list drivers as driver>
                <div class="drivers__bar over-bootstrap__form">
                    <h2 class="drivers__bar--title">Водитель ${driver_index + 1}</h2>

                    <h3 class="drivers__bar--full-name">ФИО</h3>
                    <p>${driver.lastName} ${driver.firstName} ${driver.patronymic}</p>

                    <h3 class="drivers__bar--model-rating">Рейтинг из 10 баллов</h3>
                    <p>${driver.rating}</p>

                    <h3 class="drivers__bar--black-list">Есть в чёрном списке?</h3>
                    <#if driver.blackList?? && driver.blackList><p style="color: red">Есть</p><#else >Нет</#if>

                    <div class="details__container">
                        <form action="/drivers/${driver.id}" method="get">
                            <button class="drivers__bar--details" type="submit">Подробнее</button>
                        </form>
                    </div>
                </div>
            </#list>
        </div>
    </div>

</@l.layout>