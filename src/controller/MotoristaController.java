package controller;

import model.bo.MotoristaBO;
import model.dao.MotoristaDAO;
import model.exception.ErroAoSalvarMotoristaException;
import model.vo.MotoristaVO;



public class MotoristaController {

	private static final int QUANTIDADE_DIGITOS_CNH = 11;
	private MotoristaDAO dao = new MotoristaDAO();
	public MotoristaBO bo = new MotoristaBO();
	
	public String salvar(MotoristaVO novo) throws ErroAoSalvarMotoristaException {
		String mensagem = "";
		
		if(novo == null) {
			
			mensagem = "Informe todos os dados do novo cliente";
			
		}else if(novo.getCnh().length() != QUANTIDADE_DIGITOS_CNH ){
			try {
				Long.parseLong(novo.getCnh());
			} catch (NumberFormatException excecao) {
				mensagem = "CNH dever conter somente numeros \n";
			}
			
			mensagem += "CNH deve conter 11 digitos";
			
			throw new ErroAoSalvarMotoristaException(mensagem);
		}
		
		if(mensagem.isEmpty()) {
			mensagem = bo.salvar(novo);
		}
		
		return mensagem;
	}
	
	
}
