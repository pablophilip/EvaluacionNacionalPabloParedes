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
import modelos.Departamento;
import modelos.Gerencia;
import modelos.Requerimiento;
import modelos.Usuario;

/**
 *
 * @author pparedes
 */
public class DepartamentoDAO extends Conexion{
    
    public ArrayList<Departamento> obtenerDepartamento() throws ClassNotFoundException, SQLException{
        String sentencia = "select * from v_departamento";
        conectar();
        PreparedStatement ps= obtenerPS(sentencia);
        ResultSet rs = ps.executeQuery();
        ArrayList<Departamento> lista = new ArrayList();
        while(rs.next()){
            Gerencia g = new Gerencia(rs.getInt("id_gerencia"),rs.getString("g_nombre"));
            Requerimiento r = new Requerimiento(rs.getInt("id_requerimiento"),rs.getString("r_nombre"));
            Usuario u = new Usuario(rs.getString("id_usuario"),rs.getString("u_nombre"));
            lista.add(new Departamento(rs.getInt("id_departamento"),rs.getString("d_nombre"),
                      rs.getString("descripcion"),g,u,r));
        }
        desconectar();
        return lista;
    }
    
    public Departamento obtenerDepartamento(int id) throws ClassNotFoundException, SQLException{
        String sentencia = "select * from v_departamento where id = ?";
        conectar();
        PreparedStatement ps= obtenerPS(sentencia);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Departamento d = null;
        if(rs.next()){
           Gerencia g = new Gerencia(rs.getInt("id_gerencia"),rs.getString("g_nombre"));
           Requerimiento r = new Requerimiento(rs.getInt("id_requerimiento"),rs.getString("r_nombre"));
           Usuario u = new Usuario(rs.getString("id_usuario"),rs.getString("u_nombre"));
           d = new Departamento(rs.getInt("id_departamento"),rs.getString("g_nombre"),
                      rs.getString("descripcion"),g,u,r);
        }
        desconectar();
        return d;
    }
}
