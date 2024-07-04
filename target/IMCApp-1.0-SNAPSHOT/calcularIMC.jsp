<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calcular IMC</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <c:choose>
        <c:when test="${empty sessionScope.nombreUsuario}">
            <script type="text/javascript">
                window.location.href = 'index.jsp';
            </script>
        </c:when>
        <c:otherwise>
            <h1>Calcular IMC</h1>
            <form action="calcularIMC" method="post">
                <label for="masaCorporal">Masa Corporal (en kg):</label>
                <input type="number" step="0.01" id="masaCorporal" name="masaCorporal" required><br>
                <button type="submit">Calcular</button>
            </form>
            <c:if test="${not empty error}">
                <p style="color:red">${error}</p>
            </c:if>
        </c:otherwise>
    </c:choose>
    <a href="historialIMC">Ver historial</a>
</body>
</html>
