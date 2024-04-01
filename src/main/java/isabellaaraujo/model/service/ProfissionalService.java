package isabellaaraujo.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import isabellaraujo.model.domain.Profissional;

public class ProfissionalService {
	public static Map<Integer, Profissional> profissionais = new HashMap<Integer, Profissional>();
	
	private static Integer id = 0;
	
	public static void incluir(Profissional profissional) {
		profissional.setId(++id);
		
		profissionais.put(profissional.getId(), profissional);
	}
	
	public static void excluir(Integer id) {
		profissionais.remove(id);
	}
	
	public static Collection<Profissional> obterLista() {
		return profissionais.values();
	}
	 
	public static Profissional obterPorId(Integer id) {
		return profissionais.get(id);
	}
}


