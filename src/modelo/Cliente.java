package modelo;

public class Cliente {
    private String cedula;
    private String nombre;
    private String telefono;
    private String barrio;
    private String direccion;

    public Cliente(String cedula, String nombre, String telefono, String barrio, String direccion){
        setCedula(cedula);
        setNombre(nombre);
        setTelefono(telefono);
        setBarrio(barrio);
        setDireccion(direccion);
    }
    //getters
    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getBarrio() {
        return barrio;
    }

    public String getDireccion() {
        return direccion;
    }

    //setters
    public void setCedula(String cedula) {
        if (cedula == null || cedula.trim().isEmpty()) {
            throw new IllegalArgumentException("la cédula no puede estar vacía");
        }
        this.cedula = cedula.trim();
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("el nombre no puede estar vacío");
        }
        this.nombre = nombre.trim();
    }

    public void setDireccion(String direccion) {
        if (direccion == null || direccion.trim().isEmpty()) {
            throw new IllegalArgumentException("la dirección no puede estar vacía");
        }
        this.direccion = direccion.trim();
    }

    public void setTelefono(String telefono) {
        String telefonoMax = telefono.trim();
        if (telefonoMax.length() < 7 || telefonoMax.length() > 10) {
            throw new IllegalArgumentException("el teléfono debe tener entre 7 y 10 digitos");
        }
        for (int i = 0; i < telefonoMax.length(); i++){
            if (!Character.isDigit(telefonoMax.charAt(i))) {
                throw new IllegalArgumentException("El telefono solo debe contener números.");
            }
        }
        this.telefono = telefonoMax;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio.trim();
    }

    @Override
    public String toString() {
        return "Cliente {" +
                "Cédula: '" + cedula + '\'' +
                ", Nombre: '" + nombre + '\'' +
                ", Teléfono: '" + telefono + '\'' +
                ", Barrio: '" + barrio + '\'' +
                ", Dirección: '" + direccion + '\'' +
                '}';
    }
}
