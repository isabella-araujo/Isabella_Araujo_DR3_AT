package isabellaaraujo.model.domain;

import java.util.HashMap;
import java.util.Map;

public class Paciente extends Usuario {
	public static Map<Integer, Consulta> consultas = new HashMap<Integer, Consulta>();
	private boolean convenio;
	
	public Paciente() {
		
	}
	
	public Paciente(String nome, String email, int idade, String cpf, boolean convenio) {
		super(nome, email, idade, cpf);
		this.convenio = convenio;
	}
	
	@Override
	public String toString() {
//		String consulta = "";
//		for(Consulta c : consultas){ consulta += c + "\n"; }
		
		return super.toString();
	}

	public boolean isConvenio() {
		return convenio;
	}

	public void setConvenio(boolean convenio) {
		this.convenio = convenio;
	}
}
