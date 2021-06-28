package ar.com.grupoesfera.csd.pois.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.grupoesfera.csd.pois.modelos.Poi;
import ar.com.grupoesfera.csd.pois.modelos.UbicacionActual;
import ar.com.grupoesfera.csd.pois.repositorio.RepositorioDePoi;

@Service
public class ServicePoi {

        @Autowired
        private RepositorioDePoi repositorioDePoi;

        public Poi coordenadasPOI(UbicacionActual ubicacionActual) {

        	return this.poideInteresMasCercano(ubicacionActual);
        }

        /**recorre la lista de pois y retorna el mas cercano a la ubicacion del usuario*/
        public Poi poideInteresMasCercano(UbicacionActual Ubicacion) {

                Poi poiMasCercano = new Poi();
                double distanciaPuntoMasCercano = Double.MAX_VALUE;
                List<Poi> puntosDeInteres = repositorioDePoi.findAll();

                for (Poi poi:puntosDeInteres) {
                	double distanciaPuntoActual =obtenerDistancia(Ubicacion.getLatitud(),Ubicacion.getLongitud(),poi.getLatitud(),poi.getLongitud());
                	if(distanciaPuntoActual<=distanciaPuntoMasCercano){
                		distanciaPuntoMasCercano = distanciaPuntoActual;
                		poiMasCercano=poi;
                    }
                }

                //Retorna el POI mas cercano
                return  poiMasCercano;
        }

        /**
         * ES RRROBADDDO
         * Calculate distance between two points in latitude and longitude taking
         * into account height difference. If you are not interested in height
         * difference pass 0.0. Uses Haversine method as its base.
         *
         * lat1, lon1 Start point lat2, lon2 End point el1 Start altitude in meters
         * el2 End altitude in meters
         * @returns Distance in Meters
         */
        public static double obtenerDistancia(double x1, double y1, double x2,double y2) {
        	return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        }
}
