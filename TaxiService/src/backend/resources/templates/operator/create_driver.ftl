<#import "../macros/layout.ftl" as l>
<#import "../macros/navbar.ftl" as n>
<@l.layout "TaxiService">
    <@n.navbar/>
    <div class="form-container flex__container layout-positioner">
        <h1 class="form-container__h1 flex__element">Создание нового водителя</h1>

        <form class="form-container__form" action="/operator/create_driver" method="post">
            <h2>Добавление водителя</h2>

            <label for="driver__last_name">Фамилия</label><br>
            <input class="form-container__form--input flex__element" type="text" id="driver__last_name"
                   name="lastName"
                   placeholder="Введите фамилию" required><br>

            <label for="driver__first_name">Имя</label><br>
            <input class="form-container__form--input flex__element" type="text" id="driver__first_name"
                   name="firstName"
                   placeholder="Введите имя" required><br>

            <label for="driver__patronymic">Отчество</label><br>
            <input class="form-container__form--input flex__element" type="text" id="driver__patronymic"
                   name="patronymic"
                   placeholder="Введите отчество" required><br>

            <label for="driver__drivers_license_series">Серия ВУ</label><br>
            <input class="form-container__form--input flex__element" type="number" id="driver__drivers_license_series"
                   name="driversLicenseSeries"
                   placeholder="Введите серию ВУ" required><br>

            <label for="driver__drivers_license_number">Номер ВУ</label><br>
            <input class="form-container__form--input flex__element" type="number" id="driver__drivers_license_number"
                   name="driversLicenseNumber"
                   placeholder="Введите номер ВУ" required><br>

            <label for="driver__date_of_driver_license_issue">Дата получения ВУ</label><br>
            <input class="form-container__form--input flex__element" type="date"
                   id="driver__date_of_driver_license_issue"
                   name="dateOfDriverLicenseIssue"
                   placeholder="" required><br>

            <label for="driver__date_of_driver_license_expiry">Дата окончания действия ВУ</label><br>
            <input class="form-container__form--input flex__element" type="date"
                   id="driver__date_of_driver_license_expiry"
                   name="dateOfDriverLicenseExpiry"
                   placeholder="" required><br>

            <label for="driver__passport_series">Серия паспорта</label><br>
            <input class="form-container__form--input flex__element" type="number" id="driver__passport_series"
                   name="passportSeries"
                   placeholder="Введите серию паспорта" required><br>

            <label for="driver__passport_number">Номер паспорта</label><br>
            <input class="form-container__form--input flex__element" type="number" id="driver__passport_number"
                   name="passportNumber"
                   placeholder="Введите номер папорта" required><br>

            <label for="driver__place_of_passport_issue">Дата выдачи паспорта</label><br>
            <input class="form-container__form--input flex__element" type="date" id="driver__place_of_passport_issue"
                   name="placeOfPassportIssue" required><br>

            <label for="driver__residence_address">Адрес прописки</label><br>
            <input class="form-container__form--input flex__element" type="text" id="driver__residence_address"
                   name="residenceAddress"
                   placeholder="Введите адрес прописки" required><br>

            <label for="driver__actual_address">Адрес проживания</label><br>
            <input class="form-container__form--input flex__element" type="text" id="driver__actual_address"
                   name="actualAddress"
                   placeholder="Введите адрес проживания" required><br>

            <label for="driver__phone_number">Номер телефона</label><br>
            <input class="form-container__form--input flex__element" type="text" id="driver__phone_number"
                   name="phoneNumber"
                   placeholder="Введите номер телефона" required><br>

            <button class="form-container__form--button flex__element" type="submit">Добавить водителя</button>
        </form>
    </div>
</@l.layout>