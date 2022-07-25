package estudo.comparator;

import java.util.Comparator;

import estudo.grafico.domain.enumerador.ItemGraficoDashboard;

public class ComparatorItemGraficoDashboard implements Comparator<ItemGraficoDashboard> {

	private boolean isAscendente;
	
	public ComparatorItemGraficoDashboard() {
		this.isAscendente = true;
	}
	
	public ComparatorItemGraficoDashboard(boolean isAscendente) {
		this.isAscendente = isAscendente;
	}
	
	@Override
	public int compare(ItemGraficoDashboard o1, ItemGraficoDashboard o2) {

		Integer ordem1 = o1.getCategoria().getOrdem();
		Integer ordem2 = o2.getCategoria().getOrdem();
		
		if(this.isAscendente) {
			
			return ordem1.compareTo(ordem2);
		
		}else {
			return ordem2.compareTo(ordem1);
		}
		
	}

}
