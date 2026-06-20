package dao;

import database.Conexion;
import model.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MedicoDAOImpl implements CRUDInterface<Medico> {

    @Override
    public boolean insertar(Medico medico) {
        String sql = "INSERT INTO Medicos (matricula, nombre, apellido, dni, especialidad) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, medico.getMatricula());
            ps.setString(2, medico.getNombre());
            ps.setString(3, medico.getApellido());
            ps.setString(4, medico.getDni());
            ps.setString(5, medico.getEspecialidad());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Excepción al insertar médico: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizar(Medico medico) {
        String sql = "UPDATE Medicos SET nombre = ?, apellido = ?, especialidad = ? WHERE matricula = ?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, medico.getNombre());
            ps.setString(2, medico.getApellido());
            ps.setString(3, medico.getEspecialidad());
            ps.setString(4, medico.getMatricula());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Excepción al actualizar médico: " + e.getMessage());
            return false;
        }
    }

    @Override
    public ArrayList<Medico> listarTodos() {
        ArrayList<Medico> lista = new ArrayList<>();
        String sql = "SELECT * FROM Medicos";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                
                Medico m = new Medico(
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("dni"),
                    rs.getString("matricula"),
                    rs.getString("especialidad")
                );
                lista.add(m);
            }
        } catch (SQLException e) {
            System.err.println("Excepción al listar médicos: " + e.getMessage());
        }
        return lista;
    }
}
