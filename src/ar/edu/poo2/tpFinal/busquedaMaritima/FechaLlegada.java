package ar.edu.poo2.tpFinal.busquedaMaritima;

import java.time.LocalDateTime;
import java.util.function.Predicate;

import ar.edu.poo2.tpFinal.CircuitosNaviera.Viaje;

public class FechaLlegada extends FechaCondicion {
	
	public FechaLlegada(Predicate<LocalDateTime> condicionFecha) {
		super(condicionFecha);
	}

	@Override
	protected LocalDateTime fechaCondicion(Viaje viaje) { return viaje.getFechaLlegada(); }
	
}