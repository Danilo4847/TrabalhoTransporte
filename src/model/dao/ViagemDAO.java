package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.seletor.SeletorViagem;
import model.vo.MaterialVO;
import model.vo.MotoristaVO;
import model.vo.VeiculoVO;
import model.vo.ViagemVO;

public class ViagemDAO {


	public ViagemVO criarViagem(ViagemVO viagem) {

		Connection conexao = Banco.getConnection();
		String sql="insert into viagem(idveiculo,idmotorista,idmaterial,regional,dataSaida,dataChegada)values(?,?,?,?,?,?)";
		PreparedStatement stmt=Banco.getPreparedStatementWithPk(conexao, sql);


		try {

			stmt.setInt(1, viagem.getVeiculo().getIdVeiculo());
			stmt.setInt(2, viagem.getMotorista().getIdMotorista());
			stmt.setInt(3, viagem.getMaterial().getIdmaterial());
			stmt.setString(4, viagem.getRegional());
			stmt.setInt(5, viagem.getDataSaida());
			stmt.setInt(6, viagem.getDataChegada());

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

	public ArrayList<ViagemVO>consulta(SeletorViagem selecionado){
		ArrayList<ViagemVO>viagens= new ArrayList<ViagemVO>();
		String sql="select*from v";

		Connection conexao= Banco.getConnection();


		if (selecionado.temFiltro()) {
			sql=filtro(selecionado,sql);
		}
		PreparedStatement stmt=Banco.getPreparedStatement(conexao, sql);

		try {
			ResultSet resultado=stmt.executeQuery();
			while(resultado.next()) {
				ViagemVO vo = new ViagemVO();
				vo.setDataChegada(resultado.getInt(1));
				vo.setDataSaida(resultado.getInt(2));
				//	vo.setConteudo(resultado.getString(3));
				//vo.setSetor(resultado.getString(4));
				//	vo.setQuantidade(resultado.getInt(5));

				viagens.add(vo);
			}


		} catch (Exception e) {

		}

		return viagens;


	}


	private String filtro(SeletorViagem selecionado, String sql) {

		sql+=" where ";
		boolean primeiro =false;

		if(selecionado.getDataChegada()!=null) {
			if(!primeiro) {
				sql+=" and ";
			}
			sql+=" v.dataChegada= '"+selecionado.getDataChegada()+"'";
			primeiro=false;
		}
		if(selecionado.getDataSaida()!=null) {
			if(!primeiro) {
				sql+=" and ";
			}
			sql+=" v.dataSaida= '"+selecionado.getDataSaida()+"'";
			primeiro=false;
		}
		if((selecionado.getMotorista()!=null)&&(selecionado.getMotorista().trim().length()>0)) {
			if(!primeiro) {
				sql+=" and ";
			}
			sql+=" v.moto ";
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

}
