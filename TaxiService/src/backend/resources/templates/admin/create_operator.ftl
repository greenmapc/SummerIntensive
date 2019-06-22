<#import "../macros/layout.ftl" as l>
<#import "../macros/navbar.ftl" as n>
<#import "/spring.ftl" as spring>
<@l.layout "Зарегистрировать нового оператора | TaxiService">
    <@n.navbar/>
    <div class="form-container flex__form layout-positioner">
        <h1 class="form-container__h1 flex__element">Создание нового оператора</h1>

        <form class="form-container__form" action="/admin/create_operator" method="post">
            <h2>Оператор</h2>
            <@spring.bind "form"/>

            <label for="operator__first_name">Имя</label><br>
            <@spring.formInput "form.firstName" 'class="form-container__form--input flex__element"
                            id="operator__first_name" placeholder="Введите имя" required'/><br>
            <@spring.showErrors "form.firstName"/><br>

            <label for="operator__last_name">Фамилия</label><br>
            <@spring.formInput "form.lastName" 'class="form-container__form--input flex__element"
                            id="operator__last_name" placeholder="Введите фамилию" required'/><br>
            <@spring.showErrors "form.lastName"/><br>

            <label for="operator__patronymic">Отчество</label><br>
            <@spring.formInput "form.patronymic" 'class="form-container__form--input flex__element"
                            id="operator__patronymic" placeholder="Введите отчество" required'/><br>
            <@spring.showErrors "form.patronymic"/><br>

            <label for="operator__email">Email</label><br>
            <@spring.formInput "form.email" 'class="form-container__form--input flex__element"
                            id="operator__email" placeholder="Введите email" required'/><br>
            <@spring.showErrors "form.email"/><br>

            <button class="form-container__form--button flex__element" type="submit">Создать</button>
        </form>
    </div>
</@l.layout>