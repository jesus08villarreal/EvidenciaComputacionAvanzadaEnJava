package com.imcapp.controller;

import java.io.IOException;
import java.util.List;

import com.imcapp.model.MedicionIMC;
import com.imcapp.service.IMCService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/historialIMC")
public class HistorialIMCServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IMCService imcService;

    public HistorialIMCServlet() {
        super();
        imcService = new IMCService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String nombreUsuario = (String) session.getAttribute("nombreUsuario");

        if (nombreUsuario == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        int usuarioId = imcService.obtenerUsuarioId(nombreUsuario);
        if (usuarioId == -1) {
            response.sendRedirect("index.jsp");
            return;
        }

        List<MedicionIMC> historial = imcService.obtenerMedicionesPorUsuario(usuarioId);
        request.setAttribute("historial", historial);
        request.getRequestDispatcher("historialIMC.jsp").forward(request, response);
    }
}
