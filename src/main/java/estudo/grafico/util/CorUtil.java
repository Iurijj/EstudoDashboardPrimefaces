package estudo.grafico.util;

import estudo.grafico.cor.Cor;
import estudo.grafico.cor.RGB;
import estudo.grafico.cor.RGBA;

public class CorUtil {

	private static final float DEFAULT_ALPHA = 0.3f;
	
	public static Cor<RGBA, RGB> getSkyBlue(){
		return getCor(135, 206, 235, DEFAULT_ALPHA);
	}
	
	public static Cor<RGBA, RGB> getCrimson(){
		return getCor(220, 20, 60, DEFAULT_ALPHA);
	}
	
	public static Cor<RGBA, RGB> getYellow(){
		return getCor(220, 220, 30, DEFAULT_ALPHA);
	}
	
	public static Cor<RGBA, RGB> getGreen(){
		return getCor(30, 220, 30, DEFAULT_ALPHA);
	}
	
	public static Cor<RGBA, RGB> getCor(int red, int green, int blue, float alpha){
		
		RGBA rgba = new RGBA(red, green, blue, alpha);
		RGB rgb = new RGB(red, green, blue);
		
		return new Cor<RGBA, RGB>(rgba, rgb);
		
	}
	
	public static String obterCorFundo(Cor<?, ?> corTO) {
		
		if(corTO == null || corTO.getCorFundo() == null) {
			return "";
		}
		
		return corTO.getCorFundo().getCor();
	
	}
	
	public static String obterCorBorda(Cor<?, ?> corTO) {
		
		if(corTO == null || corTO.getCorBorda() == null) {
			return "";
		}
		
		return corTO.getCorBorda().getCor();
	
	}
	
	
}
