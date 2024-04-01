package isabellaraujo.model.domain;

public class Consulta {
	private Integer id;
	private String data;
	private Profissional profissional;
	private Paciente paciente;
	private double valor;
	
	public Consulta(String data, int valor) {
		this.data = data;
		this.valor = valor;
	}
	
	public Consulta(String data, Profissional profissional, Paciente paciente, int valor) {
		this(data, valor);
		this.profissional = profissional;
		this.paciente = paciente;
	}

	public String toString() {
		return "Data da Consulta: " + data + 
				"\nValor: " + valor + 
				"\nProfissional: " + profissional + 
				"\nPaciente: " + paciente;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public Profissional getProfissional() {
		return profissional;
	}
	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
