
package modelos;

public class Gerencia {
    private int id_gerencia;
    private String nombre;
    private String descripcion;
    private Usuario usuario;
    private Requerimiento requerimiento;

    public Gerencia() {
    }

    public Gerencia(int id_gerencia, String nombre) {
        this.id_gerencia = id_gerencia;
        this.nombre = nombre;
    }
    
    public Gerencia(int id_gerencia, String nombre, String descripcion, Usuario usuario, Requerimiento requerimiento) {
        this.id_gerencia = id_gerencia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.usuario = usuario;
        this.requerimiento = requerimiento;
    }

    public Requerimiento getRequerimiento() {
        return requerimiento;
    }

    public void setRequerimiento(Requerimiento requerimiento) {
        this.requerimiento = requerimiento;
    }

    public int getId_gerencia() {
        return id_gerencia;
    }

    public void setId_gerencia(int id_gerencia) {
        this.id_gerencia = id_gerencia;
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
