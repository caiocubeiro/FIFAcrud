package br.edu.fatecfranca.apidb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//informe que a cclasse é uma entidade do banco de dados
@Entity
//Informe que a classe FifaPlayer é uma tabela FifaPlayer
@Table(name="FifaPlayer")
public class FifaPlayer {
	//cria uma variável que é uma chve primaria com
	//conteúdo gerado automaticamente com iincremento
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome")
	private String nome;
	@Column(name="posicao")
	private String posicao;
	@Column(name="overall")
	private int overall;
	@Column(name="idade")
	private int idade;
	@Column(name="habilidade")
	private int habilidade;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPosicao() {
		return posicao;
	}
	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}
	public int getOverall() {
		return overall;
	}
	public void setOverall(int overall) {
		this.overall = overall;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public int getHabilidade() {
		return habilidade;
	}
	public void setHabilidade(int habilidade) {
		this.habilidade = habilidade;
	}
	public FifaPlayer(Long id, String nome, String posicao, int overall, int idade, int habilidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.posicao = posicao;
		this.overall = overall;
		this.idade = idade;
		this.habilidade = habilidade;
	}
	public FifaPlayer() {
		super();
	}
	@Override
	public String toString() {
		return "FifaPlayer [id=" + id + ", nome=" + nome + ", posicao=" + posicao + ", overall=" + overall + ", idade=" + idade
				+ ", getId()=" + getId() + ", getNome()=" + getNome() + ", getPosicao()=" + getPosicao() + ", getOverall()="
				+ getOverall() + ", getIdade()=" + getIdade() + ", getHabilidade()=" + getHabilidade() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}