package model;
public class Turno {
    private int idTurno;
    private String fecha;
    private String hora;
    private String estado;
    private Paciente paciente;
    private Medico medico;

    public Turno(int idTurno, String fecha, String hora, String estado, Paciente paciente, Medico medico) {
        this.idTurno = idTurno;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.paciente = paciente;
        this.medico = medico;
    }
    public int getIdTurno() { return idTurno; }
    public String getFecha() { return fecha; }
    public String getHora() { return hora; }
    public String getEstado() { return estado; }
    public Paciente getPaciente() { return paciente; }
    public Medico getMedico() { return medico; }
}