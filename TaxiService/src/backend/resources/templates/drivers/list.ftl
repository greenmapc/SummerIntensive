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
        <div class="drivers">
            <#list drivers as driver>
                <div class="drivers__bar over-bootstrap__form">
                    <h2 class="drivers__bar--title">Водитель ${driver_index + 1}</h2>

                    <h3 class="drivers__bar--full-name">ФИО</h3>
                    <p>${driver.lastName} ${driver.firstName} ${driver.patronymic}</p>

                    <h3 class="drivers__bar--model-rating">Рейтинг из 10 баллов</h3>
                    <p>${driver.rating}</p>

                    <h3 class="drivers__bar--black-list">Есть в чёрном списке?</h3>
                    <#if driver.blackList><p style="color: darkred">Есть</p><#else >Нет</#if>

                    <div class="details__container">
                        <form action="/drivers/${driver.id}" method="get">
                            <button class="drivers__bar--details" type="submit">Подробнее</button>
                        </form>
                    </div>
                </div>
            </#list>
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
