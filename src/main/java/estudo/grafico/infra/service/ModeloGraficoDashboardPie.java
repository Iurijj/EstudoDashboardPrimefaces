package estudo.grafico.infra.service;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.pie.PieChartModel;

import estudo.grafico.domain.service.FactoryConjuntoDadosGraficoService;
import estudo.grafico.infra.enumerador.TipoConjuntoGrafico;

public class ModeloGraficoDashboardPie extends AbstractModeloGraficoDashboard<PieChartModel> {


	private PieChartModel pieChartModel;

	
	public ModeloGraficoDashboardPie(FactoryConjuntoDadosGraficoService factoryConjuntoDadosGraficoService) {
		super(factoryConjuntoDadosGraficoService);
	}
	
	public ModeloGraficoDashboardPie(String titulo, FactoryConjuntoDadosGraficoService factoryConjuntoDadosGraficoService) {
		super(titulo, factoryConjuntoDadosGraficoService);
	}
	
	
	@Override
	protected void instanciarModeloGrafico() {
		this.pieChartModel = new PieChartModel();
	}

	@Override
	public PieChartModel getModeloGrafico() {
		return this.pieChartModel;
	}
	
	@Override
	public TipoConjuntoGrafico getTipoConjunto() {
		return TipoConjuntoGrafico.PIE;
	}

	@Override
	protected void popularModeloGrafico(ChartData dadosModelo) {
		this.getModeloGrafico().setData(dadosModelo);
	}
	
	
}
