<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bingo Virtual - Iniciar Juego</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <h2>Iniciar Juego de Bingo</h2>
        <li><a href="generarCartones.jsp">Generar Cartones</a></li>
        <form action="IniciarJuegoServlet" method="post">
            <label for="configuracion">Configuración de Juego:</label>
            <select id="configuracion" name="configuracion" required>
                <option value="x">Jugar en X</option>
                <option value="esquinas">Cuatro Esquinas</option>
                <option value="lleno">Cartón Lleno</option>
                <option value="z">Jugar en Z</option>
            </select>

            <label for="premio">Monto del Premio:</label>
            <input type="number" id="premio" name="premio" required>

            <input type="submit" value="Iniciar Juego">
        </form>
        <a

