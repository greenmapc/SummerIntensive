<#import "../macros/layout.ftl" as l>
<#import "../macros/navbar.ftl" as n>
<@l.layout "TaxiService">
    <@n.navbar/>
    <div class="form-container flex__container layout-positioner">
        <h1 class="form-container__h1 flex__element">Список водителей</h1>

        <h2>Водитель 1</h2>
        <h3>ФИО</h3>
        <p>Иванов Иван Иванович</p>
        <h3>Рейтинг из 5 баллов</h3>
        <p>4,7</p>


    </div>
</@l.layout>