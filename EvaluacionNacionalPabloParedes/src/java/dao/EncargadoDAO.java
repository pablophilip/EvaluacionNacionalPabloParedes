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
import modelos.Encargado;
import modelos.Requerimiento;
import modelos.Usuario;

/**
 *
 * @author pparedes
 */
public class EncargadoDAO extends Conexion{
    
     public ArrayList<Encargado> obtenerEncargados() throws ClassNotFoundException, SQLException{
        String sentencia = "select * from v_encargado";
        conectar();
        PreparedStatement ps= obtenerPS(sentencia);
        ResultSet rs = ps.executeQuery();
        ArrayList<Encargado> lista = new ArrayList();
        while(rs.next()){
            Departamento d = new Departamento(rs.getInt("id_departamento"),rs.getString("d_nombre"));
            Requerimiento r = new Requerimiento(rs.getInt("id_requerimiento"),rs.getString("r_nombre"));
            Usuario u = new Usuario(rs.getString("id_usuario"),rs.getString("u_nombre"));
            lista.add(new Encargado(rs.getInt("id_encasrgado"),rs.getString("e_nombre"),
                      rs.getString("descripcion"),d,u,r));
        }
        desconectar();
        return lista;
    }
    
    public Encargado obtenerEncargado(int id) throws ClassNotFoundException, SQLException{
        String sentencia = "select * from v_encargado where id = ?";
        conectar();
        PreparedStatement ps= obtenerPS(sentencia);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Encargado e = null;
        if(rs.next()){
           Departamento d = new Departamento(rs.getInt("id_departamento"),rs.getString("d_nombre"));
           Requerimiento r = new Requerimiento(rs.getInt("id_requerimiento"),rs.getString("r_nombre"));
           Usuario u = new Usuario(rs.getString("id_usuario"),rs.getString("u_nombre"));
           e = new Encargado(rs.getInt("id_encargado"),rs.getString("e_nombre"),
                      rs.getString("descripcion"),d,u,r);
        }
        desconectar();
        return e;
    }
}

