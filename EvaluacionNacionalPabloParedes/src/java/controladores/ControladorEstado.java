/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.EstadoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Estado;

/**
 *
 * @author pparedes
 */
@WebServlet(name = "ControladorEstado", urlPatterns = {"/ControladorEstado"})
public class ControladorEstado extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            if(request.getParameter("accion")!=null){
            String accion = request.getParameter("accion");
            switch(accion){
                case "1": registrar(request,response);
                    break;
                case "2": modificar(request,response);
                    break;
                
            }
        }else{
            response.sendRedirect("estados.jsp?=No tienes permitido hacer eso");
        }
        
    }
    
    private void registrar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try{
            String nombre = request.getParameter("nombre").trim();
            if(nombre.isEmpty()){
            response.sendRedirect("estados.jsp?msj=valores erroneos");
            }else{
                EstadoDAO ed = new EstadoDAO();
                Estado nuevoEstado = new Estado(nombre);
                if(ed.obtenerEstado(nuevoEstado.getNombre())==null){
                int respuesta = ed.registarEstado(nuevoEstado);
                if(respuesta==1){
                    response.sendRedirect("estados.jsp?msj=Estado ingresado");
                        
                }else{
                    response.sendRedirect("estados.jsp?msj=Estado no se puede registar");
                }
            }else{
                response.sendRedirect("estados.jsp?msj=Estado ya existe");
            }
            }
        }catch(Exception e){
            response.sendRedirect("estados.jps="+e.getMessage());
        }
    }
    
    private void modificar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try{
            int id = Integer.parseInt(request.getParameter("id").trim());
            String nombre = request.getParameter("nombre").trim();
            if(id<1||nombre.isEmpty()){
            response.sendRedirect("estados.jsp?msj=valores erroneos");
            }else{
                Estado nuevoEstado = new Estado(id,nombre);
                EstadoDAO ed = new EstadoDAO();
                if(ed.obtenerEstado(nuevoEstado.getId())==null){
                int respuesta = ed.modificarEstado(nuevoEstado);
                if(respuesta==1){
                    response.sendRedirect("estados.jsp?msj=Estado modificado");
                        
                }else{
                    response.sendRedirect("estados.jsp?msj=Estado no se puede ser modificado");
                }
            }else{
                response.sendRedirect("estados.jsp?msj=Estado ya existe");
            }
            }
        }catch(Exception e){
            response.sendRedirect("estados.jps="+e.getMessage());
        }
    }
    
   
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
