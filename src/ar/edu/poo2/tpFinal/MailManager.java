package ar.edu.poo2.tpFinal;

import java.util.List;

public interface MailManager {
	void enviarMail(Mail mail);
	void registrarCliente();
	List<Mail> enviados();
}
