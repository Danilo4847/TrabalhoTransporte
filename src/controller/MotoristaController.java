package controller;

import java.util.ArrayList;

import model.bo.MotoristaBO;
import model.dao.MotoristaDAO;
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
			mensagem += "digite o nome de maneira correta ";
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
				mensagem = "CNH dever conter somente n�meros \n";
			}

			mensagem += "CNH deve conter 11 d�gitos ";


			throw new ErroAoSalvarMotoristaException(mensagem);
		}
		return mensagem;
	}		
	
	public ArrayList<MotoristaVO> consultaCategoria() {
		return dao.consultarCategoria(); 
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
}