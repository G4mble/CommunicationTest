package pp2015.team12.shared.message;

@SuppressWarnings("serial")
public class ErrorMsg extends Message {
	private String note;
		public ErrorMsg (String note){
			this.note= note;
		}
		public String getNote() {
			return note;
		}
		
}
