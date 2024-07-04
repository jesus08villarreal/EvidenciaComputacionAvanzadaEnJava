<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Resultado IMC</title>
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
            <h2>Resultado IMC</h2>
            <p>Tu IMC es: ${imc}</p>
            <a href="index.jsp">Volver al inicio</a>
        </c:otherwise>        
    </c:choose>
    <a href="historialIMC">Ver historial</a>
</body>
</html>
