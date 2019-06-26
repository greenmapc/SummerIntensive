<#import "../macros/layout.ftl" as l>
<#import "../macros/navbar.ftl" as n>
<#import "/spring.ftl" as spring>
<@l.layout "Обновление данных авто | TaxiService" 'style.css'>
    <@n.navbar/>
    <div class="form-container flex__form layout-positioner">
        <h1 class="form-container__h1 flex__element">Обновление данных автомобиля</h1>

        <form class="form-container__form" action="/autos/${auto.id}/update" method="post">
            <@spring.bind "form"/>

            <h2>Изменение данных</h2>

            <label for="auto__brand">Марка автомобиля</label><br>
            <@spring.formInput "form.brand" 'class="form-container__form--input flex__element"
                            id="auto__brand" placeholder="Введите марку автомобиля" required'/><br>
            <@spring.showErrors "form.brand"/><br>

            <label for="auto__model">Модель автомобиля</label><br>
            <@spring.formInput "form.model" 'class="form-container__form--input flex__element"
                            id="auto__model" placeholder="Введите модель автомобиля" required'/><br>
            <@spring.showErrors "form.model"/><br>

            <label for="auto__gos_number">Государственный номер</label><br>
            <@spring.formInput "form.gosNumber"  'class="form-container__form--input flex__element"
                            id="auto__gos_number" placeholder="Введите Гос.номер ТС" required'/><br>
            <@spring.showErrors "form.gosNumber"/><br>

            <label for="auto__vin_number">VIN номер</label><br>
            <@spring.formInput "form.vinNumber" 'class="form-container__form--input flex__element"
                            id="auto__vin_number" placeholder="Введите VIN-номер" required'/><br>
            <@spring.showErrors "form.vinNumber"/><br>

            <label for="auto__year">Год выпуска ТС</label><br>
            <@spring.formInput "form.year" 'class="form-container__form--input flex__element"
                            id="auto__year" placeholder="Введите год выпуска автомобиля" required'/><br>
            <@spring.showErrors "form.year"/><br>

            <label for="auto__volume">Объём двигателя автомобиля</label><br>
            <@spring.formInput "form.volume" 'class="form-container__form--input flex__element"
                            id="auto__volume" placeholder="Введите объём двигателя" required'/><br>
            <@spring.showErrors "form.volume"/><br>

            <label for="auto__engine_power">Мощность двигателя</label><br>
            <@spring.formInput "form.enginePower"'class="form-container__form--input flex__element"
                            id="auto__engine_power" placeholder="Введите мощность двигателя(в л.с.)" required'/><br>
            <@spring.showErrors "form.enginePower"/><br>

            <label for="auto__transmission_type">КПП</label><br>
            <@spring.formSingleSelect "form.transmissionType" transmissionType 'class="form-container__form--input flex__element"
                            id="auto__transmission_type" placeholder="Введите тип КПП" required'/><br>
            <@spring.showErrors "form.transmissionType"/><br>

            <label for="auto__drive">Привод автомобиля</label><br>
            <@spring.formSingleSelect "form.drive" driveType 'class="form-container__form--input flex__element"
                            id="auto__drive" placeholder="Введите привод автомобиля" required'/><br>
            <@spring.showErrors "form.drive"/><br>

            <label for="auto__body_type">Тип кузова</label><br>
            <@spring.formSingleSelect "form.bodyType" bodyType 'class="form-container__form--input flex__element"
                            id="auto__body_type" placeholder="Введите тип кузова" required'/><br>
            <@spring.showErrors "form.bodyType"/><br>

            <label for="auto__color">Цвет машины</label><br>
            <@spring.formInput "form.color" 'class="form-container__form--input flex__element"
                            id="auto__color" placeholder="Введите цвет машины" required'/><br>
            <@spring.showErrors "form.color"/><br>

            <label for="auto__kilometrage">Пробег</label><br>
            <@spring.formInput "form.kilometrage" 'class="form-container__form--input flex__element"
                            id="auto__kilometrage" placeholder="Введите пробег автомобиля" required'/><br>
            <@spring.showErrors "form.kilometrage"/><br>

            <@spring.formCheckbox "form.state" 'class=""
                            id="auto__state" placeholder="Машина на ходу" '/>
            <label for="auto__state">Состояние</label><br><br>

            <label for="auto__description">Описание</label><br>
            <@spring.formTextarea "form.description" 'class="form-container__form--input flex__element"
                            id="auto__description" placeholder="Введите описание автомобиля"'/><br>
            <@spring.showErrors "form.description"/><br>

            <button class="form-container__form--button flex__element" type="submit">Изменить</button>
        </form>
    </div>
</@l.layout>