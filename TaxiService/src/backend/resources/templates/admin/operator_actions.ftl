<#import "../macros/layout.ftl" as l>
<#import "../macros/navbar.ftl" as n>
<#import "/spring.ftl" as spring>
<@l.layout "Действия операторов | TaxiService">
    <@n.navbar/>
    <div class="form-container layout-positioner">
        <h1 class="form-container__h1 flex__element">История действий операторов</h1>

        <div>
            <h2>Оператор 1</h2>
            <div class="data__flex">
                <h3>ФИО</h3>
                <p>Иванов Иван Иванович</p>
            </div>
            <div class="data__flex">
                <h3>Действие</h3>
                <p>Заключил новый договор с водителем 1</p>
            </div>
            <div class="data__flex">
                <h3>Дата действия</h3>
                <p>01.06.2019</p>
            </div>
        </div>

        <div>
            <h2>Оператор 2</h2>
            <div class="data__flex">
                <h3>ФИО</h3>
                <p>Иванов Иван Иванович</p>
            </div>
            <div class="data__flex">
                <h3>Действие</h3>
                <p>Заключил новый договор с водителем 1</p>
            </div>
            <div class="data__flex">
                <h3>Дата действия</h3>
                <p>01.06.2019</p>
            </div>
        </div>

        <div>
            <h2>Оператор 3</h2>
            <div class="data__flex">
                <h3>ФИО</h3>
                <p>Иванов Иван Иванович</p>
            </div>
            <div class="data__flex">
                <h3>Действие</h3>
                <p>Заключил новый договор с водителем 1</p>
            </div>
            <div class="data__flex">
                <h3>Дата действия</h3>
                <p>01.06.2019</p>
            </div>
        </div>
    </div>
</@l.layout>