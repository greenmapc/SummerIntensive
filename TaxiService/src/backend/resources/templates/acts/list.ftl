<#import "../macros/layout.ftl" as l>
<#import "../macros/navbar.ftl" as n>

<#setting date_format="MM/dd/yyyy">

<@l.layout "Список актов передачи" "act_list">
    <@n.navbar/>
    <div class="banner">
        <div class="banner__div data__flex layout-positioner over-bootstrap__site-content">
            <h1 class="banner__h1">База данных актов</h1>
            <img class="banner__img" src="${springMacroRequestContext.contextPath}/img/document.svg"
                 alt="Иконка автомобиля">
        </div>
    </div>

    <div class="form-container layout-positioner over-bootstrap__form">
        <div class="documents">
            <#if acts??>
                <#list acts as act>
                    <div class="documents__bar over-bootstrap__form">
                        <h2 class="documents__bar--title">Акт ${act_index + 1}</h2>

                        <h3 class="documents__bar--full-name">ФИО водителя</h3>
                        <p>${act.driverRenter.lastName} ${act.driverRenter.firstName} ${act.driverRenter.patronymic}</p>

                        <h3 class="documents__bar--brand-and-model">Марка и модель авто</h3>
                        <p>${act.auto.brand} ${act.auto.model}</p>

                        <h3 class="documents__bar--release-year">Срок действия акта</h3>
                            <p>${act.leaseStartDate.format(parser)}
                            -
                            ${act.leaseEndDate.format(parser)}
                        </p>

                        <div class="details__container">
                            <form action="/download/pdf/${act.pdfFileName}" method="get">
                                <button class="documents__bar--validity-of-act" type="submit">Скачать акт</button>
                            </form>
                        </div>
                    </div>
                </#list>
            <#else >
                <div class="documents">
                    <h3>Акты приема/передачи отсутствуют</h3>
                </div>
            </#if>
        </div>
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