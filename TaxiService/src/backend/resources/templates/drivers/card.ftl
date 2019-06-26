<#import "../macros/layout.ftl" as l>
<#import "../macros/navbar.ftl" as n>

<@l.layout "Карта водителя | TaxiService" "card-style.css">
    <@n.navbar/>
    <div class="banner">
        <div class="banner_div data__flex layout-positioner">
            <h1 class="banner_h1">База данных водителей</h1>
            <img class="banner_img" src="${springMacroRequestContext.contextPath}/img/driver.svg" alt="Иконка водителя">
        </div>
    </div>
    <div class="data layout-positioner">
        <form style="margin-top: 10px" class="form-container__form" action="/drivers/${driver.id}/update" method="get">
            <button class="form-container__form--button flex__element" type="submit">Изменить данные</button>
        </form>

        <div class="data__flex">
            <h3>Фамилия водителя</h3>
            <p>${driver.lastName}</p>
        </div>
        <div class="data__flex">
            <h3>Имя водителя</h3>
            <p>${driver.firstName}</p>
        </div>
        <div class="data__flex">
            <h3>Отчество водителя</h3>
            <p>${driver.patronymic}</p>
        </div>
        <div class="data__flex">
            <h3>Дата рождения</h3>
            <p>${driver.birthDate.dayOfMonth}
                .${driver.birthDate.monthValue}
                .${driver.birthDate.year}
            </p>
        </div>
        <div class="data__flex">
            <h3>Серия В/У</h3>
            <p>${driver.driversLicenseSeries}</p>
        </div>
        <div class="data__flex">
            <h3>Номер B/У</h3>
            <p>${driver.driversLicenseNumber}</p>
        </div>
        <div class="data__flex">
            <h3>Дата выдачи в/у</h3>
            <p>${driver.dateOfLicenseIssue.dayOfMonth}
                .${driver.dateOfLicenseIssue.monthValue}
                .${driver.dateOfLicenseIssue.year}
            </p>
        </div>
        <div class="data__flex">
            <h3>Дата окончания в/у</h3>
            <p>${driver.dateOfLicenseExpiry.dayOfMonth}
                .${driver.dateOfLicenseExpiry.monthValue}
                .${driver.dateOfLicenseExpiry.year}</p>
        </div>
        <div class="data__flex">
            <h3>Серия паспорта</h3>
            <p>${driver.passportSeries}</p>
        </div>
        <div class="data__flex">
            <h3>Номер паспорта</h3>
            <p>${driver.passportNumber}</p>
        </div>
        <div class="data__flex">
            <h3>Черный список</h3>
            <p><#if driver.blackList>Да<#else>Нет</#if></p>
        </div>
        <#if driver.telegramLogin??>
            <div class="data__flex">
                <h3>Telegram водителя</h3>
                <p>{driver.telegramLogin}</p>
            </div>
        </#if>
        <div class="data__flex">
            <h3>Рейтинг водителя (от 1 до 10)</h3>
            <p>${driver.rating}</p>
        </div>
    </div>
</@l.layout>
