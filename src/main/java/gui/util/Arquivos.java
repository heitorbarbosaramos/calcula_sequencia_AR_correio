package gui.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import gui.entities.AR;
import javafx.scene.control.Alert.AlertType;

public class Arquivos {

	public static String GerarTXT(List<AR>lista) {
		
		LeituraProperties leituraProperties = new LeituraProperties();
		Properties props = leituraProperties.getProperties("arquivos");
		
		String nomeArquivo = props.getProperty("caminho.arquivo.txt")+lista.get(0).getEtiquetaCompleta()+"_"+lista.get(lista.size()-1).getEtiquetaCompleta()+".txt";
		System.out.println(" * * * * "+nomeArquivo);
		String separador = "=============================================================================";
		try(BufferedWriter bf = new BufferedWriter(new FileWriter(nomeArquivo))){
			
			bf.write(separador);
			bf.write("\nPrimeiro AR: "+lista.get(0).getEtiquetaCompleta());
			bf.write("\nUltimo AR: "+lista.get(lista.size()-1).getEtiquetaCompleta());
			bf.write("\nPrefixo: "+lista.get(0).getPrefixo());
			bf.write("\nTipo Serviço: "+lista.get(0).getDescricaoPrefixo());
			bf.write("\nQuantidade: "+lista.size());
			bf.write("\n"+separador);
			
			lista.forEach(l->{
				try {
					bf.write("\n"+l.getEtiquetaCompleta());
				} catch (IOException e) {
					Alerts.showAlert("ERROR ARQUIVO", "ERROR GERAR LISTA AR", e.getMessage(), AlertType.ERROR);
					e.printStackTrace();
				}
			});
			
		} catch (IOException e) {
			Alerts.showAlert("ERROR ARQUIVO", "ERRO ARQUIVO TXT", e.getMessage(), AlertType.ERROR);
			e.printStackTrace();
		}
		
		return nomeArquivo;
		
	}
	
	public static void main(String[] args) {
	
		List<AR> lista = new ArrayList<AR>();
		
		lista.add(new AR("JC", "12345678", "BR", "6", "JC123456786BR", "JC-ENCOMENDA ECONOMICA"));
		lista.add(new AR("JC", "12345679", "BR", "5", "JC123456795BR", "JC-ENCOMENDA ECONOMICA"));
		lista.add(new AR("JC", "12345680", "BR", "3", "JC123456803BR", "JC-ENCOMENDA ECONOMICA"));
		
		GerarTXT(lista);
	}
}
