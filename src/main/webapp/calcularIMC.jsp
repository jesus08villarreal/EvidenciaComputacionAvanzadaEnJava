<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calcular IMC</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h1>Calcular IMC</h1>
    <form action="calcularIMC" method="post">
        <label for="peso">Peso (kg):</label>
        <input type="number" step="0.1" id="peso" name="peso" required><br>
        <input type="submit" value="Calcular IMC">
    </form>
    <a href="historialIMC">Ver Historial de IMC</a>
</body>
</html>
