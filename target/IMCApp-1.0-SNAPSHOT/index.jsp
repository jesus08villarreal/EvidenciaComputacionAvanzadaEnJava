<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    </script>
</head>
<body>
    <h1>Bienvenido a la Aplicación de IMC</h1>
    <div id="loginForm">
        <form action="login" method="post">
            <h2>Iniciar Sesión</h2>
            <label for="nombreUsuario">Nombre de Usuario:</label>
            <input type="text" id="nombreUsuario" name="nombreUsuario" required><br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br>
            <input type="submit" value="Iniciar Sesión">
        </form>
        <button onclick="showRegistro()">Registrar Usuario</button>
    </div>
    <div id="registroForm" style="display:none;">
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
        <button onclick="showLogin()">Iniciar Sesión</button>
    </div>
</body>
</html>
