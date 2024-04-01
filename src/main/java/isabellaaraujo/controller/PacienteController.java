package isabellaaraujo.controller;

import com.google.gson.Gson;

import isabellaaraujo.model.service.PacienteService;
import isabellaraujo.model.domain.Paciente;
import spark.Route;

public class PacienteController {

	public static Route obterLista = (req, res) -> {
		return PacienteService.obterLista();
	};
	
	public static Route excluir = (req, res) -> {
		Integer index = Integer.valueOf(req.params("id"));
		
		Paciente paciente = PacienteService.obterPorId(index);		

		PacienteService.excluir(index);		
		
		return "Exclusão realizada com sucesso: " + paciente.getNome() + "!";
	};
	
	public static Route incluir = (req, res) -> {
		Paciente paciente = new Gson().fromJson(req.body(), Paciente.class);
		PacienteService.incluir(paciente);		
		return "Paciente " + paciente.getNome() + " incluido com sucesso.";
	};
	
	public static Route obterPorId = (req, res) -> {
		Integer index = Integer.valueOf(req.params("id"));
		
		Paciente paciente = PacienteService.obterPorId(index);		
				
		return "Recuperação realizada com sucesso: " + paciente + "!";
	};

}
