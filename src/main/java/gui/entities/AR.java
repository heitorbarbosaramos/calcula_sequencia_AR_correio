package gui.entities;

public class AR {

	private String prefixo;
	private String numero;
	private String sufixo;
	private String digitoVerificador;
	private String etiquetaCompleta;
	private String descricaoPrefixo;
	
	public AR() {
	}
	public AR(String prefixo, String numero, String sufixo, String digitoVerificador, String etiquetaCompleta,String descricaoPrefixo) {
		this.prefixo = prefixo;
		this.numero = numero;
		this.sufixo = sufixo;
		this.digitoVerificador = digitoVerificador;
		this.etiquetaCompleta = etiquetaCompleta;
		this.descricaoPrefixo = descricaoPrefixo;
	}

	public String getPrefixo() {
		return prefixo;
	}

	public void setPrefixo(String prefixo) {
		this.prefixo = prefixo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getSufixo() {
		return sufixo;
	}

	public void setSufixo(String sufixo) {
		this.sufixo = sufixo;
	}

	public String getDigitoVerificador() {
		return digitoVerificador;
	}

	public void setDigitoVerificador(String digitoVerificador) {
		this.digitoVerificador = digitoVerificador;
	}

	public String getEtiquetaCompleta() {
		return etiquetaCompleta;
	}

	public void setEtiquetaCompleta(String etiquetaCompleta) {
		this.etiquetaCompleta = etiquetaCompleta;
	}
	
	public String getDescricaoPrefixo() {
		return descricaoPrefixo;
	}

	public void setDescricaoPrefixo(String descricaoPrefixo) {
		this.descricaoPrefixo = descricaoPrefixo;
	}


	@Override
	public String toString() {
		return "AR [prefixo=" + prefixo + ", numero=" + numero + ", sufixo=" + sufixo + ", digitoVerificador="
				+ digitoVerificador + ", etiquetaCompleta=" + etiquetaCompleta + ", descricaoPrefixo=" + descricaoPrefixo + "]";
	}
	
	
	
}
