package modelo;

import java.util.HashMap;
import java.util.HashSet;
public class PruebaCliente {

    private HashMap<String, Cliente> clientes = new HashMap<>();
    private HashSet<String> barriosConCobertura = new HashSet<>();
    public boolean registrarCliente(String cedula, String nombre, String telefono, String barrio, String direccion ){
        if (clientes.containsKey(cedula)){
            System.out.println("Ya existe un cliente con esta cédula");
            return false;
        }
        if (!barriosConCobertura.contains(barrio)) {
            System.out.println(" el barrio ingresado no tiene cobertura.");
            return false;
        }
        Cliente nuevoCliente = new Cliente(cedula, nombre, telefono, barrio, direccion);
        clientes.put(cedula, nuevoCliente);
        System.out.println("Cliente registrado con éxito");
        return true;
    }

    public String listarClientes() {
        if (clientes.isEmpty()) {
            return ("No hay clientes resgistrados");

        }
        StringBuilder resultado = new StringBuilder("LISTA DE CLIENTES:\n");
        for (Cliente cliente : clientes.values()){
            resultado.append(cliente.toString()).append("\n");
        }

        return resultado.toString();
    }

    public boolean editarCliente(String cedula, String nuevoTelefono, String nuevoBarrio, String nuevaDireccion) {
        if (!clientes.containsKey(cedula)) {
            System.out.println(" No se encontró un cliente con esa cédula.");
            return false;
        }
        Cliente cliente = clientes.get(cedula);
        cliente.setTelefono(nuevoTelefono);
        cliente.setBarrio(nuevoBarrio);
        cliente.setDireccion(nuevaDireccion);

        System.out.println("Se actualizaron los datos");
        return true;
    }

    public boolean eliminarCliente(String cedula) {
        if (clientes.containsKey(cedula)) {
            clientes.remove(cedula);
            System.out.println("El cliente ha sido eliminado");
            return true;
        }
        return false;
    }

}