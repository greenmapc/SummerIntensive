<#import "../macros/layout.ftl" as l>
<#import "../macros/navbar.ftl" as n>
<#import "/spring.ftl" as spring>

<@l.layout "TaxiService">
    <@n.navbar/>
    <div class="form-container flex__container layout-positioner">
        <h1 class="form-container__h1 flex__element">Создание нового автомобиля</h1>

        <form class="form-container__form" action="/operator/create_auto" method="post">
            <@spring.bind "form"/>

            <h2>Добавление автомобиля</h2>

            <label for="auto__brand">Марка автомобиля</label><br>
            <@spring.formInput "form.brand" 'class="form-container__form--input flex__element"
                            id="auto__brand" placeholder="Введите марку автомобиля" required'/><br>
            <@spring.showErrors "form.brand"/>

            <label for="auto__model">Модель автомобиля</label><br>
            <@spring.formInput "form.model" 'class="form-container__form--input flex__element"
                            id="auto__model" placeholder="Введите модель автомобиля" required'/><br>
            <@spring.showErrors "form.model"/>

            <label for="auto__gos_number">Государственный номер</label><br>
            <@spring.formInput "form.gosNumber"  'class="form-container__form--input flex__element"
                            id="auto__gos_number" placeholder="Введите Гос.номер ТС" required'/><br>
            <@spring.showErrors "form.gosNumber"/>

            <label for="auto__vin_number">VIN номер</label><br>
            <@spring.formInput "form.vinNumber" 'class="form-container__form--input flex__element"
                            id="auto__vin_number" placeholder="Введите VIN-номер" required'/><br>
            <@spring.showErrors "form.vinNumber"/>

            <label for="auto__year">Год выпуска ТС</label><br>
            <@spring.formInput "form.year" 'class="form-container__form--input flex__element"
                            id="auto__year" placeholder="Введите год выпуска автомобиля" required'/><br>
            <@spring.showErrors "form.year"/>

            <label for="auto__volume">Объём двигателя автомобиля</label><br>
            <@spring.formInput "form.volume" 'class="form-container__form--input flex__element"
                            id="auto__volume" placeholder="Введите объём двигателя" required'/><br>
            <@spring.showErrors "form.volume"/>

            <label for="auto__engine_power">Мощность двигателя</label><br>
            <@spring.formInput "form.enginePower"'class="form-container__form--input flex__element"
                            id="auto__engine_power" placeholder="Введите мощность двигателя(в л.с.)" required'/><br>
            <@spring.showErrors "form.enginePower"/>

            <label for="auto__transmission_type">КПП</label><br>
            <@spring.formInput "form.transmissionType" 'class="form-container__form--input flex__element"
                            id="auto__transmission_type" placeholder="Введите тип КПП" required'/><br>
            <@spring.showErrors "form.transmissionType"/>

            <label for="auto__drive">Привод автомобиля</label><br>
            <@spring.formInput "form.drive" 'class="form-container__form--input flex__element"
                            id="auto__drive" placeholder="Введите привод автомобиля" required'/><br>
            <@spring.showErrors "form.drive"/>

            <label for="auto__body_type">Тип кузова</label><br>
            <@spring.formInput "form.bodyType" 'class="form-container__form--input flex__element"
                            id="auto__body_type" placeholder="Введите тип кузова" required'/><br>
            <@spring.showErrors "form.bodyType"/>

            <label for="auto__color">Цвет машины</label><br>
            <@spring.formInput "form.color" 'class="form-container__form--input flex__element"
                            id="auto__color" placeholder="Введите цвет машины" required'/><br>
            <@spring.showErrors "form.color"/>

            <label for="auto__kilometrage">Пробег</label><br>
            <@spring.formInput "form.kilometrage" 'class="form-container__form--input flex__element"
                            id="auto__kilometrage" placeholder="Введите пробег автомобиля" required'/><br>
            <@spring.showErrors "form.kilometrage"/>

            <label for="auto__description">Описание</label><br>
            <@spring.formTextarea "form.description" 'class="form-container__form--input flex__element"
                            id="auto__description" placeholder="Введите описание автомобиля"'/><br>
            <@spring.showErrors "form.description"/>

            <button class="form-container__form--button flex__element" type="submit">Добавить автомобиль</button>
        </form>
    </div>
</@l.layout>