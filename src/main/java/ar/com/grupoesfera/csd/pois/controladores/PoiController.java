package ar.com.grupoesfera.csd.pois.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.grupoesfera.csd.pois.modelos.Poi;
import ar.com.grupoesfera.csd.pois.modelos.UbicacionActual;
import ar.com.grupoesfera.csd.pois.services.ServicePoi;

@RestController
@CrossOrigin
@RequestMapping(path = "/poi")
public class PoiController {
	
	@Autowired
	private ServicePoi servicio;

	@GetMapping("/cercano")
	public ResponseEntity<Poi> obtenerPuntoMasCercano(
			@RequestParam("latitud") double latitud, @RequestParam("longitud") double longitud) {
		
		UbicacionActual ubicacion = new UbicacionActual();
		ubicacion.setLatitud(latitud);
		ubicacion.setLongitud(longitud);
		
		return ResponseEntity.ok(servicio.coordenadasPOI(ubicacion));
	}
}