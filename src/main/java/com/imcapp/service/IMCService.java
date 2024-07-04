package com.imcapp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.imcapp.model.MedicionIMC;
import com.imcapp.model.Usuario;
import com.imcapp.util.Database;

public class IMCService {
    private UsuarioService usuarioService;

    public IMCService() {
        usuarioService = new UsuarioService();
    }

    public int obtenerUsuarioId(String nombreUsuario) {
        Usuario usuario = usuarioService.obtenerUsuarioPorNombre(nombreUsuario);
        return usuario != null ? usuario.getId() : -1;
    }

    public float obtenerEstaturaUsuario(String nombreUsuario) {
        Usuario usuario = usuarioService.obtenerUsuarioPorNombre(nombreUsuario);
        return usuario != null ? usuario.getEstatura() : 0;
    }

    public void registrarMedicion(MedicionIMC medicion) {
        try (Connection connection = Database.getConnection()) {
            String query = "INSERT INTO mediciones (usuarioId, imc, fecha) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, medicion.getUsuarioId());
                statement.setFloat(2, medicion.getImc());
                statement.setDate(3, new java.sql.Date(medicion.getFecha().getTime()));
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<MedicionIMC> obtenerMedicionesPorUsuario(int usuarioId) {
        List<MedicionIMC> mediciones = new ArrayList<>();
        System.out.println("Obteniendo mediciones para usuario ID: " + usuarioId);
        try (Connection connection = Database.getConnection()) {
            String query = "SELECT * FROM mediciones WHERE usuarioId = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, usuarioId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        MedicionIMC medicion = new MedicionIMC();
                        medicion.setId(resultSet.getInt("id"));
                        medicion.setUsuarioId(resultSet.getInt("usuarioId"));
                        medicion.setImc(resultSet.getFloat("imc"));
                        medicion.setFecha(resultSet.getDate("fecha"));
                        mediciones.add(medicion);
                        System.out.println("Medición encontrada: " + medicion.getImc() + " en fecha: " + medicion.getFecha());
                    }
                    if (mediciones.isEmpty()) {
                        System.out.println("No se encontraron mediciones para el usuario con ID: " + usuarioId);
                    } else {
                        System.out.println("Mediciones obtenidas: " + mediciones.size());
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mediciones;
    }
}
