package com.imcapp.controller;

import java.io.IOException;

import com.imcapp.model.Usuario;
import com.imcapp.service.UsuarioService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsuarioService usuarioService;

    public RegistroServlet() {
        super();
        usuarioService = new UsuarioService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombreCompleto = request.getParameter("nombreCompleto");
        String nombreUsuario = request.getParameter("nombreUsuario");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String sexo = request.getParameter("sexo");
        float estatura = Float.parseFloat(request.getParameter("estatura"));
        String password = request.getParameter("password");

        if (edad < 15 || estatura < 1 || estatura > 2.5) {
            request.setAttribute("error", "Edad o estatura no válida.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }
        
        if (usuarioService.obtenerUsuarioPorNombre(nombreUsuario) != null) {
            request.setAttribute("error", "Nombre de usuario ya existe.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

        Usuario usuario = new Usuario();
        usuario.setNombreCompleto(nombreCompleto);
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setEdad(edad);
        usuario.setSexo(sexo);
        usuario.setEstatura(estatura);
        usuario.setPassword(password);

        usuarioService.registrarUsuario(usuario);

        response.sendRedirect("index.jsp?registered=true");
    }
}
