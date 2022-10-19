package br.edu.fatecfranca.apidb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecfranca.apidb.model.FifaPlayer;
import br.edu.fatecfranca.apidb.model.repositories.FifaPlayerRepository;

//informa que a classe responde por requisições restfull
@RestController
public class FifaPlayerController {
	//característica principal do spring
	//injeção de dependência
	//objeto pode utilizar métodos de sua interface sem ser instanciado
	@Autowired
	FifaPlayerRepository injecao;
	
	//método get para consultar os FifaPlayers na rota/FifaPlayer
	@GetMapping("/FifaPlayer")
	@CrossOrigin(origins="*")
	public List<FifaPlayer>get(){
		//select * from FifaPlayer
		return injecao.findAll();
	}
	//Método para inserir um pokemón na rota /FifaPlayer
	@PostMapping("/FifaPlayer")
	@CrossOrigin(origins="*")
	public FifaPlayer add(@RequestBody FifaPlayer fifaplayer) {
		FifaPlayer novoFifaPlayer = injecao.save(fifaplayer);
		return novoFifaPlayer;
	}	
	
	@DeleteMapping("/FifaPlayer/{id}")
	@CrossOrigin(origins="*")
	public String remove(@PathVariable Long id) {
		try {//Tenta remover
			injecao.deleteById(id);
			return "Remoção com sucesso";
		}
		catch(Exception e) {//Pegar erro
			return "FifaPlayer não encontrado para remoção";
		}
		
	}

	//Método para inserir um pokemón na rota /FifaPlayer
	@PutMapping("/FifaPlayer")
	@CrossOrigin(origins="*")
	public FifaPlayer updates(@RequestBody FifaPlayer fifaplayer) {
		FifaPlayer alteradoFifaPlayer = injecao.save(fifaplayer);
		return alteradoFifaPlayer;
}
	
}
