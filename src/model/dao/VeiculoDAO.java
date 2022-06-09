package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.vo.VeiculoVO;

public class VeiculoDAO {

	
	public VeiculoVO salvarVeiculo(VeiculoVO novo) {
		Connection conexao = Banco.getConnection();
		String query=" INSERT INTO VEICULO(MARCA, MODELO, PLACA, ANO, RENAVAM)"
				+ "VALUES (?, ?, ?, ?, ?);";
		PreparedStatement stmtPreparedStatement=Banco.getPreparedStatementWithPk(conexao, query);
		
		try {
			
			stmtPreparedStatement.setString(2,novo.getMarca());
			stmtPreparedStatement.setString(3, novo.getModelo());
			stmtPreparedStatement.setString(4, novo.getPlaca());
			stmtPreparedStatement.setInt(5, novo.getAno());
			stmtPreparedStatement.setString(6,novo.getRenavam());
			
			stmtPreparedStatement.execute();
			
			ResultSet resultado =stmtPreparedStatement.getGeneratedKeys();
			if(resultado.next()) {
				novo.setIdVeiculo(resultado.getInt(1));
			}
		} catch (Exception e) {
			System.out.println("Erro ao inserir veiculo. Causa:" + e.getMessage());
		}
		return novo;
	}
	public boolean atualizar(VeiculoVO veiculo) {
		boolean atualizou = false;
		Connection conexao = Banco.getConnection();
		String sql = " UPDATE VEICULO "
					+" SET MARCA=?, MODELO=?, PLACA=?, ANO=?, RENAVAM=? "
					+" WHERE IDVEICULO=? ";
		
		PreparedStatement stmt = Banco.getPreparedStatementWithPk(conexao, sql);
		
		try {
			stmt.setInt(1, veiculo.getIdVeiculo());
			stmt.setString(2, veiculo.getMarca());
			stmt.setString(3, veiculo.getModelo());
			stmt.setString(4, veiculo.getPlaca());
			stmt.setInt(5, veiculo.getAno());
			stmt.setString(6, veiculo.getRenavam());
			int linhasAfetadas = stmt.executeUpdate();
			atualizou = linhasAfetadas > 0;
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar veiculo. Causa:" + e.getMessage());
		}
		
		return atualizou;
	}
	
	public boolean removerVeiculo(int id) {
		boolean removeu = false;
		
		Connection conexao = Banco.getConnection();
		String sql = " DELETE FROM VEICULO "
					+" WHERE ID=?";
		PreparedStatement stmt = Banco.getPreparedStatementWithPk(conexao, sql);
		
		try {
			stmt.setInt(1, id);
			removeu = stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.println("Erro ao remover veiculo. Causa:" + e.getMessage());
		}		
		
		return removeu;
	}
	public VeiculoVO consultar(int id) {
		VeiculoVO clienteConsultado = null;
		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM VEICULO "
					+" WHERE IDVEICULO=?";
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		
		try {
			stmt.setInt(1, id);
			ResultSet resultado = stmt.executeQuery();
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		return clienteConsultado;
	}
	
	public boolean renavamJaUtilizado(String renavam) {
		Connection conexao = Banco.getConnection();
		String sql = " select id from VEICULO v " + 
				"where v.renavam = '" + renavam + "'";
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		boolean renavamUsado = false;
		
		try {
			ResultSet resultado = stmt.executeQuery();
			renavamUsado = resultado.next();
		} catch (SQLException e) {
			System.out.println("Erro ao verificar se RENAVAM já foi usado. Causa: " + e.getMessage());
		}
		
		return renavamUsado;
	}
	public boolean placaJaUtilizada(String placa) {
		Connection conexao = Banco.getConnection();
		String sql = " select id from VEICULO v " + 
				"where v.placa = '" + placa + "'";
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		boolean placaUsada = false;
		
		try {
			ResultSet resultado = stmt.executeQuery();
			placaUsada = resultado.next();
		} catch (SQLException e) {
			System.out.println("Erro ao verificar se PLACA já foi usado. Causa: " + e.getMessage());
		}
		
		return placaUsada;
	}
}