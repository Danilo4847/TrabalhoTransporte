package controller;


import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.bo.VeiculoBO;

import model.dao.VeiculoDAO;
import model.dao.ViagemDAO;
import model.exception.ErroAoSalvarVeiculoException;
import model.seletor.SeletorVeiculo;
import model.vo.VeiculoVO;


public class VeiculoController {

	private static final int QUANTIDADE_DIGITOS_RENAVAM = 9;
	private static final int QUANTIDADE_DIGITOS_PLACA = 7;
	private static final int QUANTIDADE_DIGITOS_modelo = 50;


	private VeiculoDAO dao = new VeiculoDAO();
	public VeiculoBO bo = new VeiculoBO();

	public String salvar(VeiculoVO novo) throws ErroAoSalvarVeiculoException {
		String mensagem = "";

		if(novo == null) {
			mensagem = "Informe todos os dados do novo veiculo";
		}else { 
			mensagem = validarModelo(novo);
			mensagem = validarMarca(novo);
			mensagem = validarPlaca(novo);
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
		if(novo.getModelo().trim() != null && novo.getModelo().length()>0 && novo.getModelo().length()<=QUANTIDADE_DIGITOS_modelo){

		}else {
			mensagem += "Informe um modelo de carro ";
			throw new ErroAoSalvarVeiculoException(mensagem);
		}
		return mensagem;
	}


	private String validarMarca(VeiculoVO novo) throws ErroAoSalvarVeiculoException {
		String mensagem="";
		if(novo.getMarca().trim() != null && novo.getMarca().length()>0&& novo.getMarca().length()<=QUANTIDADE_DIGITOS_modelo){

		}else {
			mensagem += "";
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
			ano++;
			mensagem += "informe um ano entre 1884 até "+ano;
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
				mensagem = "RENAVAM dever conter somente números -   \n";
			}

			mensagem += " RENAVAM deve conter 9 dígitos ";


			throw new ErroAoSalvarVeiculoException(mensagem);
		}
		return mensagem;
	}
	private String validarPlaca(VeiculoVO novo) throws ErroAoSalvarVeiculoException {
		String mensagem = "";
		if(novo.getPlaca().trim().isEmpty()&& novo.getPlaca().trim().length() != QUANTIDADE_DIGITOS_PLACA && novo.getPlaca()!=null) {
			mensagem +=("Informe uma placa valida com 7 digitos - ");

			Pattern validaçãoplaca = Pattern.compile("^[A-Z]{3}[0-9]{4}");
			Matcher placaquasepronta = validaçãoplaca.matcher(novo.getPlaca());

			if (!placaquasepronta.matches()) {
				mensagem +=("favor informar a placa de maneira correta:  3 letras - 4 numeros ");
				
				throw new ErroAoSalvarVeiculoException(mensagem);
			}
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
	
	public String excluirVeiculo(int id){

		String mensagem="";
		ViagemDAO viagem = new ViagemDAO();
		VeiculoDAO veiculo = new VeiculoDAO();
/*
		viagem.consultaPorIdVeiculo(id);

		if(viagem!=null){

		mensagem="Não é permitido excluir veiculo que ja efetuou uma viagem";
		}else{
		
		}
		*/
		veiculo.removerVeiculo(id);
		return mensagem;	
		}

}