<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>TaxiService. Карта водителя</title>
    <link href="${springMacroRequestContext.contextPath}/css/app.css" rel="stylesheet">
</head>
<body class="site">
<#include "../header/basicHeader.ftl">

<div class="layout-positioner">
        <h1>База данных водителей такси > Водитель ${driver.id}</h1>

        <h3>ФИО водителя</h3>
        <p>${driver.lastName} ${driver.firstName} ${driver.patronymic}</p>

        <h3>Паспортные данные</h3>
        <h4>Серия и номер</h4>
        <p>${driver.passportSeries} ${driver.passportNumber}</p>
        <h4>Орган выдачи</h4>
        <p>${driver.placeOfPassportIssue}</p>
        <h4>Дата выдачи</h4>
        <p>${driver.dateOfPassportIssue}</p>
        <a href="">Предпросмотр паспортных данных</a>

        <h3>Водительское  удостоверение</h3>
        <p>${driver.driversLicenseSeries} ${driver.driversLicenseNumber}</p>

        <h3>Контакты</h3>
        <p>${driver.phoneNumber}</p>

        <h3>История поездок</h3>
        <h4>Поездка 1</h4>
        <p>Автомобиль: Opel Astra; дата аренды: ДД.ММ.ГГГГ; время аренды: ЧЧ:ММ-ЧЧ:ММ</p>
        <h4>Поездка 2</h4>
        <p>Автомобиль: Lada Vesta; дата аренды: ДД.ММ.ГГГГ; время аренды: ЧЧ:ММ-ЧЧ:ММ</p>
        <h4>Поездка 3</h4>
        <p>Автомобиль: Ford Focus; дата аренды: ДД.ММ.ГГГГ; время аренды: ЧЧ:ММ-ЧЧ:ММ</p>
        <a href="">Посмотреть всю историю</a>

        <h3>Акт передачи</h3>
        <p>Номер акта:…</p>
        <a href="">Предпросмотр договора</a>

        <h3>Черный список</h3>
        <p><#if driver.blackList?? && driver.blackList>
                Забанен
            <#else >
                Нет
            </#if>
        </p>

        <h3>Генератор акта передачи на  текущую дату данному водителю</h3>
        <button type="button">Создать акт передачи</button>
    </div>
</body>
</html>