package model;
public class Medico extends Persona {
    private String matricula;
    private String especialidad;

    public Medico(String nombre, String apellido, String dni, String matricula, String especialidad) {
        super(nombre, apellido, dni);
        this.matricula = matricula;
        this.especialidad = especialidad;
    }
    public String getMatricula() { return matricula; }
    public String getEspecialidad() { return especialidad; }
    @Override
    public String getInformacionCompleta() {
        return "Médico: " + apellido + ", " + nombre + " [Matrícula: " + matricula + "] Espec: " + especialidad;
    }
}