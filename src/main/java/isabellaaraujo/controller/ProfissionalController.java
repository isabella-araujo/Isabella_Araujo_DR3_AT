package isabellaaraujo.controller;

import com.google.gson.Gson;

import isabellaaraujo.model.service.ProfissionalService;
import isabellaraujo.model.domain.Profissional;
import spark.Route;

public class ProfissionalController {

	public static Route obterLista = (req, res) -> {
		return ProfissionalService.obterLista();
	};
	
	public static Route excluir = (req, res) -> {
		Integer index = Integer.valueOf(req.params("id"));
		
		Profissional profissional = ProfissionalService.obterPorId(index);		

		ProfissionalService.excluir(index);		
		
		return "Exclusão realizada com sucesso: " + profissional.getNome() + "!";
	};
	
	public static Route incluir = (req, res) -> {
		
		Profissional profissional = new Gson().fromJson(req.body(), Profissional.class);
		
		ProfissionalService.incluir(profissional);	
		
		return "Profissional " + profissional.getNome() + " incluido com sucesso.";
	};
	
	public static Route obterPorId = (req, res) -> {
		Integer index = Integer.valueOf(req.params("id"));
		
		Profissional profissional = ProfissionalService.obterPorId(index);		
				
		return "Recuperação realizada com sucesso: " + profissional + "!";
	};
}
