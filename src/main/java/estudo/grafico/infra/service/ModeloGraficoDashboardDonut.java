package estudo.grafico.infra.service;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.donut.DonutChartModel;

import estudo.grafico.domain.service.FactoryConjuntoDadosGraficoService;
import estudo.grafico.infra.enumerador.TipoConjuntoGrafico;

public class ModeloGraficoDashboardDonut extends AbstractModeloGraficoDashboard<DonutChartModel> {


	private DonutChartModel donutChartModel;

	
	public ModeloGraficoDashboardDonut(FactoryConjuntoDadosGraficoService factoryConjuntoDadosGraficoService) {
		super(factoryConjuntoDadosGraficoService);
	}
	
	public ModeloGraficoDashboardDonut(String titulo, FactoryConjuntoDadosGraficoService factoryConjuntoDadosGraficoService) {
		super(titulo, factoryConjuntoDadosGraficoService);
	}
	
	
	@Override
	protected void instanciarModeloGrafico() {
		this.donutChartModel = new DonutChartModel();
	}

	@Override
	public DonutChartModel getModeloGrafico() {
		return this.donutChartModel;
	}
	
	@Override
	public TipoConjuntoGrafico getTipoConjunto() {
		return TipoConjuntoGrafico.DONUT;
	}

	@Override
	protected void popularModeloGrafico(ChartData dadosModelo) {
		this.getModeloGrafico().setData(dadosModelo);
	}
	
	
}
