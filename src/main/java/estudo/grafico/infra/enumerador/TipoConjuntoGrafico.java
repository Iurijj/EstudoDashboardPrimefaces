package estudo.grafico.infra.enumerador;

public enum TipoConjuntoGrafico {
	
	BARRA(1, "Barra"),
	BARRA_HORIZONTAL(2, "Barra Horizontal"),
	DONUT(3, "Donut"),
	PIE(4, "Pie");

	private Integer tipo;
	private String descricao;

	private TipoConjuntoGrafico(Integer tipo, String descricao) {
	
		this.tipo = tipo;
		this.descricao = descricao;
	
	}
	
	public Integer getTipo() {
		return tipo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
