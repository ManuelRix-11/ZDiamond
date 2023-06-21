<%@ page import="model.User" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <title>Document</title>
</head>
<body>
    <header>
        <nav class="main-nav">
            <a href="${pageContext.request.contextPath}/index.jsp" class="logo-container"><img src="https://raw.githubusercontent.com/ManuelRixDiscord/ProgettoTSW/main/imgs/LOGOshrinked.png" alt="" class="logo-image"></a>
            <ul class="nav-list">
                <li><a href="${pageContext.request.contextPath}/shop.jsp">Catalogo</a></li>
                <li><a href="${pageContext.request.contextPath}/results/bestseller.jsp">Best Seller</a></li>
                <li><a href="${pageContext.request.contextPath}/results/nuoviarrivi.jsp">Nuovi Arrivi</a></li>
                <li><a href="${pageContext.request.contextPath}/results/ultimipezzi.jsp">Ultimi Pezzi</a></li>
            </ul>
            <ul class="user-list">
                <li class="pop-out"><a onclick="openForm()"><img id="icon" src="${pageContext.request.contextPath}/imgs/defaultUser.png" alt="" class="user-icon"></a>
                    <form method="post" class="form-section" id="login-form" autocomplete="off">
                        <%
                            User user = (User) session.getAttribute("user");
                            if (user != null){
                        %>
                        <h3>${user.nome} ${user.cognome}</h3>
                        <a href="${pageContext.request.contextPath}/results/user-area.jsp">Accedi all'area utente</a>
                        <%
                            if (session.getAttribute("admin") != null)
                            {
                        %>
                        <a href="${pageContext.request.contextPath}/results/admin-prodotti.jsp">Aggiungi prodotti</a>
                        <%
                            }
                        %>
                        <a class="logout-button" href="${pageContext.request.contextPath}/logout">Log Out</a>
                        <%
                        }else{
                        %>
                        <h3>Log In</h3>
                        <input type="text" name="username" id="username" placeholder="username" required>
                        <input type="password" name="password" id="password" placeholder="password" required>
                        <input type="submit" id="login-button" value="Login">
                        <a class="register-nav" href="${pageContext.request.contextPath}/results/register.jsp">Register</a>
                        <h4 id="result-login"></h4>
                        <%
                            }
                        %>
                    </form>
                </li>
                <li><a href="${pageContext.request.contextPath}/results/cart.jsp"><img src="${pageContext.request.contextPath}/imgs/cartIcon.png" alt="" class="cart-icon"></a></li>
                <li>
                    <button class="media-nav">
                        <span class="line"></span>
                        <span class="line"></span>
                        <span class="line"></span>
                    </button>
                </li>
            </ul>
        </nav>
    </header>
    <script src="${pageContext.request.contextPath}/js/navbar.js"></script>
    <script src="${pageContext.request.contextPath}/js/login.js"></script>
</body>
</html>
