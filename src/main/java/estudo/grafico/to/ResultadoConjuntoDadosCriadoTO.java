package estudo.grafico.to;

import java.util.Set;

import org.primefaces.model.charts.ChartDataSet;

import estudo.grafico.domain.enumerador.CategoriaGraficoDashboard;

public class ResultadoConjuntoDadosCriadoTO<C extends ChartDataSet> {

	
	private C conjuntoGrafico;
	
	private Set<CategoriaGraficoDashboard> categoriasConjunto;
	
	
	public ResultadoConjuntoDadosCriadoTO(C conjuntoGrafico) {
		this.conjuntoGrafico = conjuntoGrafico;
	}
	
	public ResultadoConjuntoDadosCriadoTO(C conjuntoGrafico, Set<CategoriaGraficoDashboard> categoriasConjunto) {
	
		this(conjuntoGrafico);
		this.categoriasConjunto = categoriasConjunto;
	
	}
	
	
	public C getConjuntoGrafico() {
		return conjuntoGrafico;
	}
	
	public Set<CategoriaGraficoDashboard> getCategoriasConjunto() {
		return categoriasConjunto;
	}
	
	
}
