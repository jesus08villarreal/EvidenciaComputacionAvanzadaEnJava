<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>IMC App - Inicio</title>
    <link rel="stylesheet" href="styles.css">
    <script>
        function showLogin() {
            document.getElementById("loginForm").style.display = "block";
            document.getElementById("registroForm").style.display = "none";
        }

        function showRegistro() {
            document.getElementById("loginForm").style.display = "none";
            document.getElementById("registroForm").style.display = "block";
        }

        window.onload = function() {
            const urlParams = new URLSearchParams(window.location.search);
            if (urlParams.has('registered') && urlParams.get('registered') === 'true') {
                alert('Registro exitoso. Por favor, inicia sesión.');
                showLogin();
            }
        };
    </script>
</head>
<body>
    <h1>Bienvenido a la Aplicación de IMC</h1>

    <c:if test="${not empty error}">
        <p style="color:red">${error}</p>
    </c:if>

    <c:choose>
        <c:when test="${empty sessionScope.nombreUsuario}">
            <div id="loginForm" style="<%= (request.getParameter("registered") != null) ? "display:block;" : "display:none;" %>">
                <form action="login" method="post">
                    <h2>Iniciar Sesión</h2>
                    <label for="nombreUsuario">Nombre de Usuario:</label>
                    <input type="text" id="nombreUsuario" name="nombreUsuario" required><br>
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" required><br>
                    <input type="submit" value="Iniciar Sesión">
                </form>
                <button type="button" onclick="showRegistro()">Registrar Usuario</button>
            </div>

            <div id="registroForm" style="<%= (request.getParameter("registered") == null) ? "display:block;" : "display:none;" %>">
                <form action="registro" method="post">
                    <h2>Registrar Usuario</h2>
                    <label for="nombreCompleto">Nombre Completo:</label>
                    <input type="text" id="nombreCompleto" name="nombreCompleto" required><br>
                    <label for="nombreUsuario">Nombre de Usuario:</label>
                    <input type="text" id="nombreUsuario" name="nombreUsuario" required><br>
                    <label for="edad">Edad:</label>
                    <input type="number" id="edad" name="edad" required><br>
                    <label for="sexo">Sexo:</label>
                    <select id="sexo" name="sexo">
                        <option value="M">Masculino</option>
                        <option value="F">Femenino</option>
                    </select><br>
                    <label for="estatura">Estatura (m):</label>
                    <input type="number" step="0.01" id="estatura" name="estatura" required><br>
                    <label for="peso">Peso (kg):</label>
                    <input type="number" step="0.1" id="peso" name="peso" required><br>
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" required><br>
                    <input type="submit" value="Registrar">
                </form>
                <button type="button" onclick="showLogin()">Iniciar Sesión</button>
            </div>
        </c:when>
        <c:otherwise>
            <p>Bienvenido, ${sessionScope.nombreUsuario}</p>
            <a href="calcularIMC.jsp">Calcular IMC</a>
            <a href="historialIMC.jsp">Ver historial</a>
        </c:otherwise>
    </c:choose>
</body>
</html>
