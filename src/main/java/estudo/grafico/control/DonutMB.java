package estudo.grafico.control;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.charts.donut.DonutChartModel;

import estudo.grafico.domain.enumerador.ItemGraficoDashboard;
import estudo.grafico.domain.service.FactoryConjuntoDadosGraficoService;
import estudo.grafico.infra.service.ModeloGraficoDashboardDonut;
import estudo.grafico.util.ValoresGrafico;

@Named
public class DonutMB extends AbstractGraficoMB {

	private static final long serialVersionUID = 1L;

	private static final String NOME_GRAFICO = "Pie";
	
	@Inject private FactoryConjuntoDadosGraficoService factoryConjuntoDadosGraficoService;
	
	private DonutChartModel modeloDonut;
	
	
	@PostConstruct
    public void init() {
	
		super.init();
		this.criarGrafico();
	
	}
	
	private void criarGrafico() {
		
		List<ItemGraficoDashboard> valoresGrafico = ValoresGrafico.obterValoresGrafico();
		
		this.criarGraficoBarraVertical(valoresGrafico);
		
	}
	
	
	private void criarGraficoBarraVertical(List<ItemGraficoDashboard> valoresGrafico) {
		
		ModeloGraficoDashboardDonut modeloGraficoDashboardDonut = 
				new ModeloGraficoDashboardDonut(this.factoryConjuntoDadosGraficoService);
		
		modeloGraficoDashboardDonut.criarAndPopularConjuntoDadosGrafico(valoresGrafico);
		
		this.modeloDonut = modeloGraficoDashboardDonut.gerarGraficoDashboard();
		
	}
	
	public DonutChartModel getModeloDonut() {
		return modeloDonut;
	}
	
	public String getNomeGrafico() {
		return NOME_GRAFICO;
	}

}
