
package modelos;

public class Departamento {
    private int id_departamento;
    private String nombre;
    private String descripcion;
    private Gerencia gerencia;
    private Usuario usuario;
    private Requerimiento requerimiento;

    public Departamento() {
    }

    public Departamento(int id_departamento, String nombre) {
        this.id_departamento = id_departamento;
        this.nombre = nombre;
    }
    

    public Departamento(int id_departamento, String nombre, String descripcion, Gerencia gerencia, Usuario usuario, Requerimiento requerimiento) {
        this.id_departamento = id_departamento;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.gerencia = gerencia;
        this.usuario = usuario;
        this.requerimiento = requerimiento;
    }

    public Requerimiento getRequerimiento() {
        return requerimiento;
    }

    public void setRequerimiento(Requerimiento requerimiento) {
        this.requerimiento = requerimiento;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
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

    public Gerencia getGerencia() {
        return gerencia;
    }

    public void setGerencia(Gerencia gerencia) {
        this.gerencia = gerencia;
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
