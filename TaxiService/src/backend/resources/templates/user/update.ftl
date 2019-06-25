<#import "../macros/layout.ftl" as l>
<#import "../macros/navbar.ftl" as n>
<#import "/spring.ftl" as spring>
<@l.layout "Обновить данные | TaxiService">
    <@n.navbar/>
    <div class="form-container flex__form layout-positioner">
        <h1 class="form-container__h1 flex__element">Изменение данных</h1>

        <form class="form-container__form" action="/user/update" method="post">
            <h2><#if user.getStringRoles()?seq_contains('ADMIN')>Администратор<#else>Оператор</#if></h2>
            <@spring.bind "userForm"/>

            <label for="user__first_name">Имя</label><br>
            <@spring.formInput "userForm.firstName" 'class="form-container__form--input flex__element"
                            id="user__first_name" placeholder="Введите имя" required'/><br>
            <@spring.showErrors "userForm.firstName"/><br>

            <label for="user__last_name">Фамилия</label><br>
            <@spring.formInput "userForm.lastName" 'class="form-container__form--input flex__element"
                            id="user__last_name" placeholder="Введите фамилию" required'/><br>
            <@spring.showErrors "userForm.lastName"/><br>

            <label for="user__patronymic">Отчество</label><br>
            <@spring.formInput "userForm.patronymic" 'class="form-container__form--input flex__element"
                            id="user__patronymic" placeholder="Введите отчество" required'/><br>
            <@spring.showErrors "userForm.patronymic"/><br>

            <label for="user__email">Email</label><br>
            <@spring.formInput "userForm.email" 'class="form-container__form--input flex__element"
                            id="user__email" placeholder="Введите email" required' 'email'/><br>
            <@spring.showErrors "userForm.email"/><br>

            <label for="user__new_password">Новый пароль</label><br>
            <@spring.formPasswordInput "userForm.newPassword" 'id="user__new_password" class="form-container__form--input flex__element"
                   name="newPassword" placeholder="Введите новый пароль"' /><br>
            <@spring.showErrors "userForm.newPassword" /><br>

            <label for="user__new_password_2">Новый пароль</label><br>
            <@spring.formPasswordInput "userForm.newPassword2" 'id="user__new_password_2" class="form-container__form--input flex__element"
                   name="newPassword2" placeholder="Повторите новый пароль"'/><br>
            <@spring.showErrors "userForm.newPassword2"/><br>

            <button class="form-container__form--button flex__element" type="submit">Обновить</button>
        </form>
    </div>
</@l.layout>