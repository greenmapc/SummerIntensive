<#import "../macros/layout.ftl" as l>
<#import "../macros/navbar.ftl" as n>
<#import "/spring.ftl" as spring>

<@l.layout "Создание карты водителя | TaxiService">
    <@n.navbar/>
    <div class="form-container flex__container layout-positioner">
        <h1 class="form-container__h1 flex__element">Создание нового водителя</h1>

        <form class="form-container__form" action="/operator/create_driver" method="post">
            <h2>Добавление водителя</h2>
            <@spring.bind "driverForm"/>

            <label for="driver__last_name">Фамилия *</label><br>
            <@spring.formInput "driverForm.lastName" 'class="form-container__form--input flex__element"
                            id="driver__last_name" placeholder="Введите фамилию" required'/><br>
            <@spring.showErrors "driverForm.lastName"/>
            <br>

            <label for="driver__first_name">Имя *</label><br>
            <@spring.formInput "driverForm.firstName" 'class="form-container__form--input flex__element"
                            id="driver__first_name" placeholder="Введите имя" required'/><br>
            <@spring.showErrors "driverForm.firstName"/>
            <br>

            <label for="driver__patronymic">Отчество *</label><br>
            <@spring.formInput "driverForm.patronymic" 'class="form-container__form--input flex__element"
                            id="driver__patronymic" placeholder="Введите отчество" required'/><br>
            <@spring.showErrors "driverForm.patronymic"/>
            <br>

            <label for="driver__drivers_license_series">Серия ВУ *</label><br>
            <@spring.formInput "driverForm.driversLicenseSeries" 'class="form-container__form--input flex__element"
                            id="driver__drivers_license_series" type="number" placeholder="Введите серию ВУ" required'/>
            <br>
            <@spring.showErrors "driverForm.driversLicenseSeries"/>
            <br>

            <label for="driver__drivers_license_series">Номер ВУ *</label><br>
            <@spring.formInput "driverForm.driversLicenseNumber" 'class="form-container__form--input flex__element"
                            id="driver__drivers_license_number" type="number" placeholder="Введите номер ВУ" required'/>
            <br>
            <@spring.showErrors "driverForm.driversLicenseNumber"/>
            <br>

            <label for="driver__date_of_driver_license_issue">Дата получения ВУ *</label><br>
            <@spring.formInput "driverForm.dateOfDriverLicenseIssue" 'class="form-container__form--input flex__element"
                            id="driver__date_of_driver_license_issue" type="date" placeholder="Введите дату получения ВУ" required'/>
            <br>
            <@spring.showErrors "driverForm.dateOfDriverLicenseIssue"/>
            <br>

            <label for="driver__date_of_driver_license_expiry">Дата окончания действия ВУ *</label><br>
            <@spring.formInput "driverForm.dateOfDriverLicenseExpiry" 'class="form-container__form--input flex__element"
                            id="driver__date_of_driver_license_expiry" type="date" placeholder="Введите дату окончания действия ВУ" required'/>
            <br>
            <@spring.showErrors "driverForm.dateOfDriverLicenseExpiry"/>
            <br>

            <label for="driver__passport_series">Серия паспорта *</label><br>
            <@spring.formInput "driverForm.passportSeries" 'class="form-container__form--input flex__element"
                            id="driver__passport_series" type="number" placeholder="Введите серию паспорта" required'/>
            <br>
            <@spring.showErrors "driverForm.passportSeries"/>
            <br>

            <label for="driver__passport_number">Номер паспорта *</label><br>
            <@spring.formInput "driverForm.passportNumber" 'class="form-container__form--input flex__element"
                            id="driver__passport_number" type="number" placeholder="Введите номер паспорта" required'/>
            <br>
            <@spring.showErrors "driverForm.passportNumber"/>
            <br>

            <label for="driver__place_of_passport_issue">Место выдачи паспорта *</label><br>
            <@spring.formInput "driverForm.placeOfPassportIssue" 'class="form-container__form--input flex__element"
                            id="driver__place_of_passport_issue" placeholder="Введите место выдачи паспорта" required'/>
            <br>
            <@spring.showErrors "driverForm.placeOfPassportIssue"/>
            <br>

            <label for="driver__date_of_passport_issue">Дата выдачи паспорта *</label><br>
            <@spring.formInput "driverForm.dateOfPassportIssue" 'class="form-container__form--input flex__element"
                            id="driver__date_of_passport_issue" type="date" placeholder="Введите дату выдачи паспорта" required'/>
            <br>
            <@spring.showErrors "driverForm.dateOfPassportIssue"/>
            <br>

            <label for="driver__residence_address">Адрес прописки *</label><br>
            <@spring.formInput "driverForm.residenceAddress" 'class="form-container__form--input flex__element"
                            id="driver__residence_address" placeholder="Введите адрес прописки" required'/>
            <br>
            <@spring.showErrors "driverForm.residenceAddress"/>
            <br>

            <label for="driver__actual_address">Адрес проживания *</label><br>
            <@spring.formInput "driverForm.actualAddress" 'class="form-container__form--input flex__element"
                            id="driver__actual_address" placeholder="Введите адрес проживания" required'/>
            <br>
            <@spring.showErrors "driverForm.actualAddress"/>
            <br>

            <label for="driver__phone_number">Номер телефона *</label><br>
            <@spring.formInput "driverForm.phoneNumber" 'class="form-container__form--input flex__element"
                            id="driver__phone_number" placeholder="Введите номер телефона" required'/>
            <br>
            <@spring.showErrors "driverForm.phoneNumber"/>
            <br>

            <label for="driver__telegram_login">Логин в Telegram </label><br>
            <@spring.formInput "driverForm.telegramLogin" 'class="form-container__form--input flex__element"
                            id="driver__telegram_login" placeholder="Введите логин Telegram" '/>
            <br>
            <@spring.showErrors "driverForm.telegramLogin"/>
            <br>

            <button class="form-container__form--button flex__element" type="submit">Добавить водителя</button>
        </form>
    </div>
</@l.layout>