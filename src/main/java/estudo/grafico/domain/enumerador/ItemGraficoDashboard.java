package estudo.grafico.domain.enumerador;

import estudo.grafico.cor.Cor;

public interface ItemGraficoDashboard {

	CategoriaGraficoDashboard getCategoria();
	
	Cor<?, ?> getCor();

	Number getValor();
	
}
