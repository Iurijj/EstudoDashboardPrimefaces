package estudo.grafico.cor;

import estudo.grafico.cor.enumerador.TipoCor;

public class HEX extends AbstractCor<HEX> {

	
	private String hex;
	
	
	public HEX(String hex) {
		this.hex = hex;
	}
	
	
	public String getHex() {
		return hex;
	}
	
	
	@Override
	public TipoCor getTipoCor() {
		return TipoCor.HEX;
	}
	
	@Override
	protected String getValorCor() {
		return this.hex;
	}
	
	
}
