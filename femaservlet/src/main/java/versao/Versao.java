package versao;

public class Versao {
	
	private Integer codigo;
	private Integer ano;
	private String nome;
	private String novidades;
	private String problemasResolvidos;
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Integer getAno() {
		return ano;
	}
	
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNovidades() {
		return novidades;
	}
	
	public void setNovidades(String novidades) {
		this.novidades = novidades;
	}
	
	public String getProblemasResolvidos() {
		return problemasResolvidos;
	}
	
	public void setProblemasResolvidos(String problemasResolvidos) {
		this.problemasResolvidos = problemasResolvidos;
	}
}
