<!DOCTYPE html>
<html>
<head>
    <title>Registro</title>
</head>
<body>
    <h2>Registro</h2>
    <form action="registro" method="post">
        Nombre Completo: <input type="text" name="nombreCompleto" required><br>
        Nombre de Usuario: <input type="text" name="nombreUsuario" required><br>
        Edad: <input type="number" name="edad" required><br>
        Sexo: 
        <select name="sexo" required>
            <option value="M">Masculino</option>
            <option value="F">Femenino</option>
        </select><br>
        Estatura (metros): <input type="number" step="0.01" name="estatura" required><br>
        Peso (kg): <input type="number" step="0.01" name="peso" required><br>
        Contraseña: <input type="password" name="password" required><br>
        <input type="submit" value="Registrar">
    </form>
</body>
</html>
