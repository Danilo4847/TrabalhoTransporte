package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.seletor.SeletorMotorista;
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
	
	
	public ArrayList<MotoristaVO> consultarCategoria() {
		
	
		
		ArrayList<MotoristaVO> categorias = new ArrayList<MotoristaVO>();
		
		Connection conexao = Banco.getConnection();
		String sql = "SELECT distinct  categoria_carteira FROM  motorista  where categoria_carteira is not null;";
					
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		
		
		try {
			ResultSet resultado = stmt.executeQuery();
			
			while(resultado.next()) {
				MotoristaVO vo = new MotoristaVO();
				
				vo.setCategoriaCarteira(resultado.getString(1));
				categorias.add(vo);
			}

		
		} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return categorias;
	}
	
	public ArrayList<MotoristaVO> consultaSeletor(SeletorMotorista seletor){
		Connection conexao = Banco.getConnection();
		String query=" select*from motorista m ";
		PreparedStatement stmt =Banco.getPreparedStatement(conexao, query);
		ArrayList<MotoristaVO> motoristas= new ArrayList<MotoristaVO>();
		
		if(seletor.filtro()) {
			query=cirarFiltros(query,seletor);
		}
		
		try {
			
			ResultSet resultado = stmt.executeQuery();
			
			while(resultado.next()) {
				MotoristaVO m = new MotoristaVO();
				
				m.setCategoriaCarteira(resultado.getString(1));
				m.setCnh(resultado.getString(2));
				m.setNome(resultado.getString(3));
				m.setStatus(resultado.getBoolean(4));
				m.setIdMotorista(resultado.getInt(5));
				
				motoristas.add(m);
			}
			
		} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Erro na consulta de motorista "+ e.getMessage());
		}
		
		return motoristas;
	}

	private String cirarFiltros(String query, SeletorMotorista seletor) {
		
		query+=" where ";
		boolean primeiro=true;
		
		if((seletor.getCategoriaCarteira() != null)&&(seletor.getCategoriaCarteira().trim().length()>0)){
			if(!primeiro) {
				query+=" and ";
			}
			query+=" m.categoria_carteira like '%"+seletor.getCategoriaCarteira()+"%'";
			primeiro=false;
		}
		if((seletor.getCNH() !=null)&&(seletor.getCNH().trim().length()>0)) {
			if(!primeiro) {
				query+=" and ";
			}
			query+=" m.cnh like'%"+seletor.getCNH()+"%'";
			primeiro=false;
		}
		if((seletor.getNome() !=null)&&(seletor.getNome().trim().length()>0)) {
			if(!primeiro) {
				query+=" and ";
			}
			query+=" m.nome like'%"+seletor.getNome()+"%'";
			primeiro=false;
		}
		
		
		return query;
	}
	
	
}