package modelo;

public class Dron extends Repartidor {
    public Dron(String codigo, String nombre, boolean disponible) {
        super(codigo, nombre, disponible);
    }

    @Override
    public double calcularCosto(double km) {
        return 4000 + (km * 600);
    }

    @Override
    public double calcularTiempo(double km) {
        return (km / 50.0) * 60;
    }

    @Override
    public boolean puedeLlevar(double km, boolean esGrande, boolean llueve) {
        return !llueve && km <= 8 && !esGrande;
    }
}