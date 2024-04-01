package isabellaaraujo.controller;

import com.google.gson.Gson;

import isabellaaraujo.model.service.ConsultaService;
import isabellaraujo.model.domain.Consulta;
import spark.Route;

public class ConsultaController {
	public static Route obterLista = (req, res) -> {
		return ConsultaService.obterLista();
	};
	
	public static Route excluir = (req, res) -> {
		Integer idConsulta = Integer.valueOf(req.params("id"));
		Integer idPaciente = Integer.valueOf(req.params(":idPaciente"));
		Integer idProfissional = Integer.valueOf(req.params(":idProfissional"));
		
		Consulta consulta = ConsultaService.obterPorId(idConsulta);		

		ConsultaService.excluir(idConsulta, idPaciente, idProfissional);		
		
		return "Exclusão realizada com sucesso: " + consulta + "!";
	};
	
	public static Route incluir = (req, res) -> {
		Consulta consulta = new Gson().fromJson(req.body(), Consulta.class);
		
		Integer idPaciente = Integer.valueOf(req.params(":idPaciente"));
		Integer idProfissional = Integer.valueOf(req.params(":idProfissional"));
		
		ConsultaService.incluir(consulta, idPaciente, idProfissional);		
		return "Consulta " + consulta + " incluido com sucesso.";
	};
	
	public static Route obterPorId = (req, res) -> {
		Integer index = Integer.valueOf(req.params("id"));
		
		Consulta consulta = ConsultaService.obterPorId(index);		
				
		return "Recuperação realizada com sucesso: " + consulta + "!";
	};
}
