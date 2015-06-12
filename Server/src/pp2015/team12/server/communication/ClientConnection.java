package pp2015.team12.server.communication;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

import pp2015.team12.server.engine.MessageHandler;
import pp2015.team12.shared.communication.ReceiveThread;
import pp2015.team12.shared.communication.SendThread;
import pp2015.team12.shared.message.ChatMsg;
import pp2015.team12.shared.message.Message;

public class ClientConnection extends Thread
{
	private Socket clientSocket;
	private boolean connectionEstablished;
	private MessageHandler se1_messageHandler;
	private ServerCom serverCom;
	private SendThread sendThread;
	private ReceiveThread receiveThread;
	private Thread	sendMessage;
	private Thread	receiveMessage;
	private List<Message> outgoingMessages = new ArrayList<Message>();
	private int clientID;

	public ClientConnection(Socket paramClientSocket, ServerCom paramServerCom, int paramClientID, MessageHandler paramSe1_messageHandler)
	{
		this.serverCom = paramServerCom;
		this.se1_messageHandler = paramSe1_messageHandler;
		this.clientSocket = paramClientSocket;
		this.clientID = paramClientID;
//TODO change ChatMsg to UpdateClientID		
		this.outgoingMessages.add(new ChatMsg("UpdateClientID", -1));
		
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
		try
		{
			Message currentMessage = this.receiveThread.getNextMessage();
			System.out.println("Message empfangen");
			if(currentMessage != null)
				System.out.println(((ChatMsg) currentMessage).getContent());
//				this.se_I_MessageHandler.addNewMsg(currentMessage);
			else
				System.out.println("Message null");
		}
		catch(SocketTimeoutException stE)
		{
			this.disconnect();
		}
		catch(ClassNotFoundException | IOException excep)
		{}
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
		sendMessage = new Thread()
		{
			@Override
			public void run()
			{
				Message currentMessage =  null;
				while (connectionEstablished)
				{
					if(outgoingMessages.size() > 0)
						currentMessage = outgoingMessages.get(0);
					else
						currentMessage = null;
					
					if(currentMessage != null)
					{
						sendMessage(currentMessage);
					}
					//TODO thread.sleep entfernen
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
		this.sendMessage.start();
	}

	protected void disconnect()
	{
		this.connectionEstablished = false;
	}


	private void killConnection()
	{
		this.sendMessage.interrupt();
		this.receiveMessage.interrupt();
		this.serverCom.remove(this.clientID);

		try
		{
			if (this.sendThread != null)
				this.sendThread.close();
		}
		catch (IOException ioE)
		{}
		try
		{
			if (this.receiveThread != null)
				this.receiveThread.close();
		}
		catch (IOException ioE)
		{}
		try
		{
			if (this.clientSocket != null)
				this.clientSocket.close();
		}
		catch (IOException ioE)
		{}
		
		System.out.println("Client geschlossen!");
	}

	public synchronized Socket getSocket()
	{
		return this.clientSocket;
	}

	public synchronized int getClientID()
	{
		return this.clientID;
	}
	
	public void closeInputStream() throws IOException
	{
		this.receiveThread.close();
	}
	
	public void closeOutputStream() throws IOException
	{
		this.sendThread.close();
	}
	
	public synchronized void addOutgoingMessage(Message paramMessage)
	{
		this.outgoingMessages.add(paramMessage);
	}
}