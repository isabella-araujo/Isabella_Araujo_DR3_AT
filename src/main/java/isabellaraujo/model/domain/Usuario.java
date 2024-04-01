package isabellaraujo.model.domain;

public abstract class Usuario {
	private String nome;
	private String email;
	private int idade;
	private String cpf;
	private Integer id;
	
	public Usuario() {
		
	}
	
	public Usuario(String nome, String email, int idade, String cpf) {
		this();
		this.nome = nome;
		this.email = email;
		this.idade = idade;
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + 
			   "\nEmail: " + email + 
				"\nIdade: " + idade + 
				"\nCPF: " + cpf;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
