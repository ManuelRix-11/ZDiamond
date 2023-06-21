<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="components/navbar.jsp"/>
<jsp:include page="/catalogo"/>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/results/stile.css">
    <title>DiamondZ</title>
</head>
<body>
<div class="img-slider">
    <div class="slide active" id="slide1">
        <img src="https://raw.githubusercontent.com/ManuelRixDiscord/ProgettoTSW/main/imgs/slideshow-desktop-60-106-732.jpg" alt="">
    </div>
    <div class="slide" id="slide2">
        <img src="https://raw.githubusercontent.com/ManuelRixDiscord/ProgettoTSW/main/imgs/armillas.jpg" alt="">
    </div>
    <div class="slide" id="slide3">
        <img src="https://raw.githubusercontent.com/ManuelRixDiscord/ProgettoTSW/main/imgs/2000x1000_BANNER-ANELLI.jpeg" alt="">
    </div>
    <div class="navigation">
        <div class="btn active"></div>
        <div class="btn"></div>
        <div class="btn"></div>
    </div>
</div>

    <section class="section category">
        <h2>Shop by Category</h2>
        <div class="shop-category">
            <c:forEach items="${categorie}" var="check">
                <div class="category-box" onclick="location.href='${pageContext.request.contextPath}/results/${check}.jsp'">
                    <div class="category-inner"></div>
                    <h4>${check}</h4>
                </div>
            </c:forEach>
        </div>
    </section>
    <section class="section newentry">
        <h2>New Entry</h2>
        <div class="new-entry">
            <c:forEach items="${newentry}" var="gioiello">
                <div class="entry-box box" style="background-image: url(${gioiello.immagine})">
                    <h4>${gioiello.modello}</h4>
                </div>
            </c:forEach>
        </div>
    </section>
    <section class="section bestseller">
        <h2>BestSeller</h2>
        <div class="best-seller">
            <c:forEach items="${bestseller}" var="gioiello">
                <div class="bestseller-box box" style="background-image: url(${gioiello.immagine})">
                    <h4>${gioiello.modello}</h4>
                </div>
            </c:forEach>
        </div>
    </section>
    <script src="js/generic.js"></script>
    <script src="js/home.js"></script>
</body>
</html>