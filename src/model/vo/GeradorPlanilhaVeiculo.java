package model.vo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class GeradorPlanilhaVeiculo {





		



			public String geradorPlanilha(String caminho,List<VeiculoVO>veiculo){

			XSSFWorkbook areaTrabalho= new XSSFWorkbook();

			XSSFSheet planilha = areaTrabalho.createSheet("Viagem");

			int linhaAtual=0;

			String[] colunas={"Marca","Modelo","Placa","Renavam","ID"};

			criarCabecalho(colunas,planilha,linhaAtual++);

			criarLinhasProdutos(veiculo, planilha, linhaAtual);

			return salvar(areaTrabalho, caminho,".xlsx");

			}
			private  void criarLinhasProdutos(List<VeiculoVO>veiculos,XSSFSheet planilha, int posicao){

			for(VeiculoVO v:veiculos){



			XSSFRow linhaAtual = planilha.createRow(posicao);

		
			linhaAtual.createCell(0).setCellValue(v.getMarca());
			linhaAtual.createCell(1).setCellValue(v.getModelo());
			linhaAtual.createCell(2).setCellValue(v.getPlaca());
			linhaAtual.createCell(3).setCellValue(v.getRenavam());
			linhaAtual.createCell(4).setCellValue(v.getIdVeiculo());


			posicao++;

			}


			}
			private void criarCabecalho(String[] celulas, XSSFSheet planilha, int posicao){

			XSSFRow linhaAtual = planilha.createRow(posicao);

			for(int i = 0;i<celulas.length;i++){

			Cell novaCell = linhaAtual.createCell(i);
			novaCell.setCellValue(celulas[i]);

			}


			} 

			private String salvar(XSSFWorkbook areaTrabalho, String caminho, String extensao){
			String mensagem="";
			FileOutputStream saida= null;


			try{

			saida= new FileOutputStream(new File(caminho+extensao));
			areaTrabalho.write(saida);
			mensagem="Planilha gerada com sucesso";


			}catch(FileNotFoundException e ){

			mensagem = "Erro ao tentar salvar planilha em: "+caminho+extensao;
			System.out.println(" Erro ao tentar salvar planilha "+e.getMessage());

			}catch(IOException e ){

			mensagem = "Erro ao tentar salvar planilha em: "+caminho+extensao;
			System.out.println(" Erro ao tentar salvar planilha "+e.getMessage());
			}finally{

			if(saida!=null){

				try{

					saida.close();
					areaTrabalho.close();

			}catch(IOException e){

			mensagem="Erro ao tentar salvar Planilha "+caminho+extensao;
			System.out.println(" Erro "+e.getMessage());
			}
			}
			}
		return mensagem;
			}
	

}
