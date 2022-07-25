package estudo.comparator;

import java.util.Comparator;

import estudo.grafico.domain.enumerador.GrupoGraficoDashboard;

public class ComparatorGrupoGraficoDashboard implements Comparator<GrupoGraficoDashboard> {

	private boolean isAscendente;
	
	public ComparatorGrupoGraficoDashboard() {
		this.isAscendente = true;
	}
	
	public ComparatorGrupoGraficoDashboard(boolean isAscendente) {
		this.isAscendente = isAscendente;
	}
	
	@Override
	public int compare(GrupoGraficoDashboard o1, GrupoGraficoDashboard o2) {

		Integer ordem1 = o1.getOrdem();
		Integer ordem2 = o2.getOrdem();
		
		if(this.isAscendente) {
			
			return ordem1.compareTo(ordem2);
		
		}else {
			return ordem2.compareTo(ordem1);
		}
		
	}

}
