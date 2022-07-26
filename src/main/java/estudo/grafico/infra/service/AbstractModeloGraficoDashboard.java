package estudo.grafico.infra.service;

import static estudo.grafico.util.ColecaoUtil.isVazio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.ChartModel;

import estudo.comparator.ComparatorCategoriaGraficoDashboard;
import estudo.grafico.domain.enumerador.CategoriaGraficoDashboard;
import estudo.grafico.domain.enumerador.ItemGraficoDashboard;
import estudo.grafico.domain.service.ConjuntoDadosGraficoService;
import estudo.grafico.domain.service.FactoryConjuntoDadosGraficoService;
import estudo.grafico.infra.enumerador.TipoConjuntoGrafico;
import estudo.grafico.to.ResultadoConjuntoDadosCriadoTO;

public abstract class AbstractModeloGraficoDashboard<M extends ChartModel> {

	
	private ChartData dadosModelo;
	
	private Set<CategoriaGraficoDashboard> categoriasGrafico;

	private String titulo;

	private FactoryConjuntoDadosGraficoService factoryConjuntoDadosGraficoService;
	
	
	
	public AbstractModeloGraficoDashboard(FactoryConjuntoDadosGraficoService factoryConjuntoDadosGraficoService) { 
		
		this.factoryConjuntoDadosGraficoService = factoryConjuntoDadosGraficoService;
		this.dadosModelo = new ChartData();
		this.categoriasGrafico = new HashSet<CategoriaGraficoDashboard>();
		
		this.instanciarModeloGrafico();
		
	}
	
	public AbstractModeloGraficoDashboard(String titulo, FactoryConjuntoDadosGraficoService factoryConjuntoDadosGraficoService) {
		
		this(factoryConjuntoDadosGraficoService);
		this.titulo = titulo;
		
	}
	

	protected abstract void instanciarModeloGrafico();
	
	public abstract M getModeloGrafico();
	
	protected abstract void popularModeloGrafico(ChartData dadosModelo);
	
	public abstract TipoConjuntoGrafico getTipoConjunto();
	
	
	public void criarAndPopularConjuntoDadosGrafico(List<ItemGraficoDashboard> itens, String label) {
		
		ConjuntoDadosGraficoService<?> conjuntoDadosService = this.obterConjuntoDadosService(this.getTipoConjunto());
		ResultadoConjuntoDadosCriadoTO<?> resultado = conjuntoDadosService.obterConjuntoPopulado(itens, label);
		
		this.adicionarConjuntoAoModelo(resultado);
		
	}
	
	private void adicionarConjuntoAoModelo(ResultadoConjuntoDadosCriadoTO<?> res) {
		
		Set<CategoriaGraficoDashboard> categoriasConjunto = res.getCategoriasConjunto();
		
		if(!isVazio(categoriasConjunto)) {
			this.categoriasGrafico.addAll(categoriasConjunto);
		}
		
		this.dadosModelo.addChartDataSet(res.getConjuntoGrafico());
		
	}
	
	private ConjuntoDadosGraficoService<?> obterConjuntoDadosService(TipoConjuntoGrafico tipoConjunto) {
		return this.factoryConjuntoDadosGraficoService.obterConjuntoDadosService(tipoConjunto);
	}
	
	public M gerarGraficoDashboard() {
		
		List<String> labels = this.obterLabelsModeloDados();
		this.dadosModelo.setLabels(labels);
		
		this.popularModeloGrafico(this.dadosModelo);
		
		return this.getModeloGrafico();
		
	}
	
	private List<String> obterLabelsModeloDados(){
		
		List<String> labels = new LinkedList<String>();
		
		List<CategoriaGraficoDashboard> categorias = new ArrayList<CategoriaGraficoDashboard>();
		categorias.addAll(this.categoriasGrafico);
		
		Collections.sort(categorias, new ComparatorCategoriaGraficoDashboard());
		for (CategoriaGraficoDashboard categoria : categorias) {
			labels.add(categoria.getDescricao());
		}
		
		return labels;
		
	}
	
	public Set<CategoriaGraficoDashboard> getCategoriasGrafico() {
		return categoriasGrafico;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
}
