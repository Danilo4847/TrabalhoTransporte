package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import model.vo.ViagemVO;

public class ViagemDAO {


	public ViagemVO criarViagem(ViagemVO viagem) {

		return viagem;
	}
	public ArrayList<ViagemVO> consultarRegional() {
		Connection conexao= Banco.getConnection();
		String query="select distinct regional from viagem";
		PreparedStatement stmt=Banco.getPreparedStatement(conexao, query);


		try {

		} catch (Exception e) {
			System.out.println("Não foi possivel executar a query de consulta de regional "+e.getMessage());
		}

		return null;

	}


}
