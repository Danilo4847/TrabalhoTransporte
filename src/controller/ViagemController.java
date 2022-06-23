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
	

	public String salvar(ViagemVO novo) throws ErroAoSalvarViagemException {
		String mensagem = "";

		if(novo == null) {
			mensagem = "Informe todos os dados da viagem";
		}else { 
			mensagem = validarMaterial(novo);
			
		
			
			}
		if(mensagem.isEmpty()) {
			mensagem = bo.salvar(novo);
			JOptionPane.showMessageDialog(null, mensagem);
		}

		return mensagem;
	}
	
	private String validarMaterial(ViagemVO novo) throws ErroAoSalvarViagemException {
		String mensagem="";
		if(novo.getMaterial().getConteudo()!=null && novo.getMaterial().getConteudo().trim()!=null) {
			
		}else {
			mensagem += "digite o nome de maneira correta ";
            throw new ErroAoSalvarViagemException(mensagem);
		}
		


	return mensagem;
	}


	
	
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
	

}
	
