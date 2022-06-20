package model.seletor;

import java.time.LocalDateTime;

public class SeletorViagem {

	private LocalDateTime dataSaida;
	private LocalDateTime dataChegada;
	private String motorista;
	private String regional;
	private String veiculo;
	
	
	public LocalDateTime getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(LocalDateTime dataSaida) {
		this.dataSaida = dataSaida;
	}
	public LocalDateTime getDataChegada() {
		return dataChegada;
	}
	public void setDataChegada(LocalDateTime dataChegada) {
		this.dataChegada = dataChegada;
	}
	public String getMotorista() {
		return motorista;
	}
	public void setMotorista(String motorista) {
		this.motorista = motorista;
	}
	public String getRegional() {
		return regional;
	}
	public void setRegional(String regional) {
		this.regional = regional;
	}
	public String getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}
	
	public boolean temFiltro() {
		
		if(this.dataChegada!=null){
			return true;
			
		}
		if (this.dataSaida!=null) {
			return true;
		}
		if ((this.motorista!=null)&&(this.motorista.trim().length()>0)) {
			return true;
		}
		if ((this.veiculo!=null)&&(this.veiculo.trim().length()>0)) {
			return true;
		}
			
		if ((this.regional!=null)&&(this.regional.trim().length()>0)) {
			return true;
		}
		
		return false;
	}
	
	
}
