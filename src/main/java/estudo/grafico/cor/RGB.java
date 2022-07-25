package estudo.grafico.cor;

import estudo.grafico.cor.enumerador.TipoCor;

public class RGB extends AbstractCor<RGB> {

	private static final String TEMPLATE_RGB = "%s, %s, %s";

	private int red;
	private int green;
	private int blue;

	public RGB(int red, int green, int blue) {

		this.red = red;
		this.green = green;
		this.blue = blue;

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

	@Override
	public TipoCor getTipoCor() {
		return TipoCor.RGB;
	}

	@Override
	protected String getValorCor() {
		return String.format(TEMPLATE_RGB, this.red, this.green, this.blue);
	}

}