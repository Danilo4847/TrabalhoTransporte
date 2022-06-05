package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.vo.VeiculoVO;

public class VeiculoDAO {

	
	public VeiculoVO inserirVeiculo(VeiculoVO veiculo) {
		Connection conexao = Banco.getConnection();
		String query="";
		PreparedStatement stmtPreparedStatement=Banco.getPreparedStatementWithPk(conexao, query);
		
		try {
			
			stmtPreparedStatement.setString(1,veiculo.getMarca());
			stmtPreparedStatement.setString(2, veiculo.getModelo());
			stmtPreparedStatement.setString(3, veiculo.getPlaca());
			stmtPreparedStatement.setInt(4, veiculo.getAno());
			stmtPreparedStatement.setInt(5,veiculo.getRenavam());
			stmtPreparedStatement.setBoolean(6,veiculo.isStatus());
			
			
			stmtPreparedStatement.execute();
			
			ResultSet resultado =stmtPreparedStatement.getGeneratedKeys();
			if(resultado.next()) {
				veiculo.setIdVeiculo(resultado.getInt(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return veiculo;
	}
	
	public boolean excluirVeiculo() {
		boolean status=false;
		
		
		return status;
	}
	
}
