package model.vo;

public class MotoristaVO {

	private int idMotorista;
	private String nome;
	private String categoriaCarteira;
	private String cnh;
	private boolean status;
	
	
	public int getIdMotorista() {
		return idMotorista;
	}
	public void setIdMotorista(int idMotorista) {
		this.idMotorista = idMotorista;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoriaCarteira() {
		return categoriaCarteira;
	}
	public void setCategoriaCarteira(String categoriaCarteira) {
		this.categoriaCarteira = categoriaCarteira;
	}
	public String getCnh() {
		return cnh;
	}
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "("+this.categoriaCarteira.toUpperCase()+")"+" "+this.nome.toUpperCase();
	}
	public String imprimir() {
		return this.nome;
	}
	
	
	
	
}
