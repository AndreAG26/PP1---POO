<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bingo Virtual - Enviar Cartón</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <h2>Enviar Cartón a Jugador</h2>
        <form action="EnviarCartonServlet" method="post">
            <label for="cedula">Cédula del Jugador:</label>
            <input type="text" id="cedula" name="cedula" required>

            <label for="numCartones">Número de Cartones a Enviar:</label>
            <input type="number" id="numCartones" name="numCartones" min="1" required>

            <input type="submit" value="Enviar">
        </form>
        <a href="index.jsp">Volver al inicio</a>
    </div>
</body>
</html>
