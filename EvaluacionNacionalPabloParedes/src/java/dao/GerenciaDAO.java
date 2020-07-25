/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.Gerencia;
import modelos.Requerimiento;
import modelos.Usuario;

/**
 *
 * @author pparedes
 */
public class GerenciaDAO extends Conexion{
    
    public ArrayList<Gerencia> obtenerGerencias() throws ClassNotFoundException, SQLException{
        String sentencia = "select * from v_gerencias";
        conectar();
        PreparedStatement ps= obtenerPS(sentencia);
        ResultSet rs = ps.executeQuery();
        ArrayList<Gerencia> lista = new ArrayList();
        while(rs.next()){
            Requerimiento r = new Requerimiento(rs.getInt("id_requerimiento"),rs.getString("r_nombre"));
            Usuario u = new Usuario(rs.getString("id_usuario"),rs.getString("nombre"));
            lista.add(new Gerencia(rs.getInt("id_gerencia"),rs.getString("g_nombre"),
                      rs.getString("descripcion"),u,r));
        }
        desconectar();
        return lista;
    }
    
    public Gerencia obtenerGerencia(int id) throws ClassNotFoundException, SQLException{
        String sentencia = "select * from v_gerencia where id = ?";
        conectar();
        PreparedStatement ps= obtenerPS(sentencia);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Gerencia g = null;
        if(rs.next()){
           Requerimiento r = new Requerimiento(rs.getInt("id_requerimiento"),rs.getString("r_nombre"));
           Usuario u = new Usuario(rs.getString("id_usuario"),rs.getString("nombre"));
           g = new Gerencia(rs.getInt("id_gerencia"),rs.getString("g_nombre"),
                      rs.getString("descripcion"),u,r);
        }
        desconectar();
        return g;
    }
}
