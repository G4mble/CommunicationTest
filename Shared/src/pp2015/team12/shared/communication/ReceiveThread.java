package pp2015.team12.shared.communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

import pp2015.team12.shared.message.Message;

public class ReceiveThread 
{
	private ObjectInputStream inputStream;
	
	public ReceiveThread(Socket paramClientSocket) throws IOException
	{
		this.inputStream = new ObjectInputStream(paramClientSocket.getInputStream());
		System.out.println("ObjectOutputStream erzeugt");

	}
	
	public Message getNextMessage() throws ClassNotFoundException, SocketTimeoutException, IOException
	{
		Object currentMessage = this.inputStream.readObject();
		if(currentMessage != null)
			return (Message) currentMessage;
		return null;
	}
	
	public void close() throws IOException
	{
		this.inputStream.close();
	}
}