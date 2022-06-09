package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.vo.MotoristaVO;
import model.vo.VeiculoVO;

public class MotoristaDAO {

	public MotoristaVO inserirMotorista(MotoristaVO motorista) {
		Connection conexao = Banco.getConnection();
		String query ="insert into motorista(nome,CNH,categoria_carteira) values(?,?,?)";
		PreparedStatement stmt=Banco.getPreparedStatementWithPk(conexao, query);
		
		try {
			stmt.setString(1, motorista.getNome());
			stmt.setString(2, motorista.getCnh());
			stmt.setString(3, motorista.getCategoriaCarteira());
	
			
			stmt.execute();
			
			ResultSet resultado=stmt.getGeneratedKeys();
			if(resultado.next()) {
				motorista.setIdMotorista(resultado.getInt(1));
			}
		} catch (Exception e) {
			JOptionPane.showInternalMessageDialog(null, e.getMessage());
		}
		return motorista;
	}
	
	public boolean atualizar(MotoristaVO motorista) {
		boolean atualizou = false;
		Connection conexao = Banco.getConnection();
		String sql = " UPDATE MOTORISTA "
					+" SET NOME=?, CNH=?, categoria_carteira=?"
					+" WHERE IDMOTORISTA=? ";
		
		PreparedStatement stmt = Banco.getPreparedStatementWithPk(conexao, sql);
		
		try {
			stmt.setInt(1, motorista.getIdMotorista());
			stmt.setString(2, motorista.getNome());
			stmt.setString(3, motorista.getCnh());
			stmt.setString(4, motorista.getCategoriaCarteira());
			int linhasAfetadas = stmt.executeUpdate();
			atualizou = linhasAfetadas > 0;
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar motorista. Causa:" + e.getMessage());
		}
		
		return atualizou;
	}
	public boolean excluirMotorista(int idMotorista) {
		boolean excluir =false;
		
		Connection conexao = Banco.getConnection();
		String sql = " DELETE FROM MOTORISTA "
					+" WHERE IDMOTORISTA=?";
		PreparedStatement stmt = Banco.getPreparedStatementWithPk(conexao, sql);
		
		try {
			stmt.setInt(1, idMotorista);
			excluir = stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.println("Erro ao remover motorista. Causa:" + e.getMessage());
		}		
		
		return excluir;
	}
	public boolean cnhJaUtilizado(String cnh) {
		Connection conexao = Banco.getConnection();
		
		String sql = " select idmotorista from MOTORISTA M " + 
				"where M.CNH = '" + cnh + "'";
		
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		boolean CNHusado = false;
		
		try {
			ResultSet rs = stmt.executeQuery();
			CNHusado = rs.next();
		} catch (SQLException e) {
			System.out.println("Erro a CNH j√ utilizada° foi usado. Causa: " + e.getMessage());
		}
		
		return CNHusado;
	}
	
	
}
