package ar.com.grupoesfera.csd.pois.modelos;

public class UbicacionActual {

    private double latitud;
    private double longitud;

    public UbicacionActual() {}

    public UbicacionActual(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

}
