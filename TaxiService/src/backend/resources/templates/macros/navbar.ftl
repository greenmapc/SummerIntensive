<#macro navbar>
    <header class="site-header">
        <div class="layout-positioner">
            <div class="flex__header--container">
                <img class="site-header__logo" src="${springMacroRequestContext.contextPath}/img/logo.png"
                     alt="Логотип">
                <nav class="flex__header--button">
                    <#if user ??>
                        <form action="/panel">
                            <button class="site-header__button site-header__button--admin  flex__element">
                                <#if user.getStringRoles()?seq_contains("ADMIN")>Панель администратора<#else >Панель оператора</#if>
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
                        <form action="/logout">
                            <button class="site-header__button site-header__button--login flex__element">Выход</button>
                        </form>
                    <#else>
                        <form action="/login">
                            <button class="site-header__button site-header__button--login flex__element">Вход</button>
                        </form>
                    </#if>
                </nav>
            </div>
        </div>
    </header>
</#macro>