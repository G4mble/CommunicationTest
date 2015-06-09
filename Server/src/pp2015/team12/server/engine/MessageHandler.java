package pp2015.team12.server.engine;

import java.util.ArrayList;

import pp2015.team12.server.communication.ServerCom;
import pp2015.team12.server.engine.server3.SE_III_Controller;
import pp2015.team12.server.map.Node;
import pp2015.team12.shared.message.ChatMsg;
import pp2015.team12.shared.message.CreateCharacterReqMsg;
import pp2015.team12.shared.message.EngageFightMsg;
import pp2015.team12.shared.message.LoginRequestMsg;
import pp2015.team12.shared.message.MapMsg;
import pp2015.team12.shared.message.Message;
import pp2015.team12.shared.message.MoveMsg;
import pp2015.team12.shared.message.PickUpMsg;
import pp2015.team12.shared.message.RegistrationReqMsg;
import pp2015.team12.shared.message.RequestLevelChangeMsg;
import pp2015.team12.shared.message.UseItemMsg;

/**
 * receive all Messages from Communication, Sever 2, Server 3, Server 4 and send
 * them to the right receiver
 * 
 * @author Friedrich Murillo, Simon, 5802318
 */
public class MessageHandler extends Thread
{

	ServerEngine SE;
	ServerCom SC;
	ArrayList<Message> msgList = new ArrayList<Message>();
	SE_III_Controller SE_III; 
	
	private boolean databaseOn;  //TODO Alle msg die mit Server 3 zu tun haben muessen auf true kontrolliert und differenziert werden 

	/**
	 * 
	 * @author Friedrich Murillo, Simon, 5802318
	 * @param serverEngine
	 */
	public MessageHandler(ServerEngine serverEngine)
	{
		this.SE = serverEngine;
		this.SE_III = new SE_III_Controller(this);
	}

	/**
	 * 
	 * @author Friedrich Murillo, Simon, 5802318
	 * @param message
	 */
	public void addNewMsg(Message message)
	{
		this.msgList.add(message);
	}

	/**
	 * receive all Messages from Communication, Sever 2, Server 3, Server 4 and
	 * send them to the right receiver
	 * 
	 * @author Friedrich Murillo, Simon, 5802318
	 */
	private void handleMessages()
	{

		try
		{
			Message message = this.msgList.remove(0); // TODO Nur platzhalter
														// benoetige

			if (message instanceof MoveMsg)
			{
				handleMoveMsg((MoveMsg) message);
			} else if (message instanceof RegistrationReqMsg)
			{
				handleRegistrationReqMsg((RegistrationReqMsg) message);
			} else if (message instanceof RequestLevelChangeMsg)
			{
				handleMapChangeMsg((RequestLevelChangeMsg) message);
			} else if (message instanceof PickUpMsg)
			{
				handlePickUpMsg((PickUpMsg) message);
			} else if (message instanceof ChatMsg)
			{
				handleChatMsg((ChatMsg) message);
			} else if (message instanceof UseItemMsg)
			{
				handleUseItemMsg((UseItemMsg) message);
			} else if (message instanceof LoginRequestMsg)
			{
				handleLoginReqzestMsg((LoginRequestMsg) message);
			} else if (message instanceof CreateCharacterReqMsg)
			{
				handleCreateCharacterReqMsg((CreateCharacterReqMsg) message);
			} else if (message instanceof EngageFightMsg)
			{
				handleEngageFightMsg((EngageFightMsg) message);
			}

		} catch (IndexOutOfBoundsException e)
		{
			// methode von Kommunikation
		}

	}

	private void handleEngageFightMsg(EngageFightMsg message)
	{
		// TODO Konsistenzcheck 
		// TODO neue FightMsg zu Server II
		
	}

	private void handleCreateCharacterReqMsg(CreateCharacterReqMsg message)
	{
		// TODO Neuen Character erstellen 
		
	}

	private void handleLoginReqzestMsg(LoginRequestMsg message)
	{
		// TODO Dummy reservieren
		// TODO An Thomas weiterleiten und player von thomas uebergeben bekommen um ihn in Array player abzuspeichern

	}

	private void handleRegistrationReqMsg(RegistrationReqMsg message)
	{
		// TODO ClientId vergeben
		// TODO Dummy reservieren
		// TODO an Thomas weiterleiten

	}

	// traenke werden genommen (wird noch erweitert)
	private void handleUseItemMsg(UseItemMsg message)
	{
		// TODO PlayerCharacter player = playerList[message.getClientId];
		// player.getInventoryContentList().get(message.getPosInv).
		// TODO contentList[posinv].useItem(playerList[message.getClientId]

	}

	private void handleChatMsg(ChatMsg message)
	{
		// message.getContent();
		this.SE.addOutgoingChatMsg(message);
		
		// TODO kontrollieren an wen es geschickt werden muss (abgleichen mit levelId und playerList)
		// oder bei wisper spezieller client

	}

	
	private void handlePickUpMsg(PickUpMsg message)
	{
		// TODO komtrollieren ob das item noch zur verfuegung steht
		// TODO item muss geloescht und wenn keiner mehr im lvl ist wieder erstellt werden

	}

	private void handleMapChangeMsg(RequestLevelChangeMsg message)
	{
		int nextLevelId;
		int currentLevelId = message.getCurrentLevelId();
		int clientId = message.getClientId();
		Node currentNode;
		int doorId;
		String temp = Integer.toString(message.getTextureId());
		temp = temp.substring(3);
		doorId = Integer.parseInt(temp);
		
		
		currentNode = SE.getSearchedNode(currentLevelId);
		
		nextLevelId = SE.getNextLevelId(currentNode, doorId);
		
		MapMsg outgoingMessage = new MapMsg(SE.getMap(nextLevelId), clientId);
		//TODO Diese nachricht an Kommunikation weiterleiten
		
		//TODO 2weitere nachrichten mit vector array item und monster liste
		//System.out.println(SE.getMonsterList()[17]);
		//System.out.println(SE.getMonsterList()[17]);

	}

	private void handleMoveMsg(MoveMsg message)
	{
		SE.consistencyCheck(message);
		// TODO message mit true oder false an client zurueck

	}
	
	public void setDatabaseOn(boolean paramDatabaseStatus)
	{
		this.databaseOn = paramDatabaseStatus;
	}

	@Override
	public void run()
	{
		while (true)
		{
			try
			{
				handleMessages();
				Thread.sleep(10);
			} catch (Exception e)
			{
				// TODO: handle exception
			}
		}

	}

}
