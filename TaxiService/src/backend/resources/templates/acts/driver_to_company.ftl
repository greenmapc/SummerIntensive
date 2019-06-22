<#import "../macros/layout.ftl" as l>
<#import "../macros/navbar.ftl" as n>

<@l.layout "Передача автомобиля. Водитель -> Компания">
    <@n.navbar/>
    <div class="form-container flex__form layout-positioner">
        <h1 class="form-container__h1 flex__element">Создание акта передачи автомобиля от водителя к компании</h1>

        <div class="flex__container">
            <img class="admin-screen__svg--document" src="${springMacroRequestContext.contextPath}/img/document.svg"
                 alt="Иконка акта">
            <form class="form-container__form" action="/operator/create_act_from_driver_to_company" method="post">
                <h2>Акт 1</h2>

                <label for="document__auto">Автомобиль (что передают)*</label><br>
                <input
                        class="form-container__form--input flex__element"
                        type="number"
                        id="document__auto"
                        placeholder="Введите ID автомобиля"
                        required>
                <br>

                <label for="document__driver--1">Водитель (кто передаёт)*</label><br>
                <input
                        class="form-container__form--input flex__element"
                        type="number"
                        id="document__driver--1"
                        placeholder="Введите ID водителя 1"
                        required>
                <br>

                <label for="document__date-reception">Дата возвращения*</label><br>
                <input
                        class="form-container__form--input flex__element"
                        type="date"
                        id="document__date-reception"
                        placeholder="Введите телефон оператора"
                        value="2019-06-01"
                        min="2019-06-01"
                        max="2022-01-01"
                        required>
                <br>

                <button class="form-container__form--button flex__element" type="button">Создать</button>
            </form>
        </div>
    </div>
</@l.layout>