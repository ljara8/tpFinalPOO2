package ar.edu.poo2.tpFinal;

import java.time.LocalDateTime;

import ar.edu.poo2.tpFinal.ordenes.Turno;

public class EntregaTerrestre {
	
	private Chofer chofer;
	private Camion camion;
	private Turno turno;
	private LocalDateTime horarioArribo;

	public EntregaTerrestre(Chofer chofer, Camion camion, Turno turno, LocalDateTime horarioArribo) {
		super();
		this.chofer = chofer;
		this.camion = camion;
		this.turno = turno;
		this.horarioArribo = horarioArribo;
	}

	public LocalDateTime getHorarioArribo() {
		return horarioArribo;
	}

	public Chofer getChofer() {
		return chofer;
	}

	public Camion getCamion() {
		return camion;
	}

	public Turno getTurno() {
		return turno;
	}

}
