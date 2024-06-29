package com.imcapp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.imcapp.model.Usuario;
import com.imcapp.service.UsuarioService;

import java.io.IOException;

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
        float peso = Float.parseFloat(request.getParameter("peso"));
        String password = request.getParameter("password");

        Usuario usuario = new Usuario();
        usuario.setNombreCompleto(nombreCompleto);
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setEdad(edad);
        usuario.setSexo(sexo);
        usuario.setEstatura(estatura);
        usuario.setPeso(peso);
        usuario.setPassword(password);

        usuarioService.registrarUsuario(usuario);

        response.sendRedirect("index.jsp");
    }
}
