<#import "../macros/layout.ftl" as l>
<#import "../macros/navbar.ftl" as n>
<#import "/spring.ftl" as spring>
<@l.layout "Передача автомобиля. Водитель -> Компания">
    <@n.navbar/>
    <div class="form-container flex__form layout-positioner">
        <h1 class="form-container__h1 flex__element">Создание акта передачи автомобиля от водителя к компании</h1>

        <div class="flex__container">
            <form class="form-container__form" action="/user/create_act_from_driver_to_company" method="post">
                <h2>Акт 1</h2>
                <@spring.bind "formDC"/>

                <label for="document__auto">Автомобиль (что передают)*</label><br>
                <@spring.formSingleSelect "formDC.auto" autos 'class="form-container__form--input flex__element"
                        id="document__auto" placeholder="Выберите авто"'/>
                <br>

                <label for="document__driver">Водитель (кто передаёт)*</label><br>
                <@spring.formSingleSelect "formDC.renter" drivers 'class="form-container__form--input flex__element"
                                    id="document__driver" placeholder="Выберите водителя" required'/>
                <br>

                <label for="document__date-reception">Дата возвращения*</label><br>
                <@spring.formInput "formDC.leaseEndDate" 'class="form-container__form--input flex__element"
                                    id="document__date-reception" required' 'datetime-local'/>
                <br>

                <button class="form-container__form--button flex__element" type="submit">Создать</button>
            </form>
        </div>
    </div>
</@l.layout>