package entily;

public class CD {

	private int id;
	private String nome;
	private String conteudo;
	private Categoria categoria;
	
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Categoria getCategoria() {
		return categoria;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public String getConteudo() {
		return conteudo;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}


	@Override
	public String toString() {
		return  "CD - " +getId()+ "\n" +
				"NOME - " +getNome()+ "\n" + 
				"CATEGORIA - " +getCategoria()+ "\n" + 
				"CONTEUDO - " +getConteudo();
	}

}
