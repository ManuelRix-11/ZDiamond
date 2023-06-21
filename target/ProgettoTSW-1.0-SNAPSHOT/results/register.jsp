<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<body class="register-page">
    <form data-multi-step class="register-form" method="post" action="${pageContext.request.contextPath}/Register" autocomplete="off">
        <div class="form-card" data-step>
            <div class="form-group">
                <h2>Account Information</h2>
                <input type="email" name="mail" id="mail" placeholder="Email" required>
                <input type="password" name="password" id="password" placeholder="Password" required>
                <input type="password" name="confpasw" id="confpasw" placeholder="Confirm password" required>
                <button class="register-button" type="button" data-next>Next</button>
            </div>
        </div>
        <div class="form-card" data-step>
            <div class="form-group">
                <h2>Personal Information</h2>
                <input type="text" name="nome" id="nome" placeholder="Nome" required>
                <input type="text" name="cognome" id="cognome" placeholder="Cognome" required>
                <div class="flex-buttons">
                    <button class="register-button" type="button" data-prev>Previous</button>
                    <button class="register-button" type="button" data-next>Next</button>
                </div>
            </div>
        </div>
        <div class="form-card" data-step>
            <div class="form-group">
                <h2>Delivery Information</h2>
                <input type="text" name="citta" id="citta" placeholder="Città" required>
                <input type="text" name="via" id="via" placeholder="Via" required>
                <input type="text" name="ncivico" id="ncivico" placeholder="N. Civico" required>
                <div class="flex-buttons">
                    <button class="register-button" type="button" data-prev>Previous</button>
                    <button class="register-button" type="button" data-next>Next</button>
                </div>
            </div>
        </div>
        <div class="form-card" data-step>
            <div class="form-group">
                <h2>Payment information</h2>
                <input type="text" name="cartaconto" id="cartaconto" placeholder="Codice carta/conto" required>
                <input type="text" name="cvv" id="cvv" placeholder="CVV" required>
                <input type="text" name="tipo" id="tipo" placeholder="Carta/Conto" required>
                <div class="flex-buttons">
                    <button class="register-button" type="button" data-prev>Previous</button>
                    <input class="register-button" type="submit" value="Register">
                </div>
            </div>
        </div>
    </form>
    <script src="${pageContext.request.contextPath}/js/generic.js"></script>
</body>
</html>