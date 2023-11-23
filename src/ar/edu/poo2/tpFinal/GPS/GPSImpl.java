package ar.edu.poo2.tpFinal.GPS;

import java.util.ArrayList;
import java.util.List;

public class GPSImpl implements GPS {

	public List<Localizable> localizables = new ArrayList<Localizable>();
	
	GPSImpl(List<Localizable> localizables){
		this.localizables = localizables;
	}

	@Override
	public void agregarLocalizable(Localizable localizable) {
		localizables.add(localizable);
	}

	public void actualizarDistanciaDestino(double distancia) {
		for (Localizable localizable : localizables) {
			localizable.actualizarDistanciaDestino(distancia);
		}
	}

	public List<Localizable> getLocalizables() {
		return localizables;
	}

}
