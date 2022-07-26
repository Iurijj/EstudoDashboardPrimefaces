package estudo.grafico.cor;

import estudo.grafico.cor.enumerador.TipoCor;

public class HSL extends AbstractCor<HSL> {

	
	private static final String TEMPLATE_HSL = "%sdeg, %s%%, %s%%";
	
	
	private int hue;
	private int saturation;
	private int lightness;

	
	public HSL(int hue, int saturation, int lightness) {
		
		this.hue = hue;
		this.saturation = saturation;
		this.lightness = lightness;
	
	}


	public int getHue() {
		return hue;
	}

	public int getSaturation() {
		return saturation;
	}

	public int getLightness() {
		return lightness;
	}

	
	@Override
	public TipoCor getTipoCor() {
		return TipoCor.HSL;
	}
	
	@Override
	protected String getValorCor() {
		return String.format(TEMPLATE_HSL, this.hue, this.saturation, this.lightness);
	}
	
	
}
