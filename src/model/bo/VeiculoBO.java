package model.bo;

import model.dao.VeiculoDAO;
import model.exception.ErroAoSalvarVeiculoException;
import model.vo.VeiculoVO;

public class VeiculoBO {
	
	private VeiculoDAO dao = new VeiculoDAO();
	
	public String salvar(VeiculoVO veiculo) throws ErroAoSalvarVeiculoException {
		String mensagem = "";

		if(veiculo.getIdVeiculo() > 0) {
			if(dao.atualizar(veiculo)) {
				mensagem = "Veiculo atualizado com sucesso";
			}else {
				throw new ErroAoSalvarVeiculoException(
						"Erro ao atualizar Veiculo, entre em contato com lorde vilmar-junior");
			}
		}else {
			if(dao.renavamJaUtilizado(veiculo.getRenavam())) {
				throw new ErroAoSalvarVeiculoException(
						"RENAVAM informado (" + veiculo.getRenavam() + ") já foi utilizado");
			}else {
				veiculo = dao.salvarVeiculo(veiculo);
				if(veiculo.getIdVeiculo() > 0) {
					mensagem = "Veiculo cadastrado com sucesso (id: " + veiculo.getIdVeiculo() + ")";
				}else {
					throw new ErroAoSalvarVeiculoException(
							"Erro ao cadastrar Veiculo, entre em contato com o lorde vilmar-junior");
				}
			}
		}

		return mensagem;
	}

	
}
