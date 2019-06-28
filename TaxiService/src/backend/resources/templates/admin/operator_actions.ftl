<#import "../macros/layout.ftl" as l>
<#import "../macros/navbar.ftl" as n>
<#import "/spring.ftl" as spring>
<@l.layout "Действия операторов | TaxiService" "operator_actions">
    <@n.navbar/>
    <div class="form-container layout-positioner over-bootstrap__form">
        <h1 class="form-container__h1 flex__element title__left">История действий операторов</h1>

        <#list actions as action>
            <div>
                <div class="data__flex">
                    <h3>ФИО</h3>
                    <p class="p-as-input">${action.operator.lastName} ${action.operator.firstName}</p>
                </div>
                <div class="data__flex">
                    <h3>Действие</h3>
                    <p class="p-as-input">${action.action}</p>
                </div>
                <div class="data__flex">
                    <h3>Дата действия</h3>
                    <p class="p-as-input">
                        ${action.date.format(parser)}
                    </p>
                </div>
            </div>
            <br>
        </#list>
    </div>
    <nav class="pagination-position layout-positioner" aria-label="Страницы навигации по сайту">
        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="#">Назад</a></li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item"><a class="page-link" href="#">Вперёд</a></li>
        </ul>
    </nav>
</@l.layout>