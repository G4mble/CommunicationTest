package pp2015.team12.client.communication;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import pp2015.team12.client.ClientCommunication;
import pp2015.team12.shared.InventoryModel;
import pp2015.team12.shared.character.Mage;
import pp2015.team12.shared.character.Monster;
import pp2015.team12.shared.character.Monster_Tank;
import pp2015.team12.shared.communication.ReceiveThread;
import pp2015.team12.shared.communication.SendThread;
import pp2015.team12.shared.message.CharacterUpdateMsg;
import pp2015.team12.shared.message.ChatMsg;
import pp2015.team12.shared.message.LocInvMsg;
import pp2015.team12.shared.message.Message;
import pp2015.team12.shared.message.MonsterListMsg;

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
	private ClientCommunication	cC;
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
		this.cC = cC;
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
		// if connected return true
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
		Message currentMessage = this.receiveThread.getNextMessage();
		System.out.println("Message empfangen");
		if(currentMessage != null)
			System.out.println(((ChatMsg) currentMessage).getContent());
//			cC.receiveMessage(currentMessage);
		else
			System.out.println("Message null");
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

	/**
	 * method to finish the clientConnection. Thread stops after 5 seconds for possible incoming messages.
	 * @author Wirsig, Dominik
	 */
	private void disconnect()
	{
//		// try to close the connection 
//		long tempTime = System.currentTimeMillis();
//		while (System.currentTimeMillis() - tempTime < 5000)
//		{
//			// TODO do something
//		}
//		try
//		{
//			if (oos != null)
//				oos.close();
//		}
//		catch (Exception e)
//		{}
//		try
//		{
//			if (ois != null)
//				ois.close();
//		}
//		catch (Exception e)
//		{}
//		try
//		{
//			if (serversocket != null)
//				serversocket.close();
//		}
//		catch (Exception e)
//		{}
	}

	public int getPort()
	{
		return this.port;
	}

	public void setPort(int port)
	{
		this.port = port;
	}

	public String getIp()
	{
		return this.ip;
	}

	public void setIp(String ip)
	{
		this.ip = ip;
	}
	
	public void addOutgoingMsg(Message paramMessage)
	{
		this.outgoingMessages.add(paramMessage);
	}
}