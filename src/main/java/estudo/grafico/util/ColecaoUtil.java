package estudo.grafico.util;

import java.util.List;
import java.util.Set;

public class ColecaoUtil {
	
	public static <T> boolean isVazio(List<T> lista) {
		return ((lista == null)? true : lista.isEmpty());
	}
	
	public static <T> boolean isVazio(Set<T> lista) {
		return ((lista == null)? true : lista.isEmpty());
	}

}
