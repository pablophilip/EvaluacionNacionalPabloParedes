/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.EstadoDAO;
import dao.RequerimientoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.Requerimiento;

/**
 *
 * @author pparedes
 */
@WebServlet(name = "ControladorRequerimiento", urlPatterns = {"/ControladorRequerimiento"})
public class ControladorRequerimiento extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        if(request.getParameter("accion")!=null){
        String accion = request.getParameter("accion");
        switch(accion){
            case "1": registrar(request,response);
                break;
            case "2": modificar(request,response);
                break;
           }
        }
    }
    
    private void registrar(HttpServletRequest request, HttpServletResponse response) throws IOException{
       try{
            int id = Integer.parseInt(request.getParameter("id").trim());
            String nombre = request.getParameter("nombre").trim();
            String descripcion = request.getParameter("descripcion").trim();
            int estado = Integer.parseInt(request.getParameter("estado").trim());
            if(id<1||nombre.isEmpty()||descripcion.isEmpty()||estado<1){
                response.sendRedirect("registroRequerimiento.jsp?msj=Campos incompletos");
            }else{
                EstadoDAO ed = new EstadoDAO();
                Requerimiento nuevoReq = new Requerimiento(id,nombre,descripcion,ed.obtenerEstado(nombre));
                RequerimientoDAO rd = new RequerimientoDAO();
                HttpSession sesion = request.getSession();
                if(rd.obtenerRequermiento(nuevoReq.getId_requerimiento())==null){
                    int respuesta = rd.registrarRequerimiento(nuevoReq);
                    if(respuesta==1){
                    response.sendRedirect("registroRequerimiento.jsp?msj=Requerimiento ingresado");
                    }else{
                    response.sendRedirect("registroRequerimiento.jsp?msj=Requerimiento no se puede registar");
                    }

                }else{
                    response.sendRedirect("registroRequerimiento.jsp?msj=Requerimiento ya existe");
                }
            }
           }catch(Exception e){
               response.sendRedirect("inicio.jsp?msj="+e.getMessage());
           }
    }
    
    private void modificar(HttpServletRequest request, HttpServletResponse response) throws IOException{
       try{
            int id = Integer.parseInt(request.getParameter("id").trim());
            String nombre = request.getParameter("nombre").trim();
            String descripcion = request.getParameter("descripcion").trim();
            int estado = Integer.parseInt(request.getParameter("estado").trim());
            if(id<1||nombre.isEmpty()||descripcion.isEmpty()||estado<1){
                response.sendRedirect("registroRequerimiento.jsp?msj=Campos incompletos");
            }else{
                EstadoDAO ed = new EstadoDAO();
                Requerimiento nuevoReq = new Requerimiento(id,nombre,descripcion,ed.obtenerEstado(nombre));
                RequerimientoDAO rd = new RequerimientoDAO();
                HttpSession sesion = request.getSession();
                if(rd.obtenerRequermiento(nuevoReq.getId_requerimiento())==null){
                    int respuesta = rd.modificarRequerimiento(nuevoReq);
                    if(respuesta==1){
                    response.sendRedirect("registroRequerimiento.jsp?msj=Requerimiento modificado");
                    }else{
                    response.sendRedirect("registroRequerimiento.jsp?msj=Requeimiento no se pudo modificar");
                    }

                }else{
                    response.sendRedirect("registroRequerimiento.jsp?msj=Requerimiento ya existe");
                }
            }
           }catch(Exception e){
               response.sendRedirect("inicio.jsp?msj="+e.getMessage());
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
