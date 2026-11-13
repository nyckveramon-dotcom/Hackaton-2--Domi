import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class DomiService {

    //Se inicializan las colecciones
    private HashMap<String, Cliente> clientes;
    private HashSet<String> barriosConCobertura;
    private HashMap<String, Double> distanciaBarrios;
    private ArrayList<Repartidor> repartidores;
    private ArrayList<> pedidos;

    //Se crea constructor para poder inicializar las colecciones
    public DomiService() {
        this.clientes = new HashMap<>();
        this.barriosConCobertura = new HashSet<>();
        this.distanciaBarrios = new HashMap<>();
        this.repartidores = new ArrayList<>();
        this.pedidos = new ArrayList<>();

        cargarDatosIniciales();
    }

    public void cargarDatosIniciales(){

        //HashSet texto (ejem Chapinero)- HashMap clave-valor (ejem Chapinero, 1.5)

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

        //agrega a clientes la clave con que se buscara es decir la cedula y
        // el objeto que en este caso es un dato quemado//
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
                "Usaquen",
                "Carrera 7 # 120-15"
        ));

        repartidores.add(new Bici(
               "R-01",
                "Camila Torres"
        ));

        repartidores.add(new Moto(
                "R-02",
                "Andres Mejia"
        ));

        repartidores.add(new Carro(
                "R-03",
                "Jorge Pardo"
        ));



    }

    public HashSet<String> getBarriosConCobertura() {
        return barriosConCobertura;
    }

}
