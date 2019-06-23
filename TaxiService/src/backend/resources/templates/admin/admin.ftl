<#import "../macros/layout.ftl" as l>
<#import "../macros/navbar.ftl" as n>

<@l.layout "Экран администратора | TaxiService">
    <@n.navbar/>
    <div class="admin-screen layout-positioner">
        <h1 class="admin-screen__h1 form-container__h1 flex__element">
            <#if user.getStringRoles()?seq_contains("ADMIN")>Экран администратора<#else>Экран оператора</#if></h1>
        <div class="admin-screen__flex form-container__form">
            <#if user??>
                <#if user.getStringRoles()?seq_contains("ADMIN")>
                    <a class="admin-screen__a" href="/admin/create_operator">
                        <div class="admin-screen__flex--bar admin-screen__flex--bar-create">
                            <p class="admin-screen__p">Создать оператора</p>
                            <img class="admin-screen__svg--operator"
                                 src="${springMacroRequestContext.contextPath}/img/operator.svg" alt="Иконка оператора">
                        </div>
                    </a>
                </#if>
                <a class="admin-screen__a" href="/operator/create_auto">
                    <div class="admin-screen__flex--bar admin-screen__flex--bar-create">
                        <p class="admin-screen__p">Создать автомобиль</p>
                        <img class="admin-screen__svg--car" src="${springMacroRequestContext.contextPath}/img/car.svg"
                             alt="Иконка автомобиля">
                    </div>
                </a>
                <a class="admin-screen__a" href="/operator/create_driver">
                    <div class="admin-screen__flex--bar admin-screen__flex--bar-create">
                        <p class="admin-screen__p">Создать водителя</p>
                        <img class="admin-screen__svg--driver"
                             src="${springMacroRequestContext.contextPath}/img/driver.svg"
                             alt="Иконка водителя">
                    </div>
                </a>
                <a class="admin-screen__a" href="">
                    <div class="admin-screen__flex--bar">
                        <p class="admin-screen__p">Изменить данные</p>
                        <img class="admin-screen__svg--data" src="${springMacroRequestContext.contextPath}/img/data.svg"
                             alt="Иконка базы данных">
                    </div>
                </a>
                <a class="admin-screen__a" href="">
                    <div class="admin-screen__flex--bar">
                        <p class="admin-screen__p">Создание акта приема-<br>передачи автомобиля</p>
                        <img class="admin-screen__svg--document"
                             src="${springMacroRequestContext.contextPath}/img/document.svg" alt="Иконка акта">
                    </div>
                </a>
                <#if user.getStringRoles()?seq_contains("ADMIN")>
                    <a class="admin-screen__a" href="">
                        <div class="admin-screen__flex--bar">
                            <p class="admin-screen__p">Действия операторов</p>
                            <img class="admin-screen__svg--statistic"
                                 src="${springMacroRequestContext.contextPath}/img/statistic.svg"
                                 alt="Иконка статистики">
                        </div>
                    </a>
                </#if>
            </#if>
        </div>
    </div>
</@l.layout>
