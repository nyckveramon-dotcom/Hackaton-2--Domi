package modelo;

public abstract class Repartidor implements Calificable {
    private String codigo;
    private String nombre;
    private boolean disponible;
    private double sumaCalificaciones;
    private int totalCalificaciones;

    public Repartidor(String codigo, String nombre, boolean disponible) {
        setCodigo(codigo);
        setNombre(nombre);
        this.disponible = disponible;
    }

    // Declaración de comportamientos abstractos de los hijos
    public abstract double calcularCosto(double km);
    public abstract double calcularTiempo(double km);
    public abstract boolean puedeLlevar(double km, boolean esGrande, boolean llueve);

    public double calcularCosto(double km, boolean llueve) {
        double costo = calcularCosto(km);
        return llueve ? costo * 1.20 : costo;
    }

    @Override
    public void recibirCalificacion(int estrellas) {
        if (estrellas < 1 || estrellas > 5) {
            throw new IllegalArgumentException("La calificacion debe estar entre 1 y 5.");
        }
        sumaCalificaciones += estrellas;
        totalCalificaciones++;
    }

    @Override
    public double obtenerPromedio() {
        return totalCalificaciones == 0 ? 0.0 : sumaCalificaciones / totalCalificaciones;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código del repartidor no puede estar vacío.");
        }
        this.codigo = codigo.trim();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del repartidor no puede estar vacío.");
        }
        this.nombre = nombre.trim();
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
                ", promedio=" + String.format("%.1f", obtenerPromedio()) +
                '}';
    }
}
