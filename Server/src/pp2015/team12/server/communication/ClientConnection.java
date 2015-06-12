package pp2015.team12.server.communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import pp2015.team12.server.engine.MessageHandler;
import pp2015.team12.shared.communication.ReceiveThread;
import pp2015.team12.shared.communication.SendThread;
import pp2015.team12.shared.message.ChatMsg;
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
	private Thread	sendMessage;
	private Thread	receiveMessage;
	private List<Message> outgoingMessages = new ArrayList<Message>();

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
		this.startReceiving();
		this.startSending();
		
	}

	public void sendMessage(Message paramMessage)
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
			System.out.println(((ChatMsg) currentMessage).getContent());
//			this.serverCom.addIncomingMessage(currentMessage);
		else
			System.out.println("Message null");
		// method from Server Engine
	}
	
	private void startReceiving()
	{
		System.out.println("Server: start receiving");
		receiveMessage = new Thread()
		{
			@Override
			public void run()
			{
				while (connectionEstablished)
				{
					try
					{
						receiveMessage();
					}
					catch(ReflectiveOperationException excep)
					{
						excep.printStackTrace();
					}
				}
				killConnection();
			}
		};
		this.receiveMessage.start();
	}
	
	private void startSending()
	{
		System.out.println("Server: start sending");
		receiveMessage = new Thread()
		{
			@Override
			public void run()
			{
				while (connectionEstablished)
				{
					//TODO entferne testMsg
					Message currentMessage =  new ChatMsg("Server: Ich bin noch da", -1);;
					System.out.println("Server: erzeuge neue Msg");
					if(outgoingMessages.size() > 0)
					{
						currentMessage = outgoingMessages.get(0);
					}
//					else
//						currentMessage = null;
					
					if(currentMessage != null)
					{
						sendMessage(currentMessage);
					}
					try 
					{
						Thread.sleep(1000);
					} 
					catch (InterruptedException e) 
					{
						e.printStackTrace();
					}
				}
			}
		};
		this.receiveMessage.start();
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