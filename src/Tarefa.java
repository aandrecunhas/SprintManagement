

public class Tarefa {
	
	private int id;
	
	private String nome;
	
	private String descricao;
	
	private int tamanho; // dado em Pontos por Funcao (PF)
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getNome();
	}
}
