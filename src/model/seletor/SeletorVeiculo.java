package model.seletor;

public class SeletorVeiculo {

	private String marca;
	private String renavam;
	private String placa;
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getRenavam() {
		return renavam;
	}
	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public boolean filtroVeiculo() {

		if((this.marca!=null)&&(this.marca.trim().length()>0)) {
			return true;
		}
		if((this.placa!=null)&&(this.placa.trim().length()>0)) {
			return true;
		}
		if((this.renavam!=null)&&(this.renavam.trim().length()>0)) {
			return true;
		}

		return false;
	}
	
	
	
	
}
