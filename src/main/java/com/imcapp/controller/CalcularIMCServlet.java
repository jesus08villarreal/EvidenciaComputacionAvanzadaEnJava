package com.imcapp.controller;

import java.io.IOException;
import java.util.Date;

import com.imcapp.model.MedicionIMC;
import com.imcapp.service.IMCService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/calcularIMC")
public class CalcularIMCServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IMCService imcService;

    public CalcularIMCServlet() {
        super();
        imcService = new IMCService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String nombreUsuario = (String) session.getAttribute("nombreUsuario");

        if (nombreUsuario == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        String masaCorporalStr = request.getParameter("masaCorporal");
        if (masaCorporalStr == null || masaCorporalStr.trim().isEmpty()) {
            request.setAttribute("error", "La masa corporal es requerida.");
            request.getRequestDispatcher("calcularIMC.jsp").forward(request, response);
            return;
        }

        try {
            float masaCorporal = Float.parseFloat(masaCorporalStr.trim());

            if (masaCorporal <= 0) {
                request.setAttribute("error", "La masa corporal debe ser un valor positivo.");
                request.getRequestDispatcher("calcularIMC.jsp").forward(request, response);
                return;
            }

            float estatura = imcService.obtenerEstaturaUsuario(nombreUsuario);
            if (estatura <= 0) {
                request.setAttribute("error", "La estatura del usuario no es válida.");
                request.getRequestDispatcher("calcularIMC.jsp").forward(request, response);
                return;
            }

            float imc = masaCorporal / (estatura * estatura);

            MedicionIMC medicion = new MedicionIMC();
            medicion.setUsuarioId(imcService.obtenerUsuarioId(nombreUsuario));
            medicion.setImc(imc);
            medicion.setFecha(new Date());

            imcService.registrarMedicion(medicion);

            request.setAttribute("imc", imc);
            request.getRequestDispatcher("resultadoIMC.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            request.setAttribute("error", "La masa corporal debe ser un número válido.");
            request.getRequestDispatcher("calcularIMC.jsp").forward(request, response);
        }
    }
}
