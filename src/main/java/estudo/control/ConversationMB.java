package estudo.control;

import java.io.Serializable;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;

@ConversationScoped
public abstract class ConversationMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject private Conversation conversation;
	
	public void iniciarConversation() {
		
		if (this.conversation.isTransient()) {
			
			this.conversation.begin();
			this.conversation.setTimeout((1000*60)*30);
		
		}
		
	}
	
	public void finalizarConversation() {
		
		if(!this.conversation.isTransient()) {
			this.conversation.end();
		}
		
	}
	
	public String getIdConversation() {
		return this.conversation.getId();
	}
	
	public Conversation getConversation() {
		return this.conversation;
	}
	
}
