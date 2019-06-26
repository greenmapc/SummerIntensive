<#macro navbar>
    <header class="site-header bootstrap__site-header">
        <nav class="bootstrap__nav navbar navbar-expand-lg navbar-light">
            <a class="navbar-brand" href="/panel">
                <img class="site-header__logo" src="${springMacroRequestContext.contextPath}/img/logo.png"
                     alt="Логотип"></a>
            <button
                    class="navbar-toggler"
                    type="button"
                    data-toggle="collapse"
                    data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent"
                    aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <#if user ??>
                        <li class=" nav-item active">
                            <a class="nav-link" href="/panel"><p class="site-header__menu-item">Панель
                                    администратора</p> <span
                                        class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/drivers"><p class="site-header__menu-item">База водителей</p></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/autos"><p class="site-header__menu-item">База автомобилей</p></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/logout"><p class="site-header__menu-item">Выход</p></a>
                        </li>
                    <#else >
                        <li class="nav-item">
                            <a class="nav-link" href="/login"><p class="site-header__menu-item">Вход</p></a>
                        </li>
                    </#if>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="bootstrap__input form-control mr-sm-2" type="search" placeholder="Я ищу..."
                           aria-label="Поиск">
                    <button class="bootstrap__button btn btn-outline-success my-2 my-sm-0" type="submit">Найти</button>
                </form>
            </div>
        </nav>
    </header>
</#macro>