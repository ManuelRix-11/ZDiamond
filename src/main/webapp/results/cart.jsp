<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/components/navbar.jsp"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/results/stile.css">
    <title>Titolo</title>
</head>
<body>
<div class="cart">
    <div class="cart-list">
        <c:forEach items="${carrello}" var="gioiello">
                <div class="cart-item">
                    <img src="${gioiello.key.immagine}" alt="">
                    <div class="item-description">
                        <h2>${gioiello.key.modello}</h2>
                        <h3>€${gioiello.key.prezzo}</h3>
                    </div>
                    <div class="quantity-menu">
                        <form method="post" action="${pageContext.request.contextPath}/cartAdd">
                            <input type="hidden" name="gioiello" value="${gioiello.key.modello}">
                            <input type="hidden" name="mode" value="lessupdate">
                            <button class="less-button" type="submit">-</button>
                        </form>
                        <h2>${gioiello.value}</h2>
                        <form method="post" action="${pageContext.request.contextPath}/cartAdd">
                            <input type="hidden" name="gioiello" value="${gioiello.key.modello}">
                            <input type="hidden" name="mode" value="addupdate">
                            <button class="more-button" type="submit">+</button>
                        </form>
                    </div>
                </div>
            <hr>
        </c:forEach>
    </div>
    <div class="buy-zone">
        <h2>Totale: ${totale}</h2>
        <form action="${pageContext.request.contextPath}/completeBuy" method="post">
            <button class="buy-cart" type="submit">Completa l'acquisto</button>
        </form>
        <form action="${pageContext.request.contextPath}/cartAdd" method="post">
            <input type="hidden" name="mode" value="emptyupdate">
            <button class="empty-cart" type="submit">Svuota carrello</button>
        </form>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/generic.js"></script>
</body>
</html>
