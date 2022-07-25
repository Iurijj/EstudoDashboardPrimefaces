package estudo.grafico.cor;

import estudo.grafico.cor.enumerador.TipoCor;

public abstract class AbstractCor<T> {

	public abstract TipoCor getTipoCor();
	
	protected abstract String getValorCor();
	
	public String getCor() {
		return String.format(this.getTipoCor().getSintaxe(), this.getValorCor());
	}
	
}
