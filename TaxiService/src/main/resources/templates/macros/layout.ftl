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
            <link type="text/css" rel="stylesheet" href="${springMacroRequestContext.contextPath}/css/${style}.css">
        </#if>
        <title>${title}</title>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script src="${springMacroRequestContext.contextPath}/js/app.js"></script>
    </head>
    <body class="site over-bootstrap__site">
    <#nested>
    </body>
    </html>
</#macro>