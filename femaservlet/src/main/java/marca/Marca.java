package marca;

public class Marca {

	private Integer codigo;
	private String nome;
	private String descricao;
	private String especializacao;
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
	
	
	public void setEspecializacao(String especializacao) {
		this.especializacao = especializacao;
	}
	public String getEspecializacao() {
		return especializacao;
	}
}
