package pp2015.team12.shared.communication;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import pp2015.team12.shared.message.Message;

public class SendThread 
{
	private ObjectOutputStream outputStream;
	
	public SendThread(Socket paramClientSocket) throws IOException
	{
		this.outputStream = new ObjectOutputStream(paramClientSocket.getOutputStream());
		System.out.println("ObjectOutputStream erzeugt");
	}
	
	public void sendMessage(Message paramMessage) throws IOException
	{
		this.outputStream.writeObject(paramMessage);
		this.outputStream.flush();
	}
}
