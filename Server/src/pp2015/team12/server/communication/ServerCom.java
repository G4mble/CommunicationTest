package pp2015.team12.server.communication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import pp2015.team12.server.engine.MessageHandler;
import pp2015.team12.shared.character.DummyCharacter;
import pp2015.team12.shared.character.PlayerCharacter;
import pp2015.team12.shared.message.Message;


public class ServerCom
{
	private static ServerCom currentServerCom = null;
	private boolean	serverIsOpen;
	private final int SERVER_PORT;
	private ArrayList<Message> outgoingMessages;
	private ArrayList<ClientConnection>	clientList;
	private int clientCount;
	private PlayerCharacter playerList[];
	private Thread broadcastThread;
	private MessageHandler se1_messageHandler;

	private ServerCom(MessageHandler paramSe1_messageHandler)
	{
		this.se1_messageHandler = paramSe1_messageHandler;
		this.SERVER_PORT = 6012;
		this.outgoingMessages = new ArrayList<Message>();
		this.clientList = new ArrayList<>();
		this.clientCount = 0;
		this.serverIsOpen = false;
		this.playerList = new PlayerCharacter[11];
		this.playerList[0] = new DummyCharacter();
		
		this.startMessageBroadcast();
		this.start();
	}
	
	public static ServerCom getInstance(MessageHandler paramSe1_messageHandler)
	{
		if(ServerCom.currentServerCom == null)
			ServerCom.currentServerCom = new ServerCom(paramSe1_messageHandler);
		return ServerCom.currentServerCom;
	}
	
	public void start()
	{
		try
		{
			// create new ServerSocket with given port
			ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
			this.serverIsOpen = true;
			System.out.println("ServerSocket erzeugt an Port: " + SERVER_PORT);
			
			// endless loop waiting for clients to connect
			while(this.serverIsOpen)
			{
				System.out.println("Warte auf eingehende Client-Verbindung...");
				
				Socket clientSocket = null;
				try
				{
					clientSocket = serverSocket.accept();
				}
				catch(SecurityException | IOException excep)
				{
					excep.printStackTrace();
				}
				
				System.out.println("Client baut Verbindung auf..." + clientSocket.getPort());
				
				// if we have to stop
				if (!serverIsOpen)
				{
					System.out.println("Server geschlossen!");
					break;
				}
				
				// set SoTimeout for clientSocket
				System.out.println("Erzeuge Thread fuer Client-Verbindung...");
				clientSocket.setSoTimeout(60000);

				int tmpClientID = this.findFreeServerSlot();
				if(tmpClientID != -1)
				{
					ClientConnection client = new ClientConnection(clientSocket, this, tmpClientID, this.se1_messageHandler);
					this.clientList.add(client);
				}
			}
			// when cancellation, close all clients
			try
			{
				serverSocket.close();
				for (int i = 0; i < clientList.size(); ++i)
				{
					ClientConnection currentClient = clientList.get(i);
					try
					{
						currentClient.closeInputStream();
						currentClient.closeOutputStream();
						currentClient.getSocket().close();
					}
					catch (IOException ioE)
					{
						ioE.printStackTrace();
					}
				}
			}
			catch (IOException ioE)
			{
				System.out.println("Fehler beim Schliessen der Server und Clients: " + ioE);
			}
		}
		// if there is an incorrect connection
		catch (IOException e)
		{
			System.out.println("Fehler beim neuen ServerSocket: " + e);
		}
	}
	
	private synchronized ClientConnection findReceiverConnectionByClientID(int paramClientID)
	{
		for(int i = 0; i < this.clientList.size(); i++)
			if(clientList.get(i).getClientID() == paramClientID)
				return clientList.get(i);
		return null;
	}
	
	private void startMessageBroadcast()
	{
		this.broadcastThread = new Thread()
		{
			@Override
			public void run()
			{
				Message currentMessage;
				while(true)
				{
					if(outgoingMessages.size() > 0)
					{
						currentMessage = (Message) outgoingMessages.get(0);
						ClientConnection receiverConnection = findReceiverConnectionByClientID(currentMessage.getClientId());
						if(receiverConnection != null)
							receiverConnection.addOutgoingMessage(currentMessage);
					}
				}
			}
		};
		this.broadcastThread.start();
	}

	private synchronized int findFreeServerSlot()
	{
		if (this.clientCount == 10)
		{
			System.out.println("Der Server ist voll");
			return -1;
		} 
		else
		{
			for(int i = 0; i < playerList.length; i++)
				if (playerList[i] == null)
				{
					playerList[i] = new DummyCharacter();
					clientCount++;
					return i;
				}
		}
		return -1;
	}
	
	public synchronized void remove(int paramClientID)
	{
		clientList.remove((paramClientID - 1));
		this.playerList[paramClientID] = null;
	}
	
	public synchronized void addOutgointMessage(Message paramMessage)
	{
		this.outgoingMessages.add(paramMessage);
	}
}