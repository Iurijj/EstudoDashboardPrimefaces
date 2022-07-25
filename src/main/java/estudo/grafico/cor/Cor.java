package estudo.grafico.cor;


public class Cor<F extends AbstractCor<F> , B extends AbstractCor<B>> {

	
	private F corFundo;
	private B corBorda;

	
	public Cor() {}

	public Cor(F corFundo, B corBorda) {

		this.corFundo = corFundo;
		this.corBorda = corBorda;
	
	}

	
	public F getCorFundo() {
		return corFundo;
	}
	
	public void setCorFundo(F corFundo) {
		this.corFundo = corFundo;
	}
	
	public B getCorBorda() {
		return corBorda;
	}
	
	public void setCorBorda(B corBorda) {
		this.corBorda = corBorda;
	}
	
	
}
