package br.edu.fatecfranca.apidb.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fatecfranca.apidb.model.FifaPlayer;

//a classe iinterface vai herdar de outra classe interface
//FifaPlayer é o tipo da tabela, e o long é o tipo de chave
public interface FifaPlayerRepository extends JpaRepository<FifaPlayer,Long> {
	//Esta interface vai herdar os métodos de CRUD
	//C - create - insert
	//R - retrieve - select
	//U - update -update
	//D - delete - delete
}
