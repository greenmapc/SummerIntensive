<#import "../macros/layout.ftl" as l>
<#import "../macros/navbar.ftl" as n>
<#import "/spring.ftl" as spring/>
<@l.layout "Передача автомобиля. Компания -> Водитель" "">
    <@n.navbar/>
    <div class="form-container flex__form layout-positioner">
        <h1 class="form-container__h1 flex__element">Создание акта приема-передачи автомобиля от компании к
            водителю</h1>

        <form class="form-container__form" action="/user/create_act_from_company_to_driver" method="post">
            <@spring.bind "formCD"/>

            <label for="document__auto">Автомобиль (что передают)*</label><br>
            <@spring.formSingleSelect "formCD.auto" autos 'class="form-container__form--input flex__element"
                        id="document__auto" placeholder="Выберите авто"'/>
            <br>

            <label for="document__driver">Водитель (кому передают)*</label><br>
            <@spring.formSingleSelect "formCD.renter" drivers 'class="form-container__form--input flex__element"
                                    id="document__driver" placeholder="Выберите водителя" required'/>
            <br>

            <label for="document__date-transfer">Дата передачи*</label><br>
            <@spring.formInput "formCD.leaseStartDate" 'class="form-container__form--input flex__element" id="document__date-transfer"
                                value="2019-06-22" min="2019-06-22" max="2020-12-31" required' 'datetime-local'/>
            <br>

            <label for="document__date-reception">Дата возвращения*</label><br>
            <@spring.formInput "formCD.leaseEndDate" 'class="form-container__form--input flex__element" id="document__date-reception"
                                value="2019-07-22" min="2019-07-22" max="2020-12-31" required' 'datetime-local'/>
            <br>

            <label for="document__more">Дополнительные условия аренды</label><br>
            <@spring.formTextarea "formCD.conditions" 'class="document__more" id="document__more"'/>
            <br>

            <button class="form-container__form--button flex__element" type="submit">Создать</button>
        </form>
    </div>
</@l.layout>