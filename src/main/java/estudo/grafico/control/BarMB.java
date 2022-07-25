package estudo.grafico.control;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearTicks;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.hbar.HorizontalBarChartModel;
import org.primefaces.model.charts.optionconfig.title.Title;

import estudo.grafico.domain.enumerador.ItemGraficoDashboard;
import estudo.grafico.domain.service.FactoryConjuntoDadosGraficoService;
import estudo.grafico.infra.service.ModeloGraficoDashboardBarra;
import estudo.grafico.infra.service.ModeloGraficoDashboardBarraHorizontal;
import estudo.grafico.util.ValoresGrafico;

@Named
public class BarMB extends AbstractGraficoMB {

	
	private static final long serialVersionUID = 1L;

	
	private static final String NOME_GRAFICO = "Barras";
	
	
	@Inject private FactoryConjuntoDadosGraficoService factoryConjuntoDadosGraficoService;

	
	private BarChartModel modeloVerticalBarra;
	private HorizontalBarChartModel modeloHorizontalBarra;
	
	
	@PostConstruct
    public void init() {
        
		super.init();
		this.criarGraficos();
    
	}
	
	private void criarGraficos() {
		
		List<ItemGraficoDashboard> valoresGrafico = ValoresGrafico.obterValoresGrafico();
		
		this.criarGraficoBarraVertical(valoresGrafico);
		this.criarGraficoHorizontal(valoresGrafico);
		
	}
	
	private void criarGraficoBarraVertical(List<ItemGraficoDashboard> valoresGrafico) {
		
		ModeloGraficoDashboardBarra modeloGraficoDashboardBarra = 
				new ModeloGraficoDashboardBarra("Teste 1", this.factoryConjuntoDadosGraficoService);
		
		modeloGraficoDashboardBarra.criarAndPopularConjuntoDadosGrafico(valoresGrafico);
		
		this.modeloVerticalBarra = modeloGraficoDashboardBarra.gerarGraficoDashboard();
		
	}
	
	private void criarGraficoHorizontal(List<ItemGraficoDashboard> valoresGrafico) {
		
		ModeloGraficoDashboardBarraHorizontal modeloGrafDashboardBarraHorizontal = 
				new ModeloGraficoDashboardBarraHorizontal("Teste 1", this.factoryConjuntoDadosGraficoService);
		
		modeloGrafDashboardBarraHorizontal.criarAndPopularConjuntoDadosGrafico(valoresGrafico);
		
		this.modeloHorizontalBarra = modeloGrafDashboardBarraHorizontal.gerarGraficoDashboard();
		
	}
	
	
	//exemplo primefaces relatorio de barras com duas barras por label
	public void exemploPrimefaces() {
		
		
		//modelo de barras
		BarChartModel modeloV = new BarChartModel();
        
		//dadosgrafico
		ChartData data = new ChartData();

        //conjuntos de dados
		//inicio conjunto Adimplente
        BarChartDataSet barDataSet = new BarChartDataSet();
        barDataSet.setLabel("Adimplente");
        barDataSet.setBackgroundColor("rgba(135, 206, 235, 0.2)");//azulzinho
        barDataSet.setBorderColor("rgb(135, 206, 235)");//azulzinho
        barDataSet.setBorderWidth(1);
        List<Number> values = new ArrayList<>();
        values.add(52);//janeiro
        values.add(47);//fevereiro
        values.add(55);//marco
        values.add(10);
        barDataSet.setData(values);
        //fim
        
        
        BarChartDataSet barDataSet2 = new BarChartDataSet();
        barDataSet2.setLabel("Inadimplente");
        barDataSet2.setBackgroundColor("rgba(220, 20, 60, 0.2)");
        barDataSet2.setBorderColor("rgb(220, 20, 60)");
        barDataSet2.setBorderWidth(1);
        List<Number> values2 = new ArrayList<>();
        values2.add(48);
        values2.add(38);
        values2.add(43);
        values2.add(10);
        barDataSet2.setData(values2);

        
        BarChartDataSet barDataSet3 = new BarChartDataSet();
        barDataSet3.setLabel("Indefinido");
        barDataSet3.setBackgroundColor("rgba(255, 0, 0, 0.2)");
        barDataSet3.setBorderColor("rgb(255, 0, 0)");
        barDataSet3.setBorderWidth(1);
        List<Number> values3 = new ArrayList<>();
        values3.add(42);
        values3.add(45);
        values3.add(25);
        values3.add(10);
        barDataSet3.setData(values3);
        
        
        data.addChartDataSet(barDataSet);
        data.addChartDataSet(barDataSet2);
        data.addChartDataSet(barDataSet3);

        List<String> labels = new ArrayList<>();
        labels.add("Janeiro");
        labels.add("Fevereiro");
        labels.add("Março");
        labels.add("Abril");
        
        data.setLabels(labels);
        modeloV.setData(data);
        

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
        title.setDisplay(true);
        title.setText("Exemplo Primefaces");
        options.setTitle(title);

        modeloV.setOptions(options);
        
    }
	
	
	public BarChartModel getModeloVerticalBarra() {
		return modeloVerticalBarra;
	}
	
	public HorizontalBarChartModel getModeloHorizontalBarra() {
		return modeloHorizontalBarra;
	}
	
	
	@Override
	public String getNomeGrafico() {
		return NOME_GRAFICO;
	}
	

}
