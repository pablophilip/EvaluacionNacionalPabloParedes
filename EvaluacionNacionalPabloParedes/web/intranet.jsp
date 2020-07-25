<%-- 
    Document   : intranet
    Created on : 11-07-2020, 20:48:34
    Author     : pparedes
--%>

<%@page import="modelos.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Intranet</title>
    </head>
    <body>
        <center>
        <h1>Bienvenido
            <% if(session.getAttribute("usuario")!= null){
             Usuario u = (Usuario) session.getAttribute("usuario");
            %>
        <h3><%= u.getNombre()+" "+u.getApellido() %></h3>
        <%}else{response.sendRedirect("inicio.jsp?msj=acceso denegado");}%>
        </h1>
        <a href="Salir"><input type="button" value="Cerrar Sesion"/></a>
        <h1>Bienvenido</h1>
        <menu >
            <a href="registroRequerimiento.jsp">
            <menuitem >Ingresar requerimiento</menuitem>
            </a> |
            <a href="consultarRequerimiento.jsp">
            <menuitem >Consultar Requerimiento</menuitem>
            </a> | 
            <a href="cerrarRequerimiento.jsp">
            <menuitem >Cerrar Requerimiento</menuitem>
            </a> 
        </menu>
        
      </center>
    </body>
</html>
