package dao;

import database.Conexion;
import model.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PacienteDAOImpl implements CRUDInterface<Paciente> {
    @Override
    public boolean insertar(Paciente paciente) {
        String sql = "INSERT INTO Pacientes (dni, nombre, apellido, telefono) VALUES (?, ?, ?, ?)";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, paciente.getDni());
            ps.setString(2, paciente.getNombre());
            ps.setString(3, paciente.getApellido());
            ps.setString(4, paciente.getTelefono());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Excepción al insertar: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizar(Paciente paciente) {
        String sql = "UPDATE Pacientes SET nombre = ?, apellido = ?, telefono = ? WHERE dni = ?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getApellido());
            ps.setString(3, paciente.getTelefono());
            ps.setString(4, paciente.getDni());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Excepción al actualizar: " + e.getMessage());
            return false;
        }
    }

    @Override
    public ArrayList<Paciente> listarTodos() {
        ArrayList<Paciente> lista = new ArrayList<>();
        String sql = "SELECT * FROM Pacientes";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Paciente p = new Paciente(rs.getString("nombre"), rs.getString("apellido"), rs.getString("dni"), rs.getString("telefono"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.err.println("Excepción al listar: " + e.getMessage());
        }
        return lista;
    }
}