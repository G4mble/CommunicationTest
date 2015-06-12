package pp2015.team12.shared.communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

import pp2015.team12.shared.message.Message;

public class ReceiveThread 
{
	private ObjectInputStream inputStream;
	
	public ReceiveThread(Socket paramSocket) throws IOException
	{
		this.inputStream = new ObjectInputStream(paramSocket.getInputStream());
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
		catch(SocketTimeoutException stE)
		{
			System.out.println("SocketTimeoutException: disconnect client");
		}
		catch (ClassNotFoundException | IOException excep)
		{
			excep.printStackTrace();
		}
		return null;
	}
}