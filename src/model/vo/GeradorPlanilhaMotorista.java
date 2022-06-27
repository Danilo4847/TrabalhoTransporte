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


public class GeradorPlanilhaMotorista {

	



	
		



			public String geradorPlanilha(String caminho,List<MotoristaVO>motoristas){

			XSSFWorkbook areaTrabalho= new XSSFWorkbook();

			XSSFSheet planilha = areaTrabalho.createSheet("Viagem");

			int linhaAtual=0;

			String[] colunas={"Categorria da carteira","CNH","Nome","ID"};

			criarCabecalho(colunas,planilha,linhaAtual++);

			criarLinhasProdutos(motoristas, planilha, linhaAtual);

			return salvar(areaTrabalho, caminho,".xlsx");

			}
			private  void criarLinhasProdutos(List<MotoristaVO>motoristas,XSSFSheet planilha, int posicao){

			for(MotoristaVO m:motoristas){



			XSSFRow linhaAtual = planilha.createRow(posicao);

		
			linhaAtual.createCell(0).setCellValue(m.getCategoriaCarteira());
			linhaAtual.createCell(1).setCellValue(m.getCnh());
			linhaAtual.createCell(2).setCellValue(m.getNome());
			linhaAtual.createCell(3).setCellValue(m.getIdMotorista());
			


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
