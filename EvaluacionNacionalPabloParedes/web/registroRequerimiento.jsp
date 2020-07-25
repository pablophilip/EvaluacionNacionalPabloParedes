<%-- 
    Document   : registroRequerimiento
    Created on : 25-07-2020, 14:01:54
    Author     : pparedes
--%>

<%@page import="dao.EncargadoDAO"%>
<%@page import="modelos.Encargado"%>
<%@page import="dao.AsginarDAO"%>
<%@page import="modelos.Asignar"%>
<%@page import="dao.DepartamentoDAO"%>
<%@page import="modelos.Departamento"%>
<%@page import="dao.GerenciaDAO"%>
<%@page import="modelos.Gerencia"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Requerimiento</title>
    </head>
    <body>
        <form action="ControladorRequerimiento" method="post">
            <table>
            <tr>
               <td>Gerencia:</td>
                <td><select name="gerencia">
                            <option value="0">Seleccione</option>
                            <% ArrayList<Gerencia> gerencia = new GerenciaDAO().obtenerGerencias();
                            for(Gerencia g:gerencia){%>
                            <option value="<%= g.getId_gerencia() %>"><%= g %></option>
                            <% } %>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Depto:</td>
                <td><select name="departamento">
                            <option value="0">Seleccione</option>
                            <% ArrayList<Departamento> departamento = new DepartamentoDAO().obtenerDepartamento();
                            for(Departamento d:departamento){%>
                            <option value="<%= d.getId_departamento() %>"><%= d %></option>
                            <% } %>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Asignar:</td>
                <td><select name="asignar">
                            <option value="0">Seleccione</option>
                            <% ArrayList<Asignar> asignar = new AsginarDAO().obtenerAsignar();
                            for(Asignar a:asignar){%>
                            <option value="<%= a.getId_asignar() %>"><%= a %></option>
                            <% } %>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Encargado:</td>
                <td><select name="encargado">
                            <option value="0">Seleccione</option>
                            <% ArrayList<Encargado> encargado = new EncargadoDAO().obtenerEncargados();
                            for(Encargado e:encargado){%>
                            <option value="<%= e.getId_encargado() %>"><%= e %></option>
                            <% } %>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Requerimiento:</td>
                <td><textarea cols="18" rows="5" name="descripcion"></textarea></td>
                
            </tr>
            <tr>
                <td><input type="reset" value="Limpiar"/></td>
                <td><input type="submit" value="Guardar"/></td>
            </tr>
            
        </table>
            <input type="hidden" name="accion" value="1"/>
        </form>
        <% if(request.getParameter("msj")!= null){%>
        <h3><%= request.getParameter("msj") %></h3>
        <%}%>
        
    </center>
    </body>
</html>
