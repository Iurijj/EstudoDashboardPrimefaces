package estudo.grafico.domain.service;

import java.util.List;

import org.primefaces.model.charts.ChartDataSet;

import estudo.grafico.domain.enumerador.ItemGraficoDashboard;
import estudo.grafico.infra.enumerador.TipoConjuntoGrafico;
import estudo.grafico.to.ResultadoConjuntoDadosCriadoTO;

public interface ConjuntoDadosGraficoService<C extends ChartDataSet> {

	TipoConjuntoGrafico getTipoGrafico();
	
	C criarConjunto();
	
	ResultadoConjuntoDadosCriadoTO<C> obterConjuntoPopulado(List<ItemGraficoDashboard> itens);
	
}
