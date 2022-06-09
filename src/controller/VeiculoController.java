package controller;


import model.bo.VeiculoBO;

import model.dao.VeiculoDAO;
import model.exception.ErroAoSalvarVeiculoException;
import model.vo.VeiculoVO;


public class VeiculoController {
	
	private static final int QUANTIDADE_DIGITOS_RENAVAM = 9;
	private static final int QUANTIDADE_DIGITOS_PLACA = 7;

	private VeiculoDAO dao = new VeiculoDAO();
	public VeiculoBO bo = new VeiculoBO();
	
	public String salvar(VeiculoVO novo) throws ErroAoSalvarVeiculoException {
		String mensagem = "";
		
		if(novo == null) {
			mensagem = "Informe todos os dados do novo cliente";
		}else if(novo.getRenavam().length() != QUANTIDADE_DIGITOS_RENAVAM && novo.getPlaca().length() != QUANTIDADE_DIGITOS_PLACA){
			try {
				Long.parseLong(novo.getRenavam());
				
			} catch (NumberFormatException excecao) {
				mensagem = "RENAVAM e ANO dever conter somente numeros \n";
			}
			
			mensagem += "RENAVAM deve conter 9 digitos e ANO dever conte 4 digitos";
			
			throw new ErroAoSalvarVeiculoException(mensagem);
		}
		
		if(mensagem.isEmpty()) {
			mensagem = bo.salvar(novo);
		}
		return mensagem;
	}
}