<#macro navbar>
    <div class="site-header">
        <div class="layout-positioner">
            <div class="flex__header--container">
                <img class="site-header__logo" src="${springMacroRequestContext.contextPath}/img/logo.png"
                     alt="Логотип">
                <div class="flex__header--button">
                    <#if user ??>
                        <#if user.getStringRoles()?seq_contains("ADMIN")>
                            <form action="/admin/panel">
                                <button class="site-header__button site-header__button--admin  flex__element">Панель
                                    администратора
                                </button>
                            </form>
                        </#if>

                        <form action="/drivers">
                            <button class="site-header__button site-header__button--driver flex__element">База водителей
                            </button>
                        </form>
                        <form action="/autos">
                            <button class="site-header__button site-header__button--auto flex__element">База автомобилей
                            </button>
                        </form>
                        <form action="/logout">
                            <button class="site-header__button site-header__button--login flex__element">Выход</button>
                        </form>
                    <#else>
                        <form action="/login">
                            <button class="site-header__button site-header__button--login flex__element">Вход</button>
                        </form>
                    </#if>
                </div>
            </div>
        </div>
    </div>
</#macro>