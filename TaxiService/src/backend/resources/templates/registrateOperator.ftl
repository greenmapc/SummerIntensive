<html lang="en">
<head>
    <title>index</title>
</head>
<body>

<form method="post" class="col-10">
    <div class=" form-group">
        <label for="firstName">First name:</label>
        <input type="text" class="form-control" name="firstName" id="firstName" placeholder="Ivan">
    </div>
    <div class="form-group">
        <label for="lastName">Last name:</label>
        <input type="text" class="form-control" name="lastName" id="lastName" placeholder="Ivanov">
    </div>
    <div class="form-group">
        <label for="patronymic">Patronymic:</label>
        <input type="text" class="form-control" name="patronymic" id="patronymic" placeholder="Ivanovich">
    </div>
    <div class="form-group">
        <label for="email">E-mail:</label>
        <input type="text" class="form-control" name="email" id="email" placeholder="ivan.ivanov@mail.com">
    </div>
    <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" class="form-control" name="password" id="password">
    </div>
    <div class="form-group">
        <label for="repeatPassword">Repeat password:</label>
        <input type="password" class="form-control" name="repeatPassword" id="repeatPassword">
    </div>
    <div class="form-group">
        <label for="isOperator">OPERATOR</label>
        <input type="checkbox" value="true" name="isOperator" id="isOperator">
    </div>
    <button type="submit" class="btn btn-success">Registrate</button>
</form>
</body>
</html>
