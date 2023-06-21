<jsp:include page="/components/navbar.jsp"/>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/results/stile.css">
    <title>Document</title>
</head>
<body>
<div class="user-card">
    <div class="user-intro">
        <h2>${user.nome} ${user.cognome}</h2>
        <a href="${pageContext.request.contextPath}/logout">LogOut</a>
    </div>
    <div class="user-info">
        <div class="user-section">
            <h3>Informazioni Account</h3>
            <p>Mail: ${user.mail}</p>
            <p>Password: ${user.pasw}</p>
        </div>
        <div class="user-section">
            <h3>Informazioni Personali</h3>
            <p>Nome: ${user.nome}</p>
            <p>Cognome: ${user.cognome}</p>
        </div>
        <div class="user-section">
            <h3>Informazioni di Recapito</h3>
            <p>Città: ${user.citta}</p>
            <p>Via: ${user.via}</p>
            <p>Numero civico: ${user.ncivico}</p>
        </div>
    </div>
</div>
</body>
</html>
