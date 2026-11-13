package servicio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import modelo.*;

public class DomiService {

    private HashMap<String, Cliente> clientes;
    private HashSet<String> barriosConCobertura;
    private HashMap<String, Double> distanciaBarrios;
    private ArrayList<Repartidor> repartidores;
    private ArrayList<Pedido> pedidos;
    private boolean modoLluvia;

    public DomiService() {
        this.clientes = new HashMap<>();
        this.barriosConCobertura = new HashSet<>();
        this.distanciaBarrios = new HashMap<>();
        this.repartidores = new ArrayList<>();
        this.pedidos = new ArrayList<>();

        cargarDatosIniciales();
    }

    public void cargarDatosIniciales(){

        barriosConCobertura.add("Chapinero");
        distanciaBarrios.put("Chapinero", 1.5);

        barriosConCobertura.add("Teusaquillo");
        distanciaBarrios.put("Teusaquillo", 3.0);

        barriosConCobertura.add("La Candelaria");
        distanciaBarrios.put("La Candelaria", 4.5);

        barriosConCobertura.add("Usaquén");
        distanciaBarrios.put("Usaquén", 6.0);

        barriosConCobertura.add("Cedritos");
        distanciaBarrios.put("Cedritos", 8.0);

        barriosConCobertura.add("Fontibón");
        distanciaBarrios.put("Fontibón", 11.0);

        barriosConCobertura.add("Suba");
        distanciaBarrios.put("Suba", 12.0);

        barriosConCobertura.add("Kennedy");
        distanciaBarrios.put("Kennedy", 14.0);

        barriosConCobertura.add("Bosa");
        distanciaBarrios.put("Bosa", 18.0);


        clientes.put("1020304050", new Cliente(
                "1020304050",
                "Laura Gomez",
                "3001234567",
                "Teusaquillo",
                "Calle 39 # 17- 20"
        ));

        clientes.put("1030405060", new Cliente(
                "1030405060",
                "Mateo Rincon",
                "3109876543",
                "Usaquén",
                "Carrera 7 # 120-15"
        ));

        repartidores.add(new Bici(
                "R-01",
                "Camila Torres",
                true
        ));

        repartidores.add(new Moto(
                "R-02",
                "Andres Mejia",
                true
        ));

        repartidores.add(new Carro(
                "R-03",
                "Jorge Pardo",
                true
        ));

    }

    public HashSet<String> getBarriosConCobertura() {
        return barriosConCobertura;
    }

    public HashMap<String, Double> getDistanciaBarrios() {
        return distanciaBarrios;
    }

    public ArrayList<Repartidor> obtenerRepartidores(){
        return this.repartidores;
    }


    private String validarYNormalizarBarrio(String barrioIngresado) {
        if (barrioIngresado == null || barrioIngresado.trim().isEmpty()) {
            throw new IllegalArgumentException("El barrio no puede estar vacío.");
        }
        String limpio = barrioIngresado.trim();
        for (String b : barriosConCobertura) {
            if (b.equalsIgnoreCase(limpio)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Sin cobertura en el barrio '" + limpio + "'.");
    }

    public void registrarCliente(String cedula, String nombre, String telefono, String barrio, String direccion) {
        if (cedula == null || cedula.trim().isEmpty()) {
            throw new IllegalArgumentException("La cedula no puede estar vacia");
        }
        String cedulaLimpia = cedula.trim();
        if (clientes.containsKey(cedulaLimpia)) {
            throw new IllegalArgumentException("Ya existe un cliente con la cedula " + cedulaLimpia + ".");
        }
        String barrioValido = validarYNormalizarBarrio(barrio);
        Cliente nuevo = new Cliente(cedulaLimpia, nombre, telefono, barrioValido, direccion);
        clientes.put(cedulaLimpia, nuevo);
    }

    public Collection<Cliente> listarClientes() {
        return clientes.values();
    }

    public Cliente buscarClientePorCedula(String cedula) {
        if (cedula == null || !clientes.containsKey(cedula.trim())) {
            throw new IllegalArgumentException("No se encontró ningun cliente con cedula: " + cedula);
        }
        return clientes.get(cedula.trim());
    }

    public void editarCliente(String cedula, String nuevoTelefono, String nuevoBarrio, String nuevaDireccion) {
        Cliente cliente = buscarClientePorCedula(cedula);
        String barrioValido = validarYNormalizarBarrio(nuevoBarrio);

        Cliente temporal = new Cliente(cliente.getCedula(), cliente.getNombre(), nuevoTelefono, barrioValido, nuevaDireccion);

        cliente.setTelefono(temporal.getTelefono());
        cliente.setBarrio(temporal.getBarrio());
        cliente.setDireccion(temporal.getDireccion());
    }

    public void eliminarCliente(String cedula) {
        Cliente cliente = buscarClientePorCedula(cedula);
        clientes.remove(cliente.getCedula());
    }

    public void registrarRepartidor(String codigo, String nombre, int tipoOpcion) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El codigo no puede estar vacío");
        }
        String codigoLimpio = codigo.trim().toUpperCase();
        for (Repartidor r : repartidores) {
            if (r.getCodigo().equalsIgnoreCase(codigoLimpio)) {
                throw new IllegalArgumentException("Ya existe un repartidor con el código " + codigoLimpio + ".");
            }
        }

        Repartidor nuevo;
        switch (tipoOpcion) {
            case 1 -> nuevo = new Bici(codigoLimpio, nombre, true);
            case 2 -> nuevo = new Moto(codigoLimpio, nombre, true);
            case 3 -> nuevo = new Carro(codigoLimpio, nombre, true);
            case 4 -> nuevo = new Dron(codigoLimpio, nombre, true);
            default -> throw new IllegalArgumentException("Tipo de vehículo inválido. Elija 1 (Bici), 2 (Moto) o 3 (Carro)");
        }
        repartidores.add(nuevo);
    }

    public List<Repartidor> listarRepartidores() {
        return repartidores;
    }

    public Repartidor cambiarDisponibilidad(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("Debe ingresar un código de repartidor");
        }
        String codigoLimpio = codigo.trim();
        for (Repartidor r : repartidores) {
            if (r.getCodigo().equalsIgnoreCase(codigoLimpio)) {
                r.setDisponible(!r.isDisponible());
                return r;
            }
        }
        throw new IllegalArgumentException("No existe un repartidor con código: " + codigoLimpio);
    }

    public void crearPedido(String cedula, String descripcion, boolean esGrande){

        Cliente cliente = clientes.get(cedula);

        if(cliente == null){
            throw new IllegalArgumentException("El cliente no existe");
        }

        String barrio = cliente.getBarrio();
        Double km = distanciaBarrios.get(barrio);

        if (km == null){
            throw new IllegalArgumentException("El barrio no tiene cobertura");
        }

        //Se inicializan las variables para guardar la mejor cotización
        Repartidor mejorRepartidor = null;
        double mejorCosto = Double.MAX_VALUE;
        double mejorTiempo = 0;

        for (Repartidor r : repartidores){

            //Cada repartidor puede calcular sus propios valores
            if (r.isDisponible() && r.puedeLlevar(km, esGrande, modoLluvia)){
                double costo = r.calcularCosto(km, modoLluvia);
                double tiempo = r.calcularTiempo(km);

                System.out.println(r.getCodigo() + " " + r.getNombre() +
                        " (" + r.getClass().getSimpleName() + ") $" + costo + " " + tiempo + "min" );

                //comparación de cotizaciones
                if (costo < mejorCosto){
                    mejorCosto = costo;
                    mejorTiempo = tiempo;
                    mejorRepartidor = r;
                }
            }
        }

        if (mejorRepartidor == null) {
            throw new IllegalStateException("No hay repartidores disponibles que puedan realizar este envío.");
        }

        mejorRepartidor.setDisponible(false);
        Pedido nuevoPedido = new Pedido(
                cliente,
                descripcion,
                esGrande,
                km,
                mejorRepartidor,
                mejorCosto,
                mejorTiempo
        );
        pedidos.add(nuevoPedido);

        System.out.printf("✔ Pedido #%d asignado a %s (%s) · %s%n",
                nuevoPedido.getNumero(),
                mejorRepartidor.getNombre(),
                mejorRepartidor.getClass().getSimpleName(),
                nuevoPedido.getEstado());
    }

    public void cambiarModoLluvia (){
        modoLluvia = !modoLluvia;
    }

    public boolean isModoLluvia(){
        return modoLluvia;
    }

    // Buscar pedido por número
    private Pedido buscarPedidoPorNumero(int numero) {

        for (Pedido p : pedidos) {
            if (p.getNumero() == numero) {
                return p;
            }
        }

        throw new IllegalArgumentException(
                "No existe un pedido con el número " + numero
        );
    }

    // Entregar pedido
    public void entregarPedido(int numero) {

        Pedido pedido = buscarPedidoPorNumero(numero);

        if (!pedido.getEstado().equals("EN_CAMINO")) {
            throw new IllegalStateException(
                    "Solo se pueden entregar pedidos que estén en camino."
            );
        }

        pedido.setEstado("ENTREGADO");
        pedido.getRepartidorAsignado().setDisponible(true);

        System.out.println("Pedido entregado correctamente.");
    }

    // Cancelar pedido
    public void cancelarPedido(int numero) {

        Pedido pedido = buscarPedidoPorNumero(numero);

        if (!pedido.getEstado().equals("EN_CAMINO")) {
            throw new IllegalStateException(
                    "Solo se pueden cancelar pedidos que estén en camino."
            );
        }

        pedido.setEstado("CANCELADO");
        pedido.getRepartidorAsignado().setDisponible(true);

        System.out.println("Pedido cancelado correctamente.");
    }

    // Listar pedidos
    public List<Pedido> listarPedidos() {

        return new ArrayList<>(pedidos);
    }
}