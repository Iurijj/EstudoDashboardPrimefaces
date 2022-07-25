package estudo.grafico.cor;

import estudo.grafico.cor.enumerador.TipoCor;

public class NomeCor extends AbstractCor<NomeCor> {

	
	private String nome;
	
	
	public NomeCor(String nome) {
		this.nome = nome;
	}
	
	
	public String getNome() {
		return nome;
	}
	
	
	@Override
	public TipoCor getTipoCor() {
		return TipoCor.NOME;
	}
	
	@Override
	protected String getValorCor() {
		return this.nome;
	}
	
	
}
