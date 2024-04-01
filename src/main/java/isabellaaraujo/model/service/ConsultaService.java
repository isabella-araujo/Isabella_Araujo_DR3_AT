package isabellaaraujo.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import isabellaraujo.model.domain.Consulta;
import isabellaraujo.model.domain.Paciente;
import isabellaraujo.model.domain.Profissional;

public class ConsultaService {
	public static Map<Integer, Consulta> consultas = new HashMap<Integer, Consulta>();
	
	private static Integer id = 0;
	protected static Profissional profissional;
	protected static Paciente paciente;
	
	public static void incluir(Consulta consulta, Integer idPaciente, Integer idProfissional) {
		consulta.setId(++id);
		
		profissional = ProfissionalService.obterPorId(idProfissional);
		paciente = PacienteService.obterPorId(idPaciente);
		
		consulta.setPaciente(paciente);
		consulta.setProfissional(profissional);
		
		profissional.consultas.put(consulta.getId(), consulta);
		paciente.consultas.put(consulta.getId(), consulta);
		
		consultas.put(consulta.getId(), consulta);
	}
	
	public static void excluir(Integer id, Integer idPaciente, Integer idProfissional) {
		profissional.consultas.remove(id);
		paciente.consultas.remove(id);
		
		consultas.remove(id);
	}
	
	public static Collection<Consulta> obterLista() {
		return consultas.values();
	}
	 
	public static Consulta obterPorId(Integer id) {
		return consultas.get(id);
	}
}
