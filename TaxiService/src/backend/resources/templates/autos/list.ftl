<#import "../macros/layout.ftl" as l>
<#import "../macros/navbar.ftl" as n>
<@l.layout "База данных авто | TaxiService" >
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

        <h2>Автомобиль 1</h2>
        <div class="data__flex">
            <h3>Марка/бренд</h3>
            <p>Opel</p>
        </div>
        <div class="data__flex">
            <h3>Модельный ряд</h3>
            <p>Atra</p>
        </div>
        <div class="data__flex">
            <h3>Год выпуска</h3>
            <p>2011</p>
        </div>

        <h2>Автомобиль 2</h2>
        <div class="data__flex">
            <h3>Марка/бренд</h3>
            <p>Lada</p>
        </div>
        <div class="data__flex">
            <h3>Модельный ряд</h3>
            <p>Kalina</p>
        </div>
        <div class="data__flex">
            <h3>Год выпуска</h3>
            <p>2015</p>
        </div>

        <h2>Автомобиль 3</h2>
        <div class="data__flex">
            <h3>Марка/бренд</h3>
            <p>Nissan</p>
        </div>
        <div class="data__flex">
            <h3>Модельный ряд</h3>
            <p>Almera</p>
        </div>
        <div class="data__flex">
            <h3>Год выпуска</h3>
            <p>2005</p>
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
