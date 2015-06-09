package pp2015.team12.server.communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import pp2015.team12.server.engine.MessageHandler;
import pp2015.team12.shared.message.CharacterUpdateMsg;
import pp2015.team12.shared.message.ChatMsg;
import pp2015.team12.shared.message.LocInvMsg;
import pp2015.team12.shared.message.Message;
import pp2015.team12.shared.message.MonsterListMsg;

/**
 * class ClientConnection, which is compiled (wird angelegt) for each connecting
 * client and organizes the communication
 * 
 * @author Wirsig, Dominik
 */
public class ClientConnection extends Thread
{
	private long				time = -1;
	private Socket				clientsocket;
	private ObjectInputStream	ois;
	private ObjectOutputStream	oos;
	private int					id;
	private long				lastConnection	= System.currentTimeMillis();
	private Thread				writer;
	private Thread				isConnected;
	// unique Id for each connection
	private static int			ClientId;
	private boolean				threadOpen;
	private MessageHandler		mh;
	// Port-Number
	private int					port;
	private ServerCom			serverCom;

	/**
	 * constructor, which assigns (zuordnen) a unique ID to each
	 * Clientconnection and starts the accompanying (zugehoerig) Input- and
	 * Outputstream
	 * 
	 * @author Wirsig, Dominik
	 */
	public ClientConnection(Socket clientsocket, ServerCom serverCom)
	{
		this.serverCom = serverCom;
		this.clientsocket = clientsocket;
		this.id = ++ClientId;
		// generates Input/Output-Stream
		try
		{
			this.oos = new ObjectOutputStream(clientsocket.getOutputStream());
			System.out.println("ObjectOutputStream erzeugt");
			this.ois = new ObjectInputStream(clientsocket.getInputStream());
			System.out.println("ObjectInputStream erzeugt");
		}
		catch (IOException e)
		{
			System.out.println("Fehler beim Erzeugen des Input/Output Streams: " + e);
			return;
		}
		this.threadOpen = true;
	}

	/**
	 * method to run the thread
	 * @author Wirsig Dominik
	 */
	@Override
	public void run()
	{
		while (this.threadOpen)
		{
			try
			{
				System.out.println("Empfange Message");
				sendMessage();
//				System.out.println("Message empfangen");
			}
			catch (Exception e)
			{}
		}
		killConnection();
	}

	/**
	 * Method to send Messages to the Client 
	 * @author Wirsig, Dominik
	 */
	public void getNextMessage(Message message) throws IOException
	{
		try
		{
			this.oos.writeObject(message);
			this.oos.flush();
		}
		catch (IOException e)
		{
			System.out.println("Fehler beim Schreiben der Message " + e.toString());
		}
	}

	/**
	 * method to receive messages and send them to the server
	 * @author Wirsig, Dominik
	 */
	void sendMessage() throws ClassNotFoundException
	{
		try
		{
			Message msg;
			msg = (Message) this.ois.readObject();
			System.out.println("Message empfangen");
			if(msg != null)
				System.out.println("Monstername: " + ((MonsterListMsg) msg).getMonsterList()[0].getCharacterName());
			else
				System.out.println("Message null");
			// method from Server Engine
			this.mh.addNewMsg(msg);
		}
		catch (IOException f)
		{
			f.printStackTrace();
			this.disconnect();
		}
	}

	/**
	 * method to close the ClientSocketConnection
	 * @author Wirsig, Dominik
	 */
	protected void disconnect()
	{
		this.threadOpen = false;
	}

	/**
	 * method to check the connection of the client. If the client is 3 seconds inactive the client will be 
	 * disconnected
	 * @author Wirsig, Dominik
	 */
	public void connection()
	{
		isConnected = new Thread()
		{
			@Override
			public void run()
			{
				while (threadOpen)
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

	/**
	 * method to close the clientConnection. After 1 second the Input/OutputStream and the ClientSockets will 
	 * be closed 
	 * @author Wirsig, Dominik
	 */
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
			if (this.oos != null)
				this.oos.close();
		}
		catch (Exception e)
		{}
		try
		{
			if (this.ois != null)
				this.ois.close();
		}
		catch (Exception e)
		{}
		try
		{
			if (this.clientsocket != null)
				this.clientsocket.close();
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
		return this.ois;
	}

	public Socket getSocket()
	{
		return this.clientsocket;
	}

	public void setObjectInputStream(ObjectInputStream ois)
	{
		this.ois = ois;
	}

	public ObjectOutputStream getObjectOutputStream()
	{
		return oos;
	}

	public void setObjectOutputStream(ObjectOutputStream oos)
	{
		this.oos = oos;
	}

	int getID()
	{
		return this.id;
	}
}