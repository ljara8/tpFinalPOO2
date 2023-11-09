package ar.edu.poo2.tpFinal.busquedaMaritima;

import java.util.Date;
import java.util.function.Predicate;

import ar.edu.poo2.tpFinal.Viaje;

public class FechaSalida extends FechaCondicion {

	public FechaSalida(Predicate<Date> condicionFecha) {
		super(condicionFecha);
	}

	@Override
	protected Date fechaCondicion(Viaje viaje) { return viaje.getFechaSalida(); }

}
