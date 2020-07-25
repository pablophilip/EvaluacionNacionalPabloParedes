
package modelos;

public class Requerimiento {
    private int id_requerimiento;
    private String nombre;
    private String descripcion;
    private Estado estado;

    public Requerimiento() {
    }

    public Requerimiento(int id_requerimiento, String nombre) {
        this.id_requerimiento = id_requerimiento;
        this.nombre = nombre;
    }
    
    
    public Requerimiento(int id_requerimiento, String nombre, String descripcion, Estado estado) {
        this.id_requerimiento = id_requerimiento;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getId_requerimiento() {
        return id_requerimiento;
    }

    public void setId_requerimiento(int id_requerimiento) {
        this.id_requerimiento = id_requerimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
