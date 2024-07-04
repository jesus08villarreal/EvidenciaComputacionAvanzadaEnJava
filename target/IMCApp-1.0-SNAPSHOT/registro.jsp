<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registro</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h1>Registro de Usuario</h1>
    <form action="registro" method="post">
        <label for="nombreCompleto">Nombre Completo:</label>
        <input type="text" id="nombreCompleto" name="nombreCompleto" required><br>

        <label for="nombreUsuario">Nombre de Usuario:</label>
        <input type="text" id="nombreUsuario" name="nombreUsuario" required><br>

        <label for="password">ContraseÃ±a:</label>
        <input type="password" id="password" name="password" required><br>

        <label for="edad">Edad:</label>
        <input type="number" id="edad" name="edad" required><br>

        <label for="sexo">Sexo:</label>
        <select id="sexo" name="sexo">
            <option value="M">Masculino</option>
            <option value="F">Femenino</option>
        </select><br>

        <label for="estatura">Altura (en cm):</label>
        <input type="number" step="0.01" id="estatura" name="estatura" required><br>
        
        <label for "peso">Masa corporal (en kg): </label>
        <input type="number" step="0.01" id="peso" name="peso" required><br>

        <button type="submit">Registrar</button>
    </form>
    <c:if test="${not empty error}">
        <p style="color:red">${error}</p>
    </c:if>
    
    <c:if test="${not empty mensaje}">
        <p style="color:green">${mensaje}</p>
    </c:if>
    <a href="index">Iniciar SesiÃ³n</a>
</body>
</html>
