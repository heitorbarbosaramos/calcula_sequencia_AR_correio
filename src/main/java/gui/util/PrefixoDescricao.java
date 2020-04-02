package gui.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javafx.scene.control.Alert.AlertType;

public class PrefixoDescricao {

	public static String achaPrefixoDescricao(String prefixo) {

		LeituraProperties load = new LeituraProperties();
		Properties props = load.getProperties("leitura_prefixo_ars");

		String arquivo = props.getProperty("caminho.arquivo.ar");

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(arquivo))) {

			String line = bufferedReader.readLine();
			while (line != null) {
				if(prefixo.trim().toUpperCase().equals(line.split("-")[0])) {
					return line;
				}
				
				line = bufferedReader.readLine();
			}

		} catch (FileNotFoundException e) {
			Alerts.showAlert("FileNotFoundException", "FileNotFoundException", e.getMessage(), AlertType.ERROR);
		} catch (IOException e) {
			Alerts.showAlert("IOException", "IOException", e.getMessage(), AlertType.ERROR);
		}

		return "Não Foi Encontrado Prefixo: "+prefixo;

	}

}
