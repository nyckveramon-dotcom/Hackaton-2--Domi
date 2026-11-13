package modelo;

public abstract class Repartidor {
    private String codigo;
    private String nombre;
    private boolean disponible;

    public Repartidor(String codigo, String nombre, boolean disponible){
        this.codigo = codigo;
        this.nombre = nombre;
        this.disponible = disponible;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
