package controller;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.bo.VeiculoBO;

import model.dao.VeiculoDAO;
import model.exception.ErroAoSalvarVeiculoException;
import model.seletor.SeletorVeiculo;
import model.vo.VeiculoVO;


public class VeiculoController {

	private static final int QUANTIDADE_DIGITOS_RENAVAM = 9;
	private static final int QUANTIDADE_DIGITOS_PLACA = 7;

	private VeiculoDAO dao = new VeiculoDAO();
	public VeiculoBO bo = new VeiculoBO();

	public String salvar(VeiculoVO novo) throws ErroAoSalvarVeiculoException {
		String mensagem = "";

		Calendar cal = Calendar.getInstance();
		int ano = cal.get(Calendar.YEAR);

		if(novo == null) {
			mensagem = "Informe todos os dados do novo cliente";
		}else { 
			mensagem = validarRenavam(novo);
			mensagem = validarAno(novo);
			mensagem = validarRenavam(novo);
			
		}

		return mensagem;
	}




	private String validarAno(VeiculoVO novo) {


		return null;
	}




	private String validarRenavam(VeiculoVO novo) throws ErroAoSalvarVeiculoException {
		String mensagem = "";
		if(novo.getRenavam()!=null && novo.getRenavam().length() != QUANTIDADE_DIGITOS_RENAVAM ){
			try {
				Long.parseLong(novo.getRenavam());
			} catch (NumberFormatException excecao) {
				mensagem = "RENAVAM e ANO dever conter somente números \n";
			}

			mensagem += "RENAVAM deve conter 9 dígitos ";


			throw new ErroAoSalvarVeiculoException(mensagem);
		}
		return mensagem;
	}




	public ArrayList<VeiculoVO>consulta(SeletorVeiculo selecionado){
		return dao.consulta(selecionado);
	}

	public ArrayList<VeiculoVO> consultaModelo(){
		return dao.consultarModeloVeiculo();
	}

}