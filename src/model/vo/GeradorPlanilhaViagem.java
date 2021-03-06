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

public class GeradorPlanilhaViagem {





	public String geradorPlanilha(String caminho,List<ViagemVO>viagens){

		XSSFWorkbook areaTrabalho= new XSSFWorkbook();

		XSSFSheet planilha = areaTrabalho.createSheet("Viagem");

		int linhaAtual=0;

		String[] colunas={"regional","data saida","data chegada"};

		criarCabecalho(colunas,planilha,linhaAtual++);

		criarLinhasProdutos(viagens, planilha, linhaAtual);

		return salvar(areaTrabalho, caminho,".xlsx");

	}
	private  void criarLinhasProdutos(List<ViagemVO>viagens,XSSFSheet planilha, int posicao){

		for(ViagemVO v:viagens){

			XSSFRow linhaAtual = planilha.createRow(posicao);

			linhaAtual.createCell(0).setCellValue(v.getRegional());
			linhaAtual.createCell(1).setCellValue(v.getDataChegada()+"");
			linhaAtual.createCell(2).setCellValue(v.getDataSaida()+"");

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
