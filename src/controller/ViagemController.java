package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.bo.ViagemBO;
import model.dao.ViagemDAO;
import model.exception.ErroAoSalvarViagemException;
import model.seletor.SeletorViagem;
import model.vo.MaterialVO;
import model.vo.ViagemVO;

public class ViagemController {
	private ViagemDAO dao = new ViagemDAO();
	private ViagemBO bo= new ViagemBO();
	
	
	private static final int QUANTIDADE_DIGITOS_CONTEUDO = 50;
	private static final int QUANTIDADE_DIGITOS_Setor = 80;



	private String validarConteudo(MaterialVO novo) throws ErroAoSalvarViagemException {
	        String mensagem="";
	        if(novo.getConteudo().trim() != null && novo.getConteudo().length()>0&& novo.getConteudo().length()<=QUANTIDADE_DIGITOS_CONTEUDO){

	        }else {
	            mensagem += "erro campo conteudo preencha ele de forma valida esse campo estar limitado a 50 caracteres";
	            throw new ErroAoSalvarViagemException(mensagem);
	        }
	        return mensagem;
	    }

	private String validarSetor(MaterialVO novo) throws ErroAoSalvarViagemException {
	        String mensagem="";
	        if(novo.getSetor().trim() != null && novo.getSetor().length()>0 && novo.getSetor().length()<=QUANTIDADE_DIGITOS_CONTEUDO){

	        }else {
	            mensagem += "erro campo Setor preencha ele de forma valida esse campo estar limitado a 80 caracteres";
	            throw new ErroAoSalvarViagemException(mensagem);
	        }
	        return mensagem;
	    }
	

	public String salvar(ViagemVO novo) throws ErroAoSalvarViagemException {
		String mensagem = "";

		if(novo == null) {
			mensagem += "Informe todos os dados da viagem";
		}else { 
		//	mensagem = validarMaterial(novo);
		mensagem = validarData(novo);
		//	mensagem = validarQuantidade(novo);
		mensagem=validar(novo);
			
			}
		if(mensagem.isEmpty()) {
			mensagem = bo.salvar(novo);
			JOptionPane.showMessageDialog(null, mensagem);
		}

		return mensagem;
	}
	
	private String validar(ViagemVO novo) {
		String mensagem="";
		if(novo.getMaterial()!=null) {
			
		}else {
			mensagem+=" Preencha os campos de Material e clika no +";
		}
		
		return mensagem;
	}

	private String validarData(ViagemVO novo) throws ErroAoSalvarViagemException {
		String mensagem="";
		if(novo.getDataSaida()!=null) {
			
		}else {
			mensagem += "Informe uma data de saida";
         //   throw new ErroAoSalvarViagemException(mensagem);
		}
		
		return mensagem;
	}
/*
	private String validarMaterial(ViagemVO novo) throws ErroAoSalvarViagemException {
		String mensagem="";
		if(novo.getMaterial().getConteudo()!=null && novo.getMaterial().getConteudo().trim()!=null) {
			
		}else {
			mensagem += "Preencha todos os campos de material ";
       
		}
	return mensagem;
	}
	private String validarQuantidade(ViagemVO novo) {
        String mensagem="";

        if(novo.getMaterial().getQuantidade()>0) {

        }else{
            mensagem+=" O meu querido(a) poderia gentilmente informa um numero numerico e prencher o campo :)";
        }

        return mensagem;
    }
*/
	
	
	public ArrayList<ViagemVO>consultaRegional(){
		return dao.consultaRegional();
	}
	public ArrayList<MaterialVO>setor() {
		return dao.consultaSetor();
	}

	public ArrayList<ViagemVO> consulta(SeletorViagem seletor) {
		return dao.consultaSeletor(seletor);
	}
	public ArrayList<MaterialVO>consultaMaterial(){
		return dao.consultaMaterial();
	}
	public ArrayList<ViagemVO>consultageral(){
		return dao.consultaGeral();
	}
	public boolean excluirViagem(int id) {
		return dao.removerViagem(id);
	
	}
	public boolean atualizar(ViagemVO novo) {
		return dao.atualizar(novo);
	}
public ViagemVO consultaUnitaria(int id) {
	return dao.consultaViagem(id);
}
public MaterialVO criarMaterial(MaterialVO matrial) {
	return dao.criarmaterial(matrial);
}
}
	
