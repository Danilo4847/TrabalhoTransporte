package model.seletor;

public class SeletorMotorista {


	
	private String nome;
	private String CNH;
	private String categoriaCarteira;
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCNH() {
		return CNH;
	}
	public void setCNH(String cNH) {
		CNH = cNH;
	}
	public String getCategoriaCarteira() {
		return categoriaCarteira;
	}
	public void setCategoriaCarteira(String categoriaCarteira) {
		this.categoriaCarteira = categoriaCarteira;
	}
	
	
	public boolean filtro() {
		
		if((this.nome!= null)&&(this.nome.trim().length()>0)){
			return true;
		}
		if((this.categoriaCarteira!=null)&&(this.categoriaCarteira.trim().length()>0)) {
			return true;
		}
		if((this.CNH!=null)&&(this.CNH.trim().length()>0)) {
			return true;
		}
		
		return false;
	}
	
}
