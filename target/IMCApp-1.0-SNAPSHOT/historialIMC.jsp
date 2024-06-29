<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Historial IMC</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h1>Historial de IMC</h1>
    <table border="1">
        <tr>
            <th>Fecha</th>
            <th>IMC</th>
        </tr>
        <c:forEach var="medicion" items="${historial}">
            <tr>
                <td>${medicion.fecha}</td>
                <td>${medicion.imc}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="calcularIMC.jsp">Calcular nuevo IMC</a>
</body>
</html>
