package isabellaraujo.model.domain;

import java.util.HashMap;
import java.util.Map;

public class Profissional extends Usuario {
	private String area;
	public static Map<Integer, Consulta> consultas = new HashMap<Integer, Consulta>();
	
	public Profissional(String nome, String email, int idade, String cpf, String area) {
		super(nome, email, idade, cpf);
		this.area = area;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nÁrea: " + area;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	
}
