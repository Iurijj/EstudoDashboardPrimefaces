package estudo.grafico.infra.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.primefaces.model.charts.pie.PieChartDataSet;

import estudo.comparator.ComparatorItemGraficoDashboard;
import estudo.grafico.domain.enumerador.CategoriaGraficoDashboard;
import estudo.grafico.domain.enumerador.ItemGraficoDashboard;
import estudo.grafico.domain.service.ConjuntoDadosGraficoService;
import estudo.grafico.infra.enumerador.TipoConjuntoGrafico;
import estudo.grafico.to.ResultadoConjuntoDadosCriadoTO;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class ConjuntoDadosGraficoPieImpl implements ConjuntoDadosGraficoService<PieChartDataSet> {

	@Override
	public TipoConjuntoGrafico getTipoGrafico() {
		return TipoConjuntoGrafico.PIE;
	}
	
	@Override
	public PieChartDataSet criarConjunto() {
		return new PieChartDataSet();
	}
	
	@Override
	public ResultadoConjuntoDadosCriadoTO<PieChartDataSet> obterConjuntoPopulado(List<ItemGraficoDashboard> itens) {

		PieChartDataSet conjunto = this.criarConjunto();
		
		Set<CategoriaGraficoDashboard> categorias = new HashSet<CategoriaGraficoDashboard>();
		
		List<Number> valores = new LinkedList<Number>();
        List<String> cores = new LinkedList<String>();
        
        Collections.sort(itens, new ComparatorItemGraficoDashboard());
        for (ItemGraficoDashboard item : itens) {
        	
        	valores.add(item.getValor());
        	cores.add(item.getCor().getCorFundo().getCor());
        	
        	categorias.add(item.getCategoria());
        	
        }
        
        conjunto.setData(valores);
        conjunto.setBackgroundColor(cores);
		
		return new ResultadoConjuntoDadosCriadoTO<PieChartDataSet>(conjunto, categorias);
	
	}

}
