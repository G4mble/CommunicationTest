package pp2015.team12.server.communication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import pp2015.team12.shared.message.Message;


public class ServerCom
{
	private ArrayList<ClientConnection>	clientList = new ArrayList<>();
	private boolean	serverIsOpen = false;
	private final int SERVER_PORT = 6012;
	private ArrayList<Message> incomingMessages = new ArrayList<Message>();
	private ArrayList<Message> outgoingMessages = new ArrayList<Message>();

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
				
				Socket clientSocket = serverSocket.accept();
				
				//TODO catch exception from ServerSocket.accept()

				System.out.println("Client baut Verbindung auf..." + clientSocket.getPort());
				
				// if we have to stop
				if (!serverIsOpen)
				{
					System.out.println("Server geschlossen!");
					break;
				}
				
				// generate thread for the connection
				System.out.println("Erzeuge Thread fuer Client-Verbindung...");
				clientSocket.setSoTimeout(60000);
				ClientConnection client = new ClientConnection(clientSocket, this);
				
				// save the connection in the array
				this.clientList.add(client);
				
				// Start Client
				System.out.println("Starte Client Verbindung...");
				client.start();
			}
			// when cancellation, close all clients
			try
			{
				serverSocket.close();
				for (int i = 0; i < clientList.size(); ++i)
				{
					ClientConnection tempClient = clientList.get(i);
					try
					{
						tempClient.getObjectInputStream().close();
						tempClient.getObjectOutputStream().close();
						tempClient.getSocket().close();
					}
					catch (IOException ioE)
					{}
				}
			}
			catch (Exception e)
			{
				System.out.println("Fehler beim Schliessen der Server und Clients: " + e);
			}
		}
		// if there is a incorrect connection
		catch (IOException e)
		{
			System.out.println("Fehler beim neuen ServerSocket: " + e);
		}
	}

	public void stopSever()
	{
		serverIsOpen = false;
	}

	synchronized void remove(int id)
	{
		clientList.set(id - 1, null);
	}
	
	public synchronized void addIncomingMessage(Message paramMessage)
	{
		this.incomingMessages.add(paramMessage);
	}
}