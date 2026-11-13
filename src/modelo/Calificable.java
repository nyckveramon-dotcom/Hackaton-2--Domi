package modelo;

//aqui solo se crea la interface porque esta nos dice qeu debemos hacer
//pero la clase en este momento la clase Repartidor decide como hacerlo
public interface Calificable {
    void recibirCalificacion(int calificacion);
    double obtenerPromedio();
}

