package komponente.serverEngineI;

import java.util.ArrayList;

import pp2015.team12.shared.message.ChatMsg;
import pp2015.team12.shared.message.LoginRequestMsg;
import pp2015.team12.shared.message.MapChangeMsg;
import pp2015.team12.shared.message.Message;
import pp2015.team12.shared.message.MoveMsg;
import pp2015.team12.shared.message.RegistrationReqMsg;
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
	ArrayList<Message> msgList = new ArrayList<Message>();

	public MessageHandler(ServerEngine serverEngine)
	{
		this.SE = serverEngine;
	}

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
	public void handleMessages()
	{

		Message message = this.msgList.get(0); // TODO Nur platzhalter benoetige
												// methode von Kommunikation
		if (message != null)
		{
			if (message instanceof MoveMsg)
			{
				handleMoveMsg((MoveMsg) message);
			} else if (message instanceof RegistrationReqMsg)
			{
				handleRegistrationReqMsg((RegistrationReqMsg) message);
			} else if (message instanceof MapChangeMsg)
			{
//				handleMapChangeMsg((MapChangeMsg) message);
//			} else if (message instanceof ItemPickUpMsg)
//			{
//				handleItemPickUpMsg((ItemPickUpMsg) message);
//			} else if (message instanceof ChatMsg)
//			{
				handleChatMsg((ChatMsg) message);
			} else if (message instanceof UseItemMsg)
			{
				handleUseItemMsg(message);
			} else if (message instanceof LoginRequestMsg)
			{
				handleLoginReqzestMsg((LoginRequestMsg) message);
			}
		}

	}

	private void handleLoginReqzestMsg(LoginRequestMsg message)
	{
		// TODO Auto-generated method stub

	}

	private void handleRegistrationReqMsg(RegistrationReqMsg message)
	{
		// TODO Auto-generated method stub

	}

	private void handleUseItemMsg(Message message)
	{
		// TODO Auto-generated method stub

	}

	private void handleChatMsg(ChatMsg message)
	{
		// message.getContent();
		this.SE.addOutgoingChatMsg(message);

	}

//	private void handleItemPickUpMsg(ItemPickUpMsg message)
//	{
//		// TODO Auto-generated method stub
//
//	}

//	private void handleMapChangeMsg(MapChangeMsg message)
//	{
//		// TODO Auto-generated method stub
//
//	}

	private void handleMoveMsg(MoveMsg message)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void run()
	{
		while (true)
		{
			try
			{
				handleMessages();
				Thread.sleep(20);
			} catch (Exception e)
			{
				// TODO: handle exception
			}
		}

	}

}
