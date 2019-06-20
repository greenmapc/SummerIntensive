<#import "../macros/layout.ftl" as l>
<#import "../macros/navbar.ftl" as n>
<@l.layout "Экран администратора | TaxiService">
    <@n.navbar/>
    <div class="admin-screen layout-positioner">
        <h1 class="admin-screen__h1 form-container__h1 flex__element">Экран администратора</h1>
        <div class="admin-screen__flex form-container__form">
            <a class="admin-screen__a" href="">
                <div class="admin-screen__flex--bar admin-screen__flex--bar-create">
                    Создать оператора
                    <img class="admin-screen__svg--operator"
                         src="${springMacroRequestContext.contextPath}/img/operator.svg" alt="Изображение оператора">
                </div>
            </a>
            <a class="admin-screen__a" href="">
                <div class="admin-screen__flex--bar admin-screen__flex--bar-create">Создать автомобиль</div>
            </a>
            <a class="admin-screen__a" href="">
                <div class="admin-screen__flex--bar admin-screen__flex--bar-create">Создать водителя</div>
            </a>
            <a class="admin-screen__a" href="">
                <div class="admin-screen__flex--bar">Изменить данные</div>
            </a>
            <a class="admin-screen__a" href="">
                <div class="admin-screen__flex--bar">Действия операторов</div>
            </a>
        </div>
    </div>
</@l.layout>
