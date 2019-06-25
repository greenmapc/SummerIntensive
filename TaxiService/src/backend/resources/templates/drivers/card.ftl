<#import "../macros/layout.ftl" as l>
<#import "../macros/navbar.ftl" as n>

<@l.layout "Карта водителя | TaxiService">
    <@n.navbar/>
    <div class="banner">
        <div class="banner_div data__flex layout-positioner">
            <h1 class="banner_h1">База данных водителей</h1>
            <img class="banner_img" src="${springMacroRequestContext.contextPath}/img/driver.svg" alt="Иконка водителя">
        </div>
    </div>
    <div class="data layout-positioner">
        <h2>Водитель 1</h2>

        <div class="data__flex">
            <h3>Имя водителя</h3>
            <p>Иван</p>
        </div>
        <div class="data__flex">
            <h3>Фамилия водителя</h3>
            <p>Иванов</p>
        </div>
        <div class="data__flex">
            <h3>Отчество водителя</h3>
            <p>Иванович</p>
        </div>
        <div class="data__flex">
            <h3>Серия в/у</h3>
            <p>ХХХХ</p>
        </div>
        <div class="data__flex">
            <h3>Номер в/у</h3>
            <p>ХХХХ</p>
        </div>
        <div class="data__flex">
            <h3>Дата выдачи в/у</h3>
            <p>ДД.ММ.ГГГГ</p>
        </div>
        <div class="data__flex">
            <h3>Дата окончания в/у</h3>
            <p>ДД.ММ.ГГГГ</p>
        </div>
        <div class="data__flex">
            <h3>Серия паспорта</h3>
            <p>ХХХХ</p>
        </div>
        <div class="data__flex">
            <h3>Номер паспорта</h3>
            <p>ХХХХХХ</p>
        </div>
        <div class="data__flex">
            <h3>Черный список</h3>
            <p>Нет</p>
        </div>
        <div class="data__flex">
            <h3>Telegram водителя</h3>
            <p>+7 (9ХХ) ХХХ-ХХ-ХХ</p>
        </div>
        <div class="data__flex">
            <h3>Рейтинг водителя (от 1 до 10)</h3>
            <p>8</p>
        </div>

        <h3>Генератор акта передачи на текущую дату данному водителю</h3>
        <button type="button">Создать акт передачи</button>
    </div>
</@l.layout>
