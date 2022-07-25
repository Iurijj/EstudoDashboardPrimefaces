package estudo.grafico.cor.enumerador;

public enum TipoCor {

	
	RGB(1, "RGB", "rgb(%s)"),
	RGBA(2, "RGBA", "rgba(%s)"),
	HEX(3, "HEX", "#%s"),
	HSL(4, "HSL", "hsl(%s)"),
	HWB(5, "HWB", "hwb(%s)"),
	NOME(6, "Nome", "%s");
	
	
	private Integer tipo;
	private String descricao;
	private String sintaxe;

	
	private TipoCor(Integer tipo, String descricao, String sintaxe) {
		
		this.tipo = tipo;
		this.descricao = descricao;
		this.sintaxe = sintaxe;
	
	}
	
	
	public Integer getTipo() {
		return tipo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public String getSintaxe() {
		return sintaxe;
	}
	
	
}
