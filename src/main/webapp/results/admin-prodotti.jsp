<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/components/navbar.jsp" />
<jsp:include page="/catalogo"/>
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
    <div class="admin-prod-page">
        <div class="prod-list">
            <div id="legend" class="prod-item">
                <p>Modello</p>
                <p>Descrizione</p>
                <p>Prezzo</p>
                <p>In Stock</p>
            </div>
            <c:forEach items="${catalogo}" var="gioiello">
                <div class="prod-item">
                    <p>${gioiello.modello}</p>
                    <p>${gioiello.montatura.metallo}</p>
                    <p>${gioiello.prezzo}</p>
                    <p>${gioiello.pezzidisponibili}</p>
                </div>
            </c:forEach>
        </div>
        <form data-multi-step action="${pageContext.request.contextPath}/product-add" class="add-form" method="post"
            autocomplete="off">
            <div class="form-card" data-step>
                <div class="form-group">
                    <h2>Informazioni Gioiello</h2>
                    <input type="text" name="matricola" id="matricola" placeholder="Matricola Gioiello">
                    <input type="text" name="modello" id="modello" placeholder="Modello Gioiello">
                    <input type="text" name="categoria" id="categoria" placeholder="Categoria Gioiello">
                    <input type="text" name="prezzo" id="prezzo" placeholder="Prezzo Gioiello">
                    <input type="text" name="pezziDisponibile" id="pezziDisponibile" placeholder="Pezzi Disponibili">
                    <input type="text" name="pezziVenduti" id="pezziVenduti" placeholder="Pezzi Venduti">
                    <input type="text" name="immagine" id="immagine" placeholder="Link Immagine">
                    <button class="register-button" type="button" data-next>Next</button>
                </div>
            </div>
            <div class="form-card" data-step>
                <div class="form-group">
                    <h2>Informazioni Pietre</h2>
                    <input type="text" name="codicePietre" id="codicePietre" placeholder="Codice Pietre">
                    <input type="text" name="tipoPietre" id="tipoPietre" placeholder="Tipo Pietre">
                    <input type="text" name="caraturaPietre" id="caraturaPietre" placeholder="Caratura Pietre">
                    <input type="text" name="dimensionePietre" id="dimensionePietre" placeholder="Dimensione Pietre">
                    <input type="text" name="quantitaPietre" id="quantitaPietre" placeholder="Quantità Pietre">
                    <input type="text" name="prezzoPietre" id="prezzoPietre" placeholder="Prezzo Pietre">
                    <div class="flex-buttons">
                        <button class="register-button" type="button" data-prev>Previous</button>
                        <button class="register-button" type="button" data-next>Next</button>
                    </div>
                </div>
            </div>
            <div class="form-card" data-step>
                <div class="form-group">
                    <h2>Informazioni Montatura</h2>
                    <input type="text" name="codiceMontatura" id="codiceMontatura" placeholder="Codice Montatura">
                    <input type="text" name="pesoMontatura" id="pesoMontatura" placeholder="Peso Montatura">
                    <input type="text" name="metalloMontatura" id="metalloMontatura" placeholder="Metallo Montatura">
                    <input type="text" name="purezzaMontatura" id="purezzaMontatura" placeholder="Purezza Montatura">
                    <input type="text" name="prezzoMontatura" id="prezzoMontatura" placeholder="Prezzo Montatura">
                    <div class="flex-buttons">
                        <button class="register-button" type="button" data-prev>Previous</button>
                        <input class="register-button" type="submit" value="Register">
                    </div>
                </div>
            </div>
        </form>
    </div>
    <script src="${pageContext.request.contextPath}/js/generic.js"></script>
</body>
</html>