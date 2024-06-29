package com.mycompany.imcapp;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class JakartaRestConfiguration extends Application {
    // Deja esta clase vacía. Su presencia es suficiente para que Jakarta EE registre tu configuración.
}
