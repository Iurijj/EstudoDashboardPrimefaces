package estudo.grafico.domain.service;

import estudo.grafico.infra.enumerador.TipoConjuntoGrafico;

public interface FactoryConjuntoDadosGraficoService {

	ConjuntoDadosGraficoService<?> obterConjuntoDadosService(TipoConjuntoGrafico tipoConjunto);
	
}
