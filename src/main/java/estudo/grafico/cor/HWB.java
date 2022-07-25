package estudo.grafico.cor;

import estudo.grafico.cor.enumerador.TipoCor;

public class HWB extends AbstractCor<HWB> {

	
	private static final String TEMPLATE_HWB = "HWB(%s, %s%%, %s%%)";
	
	
	private int hue;
	private int whiteness;
	private int blackness;

	
	public HWB(int hue, int whiteness, int blackness) {
	
		this.hue = hue;
		this.whiteness = whiteness;
		this.blackness = blackness;
	
	}
	
	
	public int getHue() {
		return hue;
	}
	
	public int getWhiteness() {
		return whiteness;
	}
	
	public int getBlackness() {
		return blackness;
	}
	
	
	@Override
	public TipoCor getTipoCor() {
		return TipoCor.HWB;
	}
	
	@Override
	protected String getValorCor() {
		return String.format(TEMPLATE_HWB, this.hue, this.whiteness, this.blackness);
	}
	
	
}
