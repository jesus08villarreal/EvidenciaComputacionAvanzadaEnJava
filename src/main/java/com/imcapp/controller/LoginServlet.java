package com.imcapp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.imcapp.service.UsuarioService;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsuarioService usuarioService;

    public LoginServlet() {
        super();
        usuarioService = new UsuarioService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombreUsuario = request.getParameter("nombreUsuario");
        String password = request.getParameter("password");

        if (usuarioService.autenticarUsuario(nombreUsuario, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("nombreUsuario", nombreUsuario);
            response.sendRedirect("calcularIMC.jsp");
        } else {
            response.sendRedirect("index.jsp?error=true");
        }
    }
}
