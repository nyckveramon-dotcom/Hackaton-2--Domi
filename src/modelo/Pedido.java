package modelo;

// Importamos HashSet y Set para validar los estados permitidos.
import java.util.HashSet;
import java.util.Set;

public class Pedido {

    // Contador compartido por todos los pedidos.
    // Empieza en 1 y aumenta automáticamente.
    private static int contador = 1;

    // Atributos propios de cada pedido.
    private int numero;
    private Cliente cliente;
    private String descripcion;
    private boolean esGrande;
    private double km;
    private Repartidor repartidorAsignado;
    private double costo;
    private double tiempo;
    private String estado;

    // Conjunto de estados que acepta el sistema.
    // No permite estados diferentes a estos tres.
    private static final Set<String> ESTADOS_VALIDOS = new HashSet<>(
            Set.of("EN_CAMINO", "ENTREGADO", "CANCELADO")
    );

    // Constructor: se ejecuta cuando creamos un nuevo pedido.
    public Pedido(Cliente cliente, String descripcion,
                  boolean esGrande, double km,
                  Repartidor repartidorAsignado,
                  double costo, double tiempo) {

        // Asigna el número consecutivo y luego aumenta el contador.
        this.numero = contador++;

        // Guardamos el cliente que realizó el pedido.
        this.cliente = cliente;

        // Guardamos la descripción del pedido.
        this.descripcion = descripcion;

        // Guardamos si el pedido es grande o no.
        this.esGrande = esGrande;

        // Guardamos la distancia del domicilio.
        this.km = km;

        // Guardamos el repartidor seleccionado.
        this.repartidorAsignado = repartidorAsignado;

        // Guardamos el costo calculado por el repartidor.
        this.costo = costo;

        // Guardamos el tiempo estimado de entrega.
        this.tiempo = tiempo;

        // Todo pedido esta en camino.
        setEstado("EN_CAMINO");
    }

    // GETTERS: permiten consultar los atributos privados.

    public int getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isEsGrande() {
        return esGrande;
    }

    public double getKm() {
        return km;
    }

    public Repartidor getRepartidorAsignado() {
        return repartidorAsignado;
    }

    public double getCosto() {
        return costo;
    }

    public double getTiempo() {
        return tiempo;
    }

    public String getEstado() {
        return estado;
    }

    // SETTER: permite cambiar el estado, pero validándolo.
    public void setEstado(String estado) {

        // Verificamos que el estado esté dentro del conjunto permitido.
        if (estado == null || !ESTADOS_VALIDOS.contains(estado)) {

            // Si no es válido, lanzamos un error.
            throw new IllegalArgumentException(
                    "Estado no válido. Use EN_CAMINO, ENTREGADO o CANCELADO."
            );
        }

        // Si pasó la validación, guardamos el nuevo estado.
        this.estado = estado;
    }

    // Muestra la información del pedido como texto.
    @Override
    public String toString() {
        return "Pedido #" + numero +
                "\nCliente: " + cliente.getNombre() +
                "\nDescripción: " + descripcion +
                "\nGrande: " + (esGrande ? "Sí" : "No") +
                "\nDistancia: " + km + " km" +
                "\nRepartidor: " + repartidorAsignado.getNombre() +
                "\nCosto: $" + costo +
                "\nTiempo: " + tiempo + " minutos" +
                "\nEstado: " + estado;
    }
}
