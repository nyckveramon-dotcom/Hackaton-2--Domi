package servicio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import modelo.*;

public class DomiService {

    private HashMap<String, Cliente> clientes;
    private HashSet<String> barriosConCobertura;
    private HashMap<String, Double> distanciaBarrios;
    private ArrayList<Repartidor> repartidores;

    public DomiService() {
        this.clientes = new HashMap<>();
        this.barriosConCobertura = new HashSet<>();
        this.distanciaBarrios = new HashMap<>();
        this.repartidores = new ArrayList<>();

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

}