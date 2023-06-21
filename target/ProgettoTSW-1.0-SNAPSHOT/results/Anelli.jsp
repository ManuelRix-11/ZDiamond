<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Catalogo" %>
<%@ page import="model.Gioiello" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="/catalogo"/>
<jsp:include page="/cart"/>
<jsp:include page="/components/navbar.jsp"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/results/stile.css">
    <title>Document</title>
</head>
<body>
<%
    User user = (User) session.getAttribute("user");
%>
<div>
    <div class="catalogue">
        <c:forEach items="${catalogo}" var="gioiello">
            <jsp:useBean id="gioiello" type="model.Gioiello" />
            <c:if test='<%=gioiello.getCategoria().equalsIgnoreCase("anelli")%>'>
                <div class="card">
                    <img src="${gioiello.immagine}" alt="">
                    <div class="card-inner">
                        <h3>${gioiello.modello}</h3>
                        <h2>&euro;${gioiello.prezzo}</h2>
                        <%
                            if(user!=null){
                        %>
                        <a href="${pageContext.request.contextPath}/cartAdd?gioiello=${gioiello.modello}&mode=add" class="buy-button" onclick="">BUY NOW</a>
                        <%
                        }else{
                        %>
                        <a class="buy-button inactive" onclick="">BUY NOW</a>
                        <%
                            }
                        %>
                    </div>
                    <%
                        if(user!=null){
                    %>
                    <div class="card-info">
                        <p><span>| Metallo :</span> ${gioiello.montatura.metallo}</p>
                        <p><span>| Purezza Metallo :</span> ${gioiello.montatura.purezza}</p>
                        <p><span>| Tipo Pietre :</span> ${gioiello.pietre.tipo}</p>
                        <p><span>| N.Pietre :</span> ${gioiello.pietre.quantita}</p>
                        <p><span>| Carati Pietre :</span> ${gioiello.pietre.caratura}</p>
                    </div>
                    <%
                    }else{
                    %>
                    <div class="card-info inactive">
                        <p><span>| Metallo :</span> ${gioiello.montatura.metallo}</p>
                        <p><span>| Purezza Metallo :</span> ${gioiello.montatura.purezza}</p>
                        <p><span>| Tipo Pietre :</span> ${gioiello.pietre.tipo}</p>
                        <p><span>| N.Pietre :</span> ${gioiello.pietre.quantita}</p>
                        <p><span>| Carati Pietre :</span> ${gioiello.pietre.caratura}</p>
                    </div>
                    <%
                        }
                    %>
                </div>
            </c:if>
        </c:forEach>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/generic.js"></script>
</body>
</html>
