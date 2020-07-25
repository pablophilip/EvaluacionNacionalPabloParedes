
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.Asignar;
import modelos.Departamento;
import modelos.Requerimiento;
import modelos.Usuario;

public class AsginarDAO extends Conexion{
    
    public ArrayList<Asignar> obtenerAsignar() throws ClassNotFoundException, SQLException{
        String sentencia = "select * from v_departamento";
        conectar();
        PreparedStatement ps= obtenerPS(sentencia);
        ResultSet rs = ps.executeQuery();
        ArrayList<Asignar> lista = new ArrayList();
        while(rs.next()){
            Departamento d = new Departamento(rs.getInt("id_departamento"),rs.getString("d_nombre"));
            Requerimiento r = new Requerimiento(rs.getInt("id_requerimiento"),rs.getString("r_nombre"));
            Usuario u = new Usuario(rs.getString("id_usuario"),rs.getString("u_nombre"));
            lista.add(new Asignar(rs.getInt("id_departamento"),rs.getString("d_nombre"),
                      rs.getString("descripcion"),d,u,r));
        }
        desconectar();
        return lista;
    }
    
    public Asignar obtenerAsignar(int id) throws ClassNotFoundException, SQLException{
        String sentencia = "select * from v_departamento where id = ?";
        conectar();
        PreparedStatement ps= obtenerPS(sentencia);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Asignar a = null;
        if(rs.next()){
           Departamento d = new Departamento(rs.getInt("id_departamento"),rs.getString("d_nombre"));
           Requerimiento r = new Requerimiento(rs.getInt("id_requerimiento"),rs.getString("r_nombre"));
           Usuario u = new Usuario(rs.getString("id_usuario"),rs.getString("u_nombre"));
           a = new Asignar(rs.getInt("id_departamento"),rs.getString("g_nombre"),
                      rs.getString("descripcion"),d,u,r);
        }
        desconectar();
        return a;
    }
}
