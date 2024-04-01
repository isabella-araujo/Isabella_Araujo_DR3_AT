package isabellaaraujo.controller;

import com.google.gson.Gson;

import isabellaaraujo.model.service.FuncionarioService;
import isabellaraujo.model.domain.Funcionario;
import spark.Route;

public class FuncionarioController {
	public static Route obterLista = (req, res) -> {
		return FuncionarioService.obterLista();
	};
	
	public static Route excluir = (req, res) -> {
		Integer index = Integer.valueOf(req.params("id"));
		
		Funcionario funcionario = FuncionarioService.obterPorId(index);		

		FuncionarioService.excluir(index);		
		
		return "Exclusão realizada com sucesso: " + funcionario.getNome() + "!";
	};
	
	public static Route incluir = (req, res) -> {
		Funcionario funcionario = new Gson().fromJson(req.body(), Funcionario.class);
		FuncionarioService.incluir(funcionario);		
		return "Funcionario " + funcionario.getNome() + " incluido com sucesso.";
	};
	
	public static Route obterPorId = (req, res) -> {
		Integer index = Integer.valueOf(req.params("id"));
		
		Funcionario funcionario = FuncionarioService.obterPorId(index);		
				
		return "Recuperação realizada com sucesso: " + funcionario + "!";
	};
}
