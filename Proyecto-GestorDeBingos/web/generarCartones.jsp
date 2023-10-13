<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="LOGICADENEGOCIOS.Carton"%>
<%@page import="LOGICADENEGOCIOS.Juego"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bingo Virtual - Generar Cartones</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <h2>Generar Cartones</h2>
        <form action="generarCartones.jsp" method="post">
            <label for="numCartones">Número de Cartones:</label>
            <input type="number" id="numCartones" name="numCartones" min="1" max="500" required>
            <input type="submit" value="Generar">
        </form>
        <a href="index.jsp">Volver al inicio</a>
  
        <%
            
            String numCartonesStr = request.getParameter("numCartones");
            if(numCartonesStr != null && !numCartonesStr.isEmpty()) {
                try {
                    int numCartones = Integer.parseInt(numCartonesStr);
                    for(int i = 0; i < numCartones; i++) {
                        Juego juego = new Juego();
                        juego.crearCartones(numCartones);
                        }
                    out.println("<p>Cartones generados con éxito.</p>");
                } catch(NumberFormatException e) {
                    out.println("<p>Error: Debe ingresar un número válido.</p>");
                } catch(Exception e) {
                    out.println("<p>Error: " + e.getMessage() + "</p>");
                }
            }
        %>
    </div>
</body>
</html>

