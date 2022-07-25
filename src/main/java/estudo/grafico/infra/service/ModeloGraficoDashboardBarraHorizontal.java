package estudo.grafico.infra.service;

import static estudo.grafico.util.StringUtil.isVazio;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearTicks;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.hbar.HorizontalBarChartModel;
import org.primefaces.model.charts.optionconfig.title.Title;

import estudo.grafico.domain.service.FactoryConjuntoDadosGraficoService;
import estudo.grafico.infra.enumerador.TipoConjuntoGrafico;

public class ModeloGraficoDashboardBarraHorizontal extends AbstractModeloGraficoDashboard<HorizontalBarChartModel> {


	private HorizontalBarChartModel horizontalBarChartModel;

	
	public ModeloGraficoDashboardBarraHorizontal(FactoryConjuntoDadosGraficoService factoryConjuntoDadosGraficoService) {
		super(factoryConjuntoDadosGraficoService);
	}
	
	public ModeloGraficoDashboardBarraHorizontal(String titulo, FactoryConjuntoDadosGraficoService factoryConjuntoDadosGraficoService) {
		super(titulo, factoryConjuntoDadosGraficoService);
	}
	
	
	@Override
	protected void instanciarModeloGrafico() {
		this.horizontalBarChartModel = new HorizontalBarChartModel();
	}

	@Override
	public HorizontalBarChartModel getModeloGrafico() {
		return this.horizontalBarChartModel;
	}
	
	@Override
	public TipoConjuntoGrafico getTipoConjunto() {
		return TipoConjuntoGrafico.BARRA_HORIZONTAL;
	}

	@Override
	protected void popularModeloGrafico(ChartData dadosModelo) {
		
		this.getModeloGrafico().setData(dadosModelo);
		
		BarChartOptions configModelo = this.obterConfigModelo();
		this.getModeloGrafico().setOptions(configModelo);
		
	}
	
	private BarChartOptions obterConfigModelo() {
		
		//Options
        BarChartOptions options = new BarChartOptions();
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        linearAxes.setOffset(true);
        CartesianLinearTicks ticks = new CartesianLinearTicks();
        ticks.setBeginAtZero(true);
        linearAxes.setTicks(ticks);
        cScales.addYAxesData(linearAxes);
        options.setScales(cScales);

        Title title = new Title();
        title.setDisplay(!isVazio(super.getTitulo()));
        title.setPosition("top");
        title.setText(super.getTitulo());
        
        options.setTitle(title);
        
        return options;
		
	}

	
}
