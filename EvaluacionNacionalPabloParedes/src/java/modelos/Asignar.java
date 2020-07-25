
package modelos;

public class Asignar {
    private int id_asignar;
    private String nombre;
    private String descripcion;
    private Departamento departamento;
    private Usuario usuario;
    private Requerimiento requerimiento;

    public Asignar() {
    }

    public Asignar(int id_asignar, String nombre, String descripcion, Departamento departamento, Usuario usuario, Requerimiento requerimiento) {
        this.id_asignar = id_asignar;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.departamento = departamento;
        this.usuario = usuario;
        this.requerimiento = requerimiento;
    }

    public Requerimiento getRequerimiento() {
        return requerimiento;
    }

    public void setRequerimiento(Requerimiento requerimiento) {
        this.requerimiento = requerimiento;
    }

    public int getId_asignar() {
        return id_asignar;
    }

    public void setId_asignar(int id_asignar) {
        this.id_asignar = id_asignar;
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

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @Override
    public String toString(){
        return nombre;
    }
}
