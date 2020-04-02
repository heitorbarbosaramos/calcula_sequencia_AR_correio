package gui.util;

import java.util.ArrayList;
import java.util.List;

import gui.entities.AR;
import javafx.scene.control.Alert.AlertType;

public class CalculoDigitoVerificador {

	public static List<AR>listaAR (String etiqueta1, String etiqueta2){
		
		int num1 = Integer.parseInt(etiqueta1.substring(2, 10));
		int num2 = Integer.parseInt(etiqueta2.substring(2, 10));
		String etiqueta = null;
		String descricaoPrefixo = null;
		List<AR>lista = new ArrayList<AR>();
		
		if(num1 <= num2) {
			
			
			String prefixo = etiqueta1.substring(0, 2);
			String sufixo = etiqueta1.substring(11).trim();
			
	
			
			while(num1 <= num2) {
				
				etiqueta =prefixo+num1+sufixo;
				
				String numero = Integer.toString(num1);
				String digitoVerificador = calculoDigito(etiqueta);
				
				etiqueta =prefixo+num1+digitoVerificador+sufixo;
				descricaoPrefixo = PrefixoDescricao.achaPrefixoDescricao(prefixo);
				 AR ar = new AR(prefixo, numero, sufixo, digitoVerificador, etiqueta,descricaoPrefixo);
				lista.add(ar);
				
				ar.setDescricaoPrefixo(descricaoPrefixo);
				
				num1++;
			}
			
			
		}else {
			String content;
			content = "\n\nAR inicial é menor que o AR final\n\n";
			Alerts.showAlert("QUANTIDADE CARACTERES", "CARACTERES DIVERGENTES", content, AlertType.WARNING);
		}
		
		
		
		return lista;		
	}
	
	
	public static String calculoDigito(String etiqueta) {
		
		String numero = etiqueta.substring(2, 10);

		Integer[] multiplicadores = {8, 6, 4, 2, 3, 5, 9, 7};
		Integer i = 0;
		Integer soma = 0;
		Integer resto = 0;
		Integer dv = 0;
		

		while( i < 8) {
			soma += Integer.parseInt(numero.substring(i, i+1))  * multiplicadores[i];
			i++;
		}
		
		resto = soma % 11;
		
		if(resto == 0) {dv = 5;}else if(resto == 1) {dv = 0;}else {dv = 11-resto;}
		
		//etiquetaFinal = etiqueta.substring(0, 2)+numero+dv+etiqueta.substring(11, 13);

		return Integer.toString(dv);
		
	}
}
