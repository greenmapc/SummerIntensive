<#import "../macros/layout.ftl" as l>
<#import "../macros/navbar.ftl" as n>

<@l.layout "База данных водителей | TaxiService" "driver_list">
    <@n.navbar/>
    <div class="banner">
        <div class="banner_div data__flex layout-positioner">
            <h1 class="banner_h1">База данных водителей</h1>
            <img class="banner_img" src="${springMacroRequestContext.contextPath}/img/driver.svg" alt="Иконка водителя">
        </div>
    </div>
    <div class="form-container layout-positioner over-bootstrap__form">
        <div class="form-container__filter">
            <div class="form-container__filter--black-list">
                <label for="efficiency">Водитель в черном списке:</label>
                <input type="checkbox" id="efficiency" name="scales"><br>
            </div>
            <div class="form-container__filter--driver-rating">
                <label for="driver-rating">Рейтинг водителя:</label>
                <select class="driver-rating__variants" id="driver-rating">
                    <option value="choice">Выберите рейтинг</option>
                    <option value="element-1">От 7 до 10 баллов</option>
                    <option value="element-2">От 4 до 6 баллов</option>
                    <option value="element-3">От 1 до 3 баллов</option>
                </select>
            </div>
        </div>
        <#list drivers as driver>
            <h2>Водитель ${driver_index + 1}</h2>
            <div class="data__flex">
                <h3>ФИО</h3>
                <p class="p-as-input">Иванов Иван Иванович</p>
            </div>
            <div class="data__flex">
                <h3>Рейтинг из 5 баллов</h3>
                <p class="p-as-input">4,7</p>
            </div>
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
