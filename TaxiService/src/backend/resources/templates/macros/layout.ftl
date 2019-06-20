<#macro layout title>
    <!doctype html>
    <html lang="ru">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link href="${springMacroRequestContext.contextPath}/css/app.css" rel="stylesheet">
        <link href="${springMacroRequestContext.contextPath}/css/form-flex.css" rel="stylesheet">
        <title>${title}</title>
    </head>
    <body class="site">
    <#nested>
    </body>
    </html>
</#macro>