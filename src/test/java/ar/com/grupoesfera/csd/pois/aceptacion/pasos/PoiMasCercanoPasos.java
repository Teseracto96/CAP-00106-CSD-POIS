package ar.com.grupoesfera.csd.pois.aceptacion.pasos;

import ar.com.grupoesfera.csd.pois.aceptacion.configuracion.ContextoCompartido;
import ar.com.grupoesfera.csd.pois.modelos.Poi;
import ar.com.grupoesfera.csd.pois.modelos.UbicacionActual;
import io.cucumber.java.en.Then;
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
        //Set variables
        double lat = 27.92816;
        double lon = 110.88903;
        UbicacionActual ubicacionActual = new UbicacionActual( lat,  lon);
        CoordenadasPOI(ubicacionActual);
    }

    @Then("se retorna POI más cercano")
    public Poi CoordenadasPOI(UbicacionActual ubicacionActual)
    {
        //cerca
        double latCerca = 27.92398;
        double lonCerca = -110.88695;
        String NombreCercano = "Pollo Feliz Restaurant";
        String DescripcionCercano = "Cadena de restaurantes informales, con pollo cocinado al estilo mexicano, otros platos tradicionales y aguas frescas";

        //Lejos
        double latLejos = 27.92791;
        double lonLejos = -110.89115;
        String NombreLejos = "";

        return new Poi( latCerca,  lonCerca,  NombreCercano, DescripcionCercano);
    }
   //


}
