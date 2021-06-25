package ar.com.grupoesfera.csd.pois.services;

import org.springframework.stereotype.Service;

import ar.com.grupoesfera.csd.pois.modelos.Poi;
import ar.com.grupoesfera.csd.pois.modelos.UbicacionActual;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicePoi {

        List<Poi> puntosDeInteres = new ArrayList<>();

        public void ServicePoi(){
                //Los dos sahuaros
                puntosDeInteres.add(new Poi(27.92485819240602, -110.91619779813446 , "los dos sahuaros", "Tacos, burros y variada barra de salsas!"));
                //Pollo Feliz
                puntosDeInteres.add(new Poi(27.92852763385808, -110.92205645125398 , "Pollo Feliz", "Cadena de restaurantes informales, con pollo cocinado al estilo mexicano, otros platos tradicionales y aguas frescas"));
        }

        public Poi coordenadasPOI(UbicacionActual ubicacionActual) {

                //cerca
                Poi cerca = new Poi(27.92791,-110.89115,"Tacos Don chuy","");

                //Lejos
                //Poi Lejos = new Poi(27.92791,-110.89115,"Tacos Don chuy","");

                return cerca;
        }

        /**recorre la lista de pois y retorna el mas cercano a la ubicacion del usuario*/
        public Poi PoideInteresMasCercano(UbicacionActual Ubicacion) {

                Poi poiMasCercano = new Poi();
                double distanciaPuntoMasCercano=0;
                for (Poi poi:puntosDeInteres) {
                        double distanciaPuntoActual =obtenerDistancia(Ubicacion.getLatitud(),Ubicacion.getLatitud(),poi.getLatitud(),poi.getLongitud());
                        if(distanciaPuntoMasCercano==0||distanciaPuntoActual<=distanciaPuntoMasCercano){
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
        public static double obtenerDistancia(double latP1, double lonP1, double latP2,double lonP2) {

                final int R = 6371; // Radius of the earth

                double latDistance = Math.toRadians(latP2 - latP1);
                double lonDistance = Math.toRadians(lonP2 - lonP1);
                double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                        + Math.cos(Math.toRadians(latP1)) * Math.cos(Math.toRadians(latP2))
                        * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
                double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
                double distance = R * c * 1000; // convert to meters

                distance = Math.pow(distance, 2);

                return Math.sqrt(distance);
        }
}
