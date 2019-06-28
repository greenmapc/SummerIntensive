<#import "../macros/layout.ftl" as l>
<#import "../macros/navbarWithSearch.ftl" as n>
<@l.layout "База данных авто | TaxiService" "auto_list">
    <@n.navbar "/autos/search"/>
    <div class="banner">
        <div class="banner__div data__flex layout-positioner">
            <h1 class="banner__h1">База данных автомобилей</h1>
            <img class="banner__img" src="${springMacroRequestContext.contextPath}/img/car.svg" alt="Иконка автомобиля">
        </div>
    </div>
    <div class="form-container layout-positioner over-bootstrap__form">
        <div class="form-container__filter">
            <div class="form-container__filter--auto-efficiency">
                <label for="efficiency">Автомобиль на ходу:</label>
                <input type="checkbox" id="efficiency" name="state"><br>
            </div>
            <div class="form-container__filter--auto-brand">
                <label for="auto-brand">Марка автомобиля:</label>
                <select class="auto-brand__variants" name="brand" id="auto-brand">
                    <option value="choice">Выберите марку</option>
                    <option value="opel">Opel</option>
                    <option value="nissan">Nissan</option>
                    <option value="lada">Lada</option>
                </select>
            </div>
        </div>
        <div class="autos">
            <#list autos as auto>
                <div class="autos__bar">
                    <h2 class="autos__bar--title">Автомобиль ${auto_index + 1}</h2>

                    <h3 class="autos__bar--brand">Марка/бренд</h3>
                    <p>${auto.brand}</p>

                    <h3 class="autos__bar--model-row">Модельный ряд</h3>
                    <p>${auto.model}</p>

                    <h3 class="autos__bar--release-year">Год выпуска</h3>
                    <p>${auto.year?c}</p>

                    <div class="details__container">
                        <form action="/autos/${auto.id}" method="get">
                            <button class="autos__bar--details" type="submit">Подробнее</button>
                        </form>
                    </div>
                </div>
            </#list>
        </div>
    </div>
    <#if lastPageNumber gt 0 >
        <nav class="pagination-position layout-positioner" aria-label="Страницы навигации по сайту">
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="#">Назад</a></li>

                <#if pageNumber gt 1 >
                    <li class="page-item"><a class="page-link" href="#">${pageNumber-1}</a></li>
                </#if>

                <li class="page-item"><a class="page-link" href="#">${pageNumber}</a></li>

                <#if lastPageNumber - pageNumber gt 0 >
                    <li class="page-item"><a class="page-link" href="#">${pageNumber+1}</a></li>
                </#if>

                <li class="page-item"><a class="page-link" href="#">Вперёд</a></li>
            </ul>
        </nav>
    </#if>
</@l.layout>
