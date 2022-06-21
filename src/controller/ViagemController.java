package controller;

import java.util.ArrayList;

import model.dao.ViagemDAO;
import model.vo.MaterialVO;
import model.vo.ViagemVO;

public class ViagemController {
	private ViagemDAO dao = new ViagemDAO();


	public ArrayList<ViagemVO>consultaRegional(){
		return dao.consultaRegional();
	}
	public ArrayList<MaterialVO>setor() {
		return dao.consultaSetor();
	}
	public ViagemVO salvar(ViagemVO viagem){
return dao.criarViagem(viagem);
	}
}
