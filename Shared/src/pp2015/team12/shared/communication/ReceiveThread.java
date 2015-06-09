package pp2015.team12.shared.communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import pp2015.team12.shared.message.Message;

public class ReceiveThread 
{
	private ObjectInputStream inputStream;
	
	public ReceiveThread(Socket paramClientSocket) throws IOException
	{
		this.inputStream = new ObjectInputStream(paramClientSocket.getInputStream());
		System.out.println("ObjectOutputStream erzeugt");

	}
	
	public Message getNextMessage()
	{
		try 
		{
			Object currentMessage = this.inputStream.readObject();
			if(currentMessage != null)
				return (Message) currentMessage;
		}
		catch (ClassNotFoundException | IOException excep)
		{
			excep.printStackTrace();
		}
		return null;
	}
}