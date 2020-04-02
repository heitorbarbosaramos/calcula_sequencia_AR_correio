package gui.util;

import javafx.scene.control.TextField;

public class Restricoes {

	public static void setTextEtiquetaTamanho(TextField txt, int max) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && newValue.length() == max) {
				txt.setText(oldValue.toUpperCase());
			}
		});
	}
	
}
