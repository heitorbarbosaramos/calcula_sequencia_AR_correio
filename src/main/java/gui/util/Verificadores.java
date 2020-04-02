package gui.util;

import java.util.Properties;

import javafx.scene.control.Alert.AlertType;

public class Verificadores {

	public static boolean etiquetaVazia(String etiqueta) {
		
		if(etiqueta == null || etiqueta.trim().equals("")) {
			String content;
			content = "\n\n A ETIQUETA ESTÁ VAZIA\n\n";
			Alerts.showAlert("Etiqueta Vazia", "Etiqueta Não Declarada", content, AlertType.WARNING);
			
			return false;
		}else {
			return true;
		}
	}
	
	public static boolean sigla(String prefixo1, String prefixo2) {
		
		if (!prefixo1.equals(prefixo2)) {

			String content;
			content = "Sigla AR1: " + prefixo1.toUpperCase() + "\nSigla AR2: " + prefixo2.toUpperCase()
					+ "\n\n SIGLAS DIVEGENTES";
			Alerts.showAlert("SILGAS AR", "SIGLAS DIVERGENTES", content, AlertType.ERROR);
			return false;
		}else {
			return true;
		}
	}
	
	
	public static boolean etiquetaTamanho(String etiqueta) {
		
		if(etiqueta.length() != 13) {
			String content;
			content = "\n\nQUANTIDADE DE CARACTERES NÃO CORRESPONDENTE A ETIQUETA\n\n";
			Alerts.showAlert("QUANTIDADE CARACTERES", "CARACTERES DIVERGENTES", content, AlertType.ERROR);
			return false;
		}else {
			return true;
		}
	}
	
	public static boolean quantidadeMaximaEtiquetas(String etiqueta1, String etiqueta2) {
		
		LeituraProperties leituraProperties = new LeituraProperties();
		Properties props = leituraProperties.getProperties("arquivos");
		
		int limite = Integer.parseInt(props.getProperty("limite.contador.ar"));
		
		int seq1 = Integer.parseInt(etiqueta1.substring(2,10));
		int seq2 = Integer.parseInt(etiqueta2.substring(2,10));
		
		if(((seq2-seq1)+1) > limite) {
			String content;
			content = "\n\nQUANTIDADE DE ETIQUETAS MAIOR QUE O PERMITIDO\nLIMITE POR REMESSA: "+limite+"\n";
			Alerts.showAlert("QUANTIDADE ETIQUETA", "QUANTIDADE ETIQUETA", content, AlertType.ERROR);
			return false;
		}else {		
			return true;
		}
		
	}
	
}
