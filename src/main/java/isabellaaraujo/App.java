package isabellaaraujo;

import isabellaaraujo.controller.ConsultaController;
import isabellaaraujo.controller.FuncionarioController;
import isabellaaraujo.controller.PacienteController;
import isabellaaraujo.controller.ProfissionalController;
import isabellaaraujo.controller.ViaCepController;
import isabellaaraujo.model.service.ConsultaService;
import isabellaaraujo.model.service.FuncionarioService;
import isabellaaraujo.model.service.PacienteService;
import isabellaaraujo.model.service.ProfissionalService;
import isabellaraujo.model.domain.Consulta;
import isabellaraujo.model.domain.Funcionario;
import isabellaraujo.model.domain.Paciente;
import isabellaraujo.model.domain.Profissional;
import spark.Spark;

public class App {

	public static void main(String[] args) {
		Spark.port(8080);
		
		Spark.get("/", (req, res) -> {
			return App.class.getResourceAsStream("/Index.html");
		});
		
		// profissional
		Spark.get("/profissional/lista", ProfissionalController.obterLista);
		Spark.post("/profissional/incluir", ProfissionalController.incluir);
		Spark.delete("/profissional/:id/excluir", ProfissionalController.excluir);
		Spark.get("/profissional/:id", ProfissionalController.obterPorId);
		
		// funcionarios
		Spark.get("/funcionario/lista", FuncionarioController.obterLista);
		Spark.post("/funcionario/incluir", FuncionarioController.incluir);
		Spark.delete("/funcionario/:id/excluir", FuncionarioController.excluir);
		Spark.get("/funcionario/:id", FuncionarioController.obterPorId);
		
		// pacientes
		Spark.get("/paciente/lista", PacienteController.obterLista);
		Spark.post("/paciente/incluir", PacienteController.incluir);
		Spark.delete("/paciente/:id/excluir", PacienteController.excluir);
		Spark.get("/paciente/:id", PacienteController.obterPorId);
		
		// consultas
		Spark.get("/consulta/lista", ConsultaController.obterLista);
		Spark.post("/consulta/:idPaciente/:idProfissional/incluir", ConsultaController.incluir);
		Spark.delete("/consulta/:id/:idPaciente/:idProfissional/excluir", ConsultaController.excluir);
		Spark.get("/consulta/:id", ConsultaController.obterPorId);
		
		// viacep
		Spark.get("/viacep/:cep", ViaCepController.getEndereco);
		
		// ----------------------------------------------------------------
		Profissional profissional = new Profissional("Fátima Pereira", "fatima.pereira@gmail.com", 34, "123.456.789-12", "Pediatra");
		ProfissionalService.incluir(profissional);
		ProfissionalService.incluir(new Profissional("Flávia Guedes", "flaviaguedes@gmail.com", 29, "789.456.123-78", "Psicológa"));
		
		FuncionarioService.incluir(new Funcionario("Maria Beatriz Almeida", "beatrizalmeida@gmail.com", 22, "456.789.321-45", "Recepcionista", 2000));
		FuncionarioService.incluir(new Funcionario("José da Silva", "jose.silva@gmail.com", 45, "852.963.741-85", "Auxiliar de Limpeza", 2300));
		
		Paciente paciente = new Paciente("Ana Souza", "anasouza@gmail.com", 15, "546.879.21-54", false);
		PacienteService.incluir(paciente);
		PacienteService.incluir(new Paciente("Carlos Oliveira", "carlosoliveira@gmail.com", 65, "213.546.879-21", true));
		
		ConsultaService.incluir(new Consulta("12/03/2024", profissional, paciente, 400), paciente.getId(), profissional.getId());
		ConsultaService.incluir(new Consulta("04/11/2022", profissional, paciente, 600), paciente.getId(), profissional.getId());
	}

}
