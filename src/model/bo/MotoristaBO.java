package model.bo;

import model.dao.MotoristaDAO;
import model.exception.ErroAoSalvarMotoristaException;
import model.vo.MotoristaVO;

public class MotoristaBO {

private MotoristaDAO dao = new MotoristaDAO();
	
	public String salvar(MotoristaVO motorista) throws ErroAoSalvarMotoristaException {
		String mensagem = "";

		if(motorista.getIdMotorista() > 0) {
			if(dao.atualizar(motorista)) {
				mensagem = "Cliente atualizado com sucesso";
			}else {
				throw new ErroAoSalvarMotoristaException(
						"Erro ao atualizar Veiculo, entre em contato com lorde vilmar-junior");
			}
		}else {
			if(dao.cnhJaUtilizado(motorista.getCnh())) {
				throw new ErroAoSalvarMotoristaException(
						"CNH informado (" + motorista.getCnh() + ") já foi utilizado");
			}else {
				motorista = dao.inserirMotorista(motorista);
				if(motorista.getIdMotorista() > 0) {
					mensagem = "Cliente cadastrado com sucesso (id: " + motorista.getIdMotorista() + ")";
				}else {
					throw new ErroAoSalvarMotoristaException(
							"Erro ao cadastrar cliente, entre em contato com o lorde vilmar-junior");
				}
			}
		}

		return mensagem;
	}
}
