package com.imcapp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.imcapp.model.MedicionIMC;
import com.imcapp.service.IMCService;

import java.io.IOException;
import java.util.Date;

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
        float peso = Float.parseFloat(request.getParameter("peso"));

        MedicionIMC medicion = new MedicionIMC();
        medicion.setUsuarioId(imcService.obtenerUsuarioId(nombreUsuario));
        medicion.setImc(peso / (imcService.obtenerEstaturaUsuario(nombreUsuario) * imcService.obtenerEstaturaUsuario(nombreUsuario)));
        medicion.setFecha(new Date());

        imcService.registrarMedicion(medicion);

        request.setAttribute("imc", medicion.getImc());
        request.getRequestDispatcher("resultadoIMC.jsp").forward(request, response);
    }
}
