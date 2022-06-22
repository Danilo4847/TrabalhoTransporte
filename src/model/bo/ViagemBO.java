package model.bo;

import model.dao.MotoristaDAO;
import model.dao.ViagemDAO;
import model.exception.ErroAoSalvarViagemException;
import model.vo.ViagemVO;

public class ViagemBO {
		
	
	MotoristaDAO daoM= new MotoristaDAO();
		private ViagemDAO dao = new ViagemDAO();
		
		public String salvar(ViagemVO viagem) throws ErroAoSalvarViagemException {
			String mensagem = "";

			if(viagem.getIdviagem() > 0) {
				if(dao.atualizar(viagem)) {
					mensagem = "viagem atualizada com sucesso";
				}else {
					throw new ErroAoSalvarViagemException(
							"Erro ao atualizar viagem, entre em contato com lorde vilmar-junior");
				}
			}else {
				if(daoM.motoristaIndisponivel(viagem.getMotorista())) {
					throw new ErroAoSalvarViagemException(
							"motorista informado (" + viagem.getMotorista() + ") esta ocupado");
				}else {
					viagem = dao.criarViagem(viagem);
					if(viagem.getIdviagem() > 0) {
						mensagem = "Veiculo cadastrado com sucesso (id: " + viagem.getIdviagem() + ")";
					}else {
						throw new ErroAoSalvarViagemException(
								"Erro ao cadastrar Veiculo, entre em contato com o lorde vilmar-junior");
					}
				}
			}

			return mensagem;
		}
		

	}

