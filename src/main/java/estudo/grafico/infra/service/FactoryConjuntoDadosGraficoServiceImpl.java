package estudo.grafico.infra.service;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import estudo.grafico.domain.service.ConjuntoDadosGraficoService;
import estudo.grafico.domain.service.FactoryConjuntoDadosGraficoService;
import estudo.grafico.infra.enumerador.TipoConjuntoGrafico;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class FactoryConjuntoDadosGraficoServiceImpl implements FactoryConjuntoDadosGraficoService {

	@Inject
	@Any
	private Instance<ConjuntoDadosGraficoService<?>> conjuntos;
	
	@Override
	public ConjuntoDadosGraficoService<?> obterConjuntoDadosService(TipoConjuntoGrafico tipoConjunto) {

		for (ConjuntoDadosGraficoService<?> conjunto : this.conjuntos) {
			
			if(conjunto.getTipoGrafico() == tipoConjunto) {
				return conjunto;
			}
			
		}
		
		throw new IllegalArgumentException(String.format("O tipo conjunto %s não existe", tipoConjunto.getDescricao()));
		
	}

}
