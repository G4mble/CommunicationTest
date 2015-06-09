package pp2015.team12.server.communication;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.io.*;

import pp2015.team12.server.engine.MessageHandler;

public class ServerCom
{
	// Array-List for all clients
	private ArrayList<ClientConnection>	socketlist = new ArrayList<>();
	// Boolean, wich keeps the Server open
	private boolean	serverOpen;
	// Port und IP-String
	private int	port = 6012;

	/**
	 * method, which starts the Servercommunication. ServerSocket is generated
	 * and waits (in endless-loop) for a comming ClientConnection which are used
	 * in an unique Thread
	 * 
	 * @author Wirsig, Dominik
	 */
	public void start()
	{
		// ServerSocket is generated and waits for messages
		try
		{
			// ServerSocket of Port is generated
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("ServerSocket erzeugt an Port: " + port);
			this.serverOpen = true;
			
			// Endless-loop, which waits for the Server to come
			while(this.serverOpen)
			{
				System.out.println("Warte auf eingehende Client-Verbindung...");
				// accepts the connection
				Socket clientSocket = serverSocket.accept();
				//TODO catch exception from ServerSocket.accept()
		
				System.out.println("Client baut Verbindung auf..." + clientSocket.getPort());
				
				// if we have to stop
				if (!serverOpen)
				{
					System.out.println("Server geschlossen!");
					break;
				}
				
				// generate thread for the connection
				System.out.println("Erzeuge Thread fuer Client-Verbindung...");
				ClientConnection client = new ClientConnection(clientSocket, this);
				
				// save the connection in the array
				this.socketlist.add(client);
				
				// Start Client
				System.out.println("Starte Client Verbindung...");
				client.start();
			}
			// when cancellation, close all clients
			try
			{
				serverSocket.close();
				for (int i = 0; i < socketlist.size(); ++i)
				{
					ClientConnection tempClient = socketlist.get(i);
					try
					{
						tempClient.getObjectInputStream().close();
						tempClient.getObjectOutputStream().close();
						tempClient.getSocket().close();
					}
					catch (IOException ioE)
					{
					}
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

	/**
	 * method, which stops the waiting for the new ClientConnection and close
	 * all Clients
	 * 
	 * @author Wirsig, Dominik
	 */
	public void stopSever()
	{
		serverOpen = false;
	}

	/**
	 * method, which deletes a client (who wants to end) from the ArrayList, by
	 * replacing the Position with null
	 * 
	 * @author Wirsig, Dominik
	 */
	synchronized void remove(int id)
	{
		socketlist.set(id - 1, null);
	}

	public ArrayList<ClientConnection> getSocketlist()
	{
		return socketlist;
	}
}