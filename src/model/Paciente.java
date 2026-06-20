package model;
public class Paciente extends Persona {
    private String telefono;

    public Paciente(String nombre, String apellido, String dni, String telefono) {
        super(nombre, apellido, dni);
        this.telefono = telefono;
    }
    public String getTelefono() { return telefono; }
    @Override
    public String getInformacionCompleta() {
        return "Paciente: " + apellido + ", " + nombre + " (DNI: " + dni + ") - Tel: " + telefono;
    }
}