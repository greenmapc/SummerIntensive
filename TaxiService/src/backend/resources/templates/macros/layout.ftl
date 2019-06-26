<#assign path_to_style="null"/>
<#macro layout title style>
    <#import "/spring.ftl" as spring />
    <!doctype html>
    <html lang="ru">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width = device-width, initial-scale = 1">
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous">
        <link type="text/css" href="${springMacroRequestContext.contextPath}/css/app.css" rel="stylesheet">
        <#if style??>
            <#if style = "admin_screen">
                <link type="text/css" href="${springMacroRequestContext.contextPath}/css/admin_screen.css" rel="stylesheet">
            <#elseif style = "create_operator">
                <link type="text/css" href="${springMacroRequestContext.contextPath}/css/create_operator.css" rel="stylesheet">
            <#elseif style = "auto_card">
                <link type="text/css" href="${springMacroRequestContext.contextPath}/css/auto_card.css" rel="stylesheet">
            <#elseif style = "auto_list">
                <link type="text/css" href="${springMacroRequestContext.contextPath}/css/auto_list.css" rel="stylesheet">
            <#elseif style = "login">
                <link type="text/css" href="${springMacroRequestContext.contextPath}/css/login.css" rel="stylesheet">
            <#elseif style = "driver_card">
                <link type="text/css" href="${springMacroRequestContext.contextPath}/css/driver_card.css" rel="stylesheet">
            <#elseif style = "driver_list">
                <link type="text/css" href="${springMacroRequestContext.contextPath}/css/driver_list.css" rel="stylesheet">
            <#elseif style = "operator_screen">
                <link type="text/css" href="${springMacroRequestContext.contextPath}/css/operator_screen.css" rel="stylesheet">
            <#else>
            </#if>
        </#if>
        <title>${title}</title>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script src="${springMacroRequestContext.contextPath}/js/act.js"></script>
    </head>
    <body class="site over-bootstrap__site">
    <#nested>
    </body>
    </html>
</#macro>