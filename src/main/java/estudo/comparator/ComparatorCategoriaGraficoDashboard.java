package estudo.comparator;

import java.util.Comparator;

import estudo.grafico.domain.enumerador.CategoriaGraficoDashboard;

public class ComparatorCategoriaGraficoDashboard implements Comparator<CategoriaGraficoDashboard> {

	private boolean isAscendente;
	
	public ComparatorCategoriaGraficoDashboard() {
		this.isAscendente = true;
	}
	
	public ComparatorCategoriaGraficoDashboard(boolean isAscendente) {
		this.isAscendente = isAscendente;
	}
	
	@Override
	public int compare(CategoriaGraficoDashboard o1, CategoriaGraficoDashboard o2) {

		Integer ordem1 = o1.getOrdem();
		Integer ordem2 = o2.getOrdem();
		
		if(this.isAscendente) {
			
			return ordem1.compareTo(ordem2);
		
		}else {
			return ordem2.compareTo(ordem1);
		}
		
	}

}
