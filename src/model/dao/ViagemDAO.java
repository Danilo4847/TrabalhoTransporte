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
		String sql = " insert into viagem(idveiculo,idmotorista,regional,dataSaida,dataChegada)values(?,?,?,?,?)";


		PreparedStatement stmt = Banco.getPreparedStatementWithPk(conexao, sql);

		try {

			stmt.setInt(1, viagem.getVeiculo().getIdVeiculo());
			stmt.setInt(2, viagem.getMotorista().getIdMotorista());
			stmt.setString(3, viagem.getRegional());
			stmt.setObject(4, viagem.getDataSaida());
			stmt.setObject(5, viagem.getDataChegada());

			stmt.execute();

			ResultSet chavesGeradas = stmt.getGeneratedKeys();
			if(chavesGeradas.next()) {
				int id=chavesGeradas.getInt(1);
				
				
				viagem.setIdviagem(id);
				
				
				if(!viagem.getMaterial().isEmpty()) {
					ViagemDAO dao = new ViagemDAO();
					dao.criarMaterial(viagem,viagem.getMaterial());
				}
				
				
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

	private void criarMaterial(ViagemVO viagem, ArrayList<MaterialVO> material) {
	
		for(MaterialVO m :material){
		m.setIdViagem(viagem.getIdviagem());
		criarmaterial(m);
		}
	
		
		
		
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

	public ArrayList<ViagemVO>consultaSeletor(SeletorViagem seletor){

		ArrayList<ViagemVO> viagens = new ArrayList<ViagemVO>();

		String sql = "select * from viagem inner join motorista on motorista.idmotorista=viagem.idmotorista"
				+ " inner join veiculo on veiculo.idveiculo=viagem.idveiculo inner join material on material.idmaterial=viagem.idmaterial";

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
				MaterialVO material = new MaterialVO();


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
			
				viagem.setIdviagem(resultado.getInt("idviagem"));
				viagens.add(viagem);
			}

		}catch(SQLException excessao){

			JOptionPane.showMessageDialog(null," erro na consulta de viagem"+ excessao.getMessage());
		}
		return viagens;


	}



	public String criarFiltro(SeletorViagem seletor, String sql){

		boolean primeiro=true;
		sql+=" where ";

		if(seletor.getDataSaida()!=null){
			if(!primeiro){
				sql+=" and ";
			}
			sql+=" viagem.dataSaida ='"+seletor.getDataSaida()+"'";
			primeiro=false;

		}
		if(seletor.getDataChegada()!=null){
			if(!primeiro){
				sql+=" and ";
			}
			sql+=" viagem.dataChegada='"+seletor.getDataChegada()+"'";
			primeiro=false;

		}
		if(seletor.getMotorista()!=null && seletor.getMotorista().trim().length()>0){
			if(!primeiro){

				sql+=" and ";
			}
			sql+=" motorista.nome like'%"+seletor.getMotorista()+"%'";
			primeiro=false;
		}
		if(seletor.getVeiculo()!=null && seletor.getVeiculo().trim().length()>0){
			if(!primeiro){
				sql+=" and ";

			}
			sql+=" veiculo.modelo like'%"+seletor.getVeiculo()+"%'";
			primeiro=false;
		}
		if(seletor.getRegional()!=null && seletor.getRegional().trim().length()>0) {
			if(!primeiro){
				sql+=" and ";
			}
			sql+=" viagem.regional like'%"+seletor.getRegional()+"%'";
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
			stmt.setObject(4, viagem.getDataChegada());
			stmt.setObject(5, viagem.getDataSaida());


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
	
	public boolean removerViagem(int id) {
		boolean removeu = false;

		Connection conexao = Banco.getConnection();
		String sql = " DELETE FROM VIAGEM "
				+" WHERE IDVIAGEM=?";
		PreparedStatement stmt = Banco.getPreparedStatementWithPk(conexao, sql);

		try {
			stmt.setInt(1, id);
			removeu = stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.println("Erro ao remover viagem. Causa:" + e.getMessage());
		}		

		return removeu;
	}

	public ViagemVO consultaViagem(int id) {

		ViagemVO viagem = new ViagemVO();

		Connection conexao = Banco.getConnection();
		String sql = "SELECT * FROM  Viagem where idviagem=?";

		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);


		try {
			ResultSet resultado = stmt.executeQuery();

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
			viagem.setIdviagem(resultado.getInt("idregional"));

		
			
			motoristaVO.setNome(resultado.getString("nome"));
			viagem.setMotorista(motoristaVO);
			veiculo.setModelo(resultado.getString("modelo"));
			viagem.setVeiculo(veiculo);
			

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return viagem;
	}



	public MaterialVO criarmaterial(MaterialVO material) {
		Connection conexao = Banco.getConnection();
		String sql = " insert into material(conteudo,quantidade,setor,idviagem)values(?,?,?,?)";


		PreparedStatement stmt = Banco.getPreparedStatementWithPk(conexao, sql);

		try {

		
			stmt.setString(1, material.getConteudo());
			stmt.setInt(2, material.getQuantidade());
			stmt.setString(3, material.getSetor());
			stmt.setInt(4, material.getIdViagem());
			stmt.execute();

			ResultSet chavesGeradas = stmt.getGeneratedKeys();
			if(chavesGeradas.next()) {
				material.setIdmaterial(chavesGeradas.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir material. Causa:" + e.getMessage());
		}

		return material;
	}
}
