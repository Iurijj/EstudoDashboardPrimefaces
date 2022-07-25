package estudo.grafico.util;

public class StringUtil {
	
	public static boolean isVazio(String valor) {
		return ((valor == null)? true : valor.trim().isEmpty());
	}

}
