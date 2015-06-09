package pp2015.team12.server.communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import pp2015.team12.server.engine.MessageHandler;
import pp2015.team12.shared.communication.ReceiveThread;
import pp2015.team12.shared.communication.SendThread;
import pp2015.team12.shared.message.Message;

public class ClientConnection extends Thread
{
	private Socket clientSocket;
	private int id;
	private long lastConnection	= System.currentTimeMillis();
	private Thread isConnected;
	private static int ClientId;
	private boolean connectionEstablished;
	private MessageHandler mh;
	private ServerCom serverCom;
	private SendThread sendThread;
	private ReceiveThread receiveThread;

	public ClientConnection(Socket paramClientSocket, ServerCom serverCom)
	{
		this.serverCom = serverCom;
		this.clientSocket = paramClientSocket;
		this.id = ++ClientConnection.ClientId;
		// generates Input/Output-Stream
		try
		{
			this.sendThread = new SendThread(this.clientSocket);
			this.receiveThread = new ReceiveThread(this.clientSocket);
		}
		catch (IOException e)
		{
			System.out.println("Fehler beim Erzeugen des Input/Output Streams: " + e);
			return;
		}
		this.connectionEstablished = true;
	}

	@Override
	public void run()
	{
		while (this.connectionEstablished)
		{
			try
			{
				System.out.println("Server: Empfange Message");
				this.receiveMessage();
				System.out.println("Server: Message empfangen");
			}
			catch(ReflectiveOperationException excep)
			{
				excep.printStackTrace();
			}
		}
		killConnection();
	}

	public void sendMessage(Message paramMessage) throws IOException
	{
		try
		{
			this.sendThread.sendMessage(paramMessage);
		}
		catch (IOException ioE)
		{
			ioE.printStackTrace();
		}
	}

	void receiveMessage() throws ClassNotFoundException
	{
		Message currentMessage = this.receiveThread.getNextMessage();
		System.out.println("Message empfangen");
		if(currentMessage != null)
			this.serverCom.addIncomingMessage(currentMessage);
		else
			System.out.println("Message null");
		// method from Server Engine
	}

	protected void disconnect()
	{
		this.connectionEstablished = false;
	}

	public void connection()
	{
		isConnected = new Thread()
		{
			@Override
			public void run()
			{
				while (connectionEstablished)
				{
					if (System.currentTimeMillis() - lastConnection < 3000)
					{
						try
						{
							Thread.sleep(500);
							lastConnection = System.currentTimeMillis();
						}
						catch (InterruptedException e)
						{
							e.printStackTrace();
						}
					}
					else
					{
						System.out.println("DISCONNECT");
						disconnect();
					}
				}
			}
		};
		this.isConnected.start();
	}

	private void killConnection()
	{
		long tempTime = System.currentTimeMillis();
		while (System.currentTimeMillis() - tempTime < 1000)
		{
			//TODO something
		}
		// try to cloce the connection
		try
		{
//			if (this.oos != null)
//				this.oos.close();
		}
		catch (Exception e)
		{}
		try
		{
//			if (this.ois != null)
//				this.ois.close();
		}
		catch (Exception e)
		{}
		try
		{
			if (this.clientSocket != null)
				this.clientSocket.close();
		}
		catch (Exception e)
		{}
		
//		this.writer.interrupt();
//		this.isConnected.interrupt();
		this.serverCom.remove(this.id);
		System.out.println("Client geschlossen!");
	}

	public ObjectInputStream getObjectInputStream()
	{
//		return this.ois;
		return null;
	}

	public Socket getSocket()
	{
		return this.clientSocket;
	}

	public void setObjectInputStream(ObjectInputStream ois)
	{
//		this.ois = ois;
	}

	public ObjectOutputStream getObjectOutputStream()
	{
//		return oos;
		return null;
	}

	public void setObjectOutputStream(ObjectOutputStream oos)
	{
//		this.oos = oos;
	}

	int getID()
	{
		return this.id;
	}
}