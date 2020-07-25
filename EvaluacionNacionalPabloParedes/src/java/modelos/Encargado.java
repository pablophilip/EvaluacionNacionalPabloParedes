
package modelos;

public class Encargado {
    private int id_encargado;
    private String nombre;
    private String apellido;
    private Departamento departamento;
    private Usuario usuario;
    private Requerimiento requerimiento;

    public Encargado() {
    }

    public Encargado(int id_encargado, String nombre, String apellido, Departamento departamento, Usuario usuario, Requerimiento requerimiento) {
        this.id_encargado = id_encargado;
        this.nombre = nombre;
        this.apellido = apellido;
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

    public int getId_encargado() {
        return id_encargado;
    }

    public void setId_encargado(int id_encargado) {
        this.id_encargado = id_encargado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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
