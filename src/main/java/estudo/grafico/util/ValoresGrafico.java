package estudo.grafico.util;

import java.util.ArrayList;
import java.util.List;

import estudo.grafico.cor.Cor;
import estudo.grafico.domain.enumerador.CategoriaGraficoDashboard;
import estudo.grafico.domain.enumerador.ItemGraficoDashboard;
import estudo.grafico.infra.enumerador.CategoriaAno;
import estudo.grafico.infra.enumerador.ClienteGrafico;

public class ValoresGrafico {

	public static List<ItemGraficoDashboard> obterValoresGrafico() {
		
		List<ItemGraficoDashboard> valores = new ArrayList<ItemGraficoDashboard>();
		
		int valorGrafico = 50000;
		int percSaturacao = 35;
		int percLightness = 31;
		for (ClienteGrafico clienteGrafico : ClienteGrafico.values()) {
		
			valores.add(criarValorGrafico(valorGrafico, CorUtil.getCor(236, percSaturacao, percLightness), clienteGrafico));

			valorGrafico -= 5000;
			percSaturacao += 5;
			percLightness += 5;
			
		}
		
		return valores;
		
	}
	
	public static List<ItemGraficoDashboard> obterValoresGraficoDonut() {
		
		List<ItemGraficoDashboard> valores = new ArrayList<ItemGraficoDashboard>();
		
		int valorGrafico = 50000;
		int percSaturacao = 35;
		int percLightness = 31;
		for (CategoriaAno ano : CategoriaAno.values()) {
		
			valores.add(criarValorGrafico(valorGrafico, CorUtil.getCor(500, percSaturacao, percLightness), ano));

			valorGrafico -= 10000;
			percSaturacao += 5;
			percLightness += 5;
			
		}
		
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
