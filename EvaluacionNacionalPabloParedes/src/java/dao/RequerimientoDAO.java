
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.Estado;
import modelos.Requerimiento;

public class RequerimientoDAO extends Conexion{
    
    public int registrarRequerimiento(Requerimiento r) throws SQLException{
      try{
           String sentencia = "insert into requerimiento values (?,?,?,?)";
           conectar();
           PreparedStatement ps= obtenerPS(sentencia);
           ps.setInt(1, r.getId_requerimiento());
           ps.setString(2, r.getNombre());
           ps.setString(3, r.getDescripcion());
           ps.setInt(4, r.getEstado().getId());
           return ps.executeUpdate();
        }catch(Exception e){
          return -1;
        }finally{
          desconectar();
        }
    }
    
    public int modificarRequerimiento(Requerimiento r) throws SQLException{
        try{
           String sentencia = "update estadio set nombre=?, descripcion=?, id=? where id_requerimiento=?";
           conectar();
           PreparedStatement ps= obtenerPS(sentencia);
           ps.setString(1, r.getNombre());
           ps.setString(2, r.getDescripcion());
           ps.setInt(3, r.getEstado().getId());
           ps.setInt(4, r.getId_requerimiento());
           return ps.executeUpdate();
        }catch(Exception e){
          return -1;
        }finally{
          desconectar();
        }
    }
    
    public ArrayList<Requerimiento> obtenerRequermientos() throws ClassNotFoundException, SQLException{
        String sentencia = "select * from v_requerimiento";
        conectar();
        PreparedStatement ps= obtenerPS(sentencia);
        ResultSet rs = ps.executeQuery();
        ArrayList<Requerimiento> lista = new ArrayList();
        while(rs.next()){
            Estado es = new Estado(rs.getInt("id_Estado"),rs.getString("e_nombre"));
            lista.add(new Requerimiento(rs.getInt("id_requerimiento"),rs.getString("re_nombre"),
                      rs.getString("descripcion"),es));
        }
        desconectar();
        return lista;
    }
    
    public Requerimiento obtenerRequermiento(int id) throws ClassNotFoundException, SQLException{
        String sentencia = "select * from v_requerimiento where id = ?";
        conectar();
        PreparedStatement ps= obtenerPS(sentencia);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Requerimiento r = null;
        if(rs.next()){
           Estado es = new Estado(rs.getInt("id_Estado"),rs.getString("e_nombre"));
           r = new Requerimiento(rs.getInt("id_requerimiento"),rs.getString("re_nombre"),
                      rs.getString("descripcion"),es);
        }
        desconectar();
        return r;
    }
    
    
    
    
    
}
