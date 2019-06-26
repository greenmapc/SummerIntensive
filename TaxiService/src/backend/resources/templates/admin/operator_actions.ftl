<#import "../macros/layout.ftl" as l>
<#import "../macros/navbar.ftl" as n>
<#import "/spring.ftl" as spring>
<@l.layout "Действия операторов | TaxiService" 'style.css'>
    <@n.navbar/>
    <div class="form-container layout-positioner">
        <h1 class="form-container__h1 flex__element">История действий операторов</h1>

        <#list actions as action>
            <div>
                <div class="data__flex">
                    <h3>ФИО</h3>
                    <p>${action.operator.lastName} ${action.operator.firstName}</p>
                </div>
                <div class="data__flex">
                    <h3>Действие</h3>
                    <p>${action.action}</p>
                </div>
                <div class="data__flex">
                    <h3>Дата действия</h3>
                    <p>${action.date.toString()}</p>
                </div>
            </div>
            <br>
        </#list>
    </div>
</@l.layout>