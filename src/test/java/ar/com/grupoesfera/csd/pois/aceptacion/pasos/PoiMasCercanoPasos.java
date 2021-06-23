package ar.com.grupoesfera.csd.pois.aceptacion.pasos;

import ar.com.grupoesfera.csd.pois.aceptacion.configuracion.ContextoCompartido;
import ar.com.grupoesfera.csd.pois.modelos.Poi;
import ar.com.grupoesfera.csd.pois.modelos.UbicacionActual;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.javacrumbs.jsonunit.core.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static net.javacrumbs.jsonunit.spring.JsonUnitResultMatchers.json;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class PoiMasCercanoPasos {

    List<Poi> puntosDeInteres = new ArrayList<>();
    UbicacionActual ubicacionActualRecibida = new UbicacionActual();

    @Autowired
    private ContextoCompartido contextoCompartido;

    @Autowired
    private MockMvc mockMvc;

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

    @Given("que existe la ubicación {string} en latitud {double} y longitud {double}")
    public void queExisteLaUbicaciónEnLatitudYLongitud(String nombre, double latitud, double longitud) {
        puntosDeInteres.add(new Poi( latitud,  longitud,  nombre,""));
    }

    @And("que existe la ubicación del usuario en latitud {double} y longitud {double}")
    public void queExisteLaUbicaciónDelUsuarioEnLatitudYLongitud(double latitud, double longitud) {
        this.ubicacionActualRecibida = new UbicacionActual(latitud,longitud);
    }

    @When("se consulta el POI más cercano a la ubicación del usuario")
    public void seConsultaElPOIMásCercanoALaUbicaciónDelUsuario() throws Exception {
        ResultActions resultado = mockMvc.perform(get("/Poi/cercano"));
        this.contextoCompartido.agregarResultado(resultado);

    }

    @Then("se retorna POI del {string}")
    public void seRetornaPOIDel(String poimascercano) throws Exception {
        ResultActions resultado = this.contextoCompartido.obtenerResultado();

        resultado.andExpect(json().isEqualTo("{\n" +
                "nombre: \"Tacos Don chuy\",            \n" +
                "longitud: -110.89115,\n" +
                "latitud: 27.92791,\n" +
                "descripcion: \"\"\n" +
                "}")       );
    }
}
