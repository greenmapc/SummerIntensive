<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>TaxiService. Карта авто</title>
    <link href="${springMacroRequestContext.contextPath}/css/app.css" rel="stylesheet">
</head>
<body class="site">
   <#include "../header/basicHeader.ftl">
    <div class="layout-positioner">
        <h1>База данных автомобилей > Автомобиль ${auto.id}</h1>

        <h3>Марка/бренд</h3>
        <p>${auto.model} / ${auto.brand}</p>

        <h3>Внешний вид</h3>
        <p>${auto.description}</p>

        <h3>Фотографии</h3>
        <img src="" alt="Фото автомобиля в текущем состоянии 1">
        <img src="" alt="Фото автомобиля в текущем состоянии 2">
        <img src="" alt="Фото автомобиля в текущем состоянии 3">
        <img src="" alt="Фото автомобиля в текущем состоянии 4">

        <h3>VIN</h3>
        <p>${auto.vinNumber}</p>

        <h3>Гос. номер</h3>
        <p>${auto.gosNumber}</p>

        <h3>Цвет </h3>
        <p>${auto.color} </p>

        <h3>Привод</h3>
        <p>${auto.drive}</p>

        <h3>Киллометраж</h3>
        <p>${auto.kilometrage}</p>
    </div>
</body>
</html>