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
	private Thread	connectionCorrect;
	private List<Message> incomingMessages = new ArrayList<Message>();
	private List<Message> outgoingMessages = new ArrayList<Message>();
	// Port und IP-String
	private int	port = 6012;
	// private String ip = "proglab.informatik.uni-koeln.de";
	private String ip = "localhost";
	// socket for the connection to the server
	private Socket serversocket	= null;
	// OutputStream
	private static ObjectOutputStream oos = null;
	// InputStream
	private static ObjectInputStream ois = null;

	public ClientCom(ClientCommunication cC)
	{
		this.cC = cC;
		if (connect())
		{
			System.out.println("Verbindung hergestellt" );
			this.connection();
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
			ois = new ObjectInputStream(serversocket.getInputStream());
			oos = new ObjectOutputStream(serversocket.getOutputStream());
		}
		catch (IOException eIO)
		{
			System.out
					.println("Fehler beim Erzeugen des Input/Output Streams: "
							+ eIO);
			return false;
		}
		// if connected return true
		return true;
	}

	/**
	 * method to send Messages to the server
	 * @author Wirsig, Dominik
	 */
	public void getNextMessage(Message message)
	{
		try
		{
			System.out.println("versuche message zu senden");
			oos.writeObject(message);
			oos.flush();
			System.out.println("message gesendet");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * method to receive messages and send them to the client
	 * @author Wirsig, Dominik
	 */
	public void sendMessage() throws ClassNotFoundException
	{
		try
		{
			Message msgOut = (Message) ois.readObject();
			cC.receiveMessage(msgOut);
		}
		catch (IOException f)
		{}
	}

	/**
	 * method to start a thread for "Ich bin noch da"-messages
	 * @author Wirsig, Dominik
	 */
	private void connection()
	{
		connectionCorrect = new Thread()
		{
			@Override
			public void run()
			{
				while (true)
				{
					try
					{
						Thread.sleep(400);
						Monster[] monsterList = {new Monster_Tank(1,"testMonster", 1, 2, "af", 12, 23, 1)};
						System.out.println("erzeuge monster");
						System.out.println("sende monster");
						getNextMessage(new MonsterListMsg(monsterList, -1));
						System.out.println("monster ist gesendet");
						//TODO send ich bin noch da
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
					// Message connected = new Message(7);
					// getNextMessage(connected);
				}
			}
		};
		this.connectionCorrect.start();
	}

	/**
	 * method to finish the clientConnection. Thread stops after 5 seconds for possible incoming messages.
	 * @author Wirsig, Dominik
	 */
	private void disconnect()
	{
		// try to close the connection 
		long tempTime = System.currentTimeMillis();
		while (System.currentTimeMillis() - tempTime < 5000)
		{
			// TODO do something
		}
		try
		{
			if (oos != null)
				oos.close();
		}
		catch (Exception e)
		{}
		try
		{
			if (ois != null)
				ois.close();
		}
		catch (Exception e)
		{}
		try
		{
			if (serversocket != null)
				serversocket.close();
		}
		catch (Exception e)
		{}
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
}