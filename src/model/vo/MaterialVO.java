package model.vo;

public class MaterialVO {
	
	private int idmaterial;
	private String conteudo;
	private String setor;
	private int quantidade;
	
	
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getIdmaterial() {
		return idmaterial;
	}
	public void setIdmaterial(int idmaterial) {
		this.idmaterial = idmaterial;
	}
	@Override
	public String toString() {
		return this.conteudo;
	}
	
	
	
	
}
