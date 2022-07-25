package estudo.grafico.control;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.charts.pie.PieChartModel;

import estudo.grafico.domain.enumerador.ItemGraficoDashboard;
import estudo.grafico.domain.service.FactoryConjuntoDadosGraficoService;
import estudo.grafico.infra.service.ModeloGraficoDashboardPie;
import estudo.grafico.util.ValoresGrafico;

@Named
public class PieMB extends AbstractGraficoMB {

	private static final long serialVersionUID = 1L;

	private static final String NOME_GRAFICO = "Pie";
	
	@Inject private FactoryConjuntoDadosGraficoService factoryConjuntoDadosGraficoService;
	
	private PieChartModel modeloPie;
	
	
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
		
		ModeloGraficoDashboardPie modeloGraficoDashboardPie = 
				new ModeloGraficoDashboardPie(this.factoryConjuntoDadosGraficoService);
		
		modeloGraficoDashboardPie.criarAndPopularConjuntoDadosGrafico(valoresGrafico);
		
		this.modeloPie = modeloGraficoDashboardPie.gerarGraficoDashboard();
		
	}
	
	public PieChartModel getModeloPie() {
		return modeloPie;
	}
	
	public String getNomeGrafico() {
		return NOME_GRAFICO;
	}

}
