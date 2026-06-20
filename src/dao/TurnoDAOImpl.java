package dao;

import database.Conexion;
import model.Turno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class TurnoDAOImpl implements CRUDInterface<Turno> {

    @Override
    public boolean insertar(Turno turno) {
        String sql = "INSERT INTO Turnos (fecha, hora, estado, paciente_dni, medico_matricula) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            
            ps.setString(1, turno.getFecha());
            ps.setString(2, turno.getHora());
            ps.setString(3, turno.getEstado());
            ps.setString(4, turno.getPaciente().getDni());
            ps.setString(5, turno.getMedico().getMatricula());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Excepción al insertar turno: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizar(Turno turno) {
        String sql = "UPDATE Turnos SET estado = ? WHERE fecha = ? AND hora = ? AND paciente_dni = ?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, turno.getEstado());
            ps.setString(2, turno.getFecha());
            ps.setString(3, turno.getHora());
            ps.setString(4, turno.getPaciente().getDni());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Excepción al actualizar turno: " + e.getMessage());
            return false;
        }
    }

    @Override
    public ArrayList<Turno> listarTodos() {
        
        return new ArrayList<>();
    }
}