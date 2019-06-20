<#macro navbar>
    <div class="site-header">
        <div class="layout-positioner">
            <div class="flex__header--container">
                <img class="site-header__logo" src="${springMacroRequestContext.contextPath}/img/logo.png"
                     alt="Логотип">
                <div class="flex__header--button">
                    <form action="/admin/panel">
                        <button class="site-header__button site-header__button--admin  flex__element">Панель
                            администратора
                        </button>
                    </form>
                    <form action="/drivers">
                        <button class="site-header__button site-header__button--driver flex__element">База водителей
                        </button>
                    </form>
                    <form action="/autos">
                        <button class="site-header__button site-header__button--auto flex__element">База автомобилей
                        </button>
                    </form>
                    <form action="/login">
                        <button class="site-header__button site-header__button--login flex__element">Вход/выход</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</#macro>