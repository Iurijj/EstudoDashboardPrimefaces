package estudo.grafico.cor;

import estudo.grafico.cor.enumerador.TipoCor;

public class RGBA extends AbstractCor<RGBA> {

	
	private static final String TEMPLATE_RGBA = "%s, %s, %s, %s";
	
	
	private int red;
	private int green;
	private int blue;
	private float alpha;

	
	public RGBA(int red, int green, int blue, float a) {
	
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.alpha = a;
	
	}
	
	
	public int getRed() {
		return red;
	}

	public int getGreen() {
		return green;
	}

	public int getBlue() {
		return blue;
	}
	
	public float getAlpha() {
		return alpha;
	}
	
	
	@Override
	public TipoCor getTipoCor() {
		return TipoCor.RGBA;
	}
	
	@Override
	protected String getValorCor() {
		return String.format(TEMPLATE_RGBA, this.red, this.green, this.blue, this.alpha);
	}
	
	
}
