package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.sql.Timestamp;

import model.seletor.SeletorViagem;
import model.vo.MaterialVO;
import model.vo.MotoristaVO;
import model.vo.VeiculoVO;
import model.vo.ViagemVO;

public class ViagemDAO {

	
	public ViagemVO criarViagem(ViagemVO viagem) {
		Connection conexao = Banco.getConnection();
		String sql = " insert into viagem(idveiculo,idmotorista,idmaterial,regional,dataSaida,dataChegada)values(?,?,?,?,?,?)";
				

		PreparedStatement stmt = Banco.getPreparedStatementWithPk(conexao, sql);

		try {
			
			stmt.setInt(1, viagem.getVeiculo().getIdVeiculo());
			stmt.setInt(2, viagem.getMotorista().getIdMotorista());
			stmt.setInt(3, viagem.getMaterial().getIdmaterial());
			stmt.setString(4, viagem.getRegional());
			stmt.setObject(6, viagem.getDataSaida());
			stmt.setObject(5, viagem.getDataChegada());
	
			stmt.execute();

			ResultSet chavesGeradas = stmt.getGeneratedKeys();
			if(chavesGeradas.next()) {
				viagem.setIdviagem(chavesGeradas.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir viagem. Causa:" + e.getMessage());
		}

		return viagem;
	}
		
/*
	public ViagemVO criarViagem(ViagemVO viagem) {

		Connection conexao = Banco.getConnection();
		String sql="insert into viagem(idveiculo,idmotorista,idmaterial,regional,dataSaida,dataChegada)values(?,?,?,?,?,?)";
		PreparedStatement stmt=Banco.getPreparedStatementWithPk(conexao, sql);


		try {

			stmt.setInt(1, viagem.getVeiculo().getIdVeiculo());
			stmt.setInt(2, viagem.getMotorista().getIdMotorista());
			stmt.setInt(3, viagem.getMaterial().getIdmaterial());
			stmt.setString(4, viagem.getRegional());
			stmt.setObject(5, viagem.getDataSaida());
			stmt.setObject(6, viagem.getDataChegada());

			stmt.execute();

			ResultSet resultado =stmt.getGeneratedKeys();

			if(resultado.next()) {
				viagem.setIdviagem(resultado.getInt(1));
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}





		return viagem;
	}
*/

	public ArrayList<ViagemVO> consultaRegional() {

		ArrayList<ViagemVO> regionais = new ArrayList<ViagemVO>();

		Connection conexao = Banco.getConnection();
		String sql = "SELECT regional FROM  viagem where regional is not null;";

		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);


		try {
			ResultSet resultado = stmt.executeQuery();

			while(resultado.next()) {
				ViagemVO vo = new ViagemVO();

				vo.setRegional(resultado.getString(1));
				regionais.add(vo);
			}


		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return regionais;
	}

	public ArrayList<ViagemVO>consultaSeletor(SeletorViagem seletor){

		ArrayList<ViagemVO> viagens = new ArrayList<ViagemVO>();

		String sql = "select * from viagem inner join motorista on motorista.idmotorista=viagem.idmotorista inner join veiculo on veiculo.idveiculo=viagem.idveiculo";

		Connection conexao = Banco.getConnection();

		if(seletor.temFiltro()) {
			sql=criarFiltro(seletor,sql);
		}
		PreparedStatement stmt =Banco.getPreparedStatement(conexao, sql);
		try{

			ResultSet resultado = stmt.executeQuery();

			while(resultado.next()){
				ViagemVO viagem = new ViagemVO();
				MotoristaVO motoristaVO = new MotoristaVO();
				VeiculoVO veiculo= new VeiculoVO();



				viagem.setRegional(resultado.getString("regional"));
				Timestamp dataSaida=resultado.getTimestamp("dataSaida");
				Timestamp dataChegada=resultado.getTimestamp("dataChegada");

				if(dataSaida != null) {
					viagem.setDataSaida(dataSaida.toLocalDateTime());
				}
				if(dataChegada != null) {
					viagem.setDataChegada(dataChegada.toLocalDateTime());
				}
				motoristaVO.setNome(resultado.getString("nome"));
				viagem.setMotorista(motoristaVO);
				veiculo.setModelo(resultado.getString("modelo"));
				viagem.setVeiculo(veiculo);
				viagens.add(viagem);
			}

		}catch(SQLException excessao){

			JOptionPane.showMessageDialog(null, excessao.getMessage());
		}
		return viagens;


	}



	public String criarFiltro(SeletorViagem seletor, String sql){

		boolean primeiro=true;
		sql=" where ";

		if(seletor.getDataSaida()!=null){
			if(!primeiro){
				sql+=" and ";
			}
			sql+=" dataSaida= '"+seletor.getDataSaida()+"'";
			primeiro=false;

		}
		if(seletor.getDataChegada()!=null){
			if(!primeiro){
				sql+=" and ";
			}
			sql+=" dataChegada=' "+seletor.getDataChegada()+"'";
			primeiro=false;

		}
		if(seletor.getMotorista()!=null && seletor.getMotorista().trim().length()>0){
			if(!primeiro){

				sql+=" and ";
			}
			sql+=" motorista.nome 'like"+seletor.getMotorista()+"like'";
			primeiro=false;
		}
		if(seletor.getVeiculo()!=null && seletor.getVeiculo().trim().length()>0){
			if(!primeiro){
				sql+=" and ";

			}
			sql+=" veiculo.modelo 'like"+seletor.getVeiculo()+"like'";
			primeiro=false;

			if(seletor.getRegional()!=null && seletor.getRegional().trim().length()>0)
				if(!primeiro){
					sql+=" and ";

				}
			sql+=" viagem.regional 'like+"+seletor.getRegional()+"like'";
			primeiro=false;


		}
		return sql;

	}


	public ArrayList<MaterialVO> consultaSetor() {

		ArrayList<MaterialVO> setor = new ArrayList<MaterialVO>();

		Connection conexao = Banco.getConnection();
		String sql = "SELECT setor FROM  material where setor is not null;";

		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);


		try {
			ResultSet resultado = stmt.executeQuery();

			while(resultado.next()) {
				MaterialVO vo = new MaterialVO();

				vo.setSetor(resultado.getString(1));
				setor.add(vo);
			}


		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return setor;
	}
	
	public boolean atualizar(ViagemVO viagem) {
		boolean atualizou = false;
		Connection conexao = Banco.getConnection();
		String sql = " UPDATE VEICULO "
					+" SET  idmaterial=?,idveiculo=?,idmotorista=?,regional=?, dataSaida=?, dataChegada=?"
					+" WHERE idviagem=? ";
		
		PreparedStatement stmt = Banco.getPreparedStatementWithPk(conexao, sql);
		
		try {
			
			stmt.setInt(1, viagem.getVeiculo().getIdVeiculo());
			stmt.setInt(2, viagem.getMotorista().getIdMotorista());
			stmt.setString(3, viagem.getRegional());
			stmt.setInt(4, viagem.getMaterial().getIdmaterial());
			stmt.setObject(5, viagem.getDataChegada());
			stmt.setObject(6, viagem.getDataSaida());

			
			int linhasAfetadas = stmt.executeUpdate();
			atualizou = linhasAfetadas > 0;
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar viagem. Causa:" + e.getMessage());
		}
		
		return atualizou;
	}
	public ArrayList<MaterialVO> consultaMaterial() {

		ArrayList<MaterialVO> materiais = new ArrayList<MaterialVO>();

		Connection conexao = Banco.getConnection();
		String sql = "SELECT idmaterial,conteudo,quantidade,setor FROM material ;";

		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);


		try {
			ResultSet resultado = stmt.executeQuery();

			while(resultado.next()) {
				MaterialVO vo = new MaterialVO();

				vo.setIdmaterial(resultado.getInt(1));
				vo.setConteudo(resultado.getString(2));
				vo.setQuantidade(resultado.getInt(3));
				vo.setSetor(resultado.getString(4));
				materiais.add(vo);
			}


		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return materiais;
	}

	public ArrayList<ViagemVO>consultaGeral(){

		ArrayList<ViagemVO> viagens = new ArrayList<ViagemVO>();

		String sql = "select * from viagem inner join motorista on motorista.idmotorista=viagem.idmotorista inner join veiculo on veiculo.idveiculo=viagem.idveiculo";

		Connection conexao = Banco.getConnection();

	
		PreparedStatement stmt =Banco.getPreparedStatement(conexao, sql);
		try{

			ResultSet resultado = stmt.executeQuery();

			while(resultado.next()){
				ViagemVO viagem = new ViagemVO();
				MotoristaVO motoristaVO = new MotoristaVO();
				VeiculoVO veiculo= new VeiculoVO();



				viagem.setRegional(resultado.getString("regional"));
				Timestamp dataSaida=resultado.getTimestamp("dataSaida");
				Timestamp dataChegada=resultado.getTimestamp("dataChegada");

				if(dataSaida != null) {
					viagem.setDataSaida(dataSaida.toLocalDateTime());
				}
				if(dataChegada != null) {
					viagem.setDataChegada(dataChegada.toLocalDateTime());
				}
				motoristaVO.setNome(resultado.getString("nome"));
				viagem.setMotorista(motoristaVO);
				veiculo.setModelo(resultado.getString("modelo"));
				viagem.setVeiculo(veiculo);
				viagens.add(viagem);
			}

		}catch(SQLException excessao){

			JOptionPane.showMessageDialog(null, excessao.getMessage());
		}
		return viagens;


	}



}
