package com.imcapp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.imcapp.model.Usuario;
import com.imcapp.util.Database;

public class UsuarioService {

    public void registrarUsuario(Usuario usuario) {
        try (Connection connection = Database.getConnection()) {
            String query = "INSERT INTO usuarios (nombreCompleto, nombreUsuario, edad, sexo, estatura, peso, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, usuario.getNombreCompleto());
                statement.setString(2, usuario.getNombreUsuario());
                statement.setInt(3, usuario.getEdad());
                statement.setString(4, usuario.getSexo());
                statement.setFloat(5, usuario.getEstatura());
                statement.setFloat(6, usuario.getPeso());
                statement.setString(7, usuario.getPassword());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean autenticarUsuario(String nombreUsuario, String password) {
        try (Connection connection = Database.getConnection()) {
            String query = "SELECT * FROM usuarios WHERE nombreUsuario = ? AND password = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, nombreUsuario);
                statement.setString(2, password);
                try (ResultSet resultSet = statement.executeQuery()) {
                    return resultSet.next();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Usuario obtenerUsuarioPorNombre(String nombreUsuario) {
        System.out.println("Nombre de usuario: " + nombreUsuario);
        try (Connection connection = Database.getConnection()) {
            String query = "SELECT * FROM usuarios WHERE nombreUsuario = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, nombreUsuario);
                try (ResultSet resultSet = statement.executeQuery()) {
                    System.out.println(resultSet);
                    if (resultSet.next()) {
                        Usuario usuario = new Usuario();
                        usuario.setId(resultSet.getInt("id"));
                        usuario.setNombreCompleto(resultSet.getString("nombreCompleto"));
                        usuario.setNombreUsuario(resultSet.getString("nombreUsuario"));
                        usuario.setEdad(resultSet.getInt("edad"));
                        usuario.setSexo(resultSet.getString("sexo"));
                        usuario.setEstatura(resultSet.getFloat("estatura"));
                        usuario.setPeso(resultSet.getFloat("peso"));
                        usuario.setPassword(resultSet.getString("password"));
                        return usuario;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
