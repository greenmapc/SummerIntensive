<#assign path_to_style="null"/>
<#macro layout title path_to_style="">
    <#import "/spring.ftl" as spring />
    <#assign style=path_to_style/>
    <!doctype html>
    <html lang="ru">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width = device-width, initial-scale = 1">
        <link type="text/css" href="${springMacroRequestContext.contextPath}/css/app.css" rel="stylesheet">
        <link type="text/css" href="${springMacroRequestContext.contextPath}/css/data__p--margin-left.css"
              rel="stylesheet">
        <link type="text/css" href="${springMacroRequestContext.contextPath}/css/site-header.css" rel="stylesheet">
        <link type="text/css" href="${springMacroRequestContext.contextPath}/css/form-flex.css" rel="stylesheet">
        <link type="text/css" href="${springMacroRequestContext.contextPath}/css/admin-screen__flex.css"
              rel="stylesheet">
        <link type="text/css" href="${springMacroRequestContext.contextPath}/css/admin-screen__svg.css"
              rel="stylesheet">
        <link type="text/css" href="${springMacroRequestContext.contextPath}/css/operator-screen__flex.css"
              rel="stylesheet">
        <link type="text/css" href="${springMacroRequestContext.contextPath}/css/operator-screen__svg.css"
              rel="stylesheet">
        <link type="text/css" href="${springMacroRequestContext.contextPath}/css/flex-container.css" rel="stylesheet">
        <link type="text/css" href="${springMacroRequestContext.contextPath}/css/text-area.css" rel="stylesheet">
        <link type="text/css" href="${springMacroRequestContext.contextPath}/css/data__flex.css" rel="stylesheet">
        <link type="text/css" href="${springMacroRequestContext.contextPath}/css/error-field.css" rel="stylesheet">
        <link type="text/css" href="${springMacroRequestContext.contextPath}/css/site-footer.css" rel="stylesheet">
        <#if style?contains('style.css') >
            <link type="text/css" href="${springMacroRequestContext.contextPath}/css/style.css" rel="stylesheet">
        <#else >
        </#if>
        <title>${title}</title>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script src="${springMacroRequestContext.contextPath}/js/act.js"></script>
    </head>
    <body class="site">
    <#nested>
    </body>
    </html>
</#macro>