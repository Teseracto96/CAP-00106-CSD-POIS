package ar.com.grupoesfera.csd.pois.services;

import org.springframework.stereotype.Service;

import ar.com.grupoesfera.csd.pois.modelos.Poi;
import ar.com.grupoesfera.csd.pois.modelos.UbicacionActual;

@Service
public class ServicePoi {

	public Poi coordenadasPOI(UbicacionActual ubicacionActual) {

        //cerca
        double latCerca = 27.92791;
        double lonCerca = -110.89115;
        String NombreCercano = "Tacos Don chuy";
        String DescripcionCercano = "";
        
        //Lejos
        //double latLejos = 27.92791;
        //double lonLejos = -110.89115;
        //String NombreLejos = "";

        return new Poi( latCerca,  lonCerca,  NombreCercano, DescripcionCercano);
    }
}
