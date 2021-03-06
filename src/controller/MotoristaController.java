package controller;

import java.util.ArrayList;

import model.bo.MotoristaBO;
import model.dao.MotoristaDAO;
import model.dao.ViagemDAO;
import model.exception.ErroAoSalvarMotoristaException;
import model.exception.ErroAoSalvarVeiculoException;
import model.seletor.SeletorMotorista;
import model.vo.MotoristaVO;



public class MotoristaController {
	private static final int QUANTIDADE_DIGITOS_NOME = 50;
	private static final int QUANTIDADE_DIGITOS_CNH = 11;
	private MotoristaDAO dao = new MotoristaDAO();
	public MotoristaBO bo = new MotoristaBO();
	
	public String salvar(MotoristaVO novo) throws ErroAoSalvarMotoristaException {
		String mensagem = "";
		
		if(novo == null) {
			mensagem = "Informe todos os dados do novo cliente";
		}else {
			mensagem = validarNome(novo);
			mensagem = validarCNH(novo);
			
			if(mensagem.isEmpty()) {
				mensagem = bo.salvar(novo);
			}
		}
		
		return mensagem;
	}
	
	

	private String validarNome(MotoristaVO novo) throws ErroAoSalvarMotoristaException{
		String mensagem ="";
		if(novo.getNome()!=null && novo.getNome().trim().length()>0&&novo.getNome().length()<=QUANTIDADE_DIGITOS_NOME) {
			
		}else {
			mensagem += "Digite um nome";
            throw new ErroAoSalvarMotoristaException(mensagem);
		}
		
		
		return mensagem;
	}
	
	private String validarCNH(MotoristaVO novo) throws ErroAoSalvarMotoristaException {
		String mensagem="";
		if(novo.getCnh()!=null && novo.getCnh().length() != QUANTIDADE_DIGITOS_CNH ){
			try {
				Long.parseLong(novo.getCnh());
			} catch (NumberFormatException excecao) {
				mensagem = "CNH dever conter somente números \n";
			}

			mensagem += "CNH deve conter 11 d�gitos ";


			throw new ErroAoSalvarMotoristaException(mensagem);
		}
		return mensagem;
	}		

	public ArrayList<MotoristaVO> consulta(SeletorMotorista seletor) {
		return dao.consultaSeletor(seletor);
	}
	
	public ArrayList<MotoristaVO> consultaNome() {
		return dao.consultarNomeMotorista();
	}
	public MotoristaVO ConsultaMotorista(String nome) {
		return dao.consultarNomeMotorista(nome);
	}
	public MotoristaVO motorista(int id) {
		return dao.consultar(id);
	}
	
	public String excluirMotorista(int id){

		String mensagem="";
		ViagemDAO viagem = new ViagemDAO();
		MotoristaDAO mDAO= new MotoristaDAO();
/*
		viagem=dao.consultaComIdMotorista(id);

		if(viagem!=null){

		mensagem=" não é permitido excluir veiculo que ja efetuou uma viagem";

		}else{
		}
*/
		mDAO.excluirMotorista(id);
		return mensagem;

		}


	
}