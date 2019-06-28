<#import "../macros/layout.ftl" as l>
<#import "../macros/navbarWithSearch.ftl" as n>

<@l.layout "База данных водителей | TaxiService" "driver_list">
    <@n.navbar "/drivers/search"/>
    <div class="banner">
        <div class="banner__div data__flex layout-positioner">
            <h1 class="banner__h1">База данных водителей</h1>
            <img class="banner__img" src="${springMacroRequestContext.contextPath}/img/driver.svg" alt="Иконка водителя">
        </div>
    </div>
    <div class="form-container layout-positioner over-bootstrap__form">
        <div class="form-container__filter">
            <div class="form-container__filter--black-list">
                <label for="efficiency">Водитель в черном списке:</label>
                <input class="checkbox-banned" type="checkbox" id="efficiency" name="blackList"
                        <#if banned??>
                            checked="checked"
                        </#if>><br>
            </div>
            <div class="form-container__filter--driver-rating">
                <label for="driver-rating">Рейтинг водителя:</label>
                <select class="driver-rating__variants" name="raiting" id="driver-rating">
                    <option value="choice">Выберите рейтинг</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                    <option value="10">10</option>

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
                    <#if driver.blackList?? && driver.blackList><p style="color: red">Есть</p><#else >Нет</#if>

                    <div class="details__container">
                        <form action="/drivers/${driver.id}" method="get">
                            <button class="drivers__bar--details" type="submit">Подробнее</button>
                        </form>
                    </div>
                </div>
            </#list>
        </div>
    </div>
    <#if lastPageNumber gt 0 >
        <nav class="pagination-position layout-positioner" aria-label="Страницы навигации по сайту">
            <ul class="pagination">

                <#if pageNumber gt 1 >
                    <li class="page-item"><a class="page-link" href="?page=${pageNumber-1}">Назад</a></li>
                    <li class="page-item"><a class="page-link" href="?page=${pageNumber-1}">${pageNumber-1}</a></li>
                </#if>

                <li class="page-item"><a class="page-link" href="?page=${pageNumber}">${pageNumber}</a></li>

                <#if lastPageNumber - pageNumber gt 0 >
                    <li class="page-item"><a class="page-link" href="?page=${pageNumber+1}">${pageNumber+1}</a></li>
                    <li class="page-item"><a class="page-link" href="?page=${pageNumber+1}">Вперёд</a></li>
                </#if>


            </ul>
        </nav>
    </#if>
</@l.layout>
