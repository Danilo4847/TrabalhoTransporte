package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.cj.PerConnectionLRUFactory;

import model.seletor.SeletorVeiculo;
import model.vo.MotoristaVO;
import model.vo.VeiculoVO;

public class VeiculoDAO {


	public VeiculoVO salvarVeiculo(VeiculoVO novo) {
		Connection conexao = Banco.getConnection();
		String query=" INSERT INTO VEICULO(MARCA, MODELO, PLACA, ANO, RENAVAM)"
				+ "VALUES (?, ?, ?, ?, ?);";
		PreparedStatement stmtPreparedStatement=Banco.getPreparedStatementWithPk(conexao, query);

		try {

			stmtPreparedStatement.setString(1,novo.getMarca());
			stmtPreparedStatement.setString(2, novo.getModelo());
			stmtPreparedStatement.setString(3, novo.getPlaca());
			stmtPreparedStatement.setInt(4, novo.getAno());
			stmtPreparedStatement.setString(5,novo.getRenavam());

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
				+" WHERE IDveiculo=?";
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
		String sql = " select idveiculo from VEICULO v " + 
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

	public ArrayList<VeiculoVO> consulta(SeletorVeiculo selecionado){
		Connection conexao = Banco.getConnection();
		String query="SELECT *FROM VEICULO v";

		ArrayList<VeiculoVO> veiculos = new  ArrayList<VeiculoVO>();

		if(selecionado.filtroVeiculo()) {
			query=criarFiltros(selecionado,query);
		}
		PreparedStatement stmt=Banco.getPreparedStatement(conexao, query);

		try {
			ResultSet resultado=stmt.executeQuery();
			while(resultado.next()) {
				VeiculoVO vo = new VeiculoVO();
				vo.setAno(resultado.getInt("ano"));
				vo.setMarca(resultado.getString("marca"));
				vo.setModelo(resultado.getString("modelo"));
				vo.setPlaca(resultado.getString("placa"));
				vo.setRenavam(resultado.getString("renavam"));
				vo.setIdVeiculo(resultado.getInt("idveiculo"));

				veiculos.add(vo);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"N�o foi possivel executar a query de consulta veiculo "+ e.getMessage());
		}

		return veiculos;

	}
	private String criarFiltros(SeletorVeiculo selecionado, String query) {

		query+=" where ";
		boolean primeiro = true;

		if((selecionado.getMarca()!=null)&&(selecionado.getMarca().trim().length()>0)){
			if(!primeiro) {
				query+=" and ";
			}
			query+=" v.marca like'%"+selecionado.getMarca()+"%'";
			primeiro=false;
		}
		if((selecionado.getPlaca()!=null)&&(selecionado.getPlaca().trim().length()>0)) {
			if(!primeiro) {
				query+=" and ";
			}
			query+=" v.placa like'%"+selecionado.getPlaca()+"%' ";
			primeiro=false;
		}
		if((selecionado.getRenavam()!=null)&&(selecionado.getRenavam().trim().length()>0)) {
			if(!primeiro) {
				query+=" and ";
			}
			query+=" v.renavam = '"+selecionado.getRenavam()+"' ";
			primeiro=false;
		}



		return query;
	}


	public ArrayList<VeiculoVO> consultarModeloVeiculo() {

		ArrayList<VeiculoVO> veiculos = new ArrayList<VeiculoVO>();

		Connection conexao = Banco.getConnection();
		String sql = "SELECT modelo, marca, idveiculo, ano, placa, renavam FROM veiculo where modelo is not null;";

		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);

		try {
			ResultSet resultado = stmt.executeQuery();

			while(resultado.next()) {
				VeiculoVO vo = new VeiculoVO();

				vo.setModelo(resultado.getString(1));
				vo.setMarca(resultado.getString(2));
				vo.setIdVeiculo(resultado.getInt(3));
				vo.setAno(resultado.getInt(4));
				vo.setPlaca(resultado.getString(5));
				vo.setRenavam(resultado.getString(6));
				
				veiculos.add(vo);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return veiculos;
	}

	public VeiculoVO consultaVeiculo(String modelo) {

		VeiculoVO veiculo = new VeiculoVO();

		Connection conexao = Banco.getConnection();
		String sql = "SELECT * FROM  veiculo where modelo =	'"+modelo+"'";

		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);


		try {
			ResultSet resultado = stmt.executeQuery();

			veiculo.setAno(resultado.getInt(1));
			veiculo.setIdVeiculo(resultado.getInt(2));
			veiculo.setMarca(resultado.getString(3));
			veiculo.setModelo(resultado.getString(4));
			veiculo.setPlaca(resultado.getString(5));
			veiculo.setRenavam(resultado.getString(6)); 
			veiculo.setStatus(resultado.getBoolean(7));


		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return veiculo;
	}

	public VeiculoVO consulta(int id) {

		VeiculoVO veiculo = new VeiculoVO();

		Connection conexao = Banco.getConnection();
		String sql = "SELECT * FROM  veiculo where idveiculo=	'"+id+"'";

		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);


		try {
			ResultSet resultado = stmt.executeQuery();

			veiculo.setAno(resultado.getInt(1));
			veiculo.setIdVeiculo(resultado.getInt(2));
			veiculo.setMarca(resultado.getString(3));
			veiculo.setModelo(resultado.getString(4));
			veiculo.setPlaca(resultado.getString(5));
			veiculo.setRenavam(resultado.getString(6)); 
			veiculo.setStatus(resultado.getBoolean(7));


		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return veiculo;
	}


}