package controller;

import java.util.ArrayList;

import model.dao.ViagemDAO;
import model.vo.ViagemVO;

public class ViagemController {
	private ViagemDAO dao = new ViagemDAO();


	public ArrayList<ViagemVO>consultaRegional(){
		return dao.consultaRegional();
	}

}
