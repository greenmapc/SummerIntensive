<#import "../macros/layout.ftl" as l>
<#import "../macros/navbar.ftl" as n>
<@l.layout "База данных авто | TaxiService" "auto_list">
    <@n.navbar/>
    <div class="banner">
        <div class="banner_div data__flex layout-positioner">
            <h1 class="banner_h1">База данных автомобилей</h1>
            <img class="banner_img" src="${springMacroRequestContext.contextPath}/img/car.svg" alt="Иконка автомобиля">
        </div>
    </div>
    <div class="form-container layout-positioner over-bootstrap__form">
        <div class="form-container__filter">
            <div class="form-container__filter--auto-efficiency">
                <label for="efficiency">Автомобиль на ходу:</label>
                <input type="checkbox" id="efficiency" name="scales"><br>
            </div>
            <div class="form-container__filter--auto-brand">
                <label for="auto-brand">Марка автомобиля:</label>
                <select class="auto-brand__variants" id="auto-brand">
                    <option value="choice">Выберите марку</option>
                    <option value="element-1">Opel</option>
                    <option value="element-2">Nissan</option>
                    <option value="element-3">Lada</option>
                </select>
            </div>
        </div>
        <div class="drivers">
            <#list autos as auto>
                <div class="drivers__bar">
                    <h2 class="drivers__bar--title">Автомобиль ${auto_index + 1}</h2>

                    <h3 class="drivers__bar--brand">Марка/бренд</h3>
                    <p>${auto.brand}</p>

                    <h3 class="drivers__bar--model-row">Модельный ряд</h3>
                    <p>${auto.model}</p>

                    <h3 class="drivers__bar--release-year">Год выпуска</h3>
                    <p>${auto.year}</p>

                    <div class="details__container">
                        <form action="/autos/${auto.id}" method="get">
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
