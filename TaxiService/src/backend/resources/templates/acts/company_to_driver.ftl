<#import "../macros/layout.ftl" as l>
<#import "../macros/navbar.ftl" as n>

<@l.layout "Передача автомобиля. Компания -> Водитель">
    <@n.navbar/>
    <div class="form-container flex__form layout-positioner">
        <h1 class="form-container__h1 flex__element">Создание акта приема-передачи автомобиля от компании к
            водителю</h1>

        <form class="form-container__form" action="/operator/create_act_from_company_to_driver" method="post">
            <h2>Акт 1</h2>

            <label for="document__auto">Автомобиль (что передают)*</label><br>
            <input
                    class="form-container__form--input flex__element"
                    type="number"
                    id="document__auto"
                    placeholder="Введите ID автомобиля"
                    required>
            <br>

            <label for="document__driver">Водитель (кому передают)*</label><br>
            <input
                    class="form-container__form--input flex__element"
                    type="number"
                    id="document__driver"
                    placeholder="Введите ID водителя"
                    required>
            <br>

            <label for="document__date-transfer">Дата передачи*</label><br>
            <input
                    class="form-container__form--input flex__element"
                    type="date"
                    id="document__date-transfer"
                    placeholder="Введите email оператора"
                    value="2019-06-01"
                    min="2019-06-01"
                    max="2018-12-31"
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

            <label for="document__more">Дополнительные условия аренды</label><br>
            <textarea
                    class="document__more"
                    id="document__more"
                    placeholder="Введите телефон оператора">
            </textarea>
            <br>

            <button class="form-container__form--button flex__element" type="submit">Создать</button>
        </form>
    </div>
</@l.layout>