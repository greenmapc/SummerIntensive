<#import "../macros/layout.ftl" as l>
<#import "../macros/navbar.ftl" as n>
<@l.layout "Панель оператора">
    <@n.navbar/>
    <div class="operator-screen layout-positioner">
        <h1 class="operator-screen__h1 form-container__h1 flex__element">Экран оператора</h1>
        <div class="operator-screen__flex form-container__form">
            <a class="operator-screen__a" href="/user/create_auto">
                <div class="operator-screen__flex--bar operator-screen__flex--bar-create">
                    <p class="operator-screen__p">Создать автомобиль</p>
                    <img class="operator-screen__svg--car" src="${springMacroRequestContext.contextPath}/img/car.svg"
                         alt="Иконка автомобиля">
                </div>
            </a>
            <a class="operator-screen__a" href="/user/create_driver">
                <div class="operator-screen__flex--bar operator-screen__flex--bar-create">
                    <p class="operator-screen__p">Создать водителя</p>
                    <img class="operator-screen__svg--driver"
                         src="${springMacroRequestContext.contextPath}/img/driver.svg" alt="Иконка водителя">
                </div>
            </a>
            <a class="operator-screen__a" href="">
                <div class="operator-screen__flex--bar">
                    <p class="operator-screen__p">Изменить данные</p>
                    <img class="operator-screen__svg--data" src="${springMacroRequestContext.contextPath}/img/data.svg"
                         alt="Иконка базы данных">
                </div>
            </a>
            <a class="operator-screen__a" href="">
                <div class="operator-screen__flex--bar">
                    <p class="operator-screen__p">Создание акта приема-<br>передачи автомобиля</p>
                    <img class="operator-screen__svg--document"
                         src="${springMacroRequestContext.contextPath}/img/document.svg" alt="Иконка акта">
                </div>
            </a>
        </div>
    </div>
</@l.layout>