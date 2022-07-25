package estudo.grafico.infra.enumerador;

import estudo.grafico.domain.enumerador.CategoriaGraficoDashboard;

public enum CategoriaAno implements CategoriaGraficoDashboard {

	DOIS_MIL_E_DEZ(1, "2010", 1),
	DOIS_MIL_E_ONZE(2, "2011", 2),
	DOIS_MIL_E_DOZE(3, "2012", 3),
	DOIS_MIL_E_TREZE(4, "2013", 4);

	private Integer tipo;
	private String descricao;
	private Integer ordem;

	private CategoriaAno(Integer tipo, String descricao, Integer ordem) {
		this.tipo = tipo;
		this.descricao = descricao;
		this.ordem = ordem;
	}
	
	@Override
	public Integer getTipo() {
		return tipo;
	}

	@Override
	public String getDescricao() {
		return descricao;
	}

	@Override
	public Integer getOrdem() {
		return ordem;
	}
	
}
