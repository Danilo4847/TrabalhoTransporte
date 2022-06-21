package model.vo;

import java.time.LocalDateTime;
import java.util.List;

public class ViagemVO {

	private int idviagem;
	private String regional;
	private VeiculoVO veiculo;
	private MotoristaVO motorista;
	private MaterialVO material;
	private LocalDateTime dataSaida;
	private LocalDateTime dataChegada;

	
	
	

	public MaterialVO getMaterial() {
		return material;
	}
	public void setMaterial(MaterialVO material) {
		this.material = material;
	}
	public int getIdviagem() {
		return idviagem;
	}
	public void setIdviagem(int idviagem) {
		this.idviagem = idviagem;
	}
	public String getRegional() {
		return regional;
	}
	public void setRegional(String regional) {
		this.regional = regional;
	}
	public VeiculoVO getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(VeiculoVO veiculo) {
		this.veiculo = veiculo;
	}
	public MotoristaVO getMotorista() {
		return motorista;
	}
	public void setMotorista(MotoristaVO motorista) {
		this.motorista = motorista;
	}
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

	
	
	
	
}
