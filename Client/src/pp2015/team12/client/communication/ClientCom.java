package pp2015.team12.client.communication;

import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

import pp2015.team12.client.ClientCommunication;
import pp2015.team12.shared.communication.ReceiveThread;
import pp2015.team12.shared.communication.SendThread;
import pp2015.team12.shared.message.ChatMsg;
import pp2015.team12.shared.message.LogoutReplyMsg;
import pp2015.team12.shared.message.Message;

/**
 * class ClientCom, processes the communication with the clients - send and
 * receive Messages - login/logout from the server - start a connection to the
 * server -leveldaten empfangen - logout -inkrementelle updates empfangen
 * -"ich bin noch da" nachrichten
 * 
 * @author Wirsig, Dominik
 */

public class ClientCom
{
	private ClientCommunication	clientMessageHandler;
	private Thread	sendMessage;
	private Thread	receiveMessage;
	private List<Message> outgoingMessages = new ArrayList<Message>();
	// Port und IP-String
	private int	port = 6012;
	// private String ip = "proglab.informatik.uni-koeln.de";
	private String ip = "localhost";
	// socket for the connection to the server
	private Socket serversocket	= null;
	private SendThread sendThread;
	private ReceiveThread receiveThread;
	private long pingTimer;
	private boolean connectionEstablished = false;

	public ClientCom(ClientCommunication cC)
	{
		this.clientMessageHandler = cC;
		if (connect())
		{
			System.out.println("Verbindung hergestellt" );
			this.connectionEstablished = true;
			this.startSendingMessage();
			this.startReceiving();
		}
		else
			System.out.println("Verbindung fehlgeschlagen");
	}

	/**
	 * connect() checks if a connection can be started to the server. If so the Input- and OutputStream starts
	 * in a Thread which waits for new Messages. returns true 
	 * @author Wirsig, Dominik
	 */

	public boolean connect()
	{
		// make a connection to the server
		try
		{
			serversocket = new Socket(ip, port);
		}
		catch (Exception ec)
		{
			System.out.println("Fehler bei der Verbindung zum Server:" + ec);
			return false;
		}
		// generate Input/Output-Stream
		try
		{
			this.sendThread = new SendThread(this.serversocket);
			this.receiveThread = new ReceiveThread(this.serversocket);
		}
		catch (IOException e)
		{
			System.out.println("Fehler beim Erzeugen des Input/Output Streams: " + e);
			return false;
		}
		return true;
	}

	public void sendMessage(Message paramMessage)
	{
		try
		{
			this.sendThread.sendMessage(paramMessage);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void getNextMessage()
	{
		try
		{
			Message currentMessage = this.receiveThread.getNextMessage();
			System.out.println("Message empfangen");
			if(currentMessage != null)
			{	
				if(currentMessage instanceof LogoutReplyMsg)
					this.disconnect();
				System.out.println(((ChatMsg) currentMessage).getContent());
//				clientMessageHandler.receiveMessage(currentMessage);
			}
			else
				System.out.println("Message null");
		}
		catch(ClassNotFoundException | IOException excep)
		{}
	}

	private void startSendingMessage()
	{
		System.out.println("Client: start sending");
		sendMessage = new Thread()
		{
			@Override
			public void run()
			{
				Message pingMsg = new ChatMsg("Client: Ich bin noch da", -1);
				Message currentMessage = pingMsg;
				while (true)
				{
					if(outgoingMessages.size() > 0)
					{
						currentMessage = outgoingMessages.get(0);
					}
					else if((System.currentTimeMillis() - pingTimer) >= 2000)
						currentMessage = pingMsg;
					else
						currentMessage = null;
					
					if(currentMessage != null)
					{
						sendMessage(currentMessage);
						pingTimer = System.currentTimeMillis();
					}
				}
			}
		};
		this.sendMessage.start();
	}
	
	private void startReceiving()
	{
		System.out.println("Client: start receiving");
		receiveMessage = new Thread()
		{
			@Override
			public void run()
			{
				while(connectionEstablished)
					getNextMessage();
			}
		};
		this.receiveMessage.start();
	}

	private void disconnect()
	{
		// try to close the connection 
		this.sendMessage.interrupt();
		this.receiveMessage.interrupt();
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
			if (this.serversocket != null)
				serversocket.close();
		}
		catch (IOException ioE)
		{}
	}

	public void addOutgoingMsg(Message paramMessage)
	{
		this.outgoingMessages.add(paramMessage);
	}
}