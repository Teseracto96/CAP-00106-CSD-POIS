package ar.com.grupoesfera.csd.pois.aceptacion.pasos;

import ar.com.grupoesfera.csd.pois.aceptacion.configuracion.ContextoCompartido;
import ar.com.grupoesfera.csd.pois.modelos.UbicacionActual;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;



public class PoiMasCercanoPasos {

    /*
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UbicacionActual ubicacionActual;
     */

    @When("se recibe la ubicación del usuario")
    public void seRecibeLaUbicaciónDelUsuario() {
        UbicacionActual ubicacionActual = new UbicacionActual(double latitud, double longitud)
    }
}
