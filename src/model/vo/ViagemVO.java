package model.vo;

import java.util.List;

public class ViagemVO {

	private int idviagem;
	private String regional;
	private VeiculoVO veiculo;
	private MotoristaVO motorista;
	private int dataSaida;
	private int dataChegada;
	private List conteudo;
	private List setor;
	private int quantidade;
	
	
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
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
	public int getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(int dataSaida) {
		this.dataSaida = dataSaida;
	}
	public int getDataChegada() {
		return dataChegada;
	}
	public void setDataChegada(int dataChegada) {
		this.dataChegada = dataChegada;
	}
	public List getConteudo() {
		return conteudo;
	}
	public void setConteudo(List conteudo) {
		this.conteudo = conteudo;
	}
	public List getSetor() {
		return setor;
	}
	public void setSetor(List setor) {
		this.setor = setor;
	}
	
	
	
	
}
