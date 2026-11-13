
public abstract class Repartidor {
    private String codigo;
    private String nombre;
    private boolean disponible;

    public Repartidor(String codigo, String nombre, boolean disponible){
        this.codigo = codigo;
        this.nombre = nombre;
        this.disponible = disponible;
    }
    //Declaracion de comportamientos abstractos de los hijos
    public abstract double calcularCosto(double km);
    public abstract double calcularTiempo(double km);
    public abstract boolean puedeLlevar(double km, boolean esGrande);

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

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", disponible=" + (disponible ? "Sí" : "No") +
                '}';
    }
}
