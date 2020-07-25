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
import modelos.Estado;

/**
 *
 * @author pparedes
 */
public class EstadoDAO  extends Conexion{
    
    public int registarEstado(Estado estado) throws SQLException{
        String sentencia = "Insert into estado (nombre) values (?)";
        try{
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setString(1, estado.getNombre());
            return ps.executeUpdate();
        }catch(Exception e){
            return -1;
        }finally{
            desconectar();
        }
    }
    public int modificarEstado(Estado estado) throws SQLException{
        try{
           String sentencia = "update estado set nombre=? where id=?";
           conectar();
           PreparedStatement ps= obtenerPS(sentencia);
           ps.setString(1, estado.getNombre());
           ps.setInt(2, estado.getId());
           return ps.executeUpdate();
        }catch(Exception e){
          return -1;
        }finally{
          desconectar();
        }
    }
    
    public int eliminarEstado(Estado estado) throws SQLException{
        try{
           String sentencia = "delete from estado where id=?";
           conectar();
           PreparedStatement ps= obtenerPS(sentencia);
           ps.setInt(1, estado.getId());
           return ps.executeUpdate();
        }catch(Exception e){
          return -1;
        }finally{
          desconectar();
        }
    }
    
    public Estado obtenerEstado(int id) throws SQLException{
        String sentencia = "select * from estado where id=?";
        try{
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return (new Estado(rs.getInt("id"),rs.getString("nombre")));
            }else{
                return  null;
            }
        }catch(Exception e){
            return null;
        }finally{
            desconectar();
        }
    }
    public Estado obtenerEstado(String nombre) throws SQLException{
        String sentencia = "select * from estado where nombre=?";
        try{
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return (new Estado(rs.getInt("id"),rs.getString("nombre")));
            }else{
                return  null;
            }
        }catch(Exception e){
            return null;
        }finally{
            desconectar();
        }
    }
    
    public ArrayList<Estado> obternerEstados() throws SQLException{
        String sentencia = "select * from estado";
        try{
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ResultSet rs = ps.executeQuery();
            ArrayList<Estado> estado = new ArrayList();
            while(rs.next()){
                estado.add(new Estado(rs.getInt("id"),rs.getString("nombre")));
            }
            return estado;
        }catch(Exception e){
            return new ArrayList();
        }finally{
            desconectar();
        }
    }
}
