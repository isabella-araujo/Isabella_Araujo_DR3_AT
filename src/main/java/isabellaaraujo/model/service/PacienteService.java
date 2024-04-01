package isabellaaraujo.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import isabellaraujo.model.domain.Paciente;

public class PacienteService {
	private static Map<Integer, Paciente> pacientes = new HashMap<Integer, Paciente>();
	
	private static Integer id = 0;
	
	public static void incluir(Paciente paciente) {
		paciente.setId(++id);
		pacientes.put(paciente.getId(), paciente);
	}
	
	public static void excluir(Integer id) {
		pacientes.remove(id);
	}
	
	public static Collection<Paciente> obterLista() {
		return pacientes.values();
	}
	 
	public static Paciente obterPorId(Integer id) {
		return pacientes.get(id);
	}
}
