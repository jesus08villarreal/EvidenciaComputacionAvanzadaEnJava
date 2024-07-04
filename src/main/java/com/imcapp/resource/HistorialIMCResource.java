package com.imcapp.resource;

import java.util.List;

import com.imcapp.model.MedicionIMC;
import com.imcapp.service.IMCService;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/historial")
public class HistorialIMCResource {
    private IMCService imcService = new IMCService();

    @GET
    @Path("/{usuarioId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MedicionIMC> getHistorial(@PathParam("usuarioId") int usuarioId) {
        return imcService.obtenerMedicionesPorUsuario(usuarioId);
    }
}
