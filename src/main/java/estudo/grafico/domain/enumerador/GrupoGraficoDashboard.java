package estudo.grafico.domain.enumerador;

import estudo.grafico.cor.Cor;

public interface GrupoGraficoDashboard {
	
	Integer getTipo();
	
	String getDescricao();

	Cor<?, ?> getCor();
	
	Integer getOrdem();
	
}
