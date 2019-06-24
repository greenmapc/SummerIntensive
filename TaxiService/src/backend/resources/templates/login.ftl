<#import "macros/layout.ftl" as l>
<#import "macros/navbar.ftl" as n>
<@l.layout "Вход | TaxiService" 'style.css'>
    <@n.navbar/>
    <div class="position">
        <div class="form-container flex__form layout-positioner">
            <h1 class="form-container__h1 flex__element">Вход в систему</h1>

            <form class="form-container__form" action="/login" method="post">
                <label for="operator__contact--email">Email</label><br>
                <input class="form-container__form--input flex__element" type="email" name="email"
                       id="operator__contact--email"
                       placeholder="Введите email оператора" required><br>

                <label for="operator__contact--password">Пароль</label><br>
                <input class="form-container__form--input flex__element" type="password"
                       id="operator__contact--password"
                       name="password"
                       placeholder="Введите пароль" required><br>

                <button class="form-container__form--button flex__element" type="submit">Войти</button>
            </form>
        </div>
    </div>
</@l.layout>