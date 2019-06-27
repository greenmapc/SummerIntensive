<#import "../macros/layout.ftl" as l>
<#import "../macros/navbarWithSearch.ftl" as n>

<@l.layout "Карта водителя | TaxiService" "driver_card">
    <@n.navbar "/drivers/search"/>
    <div class="banner">
        <div class="banner_div data__flex layout-positioner">
            <h1 class="banner_h1">База данных водителей</h1>
            <img class="banner_img" src="${springMacroRequestContext.contextPath}/img/driver.svg" alt="Иконка водителя">
        </div>
    </div>
    <div class="data layout-positioner over-bootstrap__form">
        <div class="data__flex">
            <h3>Фамилия водителя</h3>
            <p class="p-as-input">${driver.lastName}</p>
        </div>
        <div class="data__flex">
            <h3>Имя водителя</h3>
            <p class="p-as-input">${driver.firstName}</p>
        </div>
        <div class="data__flex">
            <h3>Отчество водителя</h3>
            <p class="p-as-input">${driver.patronymic}</p>
        </div>
        <div class="data__flex">
            <h3>Дата рождения</h3>
            <p class="p-as-input">${driver.birthDate.dayOfMonth}
                .${driver.birthDate.monthValue}
                .${driver.birthDate.year?c}
            </p>
        </div>
        <div class="data__flex">
            <h3>Серия В/У</h3>
            <p class="p-as-input">${driver.driversLicenseSeries?c}</p>
        </div>
        <div class="data__flex">
            <h3>Номер B/У</h3>
            <p class="p-as-input">${driver.driversLicenseNumber?c}</p>
        </div>
        <div class="data__flex">
            <h3>Дата выдачи в/у</h3>
            <p class="p-as-input">${driver.dateOfLicenseIssue.dayOfMonth}
                .${driver.dateOfLicenseIssue.monthValue}
                .${driver.dateOfLicenseIssue.year?c}
            </p>
        </div>
        <div class="data__flex">
            <h3>Дата окончания в/у</h3>
            <p class="p-as-input">${driver.dateOfLicenseExpiry.dayOfMonth}
                .${driver.dateOfLicenseExpiry.monthValue}
                .${driver.dateOfLicenseExpiry.year?c}</p>
        </div>
        <div class="data__flex">
            <h3>Серия паспорта</h3>
            <p class="p-as-input">${driver.passportSeries?c}</p>
        </div>
        <div class="data__flex">
            <h3>Номер паспорта</h3>
            <p class="p-as-input">${driver.passportNumber?c}</p>
        </div>
        <div class="data__flex">
            <h3>Черный список</h3>
            <p class="p-as-input"><#if driver.blackList>Да<#else>Нет</#if></p>
        </div>
        <#if driver.telegramLogin?? && !(driver.telegramLogin?length = 0)>
            <div class="data__flex">
                <h3>Telegram водителя</h3>
                <p class="p-as-input">${driver.telegramLogin}</p>
            </div>
        </#if>
        <div class="data__flex">
            <h3>Рейтинг водителя (от 1 до 10)</h3>
            <p class="p-as-input">${driver.rating?c}</p>
        </div>
    </div>
</@l.layout>
