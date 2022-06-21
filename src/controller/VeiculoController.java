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

		if(novo == null) {
			mensagem = "Informe todos os dados do novo veiculo";
		}else { 
			mensagem = validarModelo(novo);
			mensagem = validarMarca(novo);
			//	mensagem = validarPlaca(novo);
			mensagem = validarRenavam(novo);
			mensagem = validarAno(novo);

			if(mensagem.isEmpty()) {
				mensagem = bo.salvar(novo);
			}
		}

		return mensagem;
	}





	private String validarModelo(VeiculoVO novo) throws ErroAoSalvarVeiculoException {
		String mensagem="";
		if(novo.getModelo().trim() != null && novo.getModelo().length()>0){

		}else {
			mensagem += "digite o modelo certo ";
			throw new ErroAoSalvarVeiculoException(mensagem);
		}
		return mensagem;
	}


	private String validarMarca(VeiculoVO novo) throws ErroAoSalvarVeiculoException {
		String mensagem="";
		if(novo.getMarca().trim() != null && novo.getMarca().length()>0){

		}else {
			mensagem += "digite a marca certo ";
			throw new ErroAoSalvarVeiculoException(mensagem);
		}
		return mensagem;
	}


	private String validarAno(VeiculoVO novo) throws ErroAoSalvarVeiculoException {
        String mensagem = "";
        Calendar cal = Calendar.getInstance();
        int ano = cal.get(Calendar.YEAR);

        if((novo.getAno()>=1884) && (novo.getAno()<= ano+1)){
            mensagem="";
        }else{ 
            mensagem += "informe o ano certo ";
            throw new ErroAoSalvarVeiculoException(mensagem);
        }
        return mensagem;
    }


	private String validarRenavam(VeiculoVO novo) throws ErroAoSalvarVeiculoException {
		String mensagem = "";
		if(novo.getRenavam()!=null && novo.getRenavam().length() != QUANTIDADE_DIGITOS_RENAVAM ){
			try {
				Long.parseLong(novo.getRenavam());
			} catch (NumberFormatException excecao) {
				mensagem = "RENAVAM e ANO dever conter somente n�meros \n";
			}

			mensagem += "RENAVAM deve conter 9 d�gitos ";


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
	public VeiculoVO veicuo(String modelo) {
		return dao.consultaVeiculo(modelo);	
	}
	public VeiculoVO veiculo(int id) {
		return dao.consulta(id);	
	}

}