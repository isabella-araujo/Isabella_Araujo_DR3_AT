package isabellaraujo.model.domain;

public class Funcionario extends Usuario{
	private String cargo;
	private double salario;
	
	public Funcionario(String nome, String email, int idade, String cpf, String cargo, double salario) {
		super(nome, email, idade, cpf);
		this.cargo = cargo;
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
}
