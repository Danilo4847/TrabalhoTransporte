package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import model.vo.MotoristaVO;

public class MotoristaDAO {

	public MotoristaVO inserirMotorista(MotoristaVO motorista) {
		Connection conexao = Banco.getConnection();
		String query ="insert into motorista(nome,CNH,habilitacao) values(?,?,?)";
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
	
	public boolean excluirMotorista() {
		boolean status=false;
		
		
		return status;
	}
	
}
