<#import "../macros/layout.ftl" as l>
<#import "../macros/navbar.ftl" as n>

<@l.layout "Выбор акта" "admin_screen">
    <@n.navbar/>
    <div class="admin-screen layout-positioner over-bootstrap__site-content">
        <h1 class="admin-screen__h1 form-container__h1 flex__element">
            Выберите тип
        </h1>
        <div class="admin-screen__flex form-container__form">
            <a class="admin-screen__a" href="/user/create_act_from_company_to_driver">
                <div class="admin-screen__flex--bar admin-screen__flex--bar-create">
                    <p class="admin-screen__p">Компания -> Водитель</p>
                    <img class="admin-screen__svg--operator"
                         src="${springMacroRequestContext.contextPath}/img/operator.svg" alt="Иконка оператора">
                </div>
            </a>
            <a class="admin-screen__a" href="/user/create_act_from_driver_to_company">
                <div class="admin-screen__flex--bar admin-screen__flex--bar-create">
                    <p class="admin-screen__p">Водитель -> Компания</p>
                    <img class="admin-screen__svg--car" src="${springMacroRequestContext.contextPath}/img/car.svg"
                         alt="Иконка автомобиля">
                </div>
            </a>
            <a class="admin-screen__a" href="/user/create_act_from_driver_to_driver">
                <div class="admin-screen__flex--bar admin-screen__flex--bar-create">
                    <p class="admin-screen__p">Водитель -> Водитель</p>
                    <img class="admin-screen__svg--driver"
                         src="${springMacroRequestContext.contextPath}/img/driver.svg"
                         alt="Иконка водителя">
                </div>
            </a>
        </div>
    </div>
</@l.layout>