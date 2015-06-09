package pp2015.team12.shared.message;
/**
 * 
 * @author Heusser, Caspar
 *
 */
@SuppressWarnings("serial")
public class ChatMsg extends Message {
	private String content;
	private String submitter;
	private String receiver;
	int type = 0;						// 0 = global 1=level 2= whisper
	/**
	 * @author Heusser, Caspar
	 * @param content
	 * @param clientId
	 */
	public ChatMsg(String content, int clientId, String submitter, String receiver) {  
		super(clientId);
		this.content=content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setSubmitter(String submitter) {
		this.submitter = submitter;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public void setType(int type) {
		this.type = type;
	}
	public ChatMsg(String content, int submitterID) {  
		super(submitterID);
		this.content=content;
	}
	public ChatMsg(String content, int submitterID, String submitter, String receiver, int type) {  
		super(submitterID);
		this.content=content;
	}
	/**
	 * @author Heusser, Caspar
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	public String getSubmitter() {
		return submitter;
	}
	public String getReceiver() {
		return receiver;
	}
	
}
