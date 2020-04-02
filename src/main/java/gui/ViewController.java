package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import gui.entities.AR;
import gui.util.Alerts;
import gui.util.Arquivos;
import gui.util.CalculoDigitoVerificador;
import gui.util.Download;
import gui.util.Restricoes;
import gui.util.Verificadores;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ViewController extends AR implements Initializable{

	@FXML
	private Label labelMensagemCalculando;
	@FXML
	private TextField txtSequenciaAR1;
	@FXML
	private TextField txtSequenciaAR2;
	@FXML
	private Label labelSequecia;
	@FXML
	private Button btCalculaAR;
	@FXML
	private Label labelPrimeiroAR;
	@FXML
	private Label labelUltimoAR;
	@FXML
	private Label labelQuantidadeAR;
	@FXML
	private Label labelDescricaoPrefixo;
	@FXML
	String mensagemStatus;
	@FXML
	private MenuItem menuDownload;
	@FXML
	private MenuItem menuAbout;
	private String descricaoPrefixo;
	private String nomeArquivo;
	
	@FXML
	public void inicioCalculaAR() {	
		
		mensagemStatus = "CALCULANDO, ESPERE!!!";
		setMensagemStatus();
		
		String etiqueta1 = String.format("%s", txtSequenciaAR1.getText().toUpperCase());
		String etiqueta2 = String.format("%s", txtSequenciaAR2.getText().toUpperCase());
		
		
		Verificadores.etiquetaVazia(etiqueta1);
		Verificadores.etiquetaVazia(etiqueta2);
		
		String prefixo1 = etiqueta1.substring(0, 2);
		String prefixo2 = etiqueta2.substring(0, 2);

		
		boolean verSigla 		= Verificadores.sigla(prefixo1, prefixo2);
		boolean verEtiqueta 	= Verificadores.etiquetaTamanho(etiqueta1);
		boolean verTamanho 		= Verificadores.etiquetaTamanho(etiqueta2);
		boolean verQuantidade 	= Verificadores.quantidadeMaximaEtiquetas(etiqueta1, etiqueta2);
		
		
		List<AR> lista = null;
		
		if(verSigla && verEtiqueta  && verTamanho && verQuantidade ) {
			
			
			lista = CalculoDigitoVerificador.listaAR(etiqueta1, etiqueta2);
			
			lista.forEach(l->{
				descricaoPrefixo = l.getDescricaoPrefixo();
				System.out.println(l);
			});
			
			
			nomeArquivo = Arquivos.GerarTXT(lista);
			
			
			
			labelPrimeiroAR.setText(lista.get(0).getEtiquetaCompleta());
			labelUltimoAR.setText(lista.get(lista.size()-1).getEtiquetaCompleta());
			labelQuantidadeAR.setText(Integer.toString(lista.size()));
			labelDescricaoPrefixo.setText(descricaoPrefixo);
					
			mensagemStatus = "CALCULO REALIZADO!";
			setMensagemStatus();
			
		}else {
			
			mensagemStatus = "CALCULO NÃO REALIZADO";
			setMensagemStatus();
			
			String content;
			content = "\n\nFavor Verificar os AR's inseridos\n\n";
			Alerts.showAlert("Verificar ARs", "Verificar AR's", content, AlertType.ERROR);
		}
		
		System.out.println(nomeArquivo);
		System.out.println(mensagemStatus);
		System.out.println("Descricao Prefixo: "+descricaoPrefixo);
		System.out.println("Primeiro AR: "+lista.get(0));
		System.out.println("Ultimo AR: "+lista.get(lista.size()-1));
		System.out.println("Quantidade AR: "+lista.size());
		System.out.println(String.format("Numero 1 %s", etiqueta1));
		System.out.println(String.format("Numero 2 %s", etiqueta2));
		System.out.println(String.format("sigla 1 %s", prefixo1));
		System.out.println(String.format("sigla 2 %s", prefixo2));

	}
	
	@FXML
	public void setMensagemStatus() {
		labelMensagemCalculando.setText(mensagemStatus);
	}
	@FXML
	public void Down() {
		Download.download(nomeArquivo);
	}
	@FXML
	public void About() {
		Alerts.showAlert("Sobre", "Sobre o Programa", "Este programa foi criado para calcular uma sequência de ARs que é disponibilizada pelas as agências de correios\n\nDesenvolvedor Heitor Fernando Barbosa Ramos\nE-mail: heitorhfbr@gmail.com\n\nMuito Obrigado por utilizar este programa", AlertType.INFORMATION);
	}
	@FXML
	public void ArquivoPrefixoDownload() {
		Download.download("src\\main\\resources\\sigla-descricao.txt");
	}
	
	public void initialize(URL location, ResourceBundle resources) {
		
		Restricoes.setTextEtiquetaTamanho(txtSequenciaAR1, 14);
		Restricoes.setTextEtiquetaTamanho(txtSequenciaAR2, 14);
		
	}

}
