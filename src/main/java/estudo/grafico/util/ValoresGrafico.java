package estudo.grafico.util;

import java.util.ArrayList;
import java.util.List;

import estudo.grafico.cor.Cor;
import estudo.grafico.domain.enumerador.CategoriaGraficoDashboard;
import estudo.grafico.domain.enumerador.ItemGraficoDashboard;
import estudo.grafico.infra.enumerador.CategoriaAno;

public class ValoresGrafico {

	public static List<ItemGraficoDashboard> obterValoresGrafico() {
		
		List<ItemGraficoDashboard> valores = new ArrayList<ItemGraficoDashboard>();
		valores.add(criarValorGrafico(1, CorUtil.getSkyBlue(), CategoriaAno.DOIS_MIL_E_TREZE));
		valores.add(criarValorGrafico(6, CorUtil.getCrimson(), CategoriaAno.DOIS_MIL_E_DOZE));
		valores.add(criarValorGrafico(7, CorUtil.getYellow(), CategoriaAno.DOIS_MIL_E_DEZ));
		valores.add(criarValorGrafico(8, CorUtil.getSkyBlue(), CategoriaAno.DOIS_MIL_E_ONZE));
		
		return valores;
		
	}
	
	private static ItemGraficoDashboard criarValorGrafico(final Number valor,
												  final Cor<?, ?> cor,
												  final CategoriaGraficoDashboard categoria) {
		
		return new ItemGraficoDashboard() {
			
			@Override
			public Number getValor() {
				return valor;
			}
			
			@Override
			public Cor<?, ?> getCor() {
				return cor;
			}
			
			@Override
			public CategoriaGraficoDashboard getCategoria() {
				return categoria;
			}
			
		};
		
	}
	
}
