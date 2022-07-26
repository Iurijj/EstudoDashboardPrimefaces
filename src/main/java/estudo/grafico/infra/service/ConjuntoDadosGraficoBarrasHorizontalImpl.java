package estudo.grafico.infra.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.primefaces.model.charts.hbar.HorizontalBarChartDataSet;

import estudo.comparator.ComparatorItemGraficoDashboard;
import estudo.grafico.domain.enumerador.CategoriaGraficoDashboard;
import estudo.grafico.domain.enumerador.ItemGraficoDashboard;
import estudo.grafico.domain.service.ConjuntoDadosGraficoService;
import estudo.grafico.infra.enumerador.TipoConjuntoGrafico;
import estudo.grafico.to.ResultadoConjuntoDadosCriadoTO;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class ConjuntoDadosGraficoBarrasHorizontalImpl implements ConjuntoDadosGraficoService<HorizontalBarChartDataSet> {

	private static final String NOME_DEFAULT = "Barra";
	
	@Override
	public TipoConjuntoGrafico getTipoGrafico() {
		return TipoConjuntoGrafico.BARRA_HORIZONTAL;
	}

	@Override
	public HorizontalBarChartDataSet criarConjunto() {
		return new HorizontalBarChartDataSet();
	}
	
	@Override
	public ResultadoConjuntoDadosCriadoTO<HorizontalBarChartDataSet> obterConjuntoPopulado(List<ItemGraficoDashboard> itens, String label) {
		
		HorizontalBarChartDataSet conjunto = this.criarConjunto();
		conjunto.setLabel(NOME_DEFAULT);
		
		Set<CategoriaGraficoDashboard> categorias = new HashSet<CategoriaGraficoDashboard>();
		
        List<Number> valores = new LinkedList<Number>();
        List<String> coresBarra = new LinkedList<String>();
        List<String> coresBordaBarra = new LinkedList<String>();
        
        Collections.sort(itens, new ComparatorItemGraficoDashboard());
        for (ItemGraficoDashboard item : itens) {
        	
        	valores.add(item.getValor());
        	coresBarra.add(item.getCor().getCorFundo().getCor());
        	coresBordaBarra.add(item.getCor().getCorBorda().getCor());
        	
        	categorias.add(item.getCategoria());
			
		}
        
        conjunto.setData(valores);
        conjunto.setBackgroundColor(coresBarra);
        conjunto.setBorderColor(coresBordaBarra);
        conjunto.setBorderWidth(1);
		
		return new ResultadoConjuntoDadosCriadoTO<HorizontalBarChartDataSet>(conjunto, categorias);
		
	}
	
	
}
