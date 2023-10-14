<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="LOGICADENEGOCIOS.CuentaCorreo"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Random"%>
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
        <form action="enviarCarton.jsp" method="post">
            <label for="cedula">Cédula del Jugador:</label>
            <input type="text" id="cedula" name="cedula" required>

            <label for="numCartones">Número de Cartones a Enviar:</label>
            <input type="number" id="numCartones" name="numCartones" min="1" required>

            <input type="submit" value="Enviar">
        </form>
        <a href="index.jsp">Volver al inicio</a>
        
        <%
            String cedula = request.getParameter("cedula");
            String numCartonesStr = request.getParameter("numCartones");
            if(cedula != null && numCartonesStr != null && !cedula.isEmpty() && !numCartonesStr.isEmpty()) {
                try {
                    int numCartones = Integer.parseInt(numCartonesStr);
                    File cartonesDir = new File("C:/Users/Daniel/Documents/GitHub/PP1---POO/Proyecto-GestorDeBingos/src/java/LOGICADENEGOCIOS/Cartones/");
                    File[] cartonesFiles = cartonesDir.listFiles();
                    Random random = new Random();
                    
                    // Validar si hay suficientes cartones para enviar
                    if(cartonesFiles.length >= numCartones) {
                        String[] archivosAdjuntos = new String[numCartones];
                        for(int i = 0; i < numCartones; i++) {
                            int randomIndex = random.nextInt(cartonesFiles.length);
                            archivosAdjuntos[i] = cartonesFiles[randomIndex].getAbsolutePath();
                        }
                        
                        // Enviar los cartones por correo
                        CuentaCorreo cuentaCorreo = new CuentaCorreo("gestorbingos@gmail.com");
                        cuentaCorreo.enviarCorreo("arcedaniel2901@gmail.com", archivosAdjuntos);
                        out.println("<p>Cartones enviados con éxito.</p>");
                    } else {
                        out.println("<p>Error: No hay suficientes cartones disponibles.</p>");
                    }
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

