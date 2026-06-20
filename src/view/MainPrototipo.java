package view;

import dao.PacienteDAOImpl;
import dao.MedicoDAOImpl;
import dao.TurnoDAOImpl;
import model.Paciente;
import model.Medico;
import model.Turno;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class MainPrototipo {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO PROTOTIPO SISTEMA DE TURNOS ===");

        // REQUERIMIENTO COMPLEMENTARIO: Arreglo tradicional [] para datos estáticos
        String[] especialidadesDisponibles = {"Cardiologia", "Pediatria", "Traumatologia", "Clinica Medica"};
        System.out.println("Cargando especialidades de la clinica (Arreglo fijo): " + especialidadesDisponibles.length + " disponibles.\n");

        // INSTANCIAS DE LOS DAO
        PacienteDAOImpl pacienteDAO = new PacienteDAOImpl();
        MedicoDAOImpl medicoDAO = new MedicoDAOImpl();
        TurnoDAOImpl turnoDAO = new TurnoDAOImpl();

        // 1. PERSISTENCIA DE PACIENTE (El que ya tenías)
        Paciente p1 = new Paciente("Jazmin", "Ostertag", "46330163", "299123456");
        boolean pInsertado = pacienteDAO.insertar(p1);
        if (pInsertado) {
            System.out.println("¡Paciente persistido en MySQL Workbench!");
        }

        // 2. PERSISTENCIA DE MÉDICO (Usa la primera especialidad de nuestro Arreglo fijo)
        Medico m1 = new Medico("Carlos", "Gomez", "20123456", "MAT-995", especialidadesDisponibles[0]);
        boolean mInsertado = medicoDAO.insertar(m1);
        if (mInsertado) {
            System.out.println("¡Médico persistido en MySQL Workbench!");
        }

        
        Turno t1 = new Turno(1, "2026-06-20", "10:30:00", "Pendiente", p1, m1);
        boolean tInsertado = turnoDAO.insertar(t1);
        if (tInsertado) {
            System.out.println("¡Turno agendado y persistido con éxito!");
        }

        System.out.println("\n--- Procesando Estructuras de Datos Complementarias ---");

        
        System.out.println("\n=== LISTADO FINAL DE PACIENTES DESDE LA BASE ===");
        ArrayList<Paciente> listaPacientes = pacienteDAO.listarTodos();
        for (int i = 0; i < listaPacientes.size(); i++) {
            Paciente p = listaPacientes.get(i);
            System.out.println("[" + (i + 1) + "] Paciente: " + p.getApellido() + ", " + p.getNombre() + " (DNI: " + p.getDni() + ")");
        }
    }
}
