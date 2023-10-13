<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="dao.daoJugador"%>
<%@page import="LOGICADENEGOCIOS.Jugador"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bingo Virtual - Registrar Jugador</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <h2>Registrar Jugador</h2>
        <form action="registrarJugador.jsp" method="post">
            <label for="nombre">Nombre Completo:</label>
            <input type="text" id="nombre" name="nombre" required>

            <label for="correo">Correo Electrónico:</label>
            <input type="email" id="correo" name="correo" required>

            <label for="cedula">Cédula:</label>
            <input type="text" id="cedula" name="cedula" required>

            <input type="submit" value="Registrar">
        </form>
        <a href="index.jsp">Volver al inicio</a>
        <%
            String nombre = request.getParameter("nombre");
            String correo = request.getParameter("correo");
            String cedulaStr = request.getParameter("cedula");
            
            if(nombre != null && correo != null && cedulaStr != null) {
                try {
                    Jugador jugador = new Jugador();
                    daoJugador dao = new daoJugador();
                    
                    jugador.setNombreCompleto(nombre);
                    jugador.setCorreo(correo);
                    int cedulaJugador = Integer.parseInt(cedulaStr);
                    jugador.setCedula(cedulaJugador);
                    
                    if (dao.insertJugador(jugador)){
                        out.println("Inserción exitosa");
                    }else{
                        out.println("ERROR");
                    }
                } catch(NumberFormatException e) {
                    out.println("Error: Formato de número inválido");
                } catch(Exception e) {
                    out.println("Error: " + e.getMessage());
                }
            }
        %>
    </div>
</body>
</html>

