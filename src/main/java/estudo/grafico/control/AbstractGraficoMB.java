package estudo.grafico.control;

import estudo.control.ConversationMB;

public abstract class AbstractGraficoMB extends ConversationMB {

	private static final long serialVersionUID = 1L;

	public abstract String getNomeGrafico();
	
	public void init() {
		
		if(this.getConversation().getId() == null) {
			this.iniciarConversation();
		}
		
	}
	
}
